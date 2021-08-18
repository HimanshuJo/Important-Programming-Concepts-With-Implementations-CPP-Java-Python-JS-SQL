/*
Project for solving some common algorithm problems
 */
package com.essenbazar.copyListWithRandomPointer;

/**
 *
 * @author himan
 */

/*

A linked list of length n is given such that each node contains an additional random pointer,
which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
where each new node has its value set to the value of its corresponding original node.
Both the next and random pointer of the new nodes should point to new nodes in the copied
list such that the pointers in the original list and copied list represent the same list state.

None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y,
then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes.

Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to,
or null if it does not point to any node.
Your code will only be given the head of the original linked list

Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]

*/

/*

Store the mapping of each node in a HashMap
Once the mapping is done, we need to update the mapping with the next and the random pointer

*/

import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>();
        
        Node curr = head;
        
        while (curr != null) {
            map.put(curr, new Node(curr.val));  // it will have the same value we have in the curr
            curr = curr.next; 
        }
        
        for (Node node : map.keySet()) {
            Node newNode = map.get(node);
            newNode.next = map.get(node.next);
            newNode.random = map.get(node.random);
        }
        
        return map.get(head);
    }
}
