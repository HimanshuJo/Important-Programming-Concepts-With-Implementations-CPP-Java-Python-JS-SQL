
package com.essenbazar.balancedBinaryTree110;

/*
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as:
 * 
 * a binary tree in which the left and right sub-trees of every node differ in
 * height by no more than 1.
 * 
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

	public boolean isBalanced(TreeNode root) {
		int left_tree_height;
		int right_tree_height;
		if (root == null) {
			return true;
		}
		left_tree_height = height(root.left);
		right_tree_height = height(root.right);
		if (Math.abs(left_tree_height - right_tree_height) <= 1 && 
				isBalanced(root.left) && isBalanced(root.right)) {
			return true;
		}
		return false;
	}

	int height(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}
}
