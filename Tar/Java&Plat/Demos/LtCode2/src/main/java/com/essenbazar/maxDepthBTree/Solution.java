
package com.essenbazar.maxDepthBTree;

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

	public int maxDepth(TreeNode root) {
		// pur base case, always needed in the tree questions
		if (root == null) {
			return 0;
		}
		// otherwise we have to ask it from the left and the right child
		int left = maxDepth(root.left);
		System.out.println("left at " + root.val + " is " + left);
		int right = maxDepth(root.right);
		System.out.println("-------");
		System.out.println("right at " + root.val + " is " + right);
		System.out.println("Max value is " + ((Math.max(left, right)) + 1));
		System.out.println("-------");
		System.out.println("-------");
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		TreeNode t5 = new TreeNode(7);
		TreeNode t4 = new TreeNode(15);
		TreeNode t3 = new TreeNode(20, t4, t5);
		TreeNode t2 = new TreeNode(9);
		TreeNode t1 = new TreeNode(3, t2, t3);
		Solution my_obj = new Solution();
		System.out.println(my_obj.maxDepth(t1));
	}
}
