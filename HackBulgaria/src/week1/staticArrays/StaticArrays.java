package week1.staticArrays;

import java.util.ArrayList;
import java.util.List;

public class StaticArrays {
	
	public static String toString(int[] a) {
		StringBuilder result = new StringBuilder();
		String separator = ", ";

		for(int i = 0; i < a.length; i++) {
			result.append(a[i]);
			if (i < (a.length - 1)) {
				result.append(separator);
			}
		}

		return result.toString();
	}

	public static void sort(int[] a) {

		for(int i = 0; i < a.length - 1; i++) {
			for(int j = i + 1; j < a.length; j++) {

				if(a[j] < a[i]) {
					int swapper = a[j];
					a[j] = a[i];
					a[i] = swapper;
				}
			}
		}

	}

	public static int[] reverse(int[] a) {
		for(int i =0; i <= a.length / 2; i++) {
			int swapper = a[i];
			a[i] = a[a.length - 1 -  i];
			a[a.length - 1 - i] = swapper;
		}
		return a;
	}
	
	public static String join(int[] a, String glue) {
		StringBuilder result = new StringBuilder();
		String separator = glue;

		for(int i = 0; i < a.length; i++) {
			result.append(a[i]);
			if (i < (a.length - 1)) {
				result.append(separator);
			}
		}

		return result.toString();
	}
	

	public static int sum(int[] a) {
		int sum = 0;

		for(int number : a) {
			sum += number;
		}

		return sum;
	}

	public static int[] range(int firstNum, int secondNum) {
		int count = secondNum - firstNum;
		int[] sequence = new int[count];
		int number = firstNum;
		for(int i = 0; i < count; i++) {
			sequence[i] = number;
			number++;
		}

		return sequence;

	}

	public static int[] filterOdd(int[] a) {
		List<Integer> list = new ArrayList<Integer>();

		for(int number : a) {
			if(number % 2 != 0) {
				list.add(number);
			}
		}

		int[] array = new int[list.size()];

		for(int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		
		return array;
	}
}
