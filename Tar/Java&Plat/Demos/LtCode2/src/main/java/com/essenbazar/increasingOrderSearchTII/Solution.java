
package com.essenbazar.increasingOrderSearchTII;

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

	public TreeNode increasingBST(TreeNode root) {
		return increasingBST(root, null);
	}

	public TreeNode increasingBST(TreeNode root, TreeNode next_node) {
		if (root == null) {
			return next_node;
		}
		TreeNode res = increasingBST(root.left, root);
		root.left = null;
		root.right = increasingBST(root.right, next_node);
		return res;
	}

	public static void main(String[] args) {
		TreeNode t9 = new TreeNode(9);
		TreeNode t8 = new TreeNode(7);
		TreeNode t7 = new TreeNode(8, t8, t9);
		TreeNode t6 = new TreeNode(6, null, t7);
		TreeNode t5 = new TreeNode(4);
		TreeNode t4 = new TreeNode(1);
		TreeNode t3 = new TreeNode(2, t4, null);
		TreeNode t2 = new TreeNode(3, t3, t5);
		TreeNode t1 = new TreeNode(5, t2, t6);

		Solution my_obj = new Solution();
		my_obj.increasingBST(t1);
	}
}
