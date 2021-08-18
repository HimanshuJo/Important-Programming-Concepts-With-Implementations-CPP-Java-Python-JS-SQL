package com.essenbazar._55;

import java.util.Stack;

//Remove All Occurrences of a Substring
/*
Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:

 Find the leftmost occurrence of the substring part and remove it from s.

Return s after removing all occurrences of part.

A substring is a contiguous sequence of characters in a string.

Example 1:

Input: s = "daabcbaabcbc", part = "abc"
Output: "dab"
Explanation: The following operations are done:
- s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
- s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
- s = "dababc", remove "abc" starting at index 3, so s = "dab".
Now s has no occurrences of "abc".

Example 2:

Input: s = "axxxxyyyyb", part = "xy"
Output: "ab"
Explanation: The following operations are done:
- s = "axxxxyyyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
- s = "axxxyyyb", remove "xy" starting at index 3 so s = "axxyyb".
- s = "axxyyb", remove "xy" starting at index 2 so s = "axyb".
- s = "axyb", remove "xy" starting at index 1 so s = "ab".
Now s has no occurrences of "xy".

Constraints:

 1 <= s.length <= 1000
 1 <= part.length <= 1000
 s​​​​​​ and part consists of lowercase English letters.

*/
/*
Approach:

 Initialize a stack to store the characters of the main string (let's say S1)

 Traverse the string S1 and perform the following operations:

     a. Push the current character in the stack

     b. If the size of the stack is at least M, then check if the top M characters of the stack form the string s2 or not

         If found to be true, then remove those characters

*/

class Solution1910 {
	String res = "";

	public String removeOccurrences(String s, String part) {
		int n = s.length();
		int m = part.length();
		minLength(s, n, part, m);
		return reverse(res);
	}

	public void minLength(String str, int N, String K, int M) {
		Stack<Character> stackOfChar = new Stack<Character>();
		for (int i = 0; i < str.length(); ++i) {
			stackOfChar.add(str.charAt(i));
			if (stackOfChar.size() >= M) {
				String l = "";
				for (int j = M - 1; j >= 0; --j) {
					if (K.charAt(j) != stackOfChar.peek()) {
						int f = 0;
						while (f != l.length()) {
							stackOfChar.add(l.charAt(f));
							f++;
						}
						break;
					} else {
						l = stackOfChar.peek() + l;
						stackOfChar.pop();
					}
				}
			}
		}
		while (!stackOfChar.isEmpty()) {
			res += stackOfChar.pop();
		}
	}

	public String reverse(String str) {
		StringBuilder res = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; --i) {
			res.append(str.charAt(i));
		}
		return res.toString();
	}
}
