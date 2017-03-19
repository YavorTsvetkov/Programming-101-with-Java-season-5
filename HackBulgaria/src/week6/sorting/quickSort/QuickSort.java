package week6.sorting.quickSort;

public class QuickSort {
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
	
	
	
	private static <T> void swap(T[] arr, int i, int j) {
		T swapper = arr[i];
		arr[i] = arr[j];
		arr[j] = swapper;
	}
	
	public static void main(String[] args) {
		Integer[] array = {7, 8, 6, 9, 1, 3, 2, 4, 5};
		
		quickSort(array);
		
		for (Integer n : array) {
			System.out.print(n + " ");
		}
	}
}
