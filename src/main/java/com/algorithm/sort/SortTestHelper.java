package com.algorithm.sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SortTestHelper {

	// SortTestHelper不允许产生任何实例
	private SortTestHelper() {
	}

	// 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
	public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

		assert rangeL <= rangeR;

		Integer[] arr = new Integer[n];

		for (int i = 0; i < n; i++)
			arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
		return arr;
	}

	// 打印arr数组的所有内容
	public static void printArray(Object arr[]) {

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	// 判断arr数组是否有序
	public static boolean isSorted(Comparable[] arr) {

		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i].compareTo(arr[i + 1]) > 0)
				return false;
		return true;
	}

	public static void testSort(String className, Comparable[] arr) {
		try {
			Class sortClass = Class.forName(className);
			Method sortMethod = sortClass.getMethod("sort",new Class[]{Comparable[].class});
			Object[] params = new Object[]{arr};
			long startTime = System.currentTimeMillis();
			sortMethod.invoke(null, params);
			long endTime = System.currentTimeMillis();
			assert isSorted( arr );
			System.out.println( sortClass.getSimpleName()+ " : " + (endTime-startTime) + "ms" );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static void swap(Object[] arr, int elementOne, int elementTwo) {
		Object temp = arr[elementOne];
		arr[elementOne] = arr[elementTwo];
		arr[elementTwo] = temp;
	}
}
