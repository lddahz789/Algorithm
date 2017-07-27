package com.algorithm.note;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class 华为机试第三题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalNum = Integer.parseInt(sc.nextLine());
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= totalNum; i++) {
			String name = sc.nextLine();
			String phone = sc.nextLine();
			list.add(name);
			
		}
        String key = sc.nextLine();
        
        int result = find(key, list);
        System.out.println(result);
    }
    
    public static int find(String key, List<String> list){
    	int count = 0;
    	Iterator<String> iterator = list.iterator();
    	while (iterator.hasNext()){
    		String name = iterator.next();
    		String[] nameSplit = name.split(" ");
    		StringBuilder sb = new StringBuilder();
    		sb.append(nameSplit[0].charAt(0));
    		sb.append(nameSplit[1].charAt(0));
    		
    		if (name.equals(key) || sb.toString().equals(key) || nameSplit[0].equals(key)
    				|| nameSplit[1].equals(key))
    			count++;
    	}
    	return count;
    }
}

