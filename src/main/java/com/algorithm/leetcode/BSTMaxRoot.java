package com.algorithm.leetcode;

import java.util.Stack;

public class BSTMaxRoot {

	/**
	 * 输入一个二叉树和一个整数，打印出二叉树中节点值的和等于输入整数所有的路径
	 * @param node
	 * @param target
	 */
	public void findPath(TreeNode node, int target){
		if (node == null)
			return;
		int currentSum = 0;
		Stack<Integer> stack = new Stack<>();
		findPath(node,target,stack,currentSum);
	}
	
	
	/**
	 * 输入一个二叉树和一个整数，打印出二叉树中节点值的和等于输入整数所有的路径
	 * @param node
	 * @param target
	 * @param stack
	 * @param currentNum
	 */
	public void findPath(TreeNode node, int target, Stack<Integer> stack, int currentNum){
		stack.push(node.data);
		currentNum += node.data;
		if (node.left == null && node.right == null){
			if(currentNum == target){
				for(int i:stack)
					System.out.println(i);
			}
		}
		
		if (node.left !=null)
			findPath(node.left,target,stack,currentNum);
		if (node.right !=null)
			findPath(node.right,target,stack,currentNum);
		stack.pop();
	}
	
	
	
}


class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
}