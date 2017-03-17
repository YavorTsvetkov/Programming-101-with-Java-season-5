package week1.anagrams;

public class Sort {
	public static void selectionSort(StringBuilder word) {
		
		for (int i = 0; i < word.length() - 1; i++) {
			for (int j = i + 1; j < word.length(); j++) {
				if (word.charAt(j) < word.charAt(i)) {
					swap(word, i, j);
				}
			}
		}
	}
	
	public static void quickSort(StringBuilder word) {
		recursiveQuickSort(word, 0, word.length() - 1);
	}
	
	private static void recursiveQuickSort(StringBuilder word,
										   int leftBound, 
										   int rightBound) {
		if (leftBound >= rightBound) {
			return;
		}
		
		Integer pivotIndex = partition(word, leftBound, rightBound);
		recursiveQuickSort(word, leftBound, pivotIndex -1);
		recursiveQuickSort(word, pivotIndex + 1, rightBound);
	}
	
	private static int partition(StringBuilder word, int leftBound, int rightBound) {
		char pivot = word.charAt(rightBound);
		int q = leftBound - 1;
		
		for (int i = leftBound; i < rightBound; i++) {
			if (word.charAt(i) <= pivot) {
				q++;
				swap(word, i, q);
			}
		}
		
		swap(word, q + 1, rightBound);
		return q + 1;
	}
	
	private static void swap(StringBuilder word, int i, int j) {
		char swapper = word.charAt(i);
		word.setCharAt(i, word.charAt(j));
		word.setCharAt(j, swapper);
	}
}
