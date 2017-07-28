package com.algorithm.note;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Zhuo He (Lyn)
 * @Date 2017-07-28
 *
 */
public class 二叉树最大路径和集合 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		二叉树最大路径和集合 a = new 二叉树最大路径和集合();

	}

	/**
	 * 最大深度 递归
	 * 
	 * @param root
	 * @return
	 */
	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	/**
	 * 非递归求解是否有最大路径和为sum的路径
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Integer> sums = new Stack<Integer>();

		stack.push(root);
		sums.push(sum);
		while (!stack.isEmpty() && (root != null)) {
			int value = sums.pop();
			TreeNode top = stack.pop();

			if (top.left == null && top.right == null && top.val == value) {
				return true;
			}
			if (top.left != null) {
				stack.push(top.left);
				sums.push(value - top.val);
			}
			if (top.right != null) {
				stack.push(top.right);
				sums.push(value - top.val);
			}
		}
		return false;
	}

	/**
	 * 递归求解是否有最大路径和为sum的路径
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSumRecursion(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && root.val == sum)
			return true;
		return hasPathSumRecursion(root.left, sum - root.val) || hasPathSumRecursion(root.right, sum - root.val);
	}

	/**
	 * 判断是否有路径和为sum的路径, 返回总体数量
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public int pathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;
		return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}

	/**
	 * 返回从当前节点往下路径和等于SUM的路径数量
	 * 
	 * @param node
	 * @param sum
	 * @return
	 */
	public int pathSumFrom(TreeNode node, int sum) {
		if (node == null)
			return 0;
		return (node.val == sum ? 1 : 0) + pathSumFrom(node.left, sum - node.val)
				+ pathSumFrom(node.right, sum - node.val);
	}

	/**
	 * 返回二叉树中最大路径
	 * 
	 * @param root
	 */
	public void maxPathInTree(TreeNode root) {
		if (root == null)
			return;
		LinkedList<Integer> mapPath = new LinkedList<>();
		List<LinkedList<Integer>> allPath = new ArrayList<>();
		maxPathInTreeHelp(root, mapPath, allPath);
		getMaxPath(allPath);
	}

	public void maxPathInTreeHelp(TreeNode node, LinkedList<Integer> mapPath, List<LinkedList<Integer>> allPath) {
		if (node == null)
			return;
		mapPath.add(node.val);
		if (node.left == null && node.right == null)
			allPath.add(new LinkedList<Integer>(mapPath));
		maxPathInTreeHelp(node.left, mapPath, allPath);
		maxPathInTreeHelp(node.right, mapPath, allPath);
		mapPath.removeLast();
	}

	public void getMaxPath(List<LinkedList<Integer>> allPath) {
		LinkedList<Integer> max = new LinkedList<Integer>();
		for (int i = 1; i < allPath.size(); i++) {
			if (linkedListSum(allPath.get(i)) > linkedListSum(allPath.get(i - 1)))
				max = allPath.get(i);
		}
		for (Integer intMaxPath : max)
			System.out.print(intMaxPath + " ");
	}

	public int linkedListSum(LinkedList<Integer> list) {
		int sum = 0;
		for (Integer integer : list) {
			sum += integer;
		}
		return sum;
	}

	/**
	 * 二叉树两结点的最低公共祖先结点
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (hasNode(root.left,p) && hasNode(root.left, q))
			return lowestCommonAncestor(root.left,p,q);
		if (hasNode(root.right,p) && hasNode(root.right, q))
			return lowestCommonAncestor(root.right,p,q);
		return root;
	}

	public boolean hasNode(TreeNode root, TreeNode target) {
		if (root == null)
			return false;
		if (root == target)
			return true;
		return hasNode(root.left, target) || hasNode(root.right, target);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}