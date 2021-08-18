
package com.essenbazar.palindromePartioningIV1745;

/*

Given a string s, return true if it is possible to split the string s into three
non-empty palindromic substrings. Otherwise, return false.​​​​​

A string is said to be palindrome if it the same string when reversed

Example 1:

Input: s = "abcbdd"
Output: true
Explanation: "abcbdd" = "a" + "bcb" + "dd", and all three substrings are palindromes.
Example 2:

Input: s = "bcbddxy"
Output: false
Explanation: s cannot be split into 3 palindromes.

*/

/*

Algo:

    The length of the string is 2000, it indicates that an O(n^2) solution could fit easily
    Firstly using O(N^2) to build a palindrome quick look-up table

        The quick look up table will tell us, if substring[i, j] is a palindrome in O(1)
        
        We could use Dynamic Programming to do that

            So for the problem, if substring[i, j] is palindrome
                
                if char(i) == char(j), we can reduce the problem to a subproblem
                    "if substring[i + 1, j + 1] is palindrome"
                
                if char(i) != char(j), simply set it to false
    
    Next, we use O(n^2) to iterate every mid part substring
        
        We can now check if the 'left', 'mid' and 'right' are all palindrome and return true

*/

public class Solution {
	public boolean checkPartioning(String s) {
		int N = s.length();
		char[] A = s.toCharArray();
		boolean[][] dp = new boolean[N][N];
		for (int i = N - 1; i >= 0; i--) {
			for (int j = i; j < N; j++) {
				if (A[i] == A[j]) {
					dp[i][j] = ((i + 1 <= j - 1) ? dp[i + 1][j - 1] : true);
				} else {
					dp[i][j] = false;
				}
			}
		}
		// iterate every mid and then check: left, mid and right
		for (int i = 1; i < N - 1; i++) {
			for (int j = i; j < N - 1; j++) {
				if (dp[0][i - 1] && dp[i][j] && dp[j + 1][N - 1]) {
					return true;
				}
			}
		}
		return false;
	}
}
