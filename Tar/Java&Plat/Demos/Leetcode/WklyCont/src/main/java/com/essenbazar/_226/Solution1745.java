package com.essenbazar._226;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author himan
 */

/*
 *
 * Given a string s, return true if it is possible to split the string s into
 * three non-empty palindromic substrings. Otherwise, return false.​​​​​
 *
 * A string is said to be palindrome if it the same string when reversed.
 *
 * Example 1: Input: s = "abcbdd" Output: true Explanation: "abcbdd" = "a" +
 * "bcb" + "dd", and all three substrings are palindromes.
 *
 * Example 2: Input: s = "bcbddxy" Output: false Explanation: s cannot be split
 * into 3 palindromes.
 *
 */

/*
 *
 * The length of the string is 2000, it indicates that an O(n^2) solution could
 * pass easily
 *
 * - Using an O(N^2) to build a palindrome quick look-up table - This quick look
 * up table will tell us, if substring[i, j] is a palindrome in O(1)
 *
 * - We can use DP to do that - For the problem if a substring[i, j] is a
 * palindrome - if char(i) == char(j) - we can reduce the problem to a
 * subproblem - if substring[i + 1, j - 1] is a palindrome or not - if char(i)
 * != char(j) - we can simply set it to false
 *
 * - Using O(N^2) to iterate every mid part substring - We can now check, if
 * left, mid and right are all palindrome - if yes return true
 *
 */

public class Solution1745 {

	public boolean checkPartioning(String s) {
		int N = s.length();
		char[] A = s.toCharArray();

		// look up table
		boolean[][] dp = new boolean[N][N];

		for (int i = N - 1; i >= 0; i--) {
			for (int j = i; j < N; j++) {
				if (A[i] == A[j]) {
					// check if the substring A[i + 1, j - 1] is a palindrome
					dp[i][j] = ((i + 1 <= j - 1) ? dp[i + 1][j - 1] : true);
				} else
					dp[i][j] = false;
			}
		}

		// iterate every mid and then check: left, mid and right
		for (int i = 0; i < N - 1; i++) {
			for (int j = i; j < N - 1; j++) {
				if (dp[0][i - 1] && dp[i][j] && dp[j + 1][N - 1])
					return true;
			}
		}

		return false;
	}
}
