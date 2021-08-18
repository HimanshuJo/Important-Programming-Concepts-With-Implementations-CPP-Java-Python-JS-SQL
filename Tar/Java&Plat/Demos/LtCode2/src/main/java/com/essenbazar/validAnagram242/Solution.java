
/*
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * 
 * Example 1:

	Input: s = "anagram", t = "nagaram"
	Output: true
	
	Example 2:
	
	Input: s = "rat", t = "car"
	Output: false

 */

package com.essenbazar.validAnagram242;

import java.util.*;

class Solution {

	public boolean isAnagram(String s, String t) {
		boolean res = true;
		if (s.length() != t.length()) {
			return false;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		System.out.println(map);
		Map<Character, Integer> map2 = new HashMap<>();
		for (int j = 0; j < t.length(); j++) {
			map2.put(t.charAt(j), map2.getOrDefault(t.charAt(j), 0) + 1);
		}
		System.out.println(map2);
		Boolean[] boolArray = new Boolean[t.length()];
		Arrays.fill(boolArray, Boolean.FALSE);
		int m = 0;
		for (char c : t.toCharArray()) {
			if (map.containsKey(c)) {
				if (Objects.equals(map.get(c), map2.get(c))) {
					System.out.println(map.get(c));
					boolArray[m] = true;
					m++;
				}
			} else if (!map.containsKey(c)) {
				res = false;
			} else {
				res = false;
			}
		}
		for (boolean b : boolArray) {
			res = b;
		}
		System.out.println(Arrays.toString(boolArray));
		return res;
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		String s = "car";
		String t = "rat";
		System.out.println(my_obj.isAnagram(s, t));
	}
}
