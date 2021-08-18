/*
Project for solving some April_21 leetcode problems
 */
package com.essenbazar.palindromeLinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author himanshu
 */

/*

Given the head of a singly linked list, return true if it is a palindrome.

Example 1:

Input: head = [1,2,2,1]
Output: true


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

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        //System.out.println(list.toString());
        Collections.reverse(list);

        int count = 0;
        int ii = 0;

        while (head != null) {
            if (head.val == list.get(ii)) {
                count++;
            }
            ii++;
            head = head.next;
        }

        return count == list.size();
    }
}

/*

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



How to solve it in O(1) space

Suppose we have a list:  1 -> 2 -> 2 -> 1

    we can find the mid of this particular list

    after we have the list and the mid, we want two separate lists

    -------

    Now we can reverse any one of the lists

        suppose we reverse the second list:

        Now we have: 1 -> 2 | 2 <- 1

        In the first list, the head will be at 1

        In the second list, the head will be at 1

    Now when I compare both these lists, we can get an equal value
        when I move in, in both the lists

    -------

    Tricky point is to reverse a list:

        2 -> 1 -> 3 -> null | null <- 2 <- 1 <- 3

        Reverse a list:

            1. Take a node prev -> null 
                // this will eventually become our last node which will be
                // attached to null

            2. Loop while head != null

            3. Reverse the pointer
            
                3.1 Catch head's next 
                        next = head.next

                3.2 head.next = prev

                3.3 prev = head

                3.4 head = next

            -------

            a. Take a prev node as null
            b. Catch head's next
            c. Put at head.next, the prev
            d. Put at prev, the head
            e. Put at head, the next



public class SolutionOpt {

    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;  // catch head's next
            
            // now I want to reverse the next pointer and move my head and previous
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev; // as head is now at previous node
    }
    
    
    
    public boolean isPalindrome(ListNode head) {
        
        // finding mid
        // here we will take turtle and rabbit pointers
            // turtle will move at a speed of 1 
            // rabbit will move at a speed of 2 * turtle
        // while rabbit reaches null, turtle will be at the mid
        
        ListNode rabbit = head;
        ListNode turtle = head;
        
        while (rabbit.next != null && rabbit.next.next != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;
        }
        
        // if the list is 1, 2, 3  and --> turtle = 2, rabbit = 3
            // the above while loop will not run further
            // here I have to break the list at  1 || 2 3
            
        // however, we want to reduce the time we are spending over reversing a linked list
            // so I will take one list element and I will do
            // turtle = turtle.next (when the list is of odd length)
        // how do we generally find out that, at that moment the rabbit will not be null
        
        if (rabbit != null) turtle = turtle.next;  // turtle is at mid now
        
        // reversing the list starting from slow
        ListNode revHead = reverse(turtle);
        
        while (revHead != null) {
            if (revHead.val != head.val) return false;
            else {
                revHead = revHead.next;
                head = head.next;
            }
        }
        
        return true;
    }
}

*/
