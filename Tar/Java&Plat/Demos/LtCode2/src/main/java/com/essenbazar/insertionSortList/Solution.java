
package com.essenbazar.insertionSortList;

import java.util.Arrays;

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

	public ListNode insertionSortList(ListNode head) {
		/*
		 *
		 * temp -> null | 4 -> 2 -> 1 -> 3 -> null
		 *
		 * temp will hold the sorted part
		 *
		 * initially 'curr' will be at 4 because we are dealing with a linked list and
		 * it is not an array, so we can not excercise a position using index
		 *
		 * therefore we have to use a pointer 'prev' at temp to traverse the sorted part
		 * from the beginning
		 *
		 * before adding the 'curr' from unsorted part to the sorted part we have to
		 * first unlink it from the unsorted part and mark the next node as 'next'
		 *
		 * 'curr' will be now in the temp part
		 *
		 * after adding 'curr' to the sorted part, we will again point it to the first
		 * node in the unsorted part, and shift the 'next' to the next node
		 *
		 * to again add 'curr' node to the sorted part, we have to traverse the sorted
		 * part and the 'curr' to the appropriate place
		 *
		 * temp -> 4 -> null | 2 -> 1 -> 3 -> null
		 *
		 * -------
		 *
		 * Time Complexity:
		 *
		 * O(n^2)
		 *
		 * we traverse the unsorted part from begining to end we traverse the sorted
		 * part for each element in the unsorted part to put it in the right spot
		 *
		 * Space Complexity:
		 *
		 * we only use a temp node and several pointers to complete the insertion sort
		 * therefore space complexity is O(1)
		 *
		 *
		 */
		if (head == null || head.next == null) {
			return head;
		}
		ListNode temp = new ListNode();
		ListNode curr = head;
		while (curr != null) {
			ListNode prev = temp;
			while (prev.next != null && prev.next.val < curr.val) {
				prev = prev.next; // traverse until find the right spot
			}
			ListNode next = curr.next;
			// insert current node between 'prev' and 'prev.next'
			curr.next = prev.next;
			prev.next = curr;
			// curr should again be in the unsorted list to bring back anaother element
			curr = next;
		}
		traverseLinkedList(temp.next);
		return temp.next;
	}

	void traverseLinkedList(ListNode head) {
		if (head != null) {
			while (head != null) {
				System.out.println(head.val);
				head = head.next;
			}
		}
	}

	public int[] insertionSort(int[] arr) {
		int i = 1;
		while (i < arr.length) {
			int j = i;
			while (j > 0 && arr[j - 1] > arr[j]) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
				j--;
			}
			i++;
		}
		return arr;
	}

	public int[] insertionSortFaster(int[] arr) {
		int i = 1;
		while (i < arr.length) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
			i++;
		}
		return arr;
	}

	public int[] insertionSortForLoop(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			int j;
			for (j = i; j > 0 && arr[j - 1] > temp; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = temp;
		}
		return arr;
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		int[] arr = { 6, 2, 1, 9, 8, 0, 7, 0, 123, 3, 89, 345, 242, 12432, 2342, 244, 1143, 2342, 223 };
		long startTime = System.nanoTime();
		System.out.println(Arrays.toString(my_obj.insertionSort(arr)));
		long stopTime = System.nanoTime();
		System.out.println("Execution time of 'normal while loop' is: " + (stopTime - startTime));
		long first_time = stopTime - startTime;
		System.out.println("-------");

		long startTime2 = System.nanoTime();
		System.out.println(Arrays.toString(my_obj.insertionSortFaster(arr)));
		long stopTime2 = System.nanoTime();
		System.out.println("Execution time of 'faster while loop' is: " + (stopTime2 - startTime2));
		long second_time = stopTime2 - startTime2;

		System.out.println("-------");

		long startTime3 = System.nanoTime();
		System.out.println(Arrays.toString(my_obj.insertionSortForLoop(arr)));
		long stopTime3 = System.nanoTime();
		System.out.println("Execution time of 'for loop' method is: " + (stopTime3 - startTime3));

		System.out.println("-------");

		System.out.println("Difference is: " + (first_time - second_time));
		long nano_time = first_time - second_time;
		double seconds = nano_time / 1_000_000_000.0;
		System.out.println("-------");

		System.out.println("time in seconds " + (seconds));

		System.out.println("-------");

		ListNode l4 = new ListNode(3);
		ListNode l3 = new ListNode(1, l4);
		ListNode l2 = new ListNode(2, l3);
		ListNode l1 = new ListNode(4, l2);

		Solution tes_obj = new Solution();

		System.out.println(tes_obj.insertionSortList(l1));

	}
}
