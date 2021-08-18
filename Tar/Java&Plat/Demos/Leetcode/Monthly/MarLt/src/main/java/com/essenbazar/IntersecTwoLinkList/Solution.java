/*
Project for solving some Mar_21 leetcode problems
 */
package com.essenbazar.IntersecTwoLinkList;

/**
 *
 * @author himan
 */

/*

Given the heads of two singly linked-lists headA and headB,
return the node at which the two lists intersect.

If the two linked lists have no intersection at all, return null.

It is guaranteed that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'

Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).

From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5].
There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.

 */
class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = 0;
        int lenB = 0;

        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != null) {
            lenA++;
            tempA = tempA.next;
        }

        while (tempB != null) {
            lenB++;
            tempB = tempB.next;
        }

        int diff = Math.abs(lenA - lenB);

        tempA = headA;
        tempB = headB;

        if (lenA > lenB) {
            while (diff-- > 0) {
                tempA = tempA.next;
            }
        } else {
            while (diff-- > 0) {
                tempB = tempB.next;
            }
        }

        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;

            if (tempA == null || tempB == null) {
                return null;
            }
        }

        return tempA;

    }
}
