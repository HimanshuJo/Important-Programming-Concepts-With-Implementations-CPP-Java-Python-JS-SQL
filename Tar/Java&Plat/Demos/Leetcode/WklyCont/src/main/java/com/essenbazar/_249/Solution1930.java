package com.essenbazar._249;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Unique Length-3 Palindromic Subsequences
/*
Given a string s, return the number of unique palindromes of length three that are a subsequence of s.

Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.

A palindrome is a string that reads the same forwards and backwards.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

 For example, "ace" is a subsequence of "abcde".

Example 1:

Input: s = "aabca"
Output: 3
Explanation: The 3 palindromic subsequences of length 3 are:
- "aba" (subsequence of "aabca")
- "aaa" (subsequence of "aabca")
- "aca" (subsequence of "aabca")

*/

class Solution {
	public int countPalindromicSubsequence(String s) {
		int first[] = new int[26], last[] = new int[26], res = 0;
		Arrays.fill(first, Integer.MAX_VALUE);
		for (int i = 0; i < s.length(); ++i) {
			first[s.charAt(i) - 'a'] = Math.min(first[s.charAt(i) - 'a'], i);
			last[s.charAt(i) - 'a'] = i;
		}
		for (int i = 0; i < 26; ++i)
			if (first[i] < last[i])
				res += s.substring(first[i] + 1, last[i]).chars().distinct().count();
		return res;
	}
}

class Solution_TLE {

	public int countPalindromicSubsequence(String s) {
		Set<String> list = new HashSet<>();
		String curr = "";
		int index = -1;
		int n = s.length();
		genSubsequences(s, n, index, curr, list);
		// System.out.println(list.toString());
		int ans = 0;
		for (String str : list) {
			if (str.length() == 3 && isPalindrome(str)) {
				ans++;
			}
		}
		return ans;
	}

	static void genSubsequences(String str, int n, int index, String curr, Set<String> list) {
		if (index == n) {
			return;
		}
		if (curr != null && !curr.trim().isEmpty()) {
			list.add(curr);
		}
		for (int i = index + 1; i < n; i++) {
			curr += str.charAt(i);
			genSubsequences(str, n, i, curr, list);
			curr = curr.substring(0, curr.length() - 1);
		}
	}

	public static boolean isPalindrome(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
