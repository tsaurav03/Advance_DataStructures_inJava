package ads.com.sorting_day2;

import java.util.Arrays;
import java.util.Random;

public class sortingOperations {
	private static void callSortingAlgos() {
		int[] sortedData = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		int[] bubbleSortData = {5, 9, 1, 6, 3, 2, 7, 4, 8, 10};
		System.out.println("Before bubble sort - " + Arrays.toString(bubbleSortData));
		SortingAlgorithms.bubbleSort(bubbleSortData);
		System.out.println("After bubble sort - " + Arrays.toString(bubbleSortData));
		System.out.println("Bubble sort loopCount - " + SortingAlgorithms.loopCount);
		System.out.println("");
		
		System.out.println("Before bubble sort - " + Arrays.toString(sortedData));
		SortingAlgorithms.bubbleSort(sortedData);
		System.out.println("After bubble sort - " + Arrays.toString(sortedData));
		System.out.println("Bubble sort loopCount - " + SortingAlgorithms.loopCount);
		System.out.println("");

		
		int[] bubbleSortOptimisedData = {5, 9, 1, 6, 3, 2, 7, 4, 8, 10};
		System.out.println("Before bubble sort (Optimised) - " + Arrays.toString(bubbleSortOptimisedData));
		SortingAlgorithms.bubbleSortOptimised(bubbleSortOptimisedData);
		System.out.println("After bubble sort (Optimised) - " + Arrays.toString(bubbleSortOptimisedData));
		System.out.println("Bubble sort loopCount - " + SortingAlgorithms.loopCount);
		System.out.println("");
		
		System.out.println("Before bubble sort (Optimised) - " + Arrays.toString(sortedData));
		SortingAlgorithms.bubbleSortOptimised(sortedData);
		System.out.println("After bubble sort - " + Arrays.toString(sortedData));
		System.out.println("Bubble sort loopCount - " + SortingAlgorithms.loopCount);
		System.out.println("");

	
		int[] selectionSortData = {5, 9, 1, 6, 3, 2, 7, 4, 8, 10};
		System.out.println("Before selection sort - " + Arrays.toString(selectionSortData));
		SortingAlgorithms.selectionSort(selectionSortData);
		System.out.println("After selection sort - " + Arrays.toString(selectionSortData));
		System.out.println("Selection sort loopCount - " + SortingAlgorithms.loopCount);
		System.out.println("");
		
		System.out.println("Before selection sort - " + Arrays.toString(sortedData));
		SortingAlgorithms.selectionSort(sortedData);
		System.out.println("After selection sort - " + Arrays.toString(sortedData));
		System.out.println("Selection sort loopCount - " + SortingAlgorithms.loopCount);
		System.out.println("");

		
		int[] insertionSortData = {5, 9, 1, 6, 3, 2, 7, 4, 8, 10};
		System.out.println("Before insertion sort - " + Arrays.toString(insertionSortData));
		SortingAlgorithms.insertionSort(insertionSortData);
		System.out.println("After insertion sort - " + Arrays.toString(insertionSortData));
		System.out.println("Insertion sort loopCount - " + SortingAlgorithms.loopCount);
		System.out.println("");
		
		System.out.println("Before insertion sort - " + Arrays.toString(sortedData));
		SortingAlgorithms.insertionSort(sortedData);
		System.out.println("After insertion sort - " + Arrays.toString(sortedData));
		System.out.println("Insertion sort loopCount - " + SortingAlgorithms.loopCount);
		System.out.println("");

		int[] reverseSortedData1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		System.out.println("Before insertion sort - " + Arrays.toString(reverseSortedData1));
		SortingAlgorithms.insertionSort(reverseSortedData1);
		System.out.println("After insertion sort - " + Arrays.toString(reverseSortedData1));
		System.out.println("Insertion sort loopCount - " + SortingAlgorithms.loopCount);
		System.out.println("");

		int[] reverseSortedData2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		System.out.println("Before bubble sort (Optimised) - " + Arrays.toString(reverseSortedData2));
		SortingAlgorithms.bubbleSortOptimised(reverseSortedData2);
		System.out.println("After bubble sort - " + Arrays.toString(reverseSortedData2));
		System.out.println("Bubble sort loopCount - " + SortingAlgorithms.loopCount);
		System.out.println("");
		

		int[] quickSortData = {5, 9, 1, 6, 3, 2, 7, 4, 8, 10};
		System.out.println("Before quick sort - " + Arrays.toString(quickSortData));
		SortingAlgorithms.quickSort(quickSortData);
		System.out.println("After quick sort - " + Arrays.toString(quickSortData));
		System.out.println("Quick sort loopCount - " + SortingAlgorithms.loopCount);
		System.out.println("");

		
		int[] mergeSortData = {5, 9, 1, 6, 3, 2, 7, 4, 8, 10};
		System.out.println("Before merge sort - " + Arrays.toString(mergeSortData));
		SortingAlgorithms.mergeSort(mergeSortData);
		System.out.println("After merge sort - " + Arrays.toString(mergeSortData));
		System.out.println("");

		
		int[] heapSortData = {5, 9, 1, 6, 3, 2, 7, 4, 8, 10};
		System.out.println("Before heap sort - " + Arrays.toString(heapSortData));
		SortingAlgorithms.heapSort(heapSortData);
		System.out.println("After heap sort - " + Arrays.toString(heapSortData));
	}

	private static void fillArrayWithRandomNumbers(int[] arr) {
		Random rand = new Random();

		for (int i = 0; i < arr.length; ++i) {
			arr[i] = rand.nextInt();
		}
	}

	public static void testExecutionTimes(int n) {
		int[] randomNumbers = new int [n];
		fillArrayWithRandomNumbers(randomNumbers);

		int[] numbersToSort = new int [n];

		System.arraycopy(randomNumbers, 0, numbersToSort, 0, randomNumbers.length);
		SortingAlgorithms.bubbleSort(numbersToSort);

		System.arraycopy(randomNumbers, 0, numbersToSort, 0, randomNumbers.length);
		long startTime = System.nanoTime();
		SortingAlgorithms.bubbleSort(numbersToSort);
		long elapsedTime = System.nanoTime() - startTime;
		System.out.printf("%10d(nanosec), %5d elements - Bubble Sort\n", elapsedTime, numbersToSort.length);

		System.arraycopy(randomNumbers, 0, numbersToSort, 0, randomNumbers.length);
		startTime = System.nanoTime();
		SortingAlgorithms.bubbleSortOptimised(numbersToSort);
		elapsedTime = System.nanoTime() - startTime;
		System.out.printf("%10d(nanosec), %5d elements - Bubble Sort Optimised\n", elapsedTime, numbersToSort.length);

		System.arraycopy(randomNumbers, 0, numbersToSort, 0, randomNumbers.length);
		startTime = System.nanoTime();
		SortingAlgorithms.selectionSort(numbersToSort);
		elapsedTime = System.nanoTime() - startTime;
		System.out.printf("%10d(nanosec), %5d elements - Selection Sort\n", elapsedTime, numbersToSort.length);

		System.arraycopy(randomNumbers, 0, numbersToSort, 0, randomNumbers.length);
		startTime = System.nanoTime();
		SortingAlgorithms.insertionSort(numbersToSort);
		elapsedTime = System.nanoTime() - startTime;
		System.out.printf("%10d(nanosec), %5d elements - Insertion Sort\n", elapsedTime, numbersToSort.length);

		System.arraycopy(randomNumbers, 0, numbersToSort, 0, randomNumbers.length);
		startTime = System.nanoTime();
		SortingAlgorithms.quickSort(numbersToSort);
		elapsedTime = System.nanoTime() - startTime;
		System.out.printf("%10d(nanosec), %5d elements - Quick Sort Optimised\n", elapsedTime, numbersToSort.length);

		System.arraycopy(randomNumbers, 0, numbersToSort, 0, randomNumbers.length);
		startTime = System.nanoTime();
		SortingAlgorithms.mergeSort(numbersToSort);
		elapsedTime = System.nanoTime() - startTime;
		System.out.printf("%10d(nanosec), %5d elements - Merge Sort Optimised\n", elapsedTime, numbersToSort.length);

		System.arraycopy(randomNumbers, 0, numbersToSort, 0, randomNumbers.length);
		startTime = System.nanoTime();
		SortingAlgorithms.heapSort(numbersToSort);
		elapsedTime = System.nanoTime() - startTime;
		System.out.printf("%10d(nanosec), %5d elements - Heap Sort Optimised\n", elapsedTime, numbersToSort.length);
	}

	public static void main(String[] args) {
		//callSortingAlgos();
		System.out.println("Testing with 10 elements.");
		testExecutionTimes(10);

		System.out.println("Testing with 50000 elements.");
		testExecutionTimes(50000);
	}
}
