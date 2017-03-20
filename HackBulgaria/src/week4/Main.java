package week4;

import week4.genericBinarySearchTree.MyBinarySearchTree;

public class Main {
	public static void main(String[] args) {
		
		Integer[] arr1 = {7, 8, 6, 9, 1, 3, 2, 4, 5};
		Integer[] arr2 = {3, 4, 6, 9, 5, 7, 2, 8, 1};
		
		
		MyBinarySearchTree<Integer> tree2 = MyBinarySearchTree.buildBinarySearchTree(arr2);
		MyBinarySearchTree<Integer> tree1 = MyBinarySearchTree.buildBinarySearchTree(arr1);
		
		tree1.print();
		tree2.print();
		
		System.out.println(MyBinarySearchTree.areEquals(tree1, tree2));
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
