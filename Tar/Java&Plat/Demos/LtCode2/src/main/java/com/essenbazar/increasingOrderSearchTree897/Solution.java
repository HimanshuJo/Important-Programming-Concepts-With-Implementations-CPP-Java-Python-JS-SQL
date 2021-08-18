package com.essenbazar.increasingOrderSearchTree897;

/*
 * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost 
 * node in the tree is now the root of the tree, and every node has no left child and only one right child.
 * 
 * Example 1:
 * 
 * 		Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
		Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 */

import java.util.ArrayList;
import java.util.List;

/*
 * Approach 1: In-order Traversal:
 * 
 * 		Intuition:
 * 
 * 			The definition of a binary search tree is that for every node, all the values of the left branch are less
 * 				than the value of the root, and all the values of the right branch are greater than 
 * 				the value of the root.
 * 			
 * 			Because of this, an in-order traversal of the nodes will yield the values in an increasing order.
 * 
 * 	Algorithm:
 * 
 * 		Once we have traversed all the nodes in an increasing order, we can construct new nodes using those values
 * 			to form the answer
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
	public TreeNode increasingBST(TreeNode root) {
		List<Integer> vals = new ArrayList<>();
		inorder(root, vals);
		TreeNode ans = new TreeNode(0);
		TreeNode cur = ans;
		for (int v : vals) {
			cur.right = new TreeNode(v);
			cur = cur.right;
		}
		return ans.right;
	}

	public void inorder(TreeNode node, List<Integer> vals) {
		if (node == null) {
			return;
		}
		inorder(node.left, vals);
		vals.add(node.val);
		inorder(node.right, vals);
	}
}

/*
 * Time: O(N), where N is the number of nodes in the given tree
 * 
 * Space: O(N)
 */

/*
 * 
 * Approach 2: Traversing with Relinking
 * 
 * Intuition:
 *
 * We can perform the same in-order traversal as in Approach 1.
 *
 * During the traversal, we'll construct the answer on the fly, reusing the
 * nodes of the given tree by cutting their left child and adjoining them to the
 * answer
 */

class Solution3 {
	TreeNode cur;

	public TreeNode increasingBST(TreeNode root) {
		TreeNode ans = new TreeNode(0);
		cur = ans;
		inorder(root);
		return ans.right;
	}

	public void inorder(TreeNode node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		node.left = null;
		cur.right = node;
		cur = node;
		inorder(node.right);
	}
}

/*
 * Time: O(N), where N is the number of nodes in the given tree
 * 
 * Space: O(H), additional space complexity, where H is the height of the given
 * tree, and the size of the implicit call stack in our in-order traversal
 */
