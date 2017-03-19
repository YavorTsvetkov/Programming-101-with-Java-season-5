package week6.sorting.countingSort;

public class CountingSort {

	public static Integer[] countingSort(Integer[] arr) {
		int min = getMin(arr);
		int max = getMax(arr);
		
		Integer[] histogram = getHistogram(arr, min, max);
		
		Integer[] sorted = sort(arr, histogram, min);
		
		return sorted;
	}
	
	private static int getMin(Integer[] arr) {
		int min = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		
		return min;
	}
	
	private static int getMax(Integer[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		return max;
	}
	
	private static Integer[] getHistogram(Integer[] array,
										  int min,
									      int max) {
		int size = (max - min) + 1;
		
		Integer[] histogram = new Integer[size];
		
		for (int i = 0; i < array.length; i++) {
			int histoIndex = array[i] - min;
			histogram[histoIndex]++;
		}
		
		addHistoElements(histogram);
		
		return histogram;
	}
	
	private static void addHistoElements(Integer[] histogram) {
		for (int i = 1; i < histogram.length; i++) {
			histogram[i] += histogram[i - 1];
		}
	} 
	
	private static Integer[] sort(Integer[] array, Integer[] histogram, int min) {
		Integer[] sorted = new Integer[array.length];
		
		for (int i = array.length - 1; i >= 0; i--) {
			histogram[array[i] - min]--;
			sorted[histogram[array[i] - min]] = array[i];
		}
		
		return sorted;
	}
}
