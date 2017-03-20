package week4;

import week4.genericBinarySearchTree.MyBinarySearchTree;

public class Main {
	public static void main(String[] args) {
		
		Integer[] arr1 = {3, 1, 5, 4, 2};
		Integer[] arr2 = {3, 1, 5, 4, 2};
		
		Integer[] arr3 = {43, 1, 5, 4, 2};
		Integer[] arr4 = {3, 1, 5, 4, 2};
		
		MyBinarySearchTree<Integer> tree3 = new MyBinarySearchTree<Integer>();
		MyBinarySearchTree<Integer> tree4 = new MyBinarySearchTree<Integer>();
		
		MyBinarySearchTree<Integer> tree1 = new MyBinarySearchTree<Integer>();
		MyBinarySearchTree<Integer> tree2 = new MyBinarySearchTree<Integer>();
		
		tree1.buildFromArray(arr1);
		tree2.buildFromArray(arr2);
		
		tree3.buildFromArray(arr3);
		tree4.buildFromArray(arr4);
		
		System.out.println(MyBinarySearchTree.areEquals(tree1, tree2));
		System.out.println(MyBinarySearchTree.areEquals(tree3, tree4));
		System.out.println(MyBinarySearchTree.areEquals(tree1, tree3));
		System.out.println(MyBinarySearchTree.areEquals(tree1, tree4));
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
