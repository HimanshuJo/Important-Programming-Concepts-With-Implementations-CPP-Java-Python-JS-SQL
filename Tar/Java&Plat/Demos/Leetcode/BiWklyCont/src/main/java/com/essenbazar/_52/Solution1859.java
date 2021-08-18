package com.essenbazar._52;

import java.util.*;

/*
A sentence is a list of words that are separated by a single space with no 
leading or trailing spaces. Each word consists of lowercase and uppercase English letters.

A sentence can be shuffled by appending the 1-indexed word position to 
each word then rearranging the words in the sentence.

    For example, the sentence "This is a sentence" can be shuffled as 
"sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".

Given a shuffled sentence s containing no more than 9 words, 
reconstruct and return the original sentence.

Example 1:

Input: s = "is2 sentence4 This1 a3"
Output: "This is a sentence"
Explanation: Sort the words in s to their original positions 
"This1 is2 a3 sentence4", then remove the numbers.

*/

class Solution1859 {

	public String sortSentence(String s) {
		String[] str = s.split(" ");
		TreeMap<Integer, String> map = new TreeMap<>();
		for (String word : str) {
			int num = Character.getNumericValue(word.charAt(word.length() - 1));
			map.put(num, word);
		}
		StringBuilder sbf = new StringBuilder();
		for (@SuppressWarnings("rawtypes")
		Map.Entry entry : map.entrySet()) {
			String word = (String) entry.getValue();
			StringBuilder temp = new StringBuilder(word);
			temp.deleteCharAt(temp.length() - 1);
			sbf.append(temp);
			sbf.append(" ");
		}
		return (sbf.toString()).trim();
	}
}
