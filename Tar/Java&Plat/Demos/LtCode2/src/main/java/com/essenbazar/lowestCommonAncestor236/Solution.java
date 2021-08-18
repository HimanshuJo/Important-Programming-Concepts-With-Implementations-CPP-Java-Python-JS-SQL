
package com.essenbazar.lowestCommonAncestor236;

/*

The lowest common ancestor (LCA) is defined between two nodes p and q as the lowest node in T
    that has both p and q as descendants (we allow a node to be descendant of itself)

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

 */

/*

We can use recursion in this problem

Base Case:

   if root == null or
   root.val == p.val or
   root.val == q.val

       return root

Recursive Case:

   we need to get the TreeNode at left and TreeNode at right

       TreeNode left = lowestCommonAncestor(TreeNode left, TreeNode p, TreeNode q)
       TreeNode right = lowestCommonAncestor(TreeNode right, TreeNode p, TreeNode q)

       check if left and right are not null
           return root
       else return the node which is not null

Time Complexity:

   O(n)  where n is the number of nodes in the tree

       as the worst case is similar to traversing a linked list


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
			System.out.println("Found it! " + root);
			return root;
		} else {
			TreeNode left = lowestCommonAncestor(root.left, p, q);
			TreeNode right = lowestCommonAncestor(root.right, p, q);
			if (right != null && left != null) {
				System.out.println("About to return the result " + root.val);
				return root;
			} else {
				return left != null ? left : right;
			}
		}
	}

	public static void printLeaves(TreeNode node) {
		if (node == null) {
			return;
		}
		if (node.left != null || node.right != null) {
			System.out.printf(" %s ", node.val);
			System.out.println("\n");
			System.out.printf("%s ", node.left.val);
			System.out.printf("%s ", node.right.val);
			System.out.println("\n");
		}
		printLeaves(node.left);
		printLeaves(node.right);
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		TreeNode tn = new TreeNode(3);
		TreeNode tn2 = new TreeNode(5);
		TreeNode tn3 = new TreeNode(1);
		TreeNode tn4 = new TreeNode(6);
		TreeNode tn5 = new TreeNode(2);
		TreeNode tn6 = new TreeNode(0);
		TreeNode tn7 = new TreeNode(8);
		TreeNode tn8 = new TreeNode(7);
		TreeNode tn9 = new TreeNode(4);
		tn.left = tn2;
		tn.right = tn3;
		tn2.left = tn4;
		tn2.right = tn5;
		tn3.left = tn6;
		tn3.right = tn7;
		tn7.left = null;
		tn7.right = null;
		tn5.left = tn8;
		tn5.right = tn9;
		System.out.println(my_obj.lowestCommonAncestor(tn, tn2, tn9));
		System.out.println("-------");
		printLeaves(tn);
	}
}
