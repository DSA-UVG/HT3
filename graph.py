import pandas as pd
import numpy as np

times = pd.read_csv('results.csv')

arraySizes = np.array(times['Size']) # Datos para el eje x

insertionSortTimes = np.array(times['InsertionSort'])
mergeSortTimes = np.array(times['MergeSort'])
quickSortTimes = np.array(times['QuickSort']) 
radixSortTimes = np.array(times['RadixSort']) 
bucketSortTimes = np.array(times['BucketSort']) 
heapSortTimes = np.array(times['HeapSort']) 

