/*

Directory to test few algorithm tasks

 */
package com.essenbazar.countSortedVowelStrings1641;

/**
 *
 * @author hjoshi
 */
/*
 * Given an integer n, return the number of strings of length n that consist
 * only of vowels (a, e, i, o, u) and are lexicographically sorted.
 * 
 * A string s is lexicographically sorted if for all valid i, s[i] is the same
 * as or comes before s[i+1] in the alphabet.
 */
class Solution {
	int ans = 0;

	public int countVowelStrings(int n) {
		char[] arr = { 'a', 'e', 'i', 'o', 'u' };
		backtrack(arr, 0, n);
		return ans;
	}

	public void backtrack(char[] arr, int start, int n) {
		if (n == 0) {
			ans++;
			return;
		}
		for (int i = start; i < arr.length; ++i) {
			backtrack(arr, i, n - 1);
		}
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.countVowelStrings(2));
	}
}