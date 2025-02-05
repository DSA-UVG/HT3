package org.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class SortingAlgorithmsTest {

    private final Integer[] unsortedArray = {5, 3, 8, 6, 2, 7, 4, 1};
    private final Integer[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8};

    @Test
    public void testInsertionSort() {
        Integer[] array = unsortedArray.clone();
        SortingAlgorithms.insertionSort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void testMergeSort() {
        Integer[] array = unsortedArray.clone();
        SortingAlgorithms.mergeSort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void testQuickSort() {
        Integer[] array = unsortedArray.clone();
        SortingAlgorithms.quickSort(array, 0, array.length - 1);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void testRadixSort() {
        int[] array = Arrays.stream(unsortedArray).mapToInt(Integer::intValue).toArray();
        int[] expected = Arrays.stream(sortedArray).mapToInt(Integer::intValue).toArray();
        SortingAlgorithms.radixSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testBucketSort() {
        float[] array = {0.5f, 0.3f, 0.8f, 0.6f, 0.2f, 0.7f, 0.4f, 0.1f};
        float[] expected = {0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f};
        SortingAlgorithms.bucketSort(array);
        assertArrayEquals(expected, array, 0.0001f); // Tolerancia para valores flotantes
    }

    @Test
    public void testHeapSort() {
        Integer[] array = unsortedArray.clone();
        SortingAlgorithms.heapSort(array);
        assertArrayEquals(sortedArray, array);
    }
}
