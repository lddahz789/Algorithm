package com.algorithm.note;

import java.util.Stack;

public class 字符串最长括号 {
	public int longestValidParentheses(String s) {
		int maxLength = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				stack.push(i);
			if (s.charAt(i) == ')') {
				stack.pop();
				if (stack.isEmpty())
					stack.push(i);
				int length = i - stack.peek();
				maxLength = length > maxLength ? length : maxLength;
			}
		}

		return maxLength;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}

}
