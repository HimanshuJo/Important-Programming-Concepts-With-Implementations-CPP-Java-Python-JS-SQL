/*

Directory to test few algorithm tasks

 */
package com.essenbazar.lowestCommonAncestorBST235;

/**
 *
 * @author hjoshi
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
            System.out.println("Found root here ! " + root.val);
            return root;
        }
        else if (root.val > p.val && root.val > q.val) {
             return lowestCommonAncestor(root.left, p, q);
        }
        else if (root.val < p.val && root.val < q.val) {
             return lowestCommonAncestor(root.right, p, q);
        } else {
            System.out.println("Found root finally ! " + root);
            return root;
        }
    }

    static void display(TreeNode root) {

        if (root == null) {

            return;
        }

        if (root.left != null || root.right != null) {
            System.out.println(" " + root.val);
            System.out.println(root.left.val + " " + root.right.val);
        }

        display(root.left);
        display(root.right);

    }
    // [6,2,8,0,4,7,9,null,null,3,5] 2 4

    public static void main(String[] args) {
        Solution my_obj = new Solution();
        TreeNode tn = new TreeNode(6);
        TreeNode tn1 = new TreeNode(2);
        TreeNode tn2 = new TreeNode(0);
        TreeNode tn3 = new TreeNode(4);
        TreeNode tn4 = new TreeNode(3);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn6 = new TreeNode(8);
        TreeNode tn7 = new TreeNode(7);
        TreeNode tn8 = new TreeNode(9);

        tn.left = tn1;
        tn.right = tn6;
        tn1.left = tn2;
        tn1.right = tn3;
        tn2.left = null;
        tn2.right = null;
        tn3.left = tn4;
        tn3.right = tn5;
        tn6.left = tn7;
        tn6.right = tn8;
        System.out.println(my_obj.lowestCommonAncestor(tn, tn1, tn3));
        display(tn);

    }

}
