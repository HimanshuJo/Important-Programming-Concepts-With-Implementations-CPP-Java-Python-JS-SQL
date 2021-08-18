package com.essenbazar.binaryTreeCameras;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a binary tree, we install cameras on the nodes of the tree. 

	Each camera at a node can monitor its parent, itself, and its immediate children.

	Calculate the minimum number of cameras needed to monitor all nodes of the tree.
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
/*
 * Intuition: We need to start from the lowest level to reduce the number of cameras that we would require
 * 			  by not adding the camera at the leaf level which have the tendency of having the highest number of nodes
 */
class Solution {
	int cam;
	Set<TreeNode> covered;
	public int minCameraCover(TreeNode root) {
		if (root == null) return 0;
		cam = 0;
		covered = new HashSet<>();
		covered.add(null);
		// to call the dfs we need the parent, because I need to cover the parent of that particular node while
		// adding a camera to it
		dfs(root, null);
		return cam;
	}
	
	public void dfs(TreeNode node, TreeNode parent) {
		if (node != null) {
			// we have to go deeper into that tree, because we want to start from the very end of the tree
			dfs(node.left, node);
			dfs(node.right, node);
			
			// now I am the bottom of the node
			// here I need to check whether I need to add a camera over here
			// Parent is null and node is uncovered OR if any of its left and right are not covered
			if (parent == null && !covered.contains(node) || !covered.contains(node.left) || !covered.contains(node.right)) {
				// without adding null, prior at the beginning of the code, what happens over here is
				// when we go to the deepest node, it's child node would not be covered because it would not
				// contains the child nodes for the leaf that is the null nodes in the HashSet
				// therefore we have to add 'null' initially in the HashSet so that I can add the children of my leaf nodes
				// into the covered category
				
				// currently this code would not go and add the cameras on the leaf nodes but would start from one level
				// above the leaf nodes
				cam++;
				covered.add(node);
				covered.add(parent);
				covered.add(node.left);
				covered.add(node.right);
			}
		}
	}
}
/*
 * Time Complexity:
 * 		O(n) because we are going to traverse to each and every node
 * Space Complexity:
 * 		O(n) because we are taking a HashSet to store all the covered nodes, and the maximum nodes tha cameras would cover
 * 			is the entire tree
*/

/*
 * Can we do that without an extra space?
 * 	In a tree at a time we can have one of the three states
 * 		1. Either it is not covered by the camera
 * 		2. Either it has a camera
 * 		3. Either it is covered with a camera but it doesn't have a camera itself for that node
 * 	So these three states can be returned, and can be used to find whether I need to put a camera or not for that
 * 	particular node
 * 
 *  We will be marking the states as 0, 1 and 2
 *  	2 -> wherein I have the camera
 *  	1 -> wherein my node is covered with a camera
 *  	0 -> wherein the node is not covered
 */

class Solution2 {
	int cam;
	public int minCameraCover(TreeNode root) {
		int ans = dfs(root);
		// in the ans we can get either a 0, 1 or 2
		return ans == 0 ? cam + 1 : cam;
	}
	
	// 2 -> has Camera
	// 1 -> covered with cameras
	// 0 -> no camera is covering this node
	public int dfs(TreeNode node) {
		if (node == null) {
			// this condition is going to happen for the child node of the leaf node
			// we would say this node is covered by the camera, because we don't want to start from the leaf node
			return 1;		
		}
		int left = dfs(node.left);
		int right = dfs(node.right);
		// check if we need to add a camera or not
		if (left == 0 || right == 0) {
			cam++;
			return 2;
		}
		else if (left == 2 || right == 2) {
			return 1;
		} else return 0;
	}
}

/*
 * Time:
 * 	O(n)
 * 
 * Space:
 * 	O(H) where H is the height of the tree, to store the recursion stack
 */







