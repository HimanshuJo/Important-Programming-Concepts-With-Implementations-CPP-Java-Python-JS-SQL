/*

Directory to test few algorithm tasks

 */
package com.essenbazar.lowestCommomAncestorBT236;

/**
 *
 * @author hjoshi
 */
/*
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 */
class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root.val == p.val || root.val == q.val) {
			return root;
		} else {
			TreeNode left = lowestCommonAncestor(root.left, p, q);
			TreeNode right = lowestCommonAncestor(root.right, p, q);
			if (left != null && right != null) {
				return root;
			} else {
				return left != null ? left : right;
			}
		}
	}
}
