package com.algorithm.note;

import java.util.Scanner;

public class 华为机试第一题 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strAll = in.nextLine().split(" ");
		int p1 = Integer.parseInt(strAll[1]);
		int p2 = Integer.parseInt(strAll[2]);
		int p3 = Integer.parseInt(strAll[3]);
		String str = strAll[0];

		StringBuffer sb = new StringBuffer(str);

		StringBuffer temp = sb;
		int i = 0;
		int count = 0;
		for (int j = 0; j < str.length(); j++) {
			if (str.toCharArray()[j] == '-')
				count++;
		}
		boolean valid = isValid(str);
		if (!valid) {
			System.out.println("ERROR");
			return;
		}
		while (i != -1) {
			i = temp.indexOf("-", ++i);
			if (i > 0 && i < sb.length() - 1) {
				int stringP = i + 1, frontP = i - 1, p = i;
				char frontChar = temp.charAt(frontP);
				char backChar = temp.charAt(stringP);
				if (Character.isDigit(frontChar) && Character.isDigit(backChar) && frontChar < backChar) {
					sb.deleteCharAt(p);
					for (char c = ++frontChar; c < backChar; ++c) {
						String s = operate(c, p1, p2, 1);
						sb.insert(p, s);
						if (p3 != 2)
							p += p2;
					}
				} else if (Character.isLowerCase(frontChar) && Character.isLowerCase(frontChar) && frontChar < backChar) {
					sb.deleteCharAt(p);
					for (char c = ++frontChar; c < backChar; ++c) {
						String s = operate(c, p1, p2, 2);
						sb.insert(p, s);
						if (p3 != 2)
							p += p2;
					}
				}
			}
		}
		System.out.println(sb);
	}

	private static String operate(char c, int p1, int p2, int p3) {
		String result = "";
		while (p2 > 0) {
			if (p1 == 2 && p3 == 2)
				result += Character.toUpperCase(c);
			else if (p1 == 3) {
				result += "*";
			} else {
				result += c;
			}
			p2--;
		}
		return result;
	}
	
	public static boolean isValid(String str){
		boolean result = true;
		int count = 0;
		for (int j = 0; j < str.length(); j++) {
			if (str.toCharArray()[j] == '-')
				count++;
		}
		if (count != 1)
			result = false;
		return result;
		}
}
