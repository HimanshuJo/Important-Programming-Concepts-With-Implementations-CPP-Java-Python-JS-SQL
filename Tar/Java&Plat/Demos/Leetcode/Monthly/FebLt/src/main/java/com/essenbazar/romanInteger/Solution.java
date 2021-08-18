/*
Project for solving some feb_21 leetcode problems
 */
package com.essenbazar.romanInteger;

/**
 *
 * @author himan
 */

/*

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two one's added together.
12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right.
However, the numeral for four is not IIII. Instead, the number four is written as IV.
Because the one is before the five we subtract it making four.

The same principle applies to the number nine, which is written as IX.
There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Example 1:

Input: s = "III"
Output: 3

 */
import java.util.*;

class Solution {

    public int romanToInt(String s) {

        int res = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        if (s.length() == 1) {
            return (map.get(s.charAt(0)));
        }

        for (int i = 0; i < s.length() - 1; i++) {
            System.out.println("i is: " + i);
            if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
                res += 4;

                if (i + 1 == s.length() - 1) {
                    break;
                }
                i += 1;
                if (i == s.length() - 2) {
                    int temp_ = map.get(s.charAt(s.length() - 1));
                    res += temp_;
                }
            } else if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
                res += 9;
                if (i + 1 == s.length() - 1) {
                    break;
                }
                i += 1;
                if (i == s.length() - 2) {
                    int temp_ = map.get(s.charAt(s.length() - 1));
                    res += temp_;
                }
            } else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
                res += 40;
                if (i + 1 == s.length() - 1) {
                    break;
                }
                i += 1;
                if (i == s.length() - 2) {
                    int temp_ = map.get(s.charAt(s.length() - 1));
                    res += temp_;
                }
            } else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
                res += 90;
                if (i + 1 == s.length() - 1) {
                    break;
                }
                i += 1;
                if (i == s.length() - 2) {
                    int temp_ = map.get(s.charAt(s.length() - 1));
                    res += temp_;
                }
                System.out.println("XC " + res + " value of i is " + i);
            } else if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
                res += 400;
                if (i + 1 == s.length() - 1) {
                    break;
                }
                i += 1;
                if (i == s.length() - 2) {
                    int temp_ = map.get(s.charAt(s.length() - 1));
                    res += temp_;
                }
            } else if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
                res += 900;
                if (i + 1 == s.length() - 1) {
                    break;
                }
                i += 1;
                if (i == s.length() - 2) {
                    int temp_ = map.get(s.charAt(s.length() - 1));
                    res += temp_;
                }
                System.out.println("CM " + res + " value of i is " + i);
            } else {
                int temp = map.get(s.charAt(i));
                res += temp;
                System.out.println("else " + res);
                if (i == s.length() - 2) {
                    int temp_ = map.get(s.charAt(s.length() - 1));
                    res += temp_;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution my_obj = new Solution();
        String s = "XC";
        System.out.println(my_obj.romanToInt(s));
    }
}
