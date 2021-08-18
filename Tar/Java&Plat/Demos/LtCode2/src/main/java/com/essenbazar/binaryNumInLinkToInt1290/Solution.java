
package com.essenbazar.binaryNumInLinkToInt1290;

/*
 * Given head which is a reference node to a singly-linked list. 
 * The value of each node in the linked list is either 0 or 1. 
 * The linked list holds the binary representation of a number.

	Return the decimal value of the number in the linked list.
	
	Input: head = [1,0,1]
	Output: 5
	Explanation: (101) in base 2 = (5) in base 10
 */

import java.util.*;

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

/*
 * The second subproblem is to convert (101)2 into 1×2^2 + 0×2^1 + 1×2^0 = 5 It
 * could be solved in two ways. To use classical arithmetic is more
 * straightforward
 * 
 * Approach 1: Binary Representation:
 * 
 * Initialize result number to be equal to head value: num = head.val. (This
 * operation is safe because the list is guaranteed to be non-empty)
 * 
 * Parse linked list starting from the head:
 * 
 * while head.next:
 * 
 * The current value is head.next.val.
 * 
 * Update the result by shifting it by one to the left and adding the current
 * value: num = num * 2 + head.next.val.
 * 
 * Complexity Analysis
 * 
 * Time complexity: O(N).
 * 
 * Space complexity: O(1).
 * 
 */

class Solution_BinaryRepresentation {
	public int getDecimalValue(ListNode head) {
		int num = head.val;
		while (head.next != null) {
			num = num * 2 + head.next.val;
			head = head.next;
		}
		return num;
	}
}

/*
 * Approach 2: Bit Manipulation:
 * 
 * 
 * 
 * Initialize result number to be equal to head value: num = head.val. This
 * operation is safe because the list is guaranteed to be non-empty.
 * 
 * Parse linked list starting from the head: while head.next:
 * 
 * The current value is head.next.val. Update the result by shifting it by one
 * to the left and adding the current value using logical OR: num = (num << 1) |
 * head.next.val.
 * 
 * Return num.
 * 
 * Complexity Analysis
 * 
 * Time complexity: O(N)
 * 
 * Space complexity: O(1)
 */

class Solution_BitManipulation {
	public int getDecimalValue(ListNode head) {
		int num = head.val;
		while (head.next != null) {
			num = (num << 1) | head.next.val;
			head = head.next;
		}
		return num;
	}
}

class Solution {

	public int getDecimalValue(ListNode head) {
		ArrayList<Integer> obj = new ArrayList<>();
		if (head.next == null) {
			obj.add(head.val);
		}
		while (head.next != null) {
			obj.add(head.val);
			head = head.next;
			if (head.next == null) {
				obj.add(head.val);
			}
		}
		Collections.reverse(obj);
		int sum = powerAndSum(obj);
		return sum;
	}

	public static int powerAndSum(List<Integer> list) {
		int sum = 0;
		int index = 0;
		for (int i : list) {
			sum += (int) i * Math.pow(2, index);
			index++;
		}
		return sum;
	}

	public static void main(String[] args) {
		Solution s1 = new Solution();
		ListNode l1 = new ListNode();
		l1.val = 1;
		System.out.println(s1.getDecimalValue(l1));
	}
}
