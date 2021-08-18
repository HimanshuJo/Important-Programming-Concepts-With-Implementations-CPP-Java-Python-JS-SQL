package com.essenbazar.removeOuterParen1021;

/**
 *
 * @author hjoshi
 */

/*

A valid parenthesis string is either empty (""), "(" + A + ")", or A + B,
    where A and B are valid parenthesis string, and + represents string conatenation

    For example, "", "()", "(())()", and "(()(()))" are all valid parenthesis strings.

A valid parenthesis string S is primitive if it is nonempty, and there does not exist a way
    to split it into S = A + B, with A and B nonempty valid parenthesis strings

Given a valid parenthesis string S, consider its primitive decomposition:
    S = P_1 + P_2 + . . . + P_k, where P_i are primitive valid parenthesis strings

Return S after removing the outermost parenthesis of every primitive string in the primitive
    decomposition of S

Input: "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

Input: "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".

 */
import java.util.*;

class Solution {

	public String removeOuterParentheses(String S) {
		Stack<Character> stack = new Stack<>();
		StringBuilder res = new StringBuilder();
		int count = 0;
		for (int i = 0; i < S.length(); i++) {
			stack.add(S.charAt(i));
			if (S.charAt(i) == '(') {
				count++;
			} else if (S.charAt(i) == ')') {
				count--;
			}
			if (count == 0) {
				System.out.println(stack.toString());
				System.out.println("-------");
				if (stack.get(0) == '(' && stack.get(stack.size() - 1) == ')') {
					for (int x = 1; x < stack.size() - 1; x++) {
						res.append(stack.get(x));
					}
				}

				stack.clear();
			}
		}
		System.out.println(res.toString());
		return res.toString();
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		String S = "(()())(())(()(()))";
		my_obj.removeOuterParentheses(S);
	}
}
