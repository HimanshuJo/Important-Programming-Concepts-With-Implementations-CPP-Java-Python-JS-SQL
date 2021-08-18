package com.essenbazar.strStr28;

/**
 *
 * @author hjoshi
 */
class Solution {

	public int strStr(String haystack, String needle) {
		int res = 0;
		if ("".equals(needle) && "".equals(haystack)) {
			return 0;
		}
		if ("".equals(needle) && !(haystack.isEmpty())) {
			return 0;
		}
		if (haystack.contains(needle)) {
			res = haystack.indexOf(needle);
		} else {
			res = -1;
		}
		return res;
	}
}
