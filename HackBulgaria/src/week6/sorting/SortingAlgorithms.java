package week6.sorting;


public class SortingAlgorithms {

	public static <T extends Comparable<T>> void selectionSort(T[] arr) {
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j].compareTo(arr[i]) < 0) {
					swap(arr, i, j);
				}
			}
		}
	}
	
	public static <T extends Comparable<T>> void insertionSort(T[] array) {
		for (int i = 1; i < array.length; i++) {
			int k = i;
			
			for (int j = i - 1; j >= 0; j--) {
				if (array[k].compareTo(array[j]) < 0) {
					swap(array, k, j);
					k--;

				} else {
					break;
				}
			}
		}
	}
	
	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		boolean flag = true;
		
		while (flag) {
			flag = false;
			for (int i = 1; i < arr.length; i++) {
				if (arr[i].compareTo(arr[i - 1]) < 0) {
					swap(arr, i - 1, i);
					flag = true;
				}
			}
			
		}
	}
	
	private static int getMax(Integer[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		return max;
	}
	
	private static int getMin(Integer[] arr) {
		int min = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		
		return min;
	}
	
	public static <T extends Comparable<T>> Integer[] countingSort(Integer[] arr) {
		int min = getMin(arr);
		int max = getMax(arr);
		int size = (max - min) + 1;
		
		int[] histogram = new int[size];
		
		for (int i = 0; i < arr.length; i++) {
			int histoIndex = arr[i] - min;
			histogram[histoIndex]++;
		}
		
		for (int i = 1; i < histogram.length; i++) {
			histogram[i] += histogram[i - 1];
		}
		Integer[] sorted = new Integer[arr.length];
		
		for (int i = arr.length - 1; i >= 0; i--) {
			histogram[arr[i] - min]--;
			sorted[histogram[arr[i] - min]] = arr[i];
		}
		
		return sorted;
	}
	
	private static <T extends Comparable<T>> int partition(T[] arr, int leftBound, int rightBound) {
		T pivot = arr[rightBound];
		int q = leftBound - 1;
		
		for (int i = leftBound; i < rightBound; i++) {
			if (arr[i].compareTo(pivot) <= 0) {
				q++;
				swap(arr, i, q);
			}
		}
		
		swap(arr, q + 1, rightBound);
		return q + 1;
	}
	
	public static <T extends Comparable<T>> void quickSort(T[] arr) {
		recursiveQuickSort(arr, 0, arr.length - 1);
	}
	
	private static <T extends Comparable<T>> void recursiveQuickSort(T[] arr, int leftBound, int rightBound) {
		if (leftBound >= rightBound) {
			return;
		}
		
		Integer pivotIndex = partition(arr, leftBound, rightBound);
		recursiveQuickSort(arr, leftBound, pivotIndex -1);
		recursiveQuickSort(arr, pivotIndex + 1, rightBound);
	}
	
	private static <T> void swap(T[] arr, int i, int j) {
		T swapper = arr[i];
		arr[i] = arr[j];
		arr[j] = swapper;
	}
	
	public static <T extends Comparable<T>> void print(T[] arr) {
		for (T el : arr) {
			System.out.print(el + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		Integer[] arr = {12, 7, 14, 9, 10, 11};
		
		quickSort(arr);
		
		print(arr);
		
		//System.out.println(result.length);
	}
	

}
