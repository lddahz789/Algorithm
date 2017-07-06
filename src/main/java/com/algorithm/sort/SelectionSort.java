package com.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度 O(n^2)
 * @author Zhuo He (Lyn)
 * @Date 2017-07-06
 *
 */
public class SelectionSort {

	private SelectionSort() {
	}

	public static void main(String[] args) {
		int n = 10000;
		Integer a[] = SortTestHelper.generateRandomArray(n, 0, n);
		
//		Arrays.sort(a);

		SortTestHelper.testSort("com.algorithm.sort.SelectionSort", a);
	}

	/**
	 * 
	 * @param array
	 *            要排序的数组
	 */
	public static void sort(Comparable[] array) {
		int n = array.length;
		for (int i = 0; i < n; i++) {
			// 从小到大排序
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (array[j].compareTo(array[minIndex]) < 0)
					minIndex = j;
			}
			SortTestHelper.swap(array, i, minIndex);
		}
	}

	
}
