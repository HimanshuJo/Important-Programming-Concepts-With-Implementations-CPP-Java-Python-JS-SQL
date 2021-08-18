
package com.essenbazar.linkedListRandomNode;

import java.util.ArrayList;

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

	ArrayList<Integer> al = new ArrayList<>();

	/**
	 * @param head The linked list's head. Note that the head is guaranteed to be
	 *             not null, so it contains at least one node.
	 */
	public Solution(ListNode head) {
		while (head != null) {
			this.al.add(head.val);
			head = head.next;
		}
	}

	/**
	 * Returns a random node's value.
	 */
	public int getRandom() {
		int pick = (int) (Math.random() * this.al.size());
		return al.get(pick);

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		Solution solution = new Solution(head);
		solution.getRandom();
	}
}
