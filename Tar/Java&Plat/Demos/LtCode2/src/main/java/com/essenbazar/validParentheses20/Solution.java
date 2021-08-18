
/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.

	An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

	Example 1:
	
	Input: s = "()"
	Output: true
	
	Example 2:
	
	Input: s = "()[]{}"
	Output: true
	
	Example 3:
	
	Input: s = "(]"
	Output: false
	
	Example 4:
	
	Input: s = "([)]"
	Output: false
	
	Example 5:
	
	Input: s = "{[]}"
	Output: true

 */

package com.essenbazar.validParentheses20;

import java.util.*;

public class Solution {

	public boolean isValid(String s) {
		boolean res = true;
		if (s.isEmpty()) {
			return res;
		}
		Stack<Character> stack = new Stack<>();
		char[] my_char = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			switch (my_char[i]) {
			case ')':
				try {
					int current = stack.pop();
					if (current != '(') {
						res = false;
					}
				} catch (Exception e) {
					res = false;
				}
				break;
			case '}':
				try {
					int current = stack.pop();
					if (current != '{') {
						res = false;
					}
				} catch (Exception e) {
					res = false;
				}
				break;
			case ']':
				try {
					int current = stack.pop();
					if (current != '[') {
						res = false;
					}
				} catch (Exception e) {
					res = false;
				}
				break;
			default:
				stack.push(my_char[i]);
				break;
			}
		}
		if (stack.empty()) {
			return res;
		} else {
			res = false;
		}
		return res;
	}
}
