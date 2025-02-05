package org.sorting;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileGenerator {
    private static final int MAX_NUMBERS = 3000;
    private static final String FILE_NAME = "numbers.txt";

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
