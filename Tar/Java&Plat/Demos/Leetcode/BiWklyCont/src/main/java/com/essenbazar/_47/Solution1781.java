package com.essenbazar._47;

import java.util.HashMap;
import java.util.Map;

/*
 * The beauty of a string is the difference in frequencies between the most
 * frequent and least frequent characters.
 * 
 * For example, the beauty of "abaacc" is 3 - 1 = 2.
 * 
 * Given a string s, return the sum of beauty of all of its substrings.
 * 
 * Example 1:
 * 
 * Input: s = "aabcb" Output: 5 Explanation: The substrings with non-zero beauty
 * are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
 */

class Solution {

	public int getMinCount(int[] charCount) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < charCount.length; ++i) {
			if (charCount[i] != 0) {
				min = Math.min(min, charCount[i]);
			}
		}
		return min;
	}

	public int getMaxCount(int[] charCount) {
		int max = 0;
		for (int i = 0; i < charCount.length; ++i) {
			max = Math.max(max, charCount[i]);
		}
		return max;
	}

	public int beautySum(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); ++i) {
			int[] charCount = new int[26];
			for (int j = i; j < s.length(); ++j) {
				++charCount[s.charAt(j) - 'a'];
				int beauty = getMaxCount(charCount) - getMinCount(charCount);
				sum += beauty;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Solution2 obj = new Solution2();
		String s = "aabcbaa";
		System.out.println(obj.beautySum(s));
	}
}

class Solution2 {

	public int beautySum(String s) {
		char[] sChar = s.toCharArray();
		int res = 0;
		for (int i = 0; i < sChar.length; ++i) {
			Map<Character, Integer> map = new HashMap<>();
			for (int x = i; x < sChar.length; ++x) {
				map.put(sChar[x], map.getOrDefault(sChar[x], 0) + 1);
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				for (@SuppressWarnings("rawtypes")
				Map.Entry entry : map.entrySet()) {
					if ((int) entry.getValue() > max) {
						max = (int) entry.getValue();
					}
				}
				for (@SuppressWarnings("rawtypes")
				Map.Entry entry : map.entrySet()) {
					if ((int) entry.getValue() < min) {
						min = (int) entry.getValue();
					}
				}
				int diff = max - min;
				res += diff;
				System.out.println(map.toString());
				System.out.println("-------");
			}
		}
		return res;
	}
}
