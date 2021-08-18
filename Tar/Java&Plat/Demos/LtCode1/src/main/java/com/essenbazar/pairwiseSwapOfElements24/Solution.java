/*

Directory to test few algorithm tasks

 */
package com.essenbazar.pairwiseSwapOfElements24;

/**
 *
 * @author himan
 */

/*
 * 
 * Given a singly linked list, write a function to swap elements pairwise.
 * 
 * Input : 1->2->3->4->5->6->NULL Output : 2->1->4->3->6->5->NULL
 * 
 * Input : 1->2->3->4->5->NULL Output : 2->1->4->3->5->NULL
 * 
 * Input : 1->NULL Output : 1->NULL
 * 
 * For example, if the linked list is 1->2->3->4->5 then the function should
 * change it to 2->1->4->3->5, and if the linked list is then the function
 * should change it to .
 * 
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

	public ListNode swapPairs(ListNode head) {
		ListNode temp = head;
		while (temp != null && temp.next != null) {
			int k = temp.val;
			temp.val = temp.next.val;
			temp.next.val = k;
			temp = temp.next.next;
		}
		return temp;
	}
}
