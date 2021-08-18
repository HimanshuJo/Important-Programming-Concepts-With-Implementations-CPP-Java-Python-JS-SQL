package com.essenbazar._245;

/*
 * You are given two strings s and p where p is a subsequence of s.
 * You are also given a distinct 0-indexed integer array removable containing a
 * subset of indices of s (s is also 0-indexed).
 *
 * You want to choose an integer k (0 <= k <= removable.length) such that,
 * after removing k characters from s using the first k indices in removable,
 * p is still a subsequence of s.
 *
 * More formally, you will mark the character at s[removable[i]] for
 * each 0 <= i < k, then remove all marked characters and check if
 * p is still a subsequence.
 *
 * Return the maximum k you can choose such that p is still a
 * subsequence of s after the removals.
 *
 * A subsequence of a string is a new string generated from the original
	string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 */

/*
 * Intuition: main intuition behind the question is to perform a binary search
 * 			  The left boundary represents the lower limit (0 at first) while the
 * 			  right boundary represents the upper limit (the length of the removable
 * array at first)
 *
 * Each time when we find a middle number which is an attempt to remove that number
 * 	of letters from the string
 *
 * We can use an array of characters and replace those letters removed with the '/'
 * 	symbol
 *
 * 	Why? Because this should be much faster and more convenient to work with as compared
 * 		to removing letters directly from a string (high time complexity from string
 * 		concatenation)
 */

public class Solution1898 {
	public int maximumRemovals(String s, String p, int[] removable) {
		char[] letters = s.toCharArray();
		int l = 0, r = removable.length;

		while (l <= r) {
			// 'mid' represents how many letters I remove this round.
			int mid = (l + r) / 2;
			// 'Remove' those letters!
			for (int i = 0; i < mid; i++)
				letters[removable[i]] = '/';

			// I perform a simple check to see if p is still a subsequence of it.
			// If it is, then we have to lower the boundary (or increase the left bound)
			// Because assumption here is that we can always do good, and we have to find
			// a max boundary
			if (check(letters, p))
				l = mid + 1;

			// If not, assumption is that
			// I can't do much better
			// I have to find a number in lower range
			// I have to replace back all the characters that I had removed
			// Then, I change the upper boundary.
			else {
				for (int i = 0; i < mid; i++)
					letters[removable[i]] = s.charAt(removable[i]);
				r = mid - 1;
			}
		}
		return r;
	}

	// Standard method to check if p is a subsequence of the array of characters
	// We can use here two pointers approach, to keep track of which char I'm
	// looking at now in the char array, and another to keep track of which char
	// I'm looking at in p

	public boolean check(char[] letters, String p) {
		int i1 = 0, i2 = 0;
		while (i1 < letters.length && i2 < p.length()) {
			char curr = letters[i1], curr2 = p.charAt(i2);
			if (curr != '/' && curr == curr2)
				i2++;
			i1++;
		}
		if (i2 == p.length())
			return true;
		return false;
	}

}
