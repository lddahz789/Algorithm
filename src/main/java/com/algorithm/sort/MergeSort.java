package com.algorithm.sort;

import java.util.Arrays;

public class MergeSort {
public static void mergeSort(int[] arr){
	mergeSortRecursion(arr,0,arr.length-1);
}

/**
 * 递归使用归并操作对arr[l...r]的范围进行排序
 * @param arr
 * @param l
 * @param r
 */
private static void mergeSortRecursion(int[] arr,int l, int r){
	if (l >= r)
		return;
	int mid = l+(r-l)/2;
	mergeSortRecursion(arr,l,mid);
	mergeSortRecursion(arr,mid+1,r);
	merge(arr,l,mid,r);
}

/**
 * 将[l,mid] [mid+1,r]进行归并操作
 * @param arr
 * @param l
 * @param mid
 * @param r
 */
private static void merge(int[] arr, int l,int mid, int r){
	
//	int[] temp = new int[r-l+1];
//	for (int i = l; i <= r; i++) {
//		temp[i-l] = arr[i];
//	}
	int[] temp = Arrays.copyOfRange(arr, l, r+1);
	int i = l, j = mid+1;
	
	for(int k = l ; k<=r; k++){
		if (i > mid){
			arr[k] = temp[i-l];
			i++;
		}else if (j > r){
			arr[k] = temp[i-l];
			i++;
		}
		else if(temp[i-l] < temp[j-l]){
			arr[k] = temp[i-l];
			i++;
		}else{
			arr[k] = temp[j-l];
			j++;
		}
	}
	
}

public static int[] generateRandomArray(int n, int rangeL, int rangeR) {

	assert rangeL <= rangeR;

	int[] arr = new int[n];

	for (int i = 0; i < n; i++)
		arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
	return arr;
}

public static void main(String[] args) {
	int N = 300000;
	int[] arr1= generateRandomArray(N,0,N);

	mergeSort(arr1);
	for (int i = 0; i < 20; i++) {
		System.out.println(arr1[i]);
	}
}

}
