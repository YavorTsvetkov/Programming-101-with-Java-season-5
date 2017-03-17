package week6.sorting.mergeSort;

public class MergeSort {
	public static <T extends Comparable<T>> void mergeSort(T[] array) {
		recursiveDivide(array);
	}
	
	private static <T extends Comparable<T>> void recursiveDivide(T[] array) {
		if (array.length == 1) {
			return;
		}
		
		T[] left = divideArray(array, 0);
		T[] right = divideArray(array, array.length / 2);
		
		recursiveDivide(left);
		recursiveDivide(right);
		
		merge(left, right, array);
	}
	
	private static <T extends Comparable<T>> T[] divideArray(T[] array, int start) {
		int n = array.length;
		T[] halfArray = (T[])new Object[n / 2];
		
		for (int i = 0; i < halfArray.length; i++) {
			halfArray[i] = array[start + i];
		}
		
		return halfArray;
	}
	
	private static <T extends Comparable<T>> void merge(T[] left, T[] right, T[] upper) {
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < left.length && j < right.length) {
			if (left[i].compareTo(right[j]) <= 0) {
				upper[k] = left[i];
				i++;
				
			} else {
				upper[k] = right[j];
				j++;
			}
			k++;
		}
		
		if (i < left.length) {
			fillArray(upper, left, k, i);
		}
		
		if (j < right.length) {
			fillArray(upper, right, k, j);
		}
	}
	
	private static <T extends Comparable<T>> void fillArray(T[] receiver, 
															T[] sender,
															int receiverIndex,
															int senderIndex) {
		while (senderIndex < sender.length) {
			receiver[receiverIndex] = sender[senderIndex];
			receiverIndex++;
			senderIndex++;
		}
	}
}
