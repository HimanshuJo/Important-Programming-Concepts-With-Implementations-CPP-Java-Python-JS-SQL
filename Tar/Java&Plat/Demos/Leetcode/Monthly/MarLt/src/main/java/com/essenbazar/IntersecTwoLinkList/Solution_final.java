/*
Project for solving some Mar_21 leetcode problems
 */
package com.essenbazar.IntersecTwoLinkList;

/**
 *
 * @author himanshu
 */

/*

Two pointers:

    The best time complexity is O(M + N) as in the worst case, we'll need to look
        at every node at least once

    But the space complexity could be improved a lot

Intution:

    We can observe that while list A and list B could be different lengths, that the shared tail
        following the intersection has to be the same length

    Imagine that we have two linked lists, A and B and we know that their lengths are N and M respectively
        (the lengths can be calculated with O(1) space complexity and time proportional to the length of list

    Because the tail must be the same length, we can conclude that if there is an intersection, the the
        intersection node will be one of the nodes in the tail

    So to check for each of these pairs (node in list A and list B) of nodes in the tail.
        we will start by setting a pointer at the start of the shorter list, and a pointer at the first
        possible matching node of the longer list

        the position of this node is simply the difference betweent the two lengths that is |M - N|

    Then we just need to step the pointers through the list, each time checking whether or not the nodes are the same

Pseudocode:
    
    1. Calculate N, the length of list A

    2. Calculate M, the length of list B

    3. Set the start pointer for the longer list

    4. Step the pointers through the list together


Algo:

    Set pointer pA to point at headA

    Set point pB to pint at headB

    while pA and pB are not pointing at the same node
        if pA is pointing to null, set pA to point to headB

        else set pA to point at pA.next

        if pB is pointing to null, set to point to headA

        else set pB to point to pB.next 

*/



public class Solution_final {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        
        return pA;
    }
}

/*

Complexity Analysis

Let N be the length of list A and MMM be the length of list B.

    Time complexity : O(N + M)

    In the worst case, each list is traversed twice giving 2⋅M + 2⋅N which is equivalent to O(N + M)

    This is because the pointers firstly go down each list so that they can be "lined up" and then
        in the second iteration, the intersection node is searched for.

    An interesting observation you might have made is that when the lists are of the same length,
        this algorithm only traverses each list once.

        This is because the pointers are already "lined up" from the start, so the additional pass is unnecessary.

    Space complexity : O(1)

    We aren't allocating any additional data structures, so the amount of extra space used does
        not grow with the size of the input. For this reason, Approach 3 is better than Approach 2.


*/