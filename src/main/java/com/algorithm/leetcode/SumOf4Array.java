package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOf4Array {

	/**
	 * 时间复杂度 n2 空间复杂度n2 地址
	 * https://leetcode.com/problems/4sum-ii/tabs/description
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return
	 */
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int n = A.length, res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum = A[i] + B[j];
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum = C[i] + D[j];
				res += map.getOrDefault(sum * -1, 0);
			}
		}

		return res;
	}

	/**
	 * sum of three
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length-2;i++){
        	if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
            int sum = 0 - nums[i];
            int lo = i + 1;
            int hi = nums.length - 1;
            while(lo < hi){
                if (nums[lo] + nums[hi] == sum){
                    res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                    while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                    while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                    lo++;
                    hi--;
                } 
                else if (nums[lo] + nums[hi] < sum) lo++;
                else hi--;    
            }
        }}
        return res;
    }
	
	public static void main(String[] args) {
		int[] te = {-1,0,1,2,-1,-4};
		List<List<Integer>> a = threeSum(te);
		for (int i = 0; i < te.length; i++) {
			System.out.print(te[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
	
	}
}
