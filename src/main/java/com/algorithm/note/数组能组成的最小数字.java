package com.algorithm.note;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 数组能组成的最小数字 {
    public String PrintMinNumber(int [] numbers) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < numbers.length;i++)
			list.add(numbers[i]);
		Collections.sort(list,new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = o1+""+o2;
				String s2 = o2+""+o1;
				return s1.compareTo(s2);
			}});
		StringBuilder sb = new  StringBuilder();
		for(int i:list)
			sb.append(String.valueOf(i));
    	return sb.toString();
    }
}
