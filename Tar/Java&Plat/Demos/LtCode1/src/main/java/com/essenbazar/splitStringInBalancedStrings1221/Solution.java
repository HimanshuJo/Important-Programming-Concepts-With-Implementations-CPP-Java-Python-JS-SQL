package com.essenbazar.splitStringInBalancedStrings1221;

/**
 *
 * @author hjoshi
 */
/*
Balanced strings are those that have an equal quantity of 'L' and 'R' characters.

Given a balanced string s, split it in the maximum amount of balanced strings.

Return the maximum amount of split balanced strings.
Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", 
each substring contains same number of 'L' and 'R'.

 */
import java.util.*;

class Solution {

	public int balancedStringSplit(String s) {
		char[] sChar = s.toCharArray();
		int count = 0;
		for (int i = 0; i < sChar.length; ++i) {
			Map<Character, Integer> map = new HashMap<>();
			for (int x = 0; x <= i; ++x) {
				map.put(sChar[x], map.getOrDefault(sChar[x], 0) + 1);
			}
			if (Objects.equals(map.get('R'), map.get('L'))) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		String s = "RLRRRLLRLL";
		System.out.println(my_obj.balancedStringSplit(s));
	}
}
