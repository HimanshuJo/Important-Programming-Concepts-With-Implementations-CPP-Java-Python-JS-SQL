/*
Project for solving some Mar_21 leetcode problems
 */
package com.essenbazar.IntersecTwoLinkList;

/**
 *
 * @author himanshu
 */

/*

Brute Force Approach:
    Good starting point to get more intution behind the problem and the required approach,
        but the approach shouldn't be considered for coding as it just wastes time

    For brute force:
        for each node in list A, traverse over list in B and check whether or not the node is
            present in list B
        The one thing we need to be careful about is that, we are comparing objects of type 'Node'
            we don't want to compare the values within the nodes, doing this would cause our code to break
            when two different nodes have the same value

*/

public class Solution_2 {
    
    // Not a good approach to implement
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode pB = headB;
            while (pB != null) {
                if (headA == pB) return headA;
                pB = pB.next;
            }
            
            headA = headA.next;
        }
        return null;
    }
    
}


/*

Time Complexity:

    Let N be the length of list A and M be the length of list B

        O(N * M)

            For each of the N nodes in list A, we are traversing over each of the nodes in list B

            In the worst case, we won't find a match, and so will need to do this until reaching the end of the list B

Space Complexity:

    O(1)

        We aren't adding any additional data structures, so the amount of extra space used does not grow
             with the size of the input

*/