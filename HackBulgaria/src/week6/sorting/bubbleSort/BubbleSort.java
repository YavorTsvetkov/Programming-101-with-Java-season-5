package week6.sorting.bubbleSort;

public class BubbleSort {
	public static <T extends Comparable<T>> void bubbleSort(T[] array) {
		boolean flag = true;
		
		while (flag) {
			flag = false;
			
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i].compareTo(array[i + 1]) > 0) {
					swap(array, i, i + 1);
					flag = true;
				}
			}
		}
	}
	
	private static <T extends Comparable<T>> void swap(T[] array, int firstIndex, int secondIndex) {
		T swapper = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = swapper;
	}
	
	public static void main(String[] args) {
		Integer[] array = {7, 8, 6, 9, 1, 3, 2, 4, 5};
		
		bubbleSort(array);
		
		for (Integer n : array) {
			System.out.print(n + " ");
		}
	}
}
