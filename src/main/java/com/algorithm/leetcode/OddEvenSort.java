package com.algorithm.leetcode;

public class OddEvenSort {
	
	public static void oddFirst(int[] arr){
		int left = 0;
		int right = arr.length-1;
		while(left != right){
			
			while(arr[left]%2 != 0 && left <right)
				left +=1;
			while(arr[right]%2 == 0 && left <right)
				right -=1;
			swap(arr,left,right);
			
		}
	}
	
public static void main(String[] args) {
	int[] arr = {5,4,1,2,5,1,67,89,0,1,10,12,15,16};
	oddFirst(arr);
	for (int i = 0; i < arr.length; i++) {
		System.out.println(arr[i]);
	}
}

public static void swap(int[] arr, int a, int b){
	int temp = arr[b];
	arr[b] = arr[a];
	arr[a] = temp;
}

}
