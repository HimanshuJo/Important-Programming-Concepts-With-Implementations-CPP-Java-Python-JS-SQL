package com.essenbazar._228;

/*
Project for solving some weekly contest problems
 */

/**
 *
 * @author himan
 */
/*
 * You are given a string s consisting only of the characters '0' and '1'. In
 * one operation, you can change any '0' to '1' or vice versa.
 *
 * The string is called alternating if no two adjacent characters are equal. For
 * example, the string "010" is alternating, while the string "0100" is not.
 *
 * Return the minimum number of operations needed to make s alternating.
 *
 * Input: s = "0100" Output: 1 Explanation: If you change the last character to
 * '1', s will be "0101", which is alternating.
 */
class Solution {

	public int minOperations(String s) {
		StringBuilder temp1 = new StringBuilder();
		StringBuilder temp2 = new StringBuilder();
		for (int i = 0; i < s.length(); ++i) {
			if (i % 2 == 0) {
				temp1.append('1');
			} else {
				temp1.append('0');
			}
		}
		for (int i = 0; i < s.length(); ++i) {
			if (i % 2 == 0) {
				temp2.append('0');
			} else {
				temp2.append('1');
			}
		}
		System.out.println(temp1.toString());
		System.out.println(temp2.toString());
		System.out.println("-------");
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) != temp1.charAt(i)) {
				count1++;
			}
		}
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) != temp2.charAt(i)) {
				count2++;
			}
		}
		return Math.min(count1, count2);
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		String s = "10";
		System.out.println(my_obj.minOperations(s));
	}
}
