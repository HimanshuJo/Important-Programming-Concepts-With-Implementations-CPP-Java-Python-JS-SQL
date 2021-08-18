package com.essenbazar.longestSubStringWithoutRepeatChars03;

/**
 *
 * @author hjoshi
 */

/*

Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/
import java.util.*;

class Solution {

	static final int NO_OF_CHARS = 256;

	public int lengthOfLongestSubstring_slidingWind(String str) {
		int n = str.length();
		int res = 0;
		int[] lastIndex = new int[NO_OF_CHARS];
		Arrays.fill(lastIndex, -1);
		int i = 0;
		for (int j = 0; j < n; j++) {
			i = Math.max(i, lastIndex[str.charAt(j)] + 1);
			res = Math.max(res, j - i + 1);
			lastIndex[str.charAt(j)] = j;
		}
		return res;
	}

	public int lengthOfLongestSubstring_HashMapOffset(String s) {
		int len_input = s.length();
		if (len_input == 0) {
			return 0;
		}
		int max_len = 0;
		int curr_len = 0;
		int curr_start = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < len_input; i++) {
			Integer offset = map.get(s.charAt(i));
			if (offset == null) {
				curr_len++;
			} else if (offset >= curr_start) {
				curr_len = i - offset;
				curr_start = offset + 1;
			} else {
				curr_len++;
			}
			map.put(s.charAt(i), i);

			if (curr_len > max_len) {
				max_len = curr_len;
			}
		}
		return max_len;
	}

	public int lengthOfLongestSubstring_HashSet(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		HashSet<Character> set = new HashSet<>();
		int result = 1;
		int i = 0;
		for (int j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			if (!set.contains(c)) {
				set.add(c);
				result = Math.max(result, set.size());
			} else {
				while (i < j) {
					if (s.charAt(i) == c) {
						i++;
						break;
					}

					set.remove(s.charAt(i));
					i++;
				}
			}
		}
		return result;
	}
}
