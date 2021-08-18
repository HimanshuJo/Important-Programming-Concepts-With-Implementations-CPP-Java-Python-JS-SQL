package com.essenbazar._241;

/*
 * Given a binary string s, return the minimum number of character swaps to make it
 * alternating, or -1 if it is impossible.

	The string is called alternating if no two adjacent characters are equal.
	For example, the strings "010" and "1010" are alternating, while the string "0100" is not.

	Any two characters may be swapped, even if they are not adjacent.

	Input: s = "111000"
	Output: 1
	Explanation: Swap positions 1 and 4: "111000" -> "101010"
	The string is now alternating.
 */

public class Solution1864 {
	public int minSwaps(String s) {
		char[] chArr = s.toCharArray();
		int ones = 0;
		for (char c : chArr) {
			if (c == '1') {
				++ones;
			}
		}
		int zeros = chArr.length - ones;
		if (Math.abs(ones - zeros) > 1) {
			return -1;
		}
		int count1 = startsWith(chArr, '1');
		int count2 = startsWith(chArr, '0');
		if ((count1 % 2 == 0) && (count2 % 2 == 0)) {
			return Math.min(count1, count2) / 2;
		}
		if (count1 % 2 == 0) {
			return count1 / 2;
		}
		return count2 / 2;
	}

	public int startsWith(char[] chArr, char start) {
		StringBuilder temp = new StringBuilder();
		int count = 0;
		if (start == '1') {
			for (int i = 0; i < chArr.length; ++i) {
				if (i % 2 == 0) {
					temp.append('1');
				} else {
					temp.append('0');
				}
			}
			for (int i = 0; i < chArr.length; ++i) {
				if (chArr[i] != temp.charAt(i)) {
					++count;
				}
			}
		} else {
			for (int i = 0; i < chArr.length; ++i) {
				if (i % 2 == 0) {
					temp.append('0');
				} else {
					temp.append('1');
				}
			}
			for (int i = 0; i < chArr.length; ++i) {
				if (chArr[i] != temp.charAt(i)) {
					++count;
				}
			}
		}
		return count;
	}
}
