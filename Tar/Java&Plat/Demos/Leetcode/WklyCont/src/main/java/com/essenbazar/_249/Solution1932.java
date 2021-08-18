package com.essenbazar._249;

//  Merge BSTs to Create Single BST
/*
 * You are given n BST (binary search tree) root nodes for n separate BSTs stored in an
 * array trees (0-indexed). Each BST in trees has at most 3 nodes, and
 * no two roots have the same value. In one operation, you can:

    Select two distinct indices i and j such that the value stored at one of the leaves of trees[i] is equal to the root value of trees[j].
    Replace the leaf node in trees[i] with trees[j].
    Remove trees[j] from trees.

	Return the root of the resulting BST if it is possible to form a valid BST after
	performing n - 1 operations, or null if it is impossible to create a valid BST.

	A BST (binary search tree) is a binary tree where each node satisfies the following property:

	    Every node in the node's left subtree has a value strictly less than the node's value.
	    Every node in the node's right subtree has a value strictly greater than the node's value.

	A leaf is a node that has no children.

	Example:

		Input: trees = [[5,3,8],[3,2,6]]
		Output: []
		Explanation:
		Pick i=0 and j=1 and merge trees[1] into trees[0].
		Delete trees[1], so trees = [[5,3,8,2,6]].
 */
/*
 * Intuition:
 *
 * 		Using map to store root value to root node
 * 		Using set to mark the deleted trees
 * 		Traverse the list of roots and check if left and right nodes can be replaced
 * 		Check if the new root forms valid BST
 * 	Special Case:
 * 		root1 set root2 as child and root2 trying to set root1 as child
 * 		* In this case we can use a map to maintain the new parent of the tree when it is modified, and check
 * 			if we are trying to set the parent as child when traversing the trees
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
