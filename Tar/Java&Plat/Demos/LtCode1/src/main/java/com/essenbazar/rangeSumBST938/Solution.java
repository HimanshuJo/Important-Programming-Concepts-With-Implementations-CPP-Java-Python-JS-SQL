
package com.essenbazar.rangeSumBST938;

/**
 *
 * @author hjoshi
 */
/*
 * Given the root node of a binary search tree and two integers low and high,
 * return the sum of values of all nodes with a value in the inclusive range
 * [low, high].
 */
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

	private int sum = 0;

	public int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null) {
			return 0;
		}
		inOrderTraversal(root, low, high);
		return sum;
	}

	private void inOrderTraversal(TreeNode root, int low, int high) {

		if (root == null) {
			return;
		}
		if (root.val <= high && root.val >= low) {
			sum += root.val;
		}
		inOrderTraversal(root.left, low, high);
		inOrderTraversal(root.right, low, high);
	}
}
