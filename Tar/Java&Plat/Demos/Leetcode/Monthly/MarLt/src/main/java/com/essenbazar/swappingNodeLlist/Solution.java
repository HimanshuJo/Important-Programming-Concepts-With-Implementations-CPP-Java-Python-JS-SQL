/*
Project for solving some Mar_21 leetcode problems
 */
package com.essenbazar.swappingNodeLlist;

/**
 *
 * @author himanshu
 */

/*

You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the
kth node from the end (the list is 1-indexed).

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]

 */

/*

Algo:

    Main task is to determine the locations of the nodes whose values are to be swapped
    This can be done by traversing the list using two pointers
        fast and slow with a certain distance between them

        The pointers move one node at a time

        The distance should be chosen such that:

            when slow is at head, fast points at the first node for swapping

            when fast is at the end, slow points at the second node for swapping

Example:

    [1, 2, 3, 4, 5], k = 2

    We traverse this list with fast and slow

    It is convenient to choose the initial position for slow to be at head i.e at 1

        If we choose fast to be k nodes after slow i.e at 3, we miss the node 2

        Therefore we put the fast k - 1 nodes after slow

        This means that the first node for swapping is the initial position of fast

        -------

        When fast is at 5, slow is at 4, which is the second node whose value will be swapped

        In other words the scond node for swapping when fast reaches the last node i.e fast.next == null

            For that distance between the slow and fast must be constant

                this is achieved by moving them both one node at a time until fast reaches the end

Algo:

    1. put slow at head, and put fast k - 1 nodes after slow

    2. first = fast

    3. If fast isn't already at the last node, move slow and fast one node further until fast.next == null

    4. second = slow

    5. swap the values of first and second

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

class Solution {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode first = head, second = head;
        
        for (int i = 0; i < k - 1; ++i)
            fast = fast.next;
        
        first = fast;
        
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        second = slow;
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        return head;
    }
}
