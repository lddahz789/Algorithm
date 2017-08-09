package com.algorithm.note;

public class 字符串展开 {

	public static void main(String[] args) {
		String str = "2[a3[bc]]";
		System.out.println(expandString(str));
	}
	public static String expandString(String str){
		String res = "";
		int index = str.indexOf('[');
		if (index == -1)
			return str;
		int lastIndex = str.lastIndexOf(']');
		int times = str.charAt(index-1)-48;
		String temp = expandString(str.substring(index+1, lastIndex));
		for(int i = 1; i <= times;i++){
			res += temp; 
		}
		if (index > 1)
			res = str.substring(0,index-1) + res;
		if (lastIndex < str.length()-1)
			res = res + str.substring(lastIndex+1,str.length());
		return res;
	}
}
