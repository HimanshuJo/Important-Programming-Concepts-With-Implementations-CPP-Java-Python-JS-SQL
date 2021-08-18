/*
Project for solving some May_21 leetcode problems
 */
package com.essenbazar.flattenBinaryTreeToLinkedList;

/**
 *
 * @author himanshu
 */
/*
Given the root of a binary tree, flatten the tree into a "linked list":

    The "linked list" should use the same TreeNode class where the right child pointer points to the
        next node in the list and the left child pointer is always null.
    The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 */
 /*
Algo:
    Take tempLeft, tempRight to store the left and right
    Make node->left as null
    Flatten left (tempLeft) and right (tempRight) tree recursively
    Attach till the bottommost node in the attached part and attach the right of it
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

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;
        root.left = null;

        // recursively call the functions recursively to flatten the available left and right sub-tree
        flatten(tempLeft);
        flatten(tempRight);

        // at this point we have the flatten trees and we need to attach them where necessary
        root.right = tempLeft;

        // we need to travel till the end of the currently attached tempLeft and then attach my rightnode
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = tempRight;
    }
}

// Algo with constant space
class SolutionMorrisTraversal {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            if (root.left != null) {
               // going to the rightmost child of that left node
               TreeNode left = root.left;
               TreeNode curr = left;
               while (curr.right != null) {
                   curr = curr.right;
               }
               curr.right = root.right;
               root.left = null;
               root.right = left;
            }
            root = root.right;
        }
    }
}
