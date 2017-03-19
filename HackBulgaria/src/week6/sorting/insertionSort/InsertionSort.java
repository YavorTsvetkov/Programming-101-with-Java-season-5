package week6.sorting.insertionSort;

public class InsertionSort {
	public static <T extends Comparable<T>> void insertionSort(T[] array) {
		for (int i = 1; i < array.length; i++) {
			int k = i;
			
			for (int j = i - 1; j >= 0; j--) {
				if (array[k].compareTo(array[j]) < 0) {
					swap(array, j, k);
					k--;
					
				} else {
					break;
				}
			}
		}
		
	}
	
	private static <T extends Comparable<T>> void swap(T[] array, 
													   int firstIndex, 
													   int secondIndex){
		T swapper = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = swapper;
	}
	
	public static void main(String[] args) {
		Integer[] array = {7, 8, 6, 9, 1, 3, 2, 4, 5};
		
		insertionSort(array);
		
		for (Integer n : array) {
			System.out.print(n + " ");
		}
	}
}
