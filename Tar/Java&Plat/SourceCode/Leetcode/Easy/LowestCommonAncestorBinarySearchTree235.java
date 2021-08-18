/*

Base case:

    if root == null or
    root.val == p.val or
    root.val == q.val

        return root

Recursive case:

    In BST all the left node values are always less than the root value and
           all the right node values are always greater than the root value

   so if p.val < root.val  and q.val < root.val then

      we call lowestCommonAncestor(TreeNode root.left, TreeNode p, TreeNode q)

      if p.val > root.val and q.val > root.val the

      we call lowestCommonAncestor(TreeNode root.right, TreeNode p, TreeNode q)

*/

/*

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: 

“The lowest common ancestor is defined between two nodes p and q as the lowest node in T 
that has both p and q as descendants (where we allow a node to be a descendant of itself).”

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

      // base case

      if (root == null || root.val == p.val || root.val == q.val) {
        return root;
        
      }

      else if (root.val > p.val && root.val > q.val) {
        return lowestCommonAncestor(root.left, p, q);
      }

      else if (root.val < p.val && root.val < q.val) {
        return lowestCommonAncestor(root.right, p, q);
      }

      else return root;

    }
}