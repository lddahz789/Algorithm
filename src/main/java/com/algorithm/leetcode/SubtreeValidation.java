package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubtreeValidation {
	/**
	 * 查找二叉树中的重复子树,把重复子树的父节点存入LIST返回
	 * 
	 * @param root
	 * @return
	 */
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		Map<String, Integer> map = new HashMap<>();
		preOrder(root, res, map);
		return res;
	}

	public String preOrder(TreeNode node, List<TreeNode> res, Map<String, Integer> map) {
		if (node == null)
			return "#";
		String serial = node.data + preOrder(node.left,res,map) + preOrder(node.right,res,map);
		if (map.getOrDefault(serial, 0) == 0){
				map.put(serial, 1);
		}else if (map.getOrDefault(serial, 0) == 1){
			map.put(serial, 2);
			res.add(node);
		}else{
			map.put(serial, map.get(serial) +1);
		}
		return serial;
	}
}
