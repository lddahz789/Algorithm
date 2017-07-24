package com.algorithm.note;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FrenquentProblems {

	/**
	 * 给定一个字符s,降序输出字符串 输入 ABCCC 输出CCCAB 或者 CCCBA
	 * 
	 * @param s
	 * @return
	 */
	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap();
		for (char a : s.toCharArray()) {
			if (map.containsKey(a))
				map.put(a, map.get(a) + 1);
			else
				map.put(a, 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> pr = new PriorityQueue<>(
				new Comparator<Map.Entry<Character, Integer>>() {
					@Override
					public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
						return o2.getValue() - o1.getValue();
					};
				});

		pr.addAll(map.entrySet());
		StringBuilder sb = new StringBuilder();
		while (!pr.isEmpty()) {
			Map.Entry<Character, Integer> prMap = pr.poll();
			for (int i = 1; i <= prMap.getValue(); i++)
				sb.append(prMap.getKey());
		}
		return sb.toString();
	}

	/**
	 * Given a non-empty array of integers, return the k most frequent elements.
	 * 
	 * For example, Given [1,1,1,2,2,3] and k = 2, return [1,2].
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]))
				map.put(nums[i], map.get(nums[i]) + 1);
			else
				map.put(nums[i], 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> pr = new PriorityQueue<>(
				new Comparator<Map.Entry<Integer, Integer>>() {
					@Override
					public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
						return o2.getValue() - o1.getValue();
					};
				});
		pr.addAll(map.entrySet());
		List<Integer> resultList = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			resultList.add(pr.poll().getKey());
		}
		return resultList;
	}

}
