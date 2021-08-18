/*
Project for solving some Mar_21 leetcode problems
 */
package com.essenbazar.IntersecTwoLinkList;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author himanshu
 */

/*

HashTable:

    Brute Force approach is inefficient because we repeatedly traverse over list B to check whether or not any of
        the nodes in list B were equal to the current one we were looking at in the list A

    Instead of repeatedly traversing through list B though, we could simply traverse it once and store each node
        in a hash table

        We could traverse through list A once, and each tim checking whether the current node exists in the hash table


Algorithm:

    Traverse list B and stores the address/reference of each node in a hash table
        Then for each node in list A, check whether or not that node exists in the hash table

        If it does, return it as it must be the intersection node
            if we get to the end of list A, without finding an intersection node return null

    The one thing we need to be careful of is that we're comparing objects of type 'Node'
        We don't want to compare the values within the nodes; doing this would cause
            our code to break when two different nodes have the same value

*/

public class Solution_3 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodesInB = new HashSet<>();
        
        while (headB != null) {
            nodesInB.add(headB);
            headB = headB.next;
        }
        
        while (headA != null) {
            if (nodesInB.contains(headA)) {
                return headA;
            }
            
            headA = headA.next;
        }
        
        return null;
    }
}

/*

Time Complexity:

    O(N + M)

    Firstly, we need to build up the HashTable. It costs O(1) to insert an item into a HashTable
        and we need to do this for each of the M nodes in list B

            This gives a cost of O(M) for building the hash table

    Secondly we need to traverse a list A, and for each node, we need to check whether or not
        it is in the HashTable

        In the worst case, there will not be a match, requiring us to check all N nodes in list A
        
        As it is also O(1) to check whether or not an item is in hash table, this checking has a total cost of O(n)

Space Complexity:
    
    As we are storing each of the nodes from list B into a hash table, the hash table will require O(M) space

*/