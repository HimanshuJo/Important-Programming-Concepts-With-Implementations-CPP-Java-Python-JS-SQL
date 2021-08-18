package com.essenbazar.stringCompression443;

/**
 *
 * @author hjoshi
 */
/*
 * Given an array of characters chars, compress it using the following
 * algorithm:
 * 
 * Begin with an empty string s. For each group of consecutive repeating
 * characters in chars:
 * 
 * If the group's length is 1, append the character to s. Otherwise, append the
 * character followed by the group's length.
 * 
 * The compressed string s should not be returned separately, but instead be
 * stored in the input character array chars. Note that group lengths that are
 * 10 or longer will be split into multiple characters in chars.
 * 
 * After you are done modifying the input array, return the new length of the
 * array. You must write an algorithm that uses only constant extra space.
 * 
 * Example 1:
 * 
 * Input: chars = ["a","a","b","b","c","c","c"] Output: Return 6, and the first
 * 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to
 * "a2b2c3".
 * 
 */
public class Solution {

	public int compress(char[] chars) {
		int index = 0;
		int i = 0;
		while (i < chars.length) {
			int j = i;
			while (j < chars.length && chars[i] == chars[j]) {
				j++;
			}
			chars[index++] = chars[i];
			if (j - i > 1) {
				String count = j - i + "";
				for (char c : count.toCharArray()) {
					chars[index++] = c;
				}
			}
			i = j;
		}
		return index;
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		char[] my_char = { 'a', 'a', 'a', 'a', 'a', 'a' };
		System.out.println(my_obj.compress(my_char));
	}
}
