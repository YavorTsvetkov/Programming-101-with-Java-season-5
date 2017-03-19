package week4.genericBinarySearchTree;

public class Sort {
	public static<T extends Comparable<T>> void quickSort(T[] array) {
		recursiveQuickSort(array, 0, array.length - 1);
	}
	
	private static <T extends Comparable<T>> void recursiveQuickSort(T[] array,
																int start,
																int end) {
		if (start >= end) {
			return;
		}
		
		int pivotIndex = partition(array, start, end);
		
		recursiveQuickSort(array, start, pivotIndex - 1);
		recursiveQuickSort(array, pivotIndex + 1, end);
	}
	
	private static <T extends Comparable<T>> int partition(T[] array,
															int start,
															int end) {
		int q = start - 1;
		T pivot = array[end];
		
		for (int i = start; i < end; i++) {
			if (array[i].compareTo(pivot) < 0) {
				q++;
				swap(array, i, q);
			}
		}
		
		swap(array, q + 1, end);
		
		return q + 1;
	}
	
	private static <T extends Comparable<T>> void swap(T[] array, int firstIndex,
													   int secondIndex) {
		T swapper = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = swapper;
	}
}
