package com.essenbazar.bTreeRightsideView199;

/*
 * Given the root of a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.
 */

import java.util.*;

class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Solution {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		helper_dfs(root, 0, res);
		return res;
	}

	public List<Integer> rightSideView_2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		helper_bfs(res, q);
		return res;
	}

	private void helper_bfs(List<Integer> res, Queue<TreeNode> q) {
		while (q.size() > 0) {
			int count = q.size();
			while (count-- >= 0) {
				TreeNode val = q.remove();
				if (count == 0) {
					res.add(val.val);
				}
				if (val.left != null) {
					q.add(val.right);
				}
				if (val.right != null) {
					q.add(val.right);
				}
			}
		}
	}

	private void helper_dfs(TreeNode root, int i, List<Integer> res) {
		if (root == null) {
			return;
		}
		if (res.size() == i) {
			res.add(root.val);
		}
		helper_dfs(root.right, i + 1, res);
		helper_dfs(root.left, i + 1, res);
	}

}
