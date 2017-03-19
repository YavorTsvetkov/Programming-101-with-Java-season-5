package week6.sorting.selectionSort;

public class SelectionSort {
	public static <T extends Comparable<T>> void selectionSort(T[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++ ) {
				if (arr[i].compareTo(arr[j]) > 0) {
					swap(arr, i, j);
				}
			}
		}
	}
	
	private static <T extends Comparable<T>> void swap(T[] arr,
												  int firstIndex,
												  int secondIndex) {
		T swapper = arr[firstIndex];
		arr[firstIndex] = arr[secondIndex];
		arr[secondIndex] = swapper;
	}
	

	public static void main(String[] args) {
		Integer[] array = {7, 8, 6, 9, 1, 3, 2, 4, 5};
		
		selectionSort(array);
		
		for (Integer n : array) {
			System.out.print(n + " ");
		}
	}
}
