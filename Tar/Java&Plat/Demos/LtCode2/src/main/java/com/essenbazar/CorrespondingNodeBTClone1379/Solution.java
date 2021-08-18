
package com.essenbazar.CorrespondingNodeBTClone1379;

import java.util.*;

class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

/*
 * 
 * Given two binary trees original and cloned and given a reference to a node
 * target in the original tree.
 * 
 * The cloned tree is a copy of the original tree.
 * 
 * Return a reference to the same node in the cloned tree.
 * 
 * Note that you are not allowed to change any of the two trees or the target
 * node and the answer must be a reference to a node in the cloned tree.
 * 
 * Follow up: Solve the problem if repeated values on the tree are allowed.
 * 
 */

/*
 * Intuition: We can traverse both the trees in parallel, and once the target
 * node is identified in the first tree, return the corresponding node from the
 * second tree
 * 
 * How to traverse the trees: DFS vs BFS
 * 
 * In DFS, we further have three choices
 * 
 * Preorder Iterative with stack Recursive Morris
 * 
 * Postorder Iterative with stack Recursive Morris
 * 
 * Inorder Iterative with stack Recursive Morris
 * 
 * BFS with the help of LinkedList or PriorityQueue
 * 
 * -------
 * 
 * ** Description of a question doesn't always give us the clue which traversal
 * is better to use, However, interview simple question are DFS inorder
 * traversals
 * 
 * -------
 * 
 * Recursive Inorder DFS and iterative inorder DFS need up to O(H) space to keep
 * stack, where H is the height of the tree
 * 
 * -------
 * 
 * Could we solve the question in Constant Space: NO
 * 
 * -------
 * 
 * Algorithm 1:
 * 
 * DFS: Recursive Inorder Traversal
 * 
 * Main idea behind the algorithm: Left -> Node -> Right
 * 
 * -------
 * 
 * DFS PreOrder: Node -> Left -> Right
 * 
 * [root.val] + preorder(root.left) + preorder(root.right) if root else []
 * 
 * DFS Inorder: Left -> Node -> Right
 * 
 * inorder(root.left) + [root.val] + inorder(root.right) if root else []
 * 
 * DFS PostOrder: Left -> Right -> Node
 * 
 * postorder(root.left) + postorder(root.right) + [root.val] if root else []
 */

class Solution_DFSInorder {
	TreeNode ans, target;

	public void inorder(TreeNode o, TreeNode c) {
		if (o != null) {
			inorder(o.left, c.left);
			if (o == target) {
				ans = c;
			}
			inorder(o.right, c.right);
		}
	}

	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		this.target = target;
		inorder(original, cloned);
		return ans;
	}
}

/*
 * Time: O(N) Since one has to visit each node, where N is a number of nodes
 * 
 * Space: O(N) In the degenerative tree case (where the tree is shaped like a
 * linked list), all the nodes will be on the run-time stack while the deepest
 * node is being processed.
 * 
 * If the tree is balanced, the space complexity will be nearer to O(log N)
 * 
 * However, for the purpose of complexity analysis, we mostly consider the worst
 * case
 */

// Solution Iterative Inorder Traversal
// Iterative inorder traversal is straightforward:
// go left as far as we can, then one step right. Repeat till the end of the
// nodes in the tree
// Don't use stack in Java, use ArrayDeque instead?

class Solution_IterativeInorderDFS {
	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		Deque<TreeNode> stack_o = new ArrayDeque<>();
		Deque<TreeNode> stack_c = new ArrayDeque<>();
		TreeNode node_o = original, node_c = cloned;
		while (!stack_o.isEmpty() || node_o != null) {
			while (node_o != null) {
				stack_o.add(node_o);
				stack_c.add(node_c);
				node_o = node_o.left;
				node_c = node_c.left;
			}
			// if reach the farthest left end and haven't still found the target, we have
			// to pop this node and go one step right
			node_o = stack_o.removeLast();
			node_c = stack_c.removeLast();
			if (node_o == target) {
				return node_c;
			}
			node_o = node_o.right;
			node_c = node_c.right;
		}
		return null;
	}
}

/*
 * Time: O(N) Since one has to visit each node
 * 
 * Space: O(N) In the degenerative tree case (where the tree is shaped like a
 * linked list), all the nodes will be on the run-time stack while the deepest
 * node is being processed.
 * 
 * If the tree is balanced, the space complexity will be nearer to O(log N)
 * 
 * However, for the purpose of complexity analysis, we mostly consider the worst
 * case
 */

class Solution_DFSPreorder {

	TreeNode ans;

	public void preorder(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		// set the base case
		if (original == target) {
			ans = cloned;
			return;
		}
		// left recursion
		if (original.left != null) {
			preorder(original.left, cloned.left, target);
		}
		// right recursion
		if (original.right != null) {
			preorder(original.right, cloned.right, target);
		}
	}

	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		if (original == null) {
			return null;
		}
		preorder(original, cloned, target);
		return ans;
	}
}

/*
 * BFS:
 * 
 * Algorithm:
 * 
 * Add root to the queue
 * 
 * While queue is not empty Pop out a node from a queue
 * 
 * If the node is a target, stop
 * 
 * Add first left and then right child node into the queue
 */

class Solution_BFS {
	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		Deque<TreeNode> queue_o = new ArrayDeque<>();
		queue_o.offer(original);
		Deque<TreeNode> queue_c = new ArrayDeque<>();
		queue_c.offer(cloned);
		while (!queue_o.isEmpty()) {
			TreeNode node_o = queue_o.poll();
			TreeNode node_c = queue_c.poll();
			if (node_o == target) {
				return node_c;
			}
			if (node_o.left != null) {
				queue_o.offer(node_o.left);
				queue_c.offer(node_c.left);
			}
			if (node_o.right != null) {
				queue_o.offer(node_o.right);
				queue_c.offer(node_c.right);
			}
		}
		return null;
	}
}

/*
 * Time: O(N) since we have to visit all the nodes
 * 
 * Space: upto O(N) to keep the queue Considering the last level to estimate the
 * queue.size(). This level could contain upto N/2 nodes in case of a Complete
 * Binary Tree
 */