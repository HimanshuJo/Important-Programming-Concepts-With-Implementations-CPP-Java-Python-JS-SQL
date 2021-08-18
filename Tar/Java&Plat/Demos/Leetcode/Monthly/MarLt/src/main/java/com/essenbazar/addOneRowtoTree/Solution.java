/*
Project for solving some Mar_21 leetcode problems
 */
package com.essenbazar.addOneRowtoTree;

/**
 *
 * @author himanshu
 */

/*

Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with 
value v at the given depth d. The root node is at depth 1.

The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1,
create two tree nodes with value v as N's left subtree root and right subtree root.

And N's original left subtree should be the left subtree of the new left subtree root,
its original right subtree should be the right subtree of the new right subtree root.

If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v 
as the new root of the whole original tree, and the original tree is the new root's left subtree.

Example 1:

Input: 
A binary tree as following:
       4
     /   \
    2     6
   / \   / 
  3   1 5   

v = 1

d = 2

Output: 
       4
      / \
     1   1
    /     \
   2       6
  / \     / 
 3   1   5   



*/

/*

We basically have to make changes to the nodes at D - 1

    Till D we will do nothing and the tree remains the same, as soon as we reach depth - 1
        
                At depth - 1 we'll have a left node and a right node

        we will start from the left
            
            take the node's left node (if available) in a temp variable

            and attach a new node of the value given to us in the left node
                finally we will attach the temp node to the new node that we have recently added
            
            similarly we will do for the node's right node
                if the node has no right node, then simply attach the new node of the value given to us
        
        do the same thing for the right node
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

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        
        insert(root, d, v, 1);
        return root;

    }
    
    
    public void insert(TreeNode node, int d, int v, int currentDepth) {
        if (node == null) return;
        
        if (currentDepth == d - 1) {
            TreeNode temp = node.left;
            node.left = new TreeNode(v);
            node.left.left = temp;
            
            temp = node.right;
            node.right = new TreeNode(v);
            node.right.right = temp;
            
        } else {
            insert(node.left, d, v, currentDepth + 1);
            insert(node.right, d, v, currentDepth + 1);
        }
    }
}
