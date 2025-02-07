package org.sorting;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Clase FileGenerator
 * Genera un archivo con números aleatorios.
 * @author  Juan Jose Alvarez
 */
public class FileGenerator {
    private static final int MAX_NUMBERS = 3000;
    private static final String FILE_NAME = "numbers.txt";

/**
 * Método para generar números aleatorios y guardarlos en un archivo.
 * Se generan 3000 números aleatorios y se guardan en un archivo llamado numbers.txt
 * Los números generados están en el rango de 0 a 9999.
 * Si el archivo ya existe, se sobreescribe.
 * Si ocurre un error al generar el archivo, se imprime un mensaje de error.
 */
    public static void generateNumbers() {
        Random random = new Random();

        try(FileWriter writer = new FileWriter(FILE_NAME)) {
            for (int i = 0; i < MAX_NUMBERS; i++) {
                int number = random.nextInt(10000);
                writer.write(number + "\n");
            }
            System.out.println("Archivo generado: " +FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error al generar el archivo" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        generateNumbers();
    }
}
