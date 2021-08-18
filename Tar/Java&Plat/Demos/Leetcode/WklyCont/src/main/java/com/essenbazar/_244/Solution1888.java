package com.essenbazar._244;

// Minimum Number of Flips to Make the Binary String Alternating

/*
 * You are given a binary string s. You are allowed to perform two types of operations on the
 * string in any sequence:

    Type-1: Remove the character at the start of the string s and append it to the end of the string.
    Type-2: Pick any character in s and flip its value, i.e., if its value is '0' it becomes '1'
    and vice-versa.

	Return the minimum number of type-2 operations you need to perform such that s becomes alternating.

	The string is called alternating if no two adjacent characters are equal.

    For example, the strings "010" and "1010" are alternating, while the string "0100" is not.

    Example 1:

	Input: s = "111000"
	Output: 2
	Explanation: Use the first operation two times to make s = "100011".
	Then, use the second operation on the third and sixth elements to make s = "101010".
 */

/*
 * why we can double s to fullfil the first operation, let's look at the same example s = 11100:

    double s: 1110011100
    size n window: |11100|11100 ==> 1|11001|1100 ==> 11|10011|100 and so on,
    when we move one step of the sliding window, it is the same to append 1 more element from beginning.

 */

public class Solution1888 {

	public static int minFlips(String s) {
		StringBuilder sbf = new StringBuilder(s + s);
		StringBuilder goodOne = new StringBuilder();
		StringBuilder goodZero = new StringBuilder();
		for (int i = 0; i < sbf.length(); ++i) {
			if (i % 2 == 0) {
				goodOne.append('1');
				goodZero.append('0');
			} else {
				goodOne.append('0');
				goodZero.append('1');
			}
		}
		int res1 = 0, res2 = 0;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < sbf.length(); ++i) {
			if (goodOne.charAt(i) != sbf.charAt(i)) {
				res1++;
			}
			if (goodZero.charAt(i) != sbf.charAt(i)) {
				res2++;
			}
			// if (i >= n)
			// the most left element is outside of sliding window,
			// therefore we need to subtract the ans if we do 'flip'
			if (i >= sbf.length() / 2) {
				if (goodOne.charAt(i - sbf.length() / 2) != sbf.charAt(i - sbf.length() / 2)) {
					res1--;
				}
				if (goodZero.charAt(i - sbf.length() / 2) != sbf.charAt(i - sbf.length() / 2)) {
					res2--;
				}
			}
			if (i >= sbf.length() / 2 - 1) {
				res = Math.min(res, Math.min(res1, res2));
			}
		}
		return res;
	}
}