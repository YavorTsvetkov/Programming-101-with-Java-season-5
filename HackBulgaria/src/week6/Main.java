package week6;

import week6.sorting.SortingAlgorithms;

public class Main {

	
	public static void main(String[] args) {
		Integer[] arr = {-1, -9, -8, -6, -2, -4, 0, 2, 1, 6};
		
		SortingAlgorithms.quickSort(arr);
		
		//printArray(arr);
		
		System.out.println(1 ^ 3);
	}
	
	public static <T extends Comparable<T>> void printArray(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			
			if (i < arr.length - 1) {
				System.out.print(", ");
			}
		}
		
		System.out.println();
	}

}
