import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

times = pd.read_csv('results.csv')

arraySizes = np.array(times['Size']) # Datos para el eje x

insertionSortTimes = np.array(times['InsertionSort'])
mergeSortTimes = np.array(times['MergeSort'])
quickSortTimes = np.array(times['QuickSort']) 
radixSortTimes = np.array(times['RadixSort']) 
bucketSortTimes = np.array(times['BucketSort']) 
heapSortTimes = np.array(times['HeapSort']) 

plt.plot(arraySizes, insertionSortTimes, label='Insertion Sort')
plt.plot(arraySizes, mergeSortTimes, label='Merge Sort')
plt.plot(arraySizes, quickSortTimes, label='Quick Sort')
plt.plot(arraySizes, radixSortTimes, label='Radix Sort')
plt.plot(arraySizes, bucketSortTimes, label='Bucket Sort')
plt.plot(arraySizes, heapSortTimes, label='Heap Sort')

plt.xlabel('Array Size')
plt.ylabel('Time (s)')
plt.title('Sorting Algorithms Performance')
plt.legend()
plt.show()