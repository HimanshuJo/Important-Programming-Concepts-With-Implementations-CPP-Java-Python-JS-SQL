/*
Project for solving some common algorithm problems
 */
package com.essenbazar.BinaryTreeRightSideView;

import java.util.*;

/**
 *
 * @author himan
 */

/*

Given a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4  

 */

 /*

    Here in the Binary Tree we have different levels
        and in each level we need to obtain the last value
    
    Here we can make out that this problem is a 'level order traversal' problem
        in this case we will just obtain the last value in each levels

Iterative:

    In the level order traversal we usually have a queue in which we try to put the values
        and then pop it according to some of the conditions

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
    
    List<Integer> list = new ArrayList<>();
    
    public List<Integer> rightSideView_Iterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (q.size() > 0) {
            int count = q.size();
            
            while (count-- > 0) {
                // we need to remove the values from the queue
                TreeNode val = q.remove();

                // is it the last value
                if (count == 0) {
                    res.add(val.val);
                }

                // else we need to put the left and right child nodes into the queue
                if (val.left != null) {
                    q.add(val.right);
                }
                
                if (val.right != null) {
                    q.add(val.right);
                }
            }
        }
        
        return res;
    }
    
    public List<Integer> rightSideView_Recursive(TreeNode root) {
        levelOrder(root, 0); // value 0 here signifies the level which we are currently in
        return list;
    }
    
    private void levelOrder(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        // list.size == level signifies that the node we are encountering right now
        // is the first node of that particular level
        if (list.size() == level) {
            list.add(node.val);
        }

        // call the method levelOrder recursively but right node first
        levelOrder(node.right, level + 1);
        levelOrder(node.left, level + 1);
    }
    
    public int sumOfUnique(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> keys = new ArrayList<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        System.out.println(map.toString());
        
        map.entrySet().stream().filter(entry -> (entry.getValue().equals(1))).forEachOrdered(entry -> {
            keys.add(entry.getKey());
        });
        
        System.out.println(keys.toString());
        int sum = 0;
        for (int i = 0; i < keys.size(); i++) {
            sum += keys.get(i);
        }
        return sum;
        
    }
    
    public static void main(String[] args) {
        Solution my_obj = new Solution();
        int[] nums = {1, 2, 3, 2};
        System.out.println(my_obj.sumOfUnique(nums));
    }
    
}
