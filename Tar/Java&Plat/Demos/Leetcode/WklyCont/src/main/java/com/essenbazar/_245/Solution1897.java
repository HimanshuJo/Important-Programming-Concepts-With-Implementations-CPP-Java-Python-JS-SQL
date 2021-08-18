package com.essenbazar._245;

/*
 * You are given an array of strings words (0-indexed).

	In one operation, pick two distinct indices i and j,
	where words[i] is a non-empty string, and move any character from words[i]
	to any position in words[j].

	Return true if you can make every string in words equal using any number
	of operations, and false otherwise.

	Example 1:

	Input: words = ["abc","aabc","bc"]
	Output: true
	Explanation: Move the first 'a' in words[1] to the front of words[2],
	to make words[1] = "abc" and words[2] = "abc".
	All the strings are now equal to "abc", so return true.

 */

import java.util.HashMap;

class Solution1897 {
	public boolean makeEqual(String[] words) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (String word : words) {
			for (int j = 0; j < word.length(); j++) {
				map.put(word.charAt(j), map.getOrDefault(word.charAt(j), 0) + 1);
			}
		}
		/*
		 * If frequency of each character is equally divisible by the length of the word
		 * 	that means that we can equally distribute all the characters equally in all
		 * 	the places
		 */
		for (Character key : map.keySet()) {
			int freq = map.get(key);
			if (freq % words.length != 0) {
				return false;
			}
		}
		return true;
	}
}