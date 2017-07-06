package com.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序 时间复杂度 O(n^2)
 * 
 * @author Zhuo He (Lyn)
 * @Date 2017-07-06
 *
 */
public class InsertionSort {
	private InsertionSort() {
	}

	public static void sort(Comparable[] array) {

		for (int i = 1; i < array.length; i++) {

			for (int j = i; j > 0 && array[j].compareTo(array[j - 1]) < 0; j--) {
				SortTestHelper.swap(array, j, j - 1);
			}
		}
	}

	/**
	 *  比较SelectionSort和InsertionSort两种排序算法的性能效率
     *  此时，插入排序比选择排序性能略低
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 20000;
		System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

		Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
		Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

		SortTestHelper.testSort("com.algorithm.sort.InsertionSort", arr1);
		SortTestHelper.testSort("com.algorithm.sort.SelectionSort", arr2);

	}
}
