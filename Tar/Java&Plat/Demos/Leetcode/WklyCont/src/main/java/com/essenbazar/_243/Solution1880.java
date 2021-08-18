package com.essenbazar._243;

/*
 * The letter value of a letter is its position in the alphabet starting from 0
 * (i.e. 'a' -> 0, 'b' -> 1, 'c' -> 2, etc.).

	The numerical value of some string of lowercase English letters s is the concatenation of the
	letter values of each letter in s, which is then converted into an integer.

	    For example, if s = "acb", we concatenate each letter's letter value, resulting in "021".
	    After converting it, we get 21.

	You are given three strings firstWord, secondWord, and targetWord, each consisting of lowercase
	English letters 'a' through 'j' inclusive.

	Return true if the summation of the numerical values of firstWord and secondWord equals the
	numerical value of targetWord, or false otherwise.
 */
import java.util.HashMap;
import java.util.Map;

public class Solution1880 {

	public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
		Map<Character, Integer> map = new HashMap<>();
		int i = 0;
		for (char ch = 'a'; ch <= 'z'; ++ch) {
			map.put(ch, i);
			++i;
		}
		StringBuilder sbf1 = new StringBuilder();
		StringBuilder sbf2 = new StringBuilder();
		for (int ii = 0; ii < firstWord.length(); ++ii) {
			sbf1.append(map.get(firstWord.charAt(ii)));
		}
		for (int i_ = 0; i_ < secondWord.length(); ++i_) {
			sbf2.append(map.get(secondWord.charAt(i_)));
		}
		int num1 = Integer.parseInt(sbf1.toString());
		int num2 = Integer.parseInt(sbf2.toString());
		int target = Integer.parseInt(targetWord);
		return num1 + num2 == target;
	}
}
