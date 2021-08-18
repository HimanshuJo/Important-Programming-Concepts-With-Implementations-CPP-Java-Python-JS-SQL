package com.essenbazar._237;

/*
Project for solving some weekly contest problems
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author himanshu
 */

/*
 *
 * A pangram is a sentence where every letter of the English alphabet appears at
 * least once.
 *
 * Given a string sentence containing only lowercase English letters, return
 * true if sentence is a pangram, or false otherwise.
 *
 * Example 1:
 *
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog" Output: true
 * Explanation: sentence contains at least one of every letter of the English
 * alphabet.
 *
 */
class Solution {

	public boolean checkIfPangram(String sentence) {
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < sentence.length(); ++i) {
			map.put(sentence.charAt(i), map.getOrDefault(sentence.charAt(i), 0) + 1);
		}

		int count = 0;
		for (char ch = 'a'; ch <= 'z'; ch++) {
			if (map.containsKey(ch)) {
				count++;
			}
		}

		// System.out.println(map.toString());
		return count == 26;
	}
}
