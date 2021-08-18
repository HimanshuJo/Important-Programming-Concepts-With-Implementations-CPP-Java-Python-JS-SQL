package com.essenbazar._234;

/*
Project for solving some weekly contest problems
 */

/**
 *
 * @author himanshu
 */

/*

You are given a string word that consists of digits and lowercase English letters.

You will replace every non-digit character with a space.

For example, "a123bc34d8ef34" will become " 123  34 8  34".

Notice that you are left with some integers that are separated by at least one space:
"123", "34", "8", and "34".

Return the number of different integers after performing the replacement operations on word.

Two integers are considered different if their decimal representations without any
leading zeros are different.


Example 1:

Input: word = "a123bc34d8ef34"
Output: 3
Explanation: The three different integers are "123", "34", and "8".
Notice that "34" is only counted once.

*/
import java.util.HashSet;
import java.util.Set;

class Solution1805 {

	public int numDifferentIntegers(String word) {
		StringBuilder sbf = new StringBuilder(word);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Set<String> set = new HashSet();
		boolean isGood = false;
		for (int i = 0; i < sbf.length(); ++i) {
			char c = sbf.charAt(i);
			if (!Character.isDigit(c)) {
				isGood = true;
				break;
			}
		}
		if (isGood) {
			for (int i = 0; i < sbf.length(); ++i) {
				char c = sbf.charAt(i);
				if (!Character.isDigit(c)) {
					sbf.setCharAt(i, ' ');
				}
			}
			// System.out.println("After spacng out chars " + sbf.toString());
			String[] splited = (sbf.toString()).split("\\s+");
			// System.out.println("Splitted String on Spaces " + Arrays.toString(splited));
			for (String temp : splited) {
				// String noSpaceStr = temp.replaceAll("\\s", "");
				// System.out.println(temp);
				boolean isGood_ = false;
				if (temp.length() != 0) {
					for (int x = 0; x < temp.length(); ++x) {
						char c = temp.charAt(x);
						if (Character.isDigit(c)) {
							isGood_ = true;
							break;
						}
					}
				}
				if (isGood_) {
					StringBuilder temp__ = new StringBuilder(temp);
					for (int x = 0; x < temp__.length(); ++x) {
						char c = temp__.charAt(x);

						if (c != '0') {
							int counter = x;
							for (int m = counter; m >= 0; --m) {
								if (temp__.charAt(m) == '0') {
									temp__.setCharAt(m, ' ');
								}
							}
						}
					}
					String noSpaceStr = (temp__.toString()).replaceAll("\\s", "");
					set.add(noSpaceStr);
				}
			}
			// System.out.println(set.toString());
		}
		return isGood ? set.size() : 1;
	}
}
