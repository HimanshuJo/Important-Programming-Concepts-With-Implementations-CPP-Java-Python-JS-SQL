
package com.essenbazar.NextGreaterElementIII556;

import java.util.Arrays;

/**
 *
 * @author himan
 */

/*
 * 
 * Given a positive integer n, find the smallest integer which has exactly the
 * same digits existing in the integer n and is greater in value than n. If no
 * such positive integer exists, return -1.
 * 
 * Note that the returned integer should fit in 32-bit integer, if there is a
 * valid answer but it does not fit in 32-bit integer, return -1.
 * 
 * Example 1:
 * 
 * Input: n = 12 Output: 21 Example 2:
 * 
 * Input: n = 21 Output: -1
 * 
 */
class Solution {

	public int nextGreaterElement(int n) {
		char[] number = (n + "").toCharArray();
		int i, j;

		// Step 1
		// Start traversing from the right most digit and find the first digit that is
		// smaller
		// than the digit next to it
		for (i = number.length - 1; i > 0; i--) {
			if (number[i - 1] < number[i]) {
				System.out.println("number[i - 1] is " + number[i - 1]);
				System.out.println("number[i] is " + number[i]);
				System.out.println("-------");
				break;
			}
		}

		// if no such digit exit, then it's the edge case
		if (i == 0) {
			return -1;
		}

		int x = number[i - 1];
		int currBigNumIndex = i;
		System.out.println("number[i - 1] is " + number[i - 1]);
		System.out.println("i or currBigNumIndex is " + i);
		System.out.println("-------");

		// Step 2
		// Find the smallest digit on the right side of (i - 1)'th
		// digit that is greater than number[i - 1]
		for (j = i + 1; j < number.length; j++) {
			System.out.println("j here is " + j);
			if (number[j] > x && number[j] <= number[currBigNumIndex]) {
				currBigNumIndex = j;
			}
		}

		// Step 3
		// swaping the above found smallest digit with number[i - 1]
		char temp = number[i - 1];
		number[i - 1] = number[currBigNumIndex];
		number[currBigNumIndex] = temp;

		// Sort the digits after (i - 1) in ascending order
		Arrays.sort(number, i, number.length);
		long val = Long.parseLong(new String(number));
		return (val <= Integer.MAX_VALUE) ? (int) val : -1;

	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		my_obj.nextGreaterElement(12);
	}
}
