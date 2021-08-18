/*
Project for solving some feb_21 leetcode problems
 */
package com.essenbazar.minRemoveValidParen;

/**
 *
 * @author himan
 */

/*

Given a string s of '(' , ')' and lowercase English characters. 

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

*/

class Solution {
    public String minRemoveToMakeValid(String s) {
        
        char [] ch = s.toCharArray();
        
        // first moving 'left to right' and finding all the closed parenthesis
            // for an open parenthesis
            // marking all the extra which needs to be deleted
        
        int count = 0;
        
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                count++;
            } else if (ch[i] == ')') {
                if (count > 0) {
                    count--;
                } else {
                    ch[i] = 0;
                }
            }
        }
        
        // right to left and marking all the open parenthesis for deletion
            // which do not have a closed parenthesis
        
        for (int i = ch.length - 1; i >= 0; i--) {
            if (ch[i] == ')') {
                count++;
            } else if (ch[i] == '(') {
                if (count > 0) {
                    count--;
                } else {
                    ch[i] = 0;
                }
            }
        }
        
        StringBuilder sbf = new StringBuilder();
        for (char c : ch) {
            if (c != 0) {
                sbf.append(c);
            }
        }
        
        return sbf.toString();
        
    }
}
