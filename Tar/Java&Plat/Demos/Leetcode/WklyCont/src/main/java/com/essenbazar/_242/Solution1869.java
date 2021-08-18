package com.essenbazar._242;

/*
 * Given a binary string s, return true if the longest contiguous segment of 1s is strictly longer
 * than the longest contiguous segment of 0s in s. Return false otherwise.

    For example, in s = "110100010" the longest contiguous segment of 1s has length 2,
    and the longest contiguous segment of 0s has length 3.

	Note that if there are no 0s, then the longest contiguous segment of 0s is considered to have length 0.
	The same applies if there are no 1s.

	Example 1:

	Input: s = "1101"
	Output: true
	Explanation:
	The longest contiguous segment of 1s has length 2: "1101"
	The longest contiguous segment of 0s has length 1: "1101"
	The segment of 1s is longer, so return true.
 */

class Solution1869 {
	public boolean checkZeroOnes(String s) {
		int count1 = 0;
		int count0 = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '1') {
				int x = i;
				int temp = 0;
				while (s.charAt(x) == '1' && x < s.length()) {
					temp++;
					x++;
					if (x == s.length()) {
						break;
					}
				}
				count1 = Math.max(count1, temp);
			} else {
				int x = i;
				int temp = 0;
				while (s.charAt(x) == '0' && x < s.length()) {
					temp++;
					x++;
					if (x == s.length()) {
						break;
					}
				}
				count0 = Math.max(count0, temp);
			}
		}
		return count1 > count0;
	}
}