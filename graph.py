import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

times = pd.read_csv('results.csv')

arraySizes = np.array(times['Size']) # Datos para el eje x

# Tiempos de ejecucion de cada uno de los algoritmos.
insertionSortTimes = np.array(times['InsertionSort'])
mergeSortTimes = np.array(times['MergeSort'])
quickSortTimes = np.array(times['QuickSort']) 
radixSortTimes = np.array(times['RadixSort']) 
bucketSortTimes = np.array(times['BucketSort']) 
heapSortTimes = np.array(times['HeapSort']) 

# Graficar los tiempos de ejecucion de cada uno de los algoritmos.
plt.plot(arraySizes, insertionSortTimes, label='Insertion Sort. O(n^2)')
plt.plot(arraySizes, mergeSortTimes, label='Merge Sort. O(n log n)')
plt.plot(arraySizes, quickSortTimes, label='Quick Sort. O(n log n)')
plt.plot(arraySizes, radixSortTimes, label='Radix Sort. O(nk)')
plt.plot(arraySizes, bucketSortTimes, label='Bucket Sort. O(n+k)')
plt.plot(arraySizes, heapSortTimes, label='Heap Sort. O(n log n)')

plt.xlabel('Array Size')
plt.ylabel('Time (s)')
plt.title('Sorting Algorithms Performance')
plt.legend()
plt.show()