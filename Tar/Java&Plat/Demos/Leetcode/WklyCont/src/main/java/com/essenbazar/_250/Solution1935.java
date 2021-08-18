package com.essenbazar._250;

/*
 * There is a malfunctioning keyboard where some letter keys do not work. All other keys on the 
 * keyboard work properly.

	Given a string text of words separated by a single space (no leading or trailing spaces) and 
	a string brokenLetters of all distinct letter keys that are broken, return the number of words 
	in text you can fully type using this keyboard.

	Example 1:
	
	Input: text = "hello world", brokenLetters = "ad"
	Output: 1
	Explanation: We cannot type "world" because the 'd' key is broken.

 */

import java.util.HashMap;
import java.util.Map;

class Solution1935 {
	public int canBeTypedWords(String text, String brokenLetters) {
		Map<Character, Character> map = new HashMap<>();
		for (char ch : brokenLetters.toCharArray()) {
			map.put(ch, ch);
		}
		String[] strArr = text.split(" ");
		int ans = 0;
        //System.out.println(Arrays.toString(strArr));
		for (String str : strArr) {
			for (int i = 0; i < str.length(); ++i) {
				if (map.containsKey(str.charAt(i))) {
					ans++;
					break;
				}
			}
		}
		return Math.abs(ans - strArr.length);
	}
}
