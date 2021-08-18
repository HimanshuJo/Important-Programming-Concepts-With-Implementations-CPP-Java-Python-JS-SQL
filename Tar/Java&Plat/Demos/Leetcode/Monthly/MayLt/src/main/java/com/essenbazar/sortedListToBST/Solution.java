/*
Project for solving some May_21 leetcode problems
 */
package com.essenbazar.sortedListToBST;

/**
 *
 * @author himanshu
 */

/*

Given the head of a singly linked list where elements are sorted in ascending order, 
    convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which 
    the depth of the two subtrees of every node never differ by more than 1.

 */

 /*

Different approaches to solve:
    1. Converting the list into an array and convert this array into BST
        (require extra space though)
    
    2. Recursion (find the mid, and the create the Tree using the list itself)

    -------

    Using Recursion:

        Step 1: Finding the mid that will be our root

            To find the mid in the linked list the general approach that is used by using 2 pointers
                Fast and Slow

                -------

                At start both the pointers are at head

                From here the slow pointer moves one step at a time
                    
                    while the Fast pointer moves twice as fast as the Slow pointer

                Thus when the slow pointer reaches the mid, the fast pointer will be at the end

        -------

        As soon as we find the mid, we divide it into two parts
            left and right tree

        -------

        After that we will follow the same procedure of finding the mid in the left and the right subtree

        -------

        Finally we will be left with just a single node in the left and the right subtree
            these nodes itself becomes the mid

    -------

Algo:

    Recursive method to create Tree  --> sortedListToBst(ListNode head)

        if head = null; return null

        find mid node: Call the mid method mid(head)

        create root node with value as mid.val

        if head = mid; return root

        root.left = recursive call sortedListToBST(head)

        root.right = recursive call sortedListToBST(mid.next)

    Finding mid and breaking the previous links  --> mid(ListNode head)

        initialize slow, fast, prev to head

        while fast NOT_NULL and fast.next NOT_NULL
            assign prev to slow
            move slow 1 step
            move fast 2 steps

        if prev is NOT_NULL
            break the link between the prev and prev.next

        return slow

 */
class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

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

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode mid = mid(head);
        TreeNode root = new TreeNode(mid.val);

        if (head == mid) {
            return root;
        }

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }

    public ListNode mid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = slow;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }
}
