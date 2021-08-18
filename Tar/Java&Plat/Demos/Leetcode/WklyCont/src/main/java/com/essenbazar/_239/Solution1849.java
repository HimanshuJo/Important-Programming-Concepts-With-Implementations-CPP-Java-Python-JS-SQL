package com.essenbazar._239;

/*
 *
 * Standard backtracking problem:
 *
 * This is a brute force approach, because we will be handling basically every
 * single possible case
 *
 * Important point to notice here is that:
 *
 * There is no restriction on what could be our first integer
 *
 * for example in this case:
 *
 * 0090089 --> we can assign our first integer as either 0, or 00, or 009, or
 * 0090 etc..
 *
 * But the second integer has to be one less than the first
 *
 * So here we can brute force we can try the first digit by itself, then next
 * two digits as first and so on
 *
 * -------
 *
 * In this case, how would a decision tree or backtracking tree would look like:
 *
 * One path would be just one digit
 *
 * Next path could be two digit
 *
 * and so on ..
 *
 * Furthermor the first path can be one digit, the second path can have one
 * digit and so on
 *
 * we will continue that until we don't have any more digits left in our entire
 * string
 *
 * -------
 *
 * Based on this idea we can see that we can have n branches (in the worst case)
 *
 * and the height of the tree can also be roughly n
 *
 * So the rough estimate of the time complexity can be O(n^n) but can be much
 * efficient than that, as we will be performing pruning
 *
 */

class Solution1849 {

	public boolean splitString(String s) {
		// get the length
		int n = s.length();
		// run dfs for each substring from 0 to i
		for (int i = 1; i < n; ++i) {
			if (dfs(s, i, Long.parseUnsignedLong(s.substring(0, i)))) {
				return true;
			}
		}
		return false;
	}

	// custom dfs function
	boolean dfs(String s, int pos, long prev) {
		long tar = prev - 1;
		int n = s.length();
		if (pos == n) {
			return true;
		}
		for (int i = pos + 1; i <= n; ++i) {
			long f = Long.parseUnsignedLong(s.substring(pos, i));
			if (tar == f && dfs(s, i, f)) {
				return true;
			}
		}
		return false;
	}
}

class Solution2 {

	public boolean splitString(String s) {
		for (int i = 1; i < s.length(); ++i) {
			String temp = s.substring(0, i);
			long val = Long.parseUnsignedLong(temp);
			if (dfs(i, val, s)) {
				return true;
			}
		}
		return false;
	}

	public boolean dfs(int index, long prev, String s) {
		if (index == s.length()) {
			return true;
		}
		for (int j = index + 1; j <= s.length(); ++j) {
			String temp_ = s.substring(index, j);
			long val_ = Long.parseUnsignedLong(temp_);
			if (val_ + 1 == prev) {
				if (dfs(j, val_, s)) {
					return true;
				}
			}
		}
		return false;
	}
}
