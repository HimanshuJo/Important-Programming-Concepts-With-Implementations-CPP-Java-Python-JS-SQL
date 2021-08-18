/*
Project for solving some common algorithm problems
 */
package com.essenbazar.TrimBinarySearchTree;

/**
 *
 * @author himan
 */

/*

Given the root of a binary search tree and the lowest and highest boundaries as low and high,
trim the tree so that all its elements lies in [low, high].

Trimming the tree should not change the relative structure of the elements that will
remain in the tree (i.e., any node's descendant should remain a descendant).

It can be proven that there is a unique answer.

Return the root of the trimmed binary search tree.
Note that the root may change depending on the given bounds.

Input: root = [1,0,2], low = 1, high = 2
Output: [1,null,2]

 */

 /*

Algo:

    All the value outside the left range
        e.g [5, 7] and the tree is below so, 2, 1 in the left sub-tree are outside the range
            2
           / \
          1   8 
             / \
            6   9
           / \
          5   7

    So the values outside the range will not be included in the result tree
        we need to remove these nodes
    
    So when the root is less than low, then the answer is root.right
        so, we need to work upon the right part
    
    We again check the root node and check does it fall in between the range or not
        As in the given example, the value 7 is less than the new root 8

            That means all the values greater than the root node are also not included in the result

                so we can say that, if the root is greater than high then the answer is root.left

    We again check if the root is again in the range, hence in this case (6 will be included in the result)
        and the root.left contains the left tree result
        and the root.right contains the right tree result
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

class Solution {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            // answer lie in the right part of this tree
            return trimBST(root.right, low, high);
        }

        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
