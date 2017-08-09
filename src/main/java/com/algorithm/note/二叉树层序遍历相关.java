package com.algorithm.note;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class 二叉树层序遍历相关 {

	/**
	 * 输出每层的平均值 节点和/节点数量
	 * 
	 * @param root
	 * @return
	 */
	public List<Double> averageOfLevels(TreeNode root) {
		if (root == null)
			return null;
		List<Double> res = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int n = q.size();
			double sum = 0;
			for (int i = 0; i < n; i++) {
				TreeNode temp = q.poll();
				sum += temp.val;
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
			}
			res.add(sum / n);
		}
		return res;
	}

	/**
	 * 由下向上输出层序遍历结果
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		
		if (root == null) return res;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()){
			int n = q.size();
			List<Integer> levelRes = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				TreeNode temp = q.poll();
				levelRes.add(temp.val);
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
			}
			res.add(0,levelRes);
		}
		return res;
	}
}
