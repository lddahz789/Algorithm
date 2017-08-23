package com.algorithm.sort;

public class QuickSort {
	private QuickSort() {
	}

	public static void sort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int[] arr, int l, int r) {
		if (l >= r)
			return;
		int p = partition(arr,l,r);
		quickSort(arr,l,p-1);
		quickSort(arr,p+1,r);
	}
	
	
	private  static int partition(int[] arr, int l, int r){
		int index = (int)((Math.random()*(r-l+1))+l);
		swap(arr,l,index);
		int v = arr[l];
		int j = l;
		for(int i = l+1; i<=r;i++){
			if(arr[i] < v){
				j++;
				swap(arr,j,i);
			}
		}
		swap(arr,l,j);
		return j;
	}
	
	public static void swap(int[] arr, int a, int b){
		int temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
	}
	
	public static void main(String[] args) {
		int N = 30000000;
		int[] arr1= generateRandomArray(N,0,N);

		sort(arr1);
		for (int i = 0; i < 20; i++) {
			System.out.println(arr1[i]);
		}

	}
	
	public static int[] generateRandomArray(int n, int rangeL, int rangeR) {

		assert rangeL <= rangeR;

		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
		return arr;
	}
}
