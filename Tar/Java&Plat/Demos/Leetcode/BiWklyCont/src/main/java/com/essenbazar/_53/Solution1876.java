package com.essenbazar._53;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/*
 * A string is good if there are no repeated characters.

	Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

	Note that if there are multiple occurrences of the same substring, 
	every occurrence should be counted.

	A substring is a contiguous sequence of characters in a string.
	
	Example 1:

	Input: s = "xyzzaz"
	Output: 1
	Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
	The only good substring of length 3 is "xyz".
 */

class Solution1876 {
	public int countGoodSubstrings(String s) {
		int count = 0;
		for (int i = 0; i < s.length() - 1; ++i) {
			int temp_ = 0;
			StringBuilder temp = new StringBuilder();
			for (int j = i; j < s.length(); ++j) {
				temp.append(s.charAt(j));
				temp_++;
				if (temp_ == 3) {
					break;
				}
			}
			Map<Character, Integer> map = new HashMap<>();
			for (int ii = 0; ii < temp.length(); ++ii) {
				map.put(temp.charAt(ii), map.getOrDefault(temp.charAt(ii), 0) + 1);
			}
			boolean flag = false;
			if (map.size() > 1) {
				for (Iterator<Entry<Character, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
					Entry<Character, Integer> entry = iterator.next();
					if ((int) entry.getValue() != 1) {
						flag = true;
						break;
					}
				}
			}
			if (!flag && map.size() == 3) {
				count++;
			}
		}
		return count;
	}
}
