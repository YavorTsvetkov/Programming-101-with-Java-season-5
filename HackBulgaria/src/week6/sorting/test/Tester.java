package week6.sorting.test;

import org.junit.Test;

import junit.framework.Assert;
import week6.sorting.SortingAlgorithms;

public class Tester {
	@Test
	public void selectionSortTester() {
		Integer[] arr = {5, 1, 4, 5, 7, 8, 10, 4, 12, 54};
		int[] exp = {1, 4, 4, 5, 5, 7, 8, 10, 12, 54};
		SortingAlgorithms.selectionSort(arr);
		
		//Assert.assertEquals(exp, arr);
		Assert.assertSame(exp, arr);
	}
}
