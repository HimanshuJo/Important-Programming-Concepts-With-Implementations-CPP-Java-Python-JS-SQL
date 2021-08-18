/*
Project for solving some common algorithm problems
 */
package com.essenbazar.scoreOfParenthesis_856;

import java.util.Stack;

/**
 *
 * @author himanshu
 */

/*

Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 
Example 1:

Input: "()"
Output: 1
Example 2:

Input: "(())"
Output: 2

 */
class Solution {

    public int scoreOfParentheses(String S) {
        int res = 0;
        Stack<Integer> st = new Stack<>();
        for (char c : S.toCharArray()) {
            int val = 0;
            if (c == '(') {
                st.push(0);
            } else {
                while (st.peek() != 0) {
                    val += st.pop();
                }
                val = Math.max(2 * val, 1);
                st.pop();
                st.push(val);
            }
        }
        while (!st.isEmpty()) {
            res += st.pop();
        }

        return res;
    }
}
