package org.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *  Clase Profiler 
 *  Se encarga de leer los números de un archivo, ejecutar los algoritmos de ordenamiento y medir el tiempo de ejecución.
 *  Los resultados se guardan en un archivo CSV y se genera un gráfico con los resultados usando Python.
 * @author  Juan Jose Alvarez
**/
public class Profiler {
    private static final String FILE_NAME = "numbers.txt";
    private static final String OUTPUT_CSV = "results.csv";
    private static final int[] SAMPLE_SIZES = {10, 50, 100, 500, 1000, 2000, 3000};

    public static void main(String[] args) {
        List<Integer> numbers = readNumbersFromFile();
        if (numbers.isEmpty()) {
            System.err.println("No se encontraron datos en el archivo.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_CSV))) {
            writer.write("Size,InsertionSort,MergeSort,QuickSort,RadixSort,BucketSort,HeapSort\n");

            for (int size : SAMPLE_SIZES) {
                Integer[] array = numbers.subList(0, size).toArray(new Integer[0]);
                int[] radixArray = Arrays.stream(array).mapToInt(Integer::intValue).toArray();
                float[] bucketArray = new float[size];

                for (int i = 0; i < size; i++) {
                    bucketArray[i] = array[i] / 10000.0f; // Normalización para Bucket Sort
                }

                float tInsertion = measureTime(() -> SortingAlgorithms.insertionSort(array.clone()));
                float tMerge = measureTime(() -> SortingAlgorithms.mergeSort(array.clone()));
                float tQuick = measureTime(() -> SortingAlgorithms.quickSort(array.clone(), 0, array.length - 1));
                float tRadix = measureTime(() -> SortingAlgorithms.radixSort(radixArray.clone()));
                float tBucket = measureTime(() -> SortingAlgorithms.bucketSort(bucketArray.clone()));
                float tHeap = measureTime(() -> SortingAlgorithms.heapSort(array.clone()));

                writer.write(size + "," + tInsertion + "," + tMerge + "," + tQuick + ","
                        + tRadix + "," + tBucket + "," + tHeap + "\n");

                System.out.println("Prueba completada para tamaño: " + size);

            }

            System.out.println("📊 Resultados guardados en " + OUTPUT_CSV);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }

/** 
 * Método que lee los números de un archivo y los almacena en una lista.
 * @return List<Integer> Lista de números leídos del archivo.
*/
    private static List<Integer> readNumbersFromFile() {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return numbers;
    }

/**
 * Método que mide el tiempo de ejecución de un algoritmo de ordenamiento.
 * @param sortingAlgorithm Algoritmo de ordenamiento a ejecutar.
 * @return float Tiempo de ejecución en segundos.
**/
    private static float measureTime(Runnable sortingAlgorithm) {
        long start = System.nanoTime();
        sortingAlgorithm.run();
        return (float)(System.nanoTime() - start) / 1000000;
    }
}
