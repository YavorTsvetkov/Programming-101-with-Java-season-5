package week4;

import week4.genericBinarySearchTree.MyBinarySearchTree;

public class Main {
	public static void main(String[] args) {
		
		Integer[] arr1 = {3, 1, 5, 4, 2};
		Integer[] arr2 = {3, 4, 6, 9, 5, 7, 2, 8, 1};
		
		MyBinarySearchTree.sort(arr1);
		MyBinarySearchTree.sort(arr2);
		
		printArray(arr1);
		printArray(arr2);
	}
	
	private static <T extends Comparable<T>> void printArray(T[] arr) {
		for (T n : arr) {
			System.out.print(n + " ");
		}
		
		System.out.println();
	}
	
	public static int multiplication(int[] number, int index) {
		if(index < 0 || (index > number.length - 1)){
			throw new IndexOutOfBoundsException();
		}
		int result = 1;
		
		for(int i = 0; i < number.length; i++) {
			if(i == index) {
				continue;
			}
			else{
				result *= number[i];
			}
		}
		
		return result;
	}
	
	public void printFile(String path) {
		//throw checkedException("The file is not present");
	}

}
