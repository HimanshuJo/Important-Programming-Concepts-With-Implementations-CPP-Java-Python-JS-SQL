package com.essenbazar._228;

/*
Project for solving some weekly contest problems
 */

/**
 *
 * @author himan
 */

/*
 *
 * Given a string s, return the number of homogenous substrings of s. Since the
 * answer may be too large, return it modulo 10^9 + 7.
 *
 * A string is homogenous if all the characters of the string are the same.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example 1:
 *
 * Input: s = "abbcccaa" Output: 13 Explanation: The homogenous substrings are
 * listed as below: "a" appears 3 times. "aa" appears 1 time. "b" appears 2
 * times. "bb" appears 1 time. "c" appears 3 times. "cc" appears 2 times. "ccc"
 * appears 1 time.
 *
 * 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.
 *
 */
/*
 * cur is the previous character in type integer count is the number of
 * continuous same character
 *
 * We can iterate the while string character by character, it it's same as the
 * previous we can increment the 'count', otherwise we can set it to 1
 *
 * There are count characters to start with, ending at this current character,
 * in order to construct a homogenous string
 *
 * So we will increment our final result res = (res + count) % MOD
 *
 * Time: O(n)
 */

class Solution1759 {
	public int countHomogenous(String s) {
		int res = 0, cur = 0, count = 0, MOD = 1_000_000_007;
		for (int i = 0; i < s.length(); ++i) {
			count = s.charAt(i) == cur ? count + 1 : 1;
			cur = s.charAt(i);
			res = (res + count) % MOD;
		}
		return res;
	}
}
