package com.algorithm.note;

import java.util.Scanner;
import java.util.Stack;

public class 华为机试第二题 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String target = in.nextLine();
		System.out.println((newCalculate(target)));
	}

	
	public static String newCalculate(String number){
		
		StringBuffer result = new StringBuffer();;
		Stack<Character> stack = new Stack<Character>();
		for (char c : number.toCharArray()){
			
			if (c != ')') {
				stack.push(c);
			} else {
				StringBuffer sBuffer = new StringBuffer();
				Stack<Character> stack2 = new Stack<Character>();
				while (!stack.isEmpty()){
					if (stack.peek() != '(') {
						stack2.push(stack.pop());
					} else {
						stack.pop();
						while (!stack2.isEmpty()){
							sBuffer.append(stack2.pop());
						}
						break;
					}
				}
				System.out.println(sBuffer.toString());
				String[] miniNum = sBuffer.toString().split(" ");
				int n1 = Integer.parseInt(miniNum[1]);
				int n2 = Integer.parseInt(miniNum[2]);
				int result1 = 0;
				switch (miniNum[0]) {
				case "add":
					result1 = n1 + n2;
					break;
				case "sub":
					result1 = n1 - n2;
					break;
				case "mul":
					result1 = n1 * n2;
					break;
				case "div":
					if (n2 == 0) 
						return "error";
					else 
						result1 = n1 / n2;
					break;
				default:
					break;
				}
				if (stack.isEmpty()) {
					stack.push(' ');
				}
				for (char c3 : (result1 + "").toCharArray()){
					stack.push(c3);
				}
				if (stack.isEmpty())
					stack.push(' ');
			}
		}
		Stack<Character> stack3 = new Stack<Character>();
		while(!stack.isEmpty()){
			stack3.push(stack.pop());
		}
		while (!stack3.isEmpty()) {
			result.append(stack3.pop());
		}
		return result.toString().trim();
	}
}

