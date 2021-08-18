package com.essenbazar.binaryTreeMaxPath124;

/*
 * 
 * A path in a binary tree is a sequence of nodes where each pair of adjacent
 * nodes in the sequence has an edge connecting them
 * 
 * A node can only appear in the sequence at 'most once'
 * 
 * Note that the path does not need to pass through the root
 * 
 * -------
 * 
 * The path sum of a path is the sum of the node's values in that path
 * 
 * -------
 * 
 * Given a non-empty binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any node sequence from some starting
 * node to any node in the tree along the parent-child connections. The path
 * must contain at least one node and does not need to go through the root.
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3] Output: 6
 * 
 */

/*
 * 
 * Algo:
 * 
 * If we are using the current root, we can use both 'left' and 'right'
 * 
 * else we can only use max(left, right)
 * 
 * Can be solved as a 'Post-Order' traversal
 * 
 * Time Complexity:
 * 
 * In the worst case, it is at least the height of the tree => O(n)
 * 
 * Space Complexity:
 * 
 * we have implicit stack height => O(n)
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

public class Solution {

	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		helper(root);
		return max;
	}

	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = Math.max(0, helper(root.left));
		int right = Math.max(0, helper(root.right));
		int sum = root.val + left + right;
		max = Math.max(max, sum);
		return Math.max(left, right) + root.val;
	}

	public static void main(String[] args) {
		TreeNode node_2 = new TreeNode(2);
		TreeNode node_3 = new TreeNode(3);
		TreeNode root = new TreeNode(1, node_2, node_3);
		Solution my_obj = new Solution();
		my_obj.maxPathSum(root);
	}
}
