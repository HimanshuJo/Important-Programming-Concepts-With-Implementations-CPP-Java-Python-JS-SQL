package com.essenbazar._235;

/*
Project for solving some weekly contest problems
 */

/**
 *
 * @author himanshu
 */
class Solution1861 {

	public String truncateSentence(String s, int k) {
		String[] splitted = s.split("\\s");
		StringBuilder sbf = new StringBuilder();

		if (splitted.length < k) {
			return null;
		} else {
			for (int i = 0; i < k; ++i) {
				sbf.append(splitted[i]);
				if (i < k - 1) {
					sbf.append(" ");
				}
			}
		}

		return sbf.toString();
	}
}
