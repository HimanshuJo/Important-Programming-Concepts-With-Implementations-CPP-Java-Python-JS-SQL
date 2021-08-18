package com.essenbazar._246;

// Largest Odd Number in String
/*
 * You are given a string num, representing a large integer.
 * Return the largest-valued odd integer (as a string) that is a non-empty substring of num,
 * or an empty string "" if no odd integer exists.

	A substring is a contiguous sequence of characters within a string.

	Example 1:

	Input: num = "52"
	Output: "5"
	Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.

	Example 2:

	Input: num = "4206"
	Output: ""
	Explanation: There are no odd numbers in "4206".

	Example 3:

	Input: num = "35427"
	Output: "35427"
	Explanation: "35427" is already an odd number.
 */

public class Solution1903 {
	public String largestOddNumber(String num) {
		int temp = Character.getNumericValue(num.charAt(num.length() - 1));
		if (temp % 2 != 0) {
			return num;
		}
		int count = 0;
		StringBuilder sbf = new StringBuilder(num);
		for (int i = 0; i < num.length(); ++i) {
			if (Character.getNumericValue(num.charAt(i)) % 2 == 0) {
				count++;
			}
		}
		if (count == num.length()) {
			return "";
		}
		int ii = num.length() - 1;
		while (true) {
			if (Character.getNumericValue(num.charAt(ii)) % 2 == 0) {
				sbf.setCharAt(ii, ' ');
			} else
				break;
			ii--;
		}
		return sbf.toString().trim();
	}
}
