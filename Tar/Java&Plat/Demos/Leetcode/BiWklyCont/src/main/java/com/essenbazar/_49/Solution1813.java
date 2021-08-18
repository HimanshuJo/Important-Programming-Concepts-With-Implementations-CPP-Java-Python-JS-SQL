package com.essenbazar._49;

/*
 * Algo:
 * 
 * 1. Split the sentences into words
 * 
 * 2. Scan the shorter one from left and compare word by word with the longer
 * word
 * 
 * Whenever the words from the 2 sentences are not equal compare the tails of
 * the 2 sentences word by word
 * 
 * till the end or they do not match
 * 
 * 3. Confirm if the pointer reaches the end of the shorter sentences
 * 
 * If yes return true, else return false
 * 
 */

class Solution1813 {
	public boolean areSentencesSimilar(String sentence1, String sentence2) {
		String[] words1 = sentence1.split(" "), words2 = sentence2.split(" ");
		int i = 0, n1 = words1.length, n2 = words2.length;
		if (n1 > n2) {
			return areSentencesSimilar(sentence2, sentence1);
		}
		while (i < n1 && words1[i].equals(words2[i])) {
			++i;
		}
		while (i < n1 && words1[i].equals(words2[n2 - n1 + i])) {
			++i;
		}
		return i == n1;
	}
}
