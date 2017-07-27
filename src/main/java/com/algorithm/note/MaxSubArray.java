package com.algorithm.note;

public class MaxSubArray {

	/**
	 * 数组解法 设sum[i] = A[0] +Ａ[1] + …… +Ａ[i] 记S[i, j]为从子数组A[i],…..A[j]的和，则S[i, j]
	 * = sum[j] - sum[i-1], 如何求出最大的S[i,
	 * j]，一个很直观的想法就是再遍历j的时候，我们使得sum[i-1]保持最小，即可得到在j在当前的最小子数组和，另外每遍历一次j，我们就像当前的到的S[i,
	 * j]和保留值作比较，并更新maxSum。
	 * 
	 * 复杂度：时间复杂度O(n)，空间复杂度O(n)
	 * 
	 * @param arr
	 * @return
	 */
	public int maxSubArray(int[] arr) {
		int[] sum = new int[arr.length];
		sum[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			sum[i] = sum[i - 1] + arr[i];
		}
		int maxSum = sum[0];
		int min = 0;
		for (int j = 1; j < sum.length; j++) {
			if (sum[j - 1] < min)
				min = sum[j - 1];
			if (sum[j] - min > maxSum)
				maxSum = sum[j] - min;
		}

		return maxSum;
	}
	
	
	/**
	 * 动态规划解法
	 * @param A
	 * @return
	 */
	public int maxSubArrayDP(int[] A) {
        int n = A.length;
      //dp[i] means the maximum subarray ending with A[i];
        int[] dp = new int[n];
        
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
}
	
}
