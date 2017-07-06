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

	public static void sort(Comparable[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			Comparable e = arr[i];
			int j = i;
			for (; j > 0 ; j--) {
				if(arr[j-1].compareTo(e) > 0){
					arr[j] = arr[j-1];
				}
			}
			arr[j] = e;
		}
	}

	/**
	 *  比较SelectionSort和InsertionSort两种排序算法的性能效率
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 30000;
		System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

		Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
		Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

		SortTestHelper.testSort("com.algorithm.sort.SelectionSort", arr1);
		SortTestHelper.testSort("com.algorithm.sort.InsertionSort", arr2);
		

	}
}
