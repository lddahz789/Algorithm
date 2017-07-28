package com.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SumOf4Array {

	/**
	 * 时间复杂度 n2 空间复杂度n2
	 * 地址
	 * https://leetcode.com/problems/4sum-ii/tabs/description
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return
	 */
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length,res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < n; j++){
        		int sum = A[i] + B[j];
        		map.put(sum, map.getOrDefault(sum, 0) + 1);
        	}
        }
        
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < n; j++){
        		int sum = C[i] + D[j];
        		res += map.getOrDefault(sum * -1, 0);
        	}
        }
        
        return res;
    }
}
