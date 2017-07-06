package com.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author Zhuo He (Lyn)
 * @Date 2017-07-06
 *
 */
public class BubbleSort {
	private BubbleSort() {
	}

	public static void sort(Comparable[] arr) {
		int n = arr.length;
		boolean swapped = false;
		do {
			swapped = false;
			for (int i = 0; i < n - 1; i++) {
				if (arr[i].compareTo(arr[i + 1]) > 0) {
					SortTestHelper.swap(arr, i, i + 1);
					swapped = true;
				}
			}
			n--;
		} while (swapped);

	}

	public static void main(String[] args) {
		int N = 30000;
		System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

		Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);

		SortTestHelper.testSort("com.algorithm.sort.BubbleSort", arr1);

	}

}
