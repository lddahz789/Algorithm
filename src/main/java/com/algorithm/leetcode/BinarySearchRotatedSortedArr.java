package com.algorithm.leetcode;

public class BinarySearchRotatedSortedArr {

	public static int searchRotatedArr(int[] arr, int target) {
		int boundaryIndex = searchBoundary(arr);
		if(arr[0] <= target && target <= arr[boundaryIndex-1])
			return binarySearchRecursion(arr, target, 0, boundaryIndex-1);
		else
			return binarySearchRecursion(arr, target, boundaryIndex, arr.length-1);
	}

	public static int searchBoundary(int[] arr) {
		int l = 0;
		int r = arr.length - 1;
		int mid = l;
		while (arr[l] >= arr[r]) {
			
			if (r-l==1){
				mid = r;
				break;
			}
				
			mid = (r - l) / 2 + l;
			if (arr[mid] > arr[l])
				l = mid;
			if (arr[mid] < arr[r])
				r = mid;
		}
		return mid;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 1, 2, 3 };
		int[] arr2 = { 8, 10, 12, 15, 16,5, 6, 7 };
		int[] arrSorted = { 1, 2, 3, 4, 5, 6, 7 };
		// System.out.println(binarySearchRecursionStart(arrSorted, 5));
//		System.out.println(searchBoundary(arr2));
System.out.println(searchRotatedArr(arr,3));
	}

	/**
	 * 非递归二分查找
	 * 
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int binarySearch(int[] arr, int target) {
		int l = 0;
		int r = arr.length - 1;
		while (l <= r) {
			// 防止极端情况溢出
			int mid = (r - l) / 2 + l;
			if (target == arr[mid])
				return mid;
			if (target > arr[mid])
				l = mid + 1;
			if (target < arr[mid])
				r = mid - 1;
		}

		return -1;
	}

	/**
	 * 递归的二分查找
	 * 
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int binarySearchRecursionStart(int[] arr, int target) {

		return binarySearchRecursion(arr, target, 0, arr.length - 1);
	}

	public static int binarySearchRecursion(int[] arr, int target, int l, int r) {

		if (l > r)
			return -1;
		int mid = (r - l) / 2 + l;
		if (arr[mid] == target)
			return mid;
		else if (arr[mid] < target)
			return binarySearchRecursion(arr, target, mid + 1, r);
		else
			return binarySearchRecursion(arr, target, l, mid - 1);

	}

}