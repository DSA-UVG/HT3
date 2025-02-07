package org.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Clase SortingAlgorithms
 * Contiene implementaciones de algoritmos de ordenamiento.
 * @author Juan Jose Alvarez
 */
public class SortingAlgorithms {

    /**
     * Ordena un arreglo de números enteros utilizando el algoritmo de ordenamiento por inserción.
     * @param array Arreglo de números enteros.
     * @return Arreglo ordenado.
     */
    public static <T extends Comparable<T>> void insertionSort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    /**
     * Ordena un arreglo de números enteros utilizando el algoritmo de ordenamiento por mezcla.
     * @param array Arreglo de números enteros.
     * @return Arreglo ordenado.
     */
    public static <T extends Comparable<T>> void mergeSort(T[] array) {
        if (array.length < 2) return;
        int mid = array.length / 2;
        T[] left = (T[]) new Comparable[mid];
        T[] right = (T[]) new Comparable[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }
    /**
     * Combina dos arreglos ordenados en un solo arreglo ordenado.
     * @param array Arreglo de números enteros.
     * @param left Arreglo de números enteros.
     * @param right Arreglo de números enteros.
     */
    private static <T extends Comparable<T>> void merge(T[] array, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }
 
    /**
     * Ordena un arreglo de números enteros utilizando el algoritmo de ordenamiento rápido.
     * @param array Arreglo de números enteros.
     * @return Arreglo ordenado.
     */
    public static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    /**
     * Particiona un arreglo en dos subarreglos.
     * @param array Arreglo de números enteros.
     * @param low Índice del primer elemento.
     * @param high Índice del último elemento.
     * @return Índice del pivote.
     */
    private static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
 
    /**
     * Ordena un arreglo de números enteros utilizando el algoritmo de ordenamiento por casillas.
     * @param array Arreglo de números enteros.
     * @return Arreglo ordenado.
     */
    public static void radixSort(int[] array) {
        int max = getMax(array);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(array, exp);
        }
    }

    /**
     * Ordena un arreglo de números en base a un dígito específico.
     * @param array Arreglo de números enteros.
     * @param exp Dígito por el que se ordenará el arreglo.
     */
    private static void countingSortByDigit(int[] array, int exp) {
        int[] output = new int[array.length];
        int[] count = new int[10];

        for (int num : array) count[(num / exp) % 10]++;
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, array, 0, array.length);
    }

    /**
     * Obtiene el número máximo de un arreglo.
     * @param array Arreglo de números enteros.
     * @return Número máximo.
     */
    private static int getMax(int[] array) {
        int max = array[0];
        for (int num : array) max = Math.max(max, num);
        return max;
    }

    /**
     * Ordena un arreglo de números en punto flotante utilizando el algoritmo de ordenamiento por casillas.
     * @param array Arreglo de números en punto flotante.
     * @return Arreglo ordenado.
     */
    public static void bucketSort(float[] array) {
        int n = array.length;
        List<Float>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) buckets[i] = new ArrayList<>();
        for (float num : array) buckets[(int) (num * n)].add(num);
        for (List<Float> bucket : buckets) Collections.sort(bucket);

        int index = 0;
        for (List<Float> bucket : buckets) {
            for (float num : bucket) {
                array[index++] = num;
            }
        }
    }

    /**
     * Ordena un arreglo de números enteros utilizando el algoritmo de ordenamiento por montículos.
     * @param array Arreglo de números enteros.
     * @return Arreglo ordenado.
     */
    public static <T extends Comparable<T>> void heapSort(T[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(array, n, i);
        for (int i = n - 1; i > 0; i--) {
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    /**
     * Convierte un arreglo en un montículo.
     * @param array Arreglo de números enteros.
     * @param n Tamaño del montículo.
     * @param i Índice del nodo raíz.
     */
    private static <T extends Comparable<T>> void heapify(T[] array, int n, int i) {
        int largest = i, left = 2 * i + 1, right = 2 * i + 2;
        if (left < n && array[left].compareTo(array[largest]) > 0) largest = left;
        if (right < n && array[right].compareTo(array[largest]) > 0) largest = right;
        if (largest != i) {
            T swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            heapify(array, n, largest);
        }
    }

}
