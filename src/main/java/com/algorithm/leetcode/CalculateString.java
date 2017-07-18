package com.algorithm.leetcode;

import java.util.Stack;

public class CalculateString {

	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			try {
				int num = Integer.parseInt(tokens[i]);
				stack.push(num);
			} catch (NumberFormatException e) {
				int numA = stack.pop();
				int numB = stack.pop();
				stack.push(calculate(tokens[i],numA,numB));
			}
		}

		return stack.pop();

	}

	private static int calculate(String expression, int a, int b) {
		switch (expression) {
		case "+":
			return a + b;
		case "-":
			return b - a;
		case "*":
			return a * b;	
		case "/":
			return b / a;
		default: return 0; 
		}
	}

	public static void main(String[] args) {
		String[] em = {"4","13","5","/","+"};
		for (int i = 0; i < em.length; i++) {
			System.out.println(em[i]);
		}
	}
}
