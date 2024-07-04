package ads.com.sorting_day2;

public class SortingAlgorithms {
	public static int loopCount;

	public static void bubbleSort(int[] arr) {
		int n = arr.length;

		loopCount = 0;
		while (n > 1) {
			int left = 0;
			
			while (left < (n - 1)) {
				++loopCount;
				
				if (arr[left] > arr[left + 1]) {
					int t = arr[left];
					arr[left] = arr[left + 1];
					arr[left + 1] = t;
				}
				
				++left;
			}
			
			--n;
		}
	}

	public static void bubbleSortOptimised(int[] arr) {
		int n = arr.length;

		loopCount = 0;
		while (n > 1) {
			int left = 0;
			boolean isSwapped = false;

			while (left < (n - 1)) {
				++loopCount;
				
				if (arr[left] > arr[left + 1]) {
					int t = arr[left];
					arr[left] = arr[left + 1];
					arr[left + 1] = t;
					
					isSwapped = true;
				}
				
				++left;
			}
			
			if (! isSwapped) {
				break;
			}
			
			--n;
		}
	}
	
	public static void selectionSort(int[] arr) {
		int n = arr.length;
		int elementPos = 0;
		
		loopCount = 0;
		
		while (elementPos < (n - 1)) {
			int smallestElementPos = elementPos;
			int i = elementPos + 1;
			
			while (i < n) {
				++loopCount;

				if (arr[i] < arr[smallestElementPos]) {
					smallestElementPos = i;
				}
				
				++i;
			}
			
			if (elementPos != smallestElementPos) {
				int t = arr[elementPos];
				arr[elementPos] = arr[smallestElementPos];
				arr[smallestElementPos] = t;
			}
			
			++elementPos;
		}
	}
	
	public static void insertionSort(int[] arr) {
		int n = arr.length;

		loopCount = 0;
		
		for (int sortedSize = 1; sortedSize < n; ++sortedSize) {
			int insertElement = arr[sortedSize];
			int i = sortedSize - 1;

			for (; i >= 0; --i) {
				++loopCount;
				
				if (arr[i] > insertElement) {
					arr[i + 1] = arr[i];
				} else {
					break;
				}
			}
			
			arr[i + 1] = insertElement;
		}
	}
	

	private static int partition(int[] arr, int startPos, int endPos) {
		int pivotPos = startPos;
		int left = startPos + 1;
		int right = endPos;
		
		while (left <= right) {
			while ((left <= right) && (arr[left] < arr[pivotPos])) {
				++loopCount;
				++left;
			}
			while ((left <= right) && (arr[pivotPos] < arr[right])) {
				++loopCount;
				--right;
			}
			
			if (left < right) {
				int t = arr[left];
				arr[left] = arr[right];
				arr[right] = t;
			}
		}
		
		int t = arr[pivotPos];
		arr[pivotPos] = arr[right];
		arr[right] = t;
		
		return right;
	}
	private static void quickSort(int[] arr, int startPos, int endPos) {
		if ((endPos - startPos + 1) <= 1) {
			return;
		}
		
		int pivotPos = partition(arr, startPos, endPos);
		quickSort(arr, startPos, pivotPos - 1);
		quickSort(arr, pivotPos + 1, endPos);
	}
	public static void quickSort(int[] arr) {
		loopCount = 0;
		quickSort(arr, 0, arr.length - 1);
	}

	private static int[] mergedArray;
	private static void merge(int[] arr, int startPos1, int endPos1, int startPos2, int endPos2) {
		int i1 = startPos1;
		int i2 = startPos2;
		int r = 0;
		
		while ((i1 <= endPos1) && (i2 <= endPos2)) {
			if (arr[i1] < arr[i2]) {
				mergedArray[r] = arr[i1];
				++i1;
			} else {
				mergedArray[r] = arr[i2];
				++i2;
			}
			++r;
		}
		
		while (i1 <= endPos1) {
			mergedArray[r] = arr[i1];
			++i1;
			++r;
		}
		while (i2 <= endPos2) {
			mergedArray[r] = arr[i2];
			++i2;
			++r;
		}

		for (int i = startPos1, j = 0; j < r; ++i, ++j) {
			arr[i] = mergedArray[j];
		}
	}
	private static void mergeSort(int[] arr, int startPos, int endPos) {
		if ((endPos - startPos + 1) <= 1) {
			return;
		}

		int mid = startPos + (endPos - startPos) / 2;
		mergeSort(arr, startPos, mid);
		mergeSort(arr, mid + 1, endPos);
		
		merge(arr, startPos, mid, mid + 1, endPos);
		
	}
	public static void mergeSort(int[] arr) {
		mergedArray = new int[arr.length];

		mergeSort(arr, 0, arr.length - 1);
	}
/*
	private static void makeMaxHeap(int[] arr, int parent, int n) {
		int maxChildPos = 2 * parent + 1; // Assume left child is largest;
		int rightChildPos = 2 * parent + 2;
		
		if (rightChildPos < n) {
			if (arr[rightChildPos] > arr[maxChildPos]) {
				maxChildPos = rightChildPos;
			}
		}
		
		if (arr[parent] > arr[maxChildPos]) {
			return;
		}
		
		int t = arr[parent];
		arr[parent] = arr[maxChildPos];
		arr[maxChildPos] = t;

		int leftChildOfMaxChild = 2 * maxChildPos + 1;
		if (leftChildOfMaxChild >= n) {
			return;
		}
		
		makeMaxHeap(arr, maxChildPos, n);
	}
*/
	private static void makeMaxHeap(int[] arr, int parent, int n) {
		//while ((2 * parent + 1) < n) {
		boolean done = false;
		while (! done) {
			int maxChildPos = 2 * parent + 1; // Assume left child is largest;
			int rightChildPos = 2 * parent + 2;
			
			if (rightChildPos < n) {
				if (arr[rightChildPos] > arr[maxChildPos]) {
					maxChildPos = rightChildPos;
				}
			}
			
			if (arr[parent] > arr[maxChildPos]) {
				return;
			}
		
			int t = arr[parent];
			arr[parent] = arr[maxChildPos];
			arr[maxChildPos] = t;
	
			int leftChildOfMaxChild = 2 * maxChildPos + 1;
			if (leftChildOfMaxChild >= n) {
				return;
			}
			parent = maxChildPos;
		}
		//makeMaxHeap(arr, maxChildPos, n);
	}
	private static void convertToMaxHeap(int[] arr, int n) {
		int lastParent = n / 2 - 1;
		
		while (lastParent >= 0) {
			makeMaxHeap(arr, lastParent, n);
			--lastParent;
		}
	}
	public static void heapSort(int[] arr) {
		convertToMaxHeap(arr, arr.length);
		
		int lastChildPos = arr.length - 1;
		
		while (lastChildPos > 0) {
			int t = arr[0];
			arr[0] = arr[lastChildPos];
			arr[lastChildPos] = t;
			
			if (lastChildPos > 1) {
				makeMaxHeap(arr, 0, lastChildPos);
			}
			
			--lastChildPos;
		}
	}
}
