package com.essenbazar.decryptStringFromAlphaIntMap_1309;

import java.util.HashMap;
import java.util.Map;

/*

Given a string s formed by digits ('0' - '9') and '#' .
We want to map s to English lowercase characters as follows:

Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively. 
Return the string formed after mapping.

It's guaranteed that a unique mapping will always exist.

Example 1:

Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".

 */

class Solution {

    public String freqAlphabets(String s) {
        Map<String, Character> map = new HashMap<>();
        StringBuilder res_ = new StringBuilder();
        StringBuilder sbf__ = new StringBuilder();
        StringBuilder original = new StringBuilder();
        StringBuilder result = new StringBuilder(s);
        int x_ = 1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (ch < 'j') {
                map.put(String.valueOf(x_), ch);
                x_++;
            } else {
                map.put((x_) + "#", ch);
                x_++;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                sbf__.append(s.charAt(i - 2));
                sbf__.append(s.charAt(i - 1));
                original.append(s.charAt(i - 2));
                original.append(s.charAt(i - 1));
                original.append('#');
                result.setCharAt(i, ' ');
                result.setCharAt(i - 1, ' ');
                result.setCharAt(i - 2, ' ');
            }
        }
        for (int i = 0; i < sbf__.length(); i++) {
            StringBuilder temp_ = new StringBuilder();
            temp_.append(sbf__.charAt(i));
            temp_.append(sbf__.charAt(i + 1));
            temp_.append('#');
            res_.append(map.get(temp_.toString()));
            i += 1;
        }
        StringBuilder final_ = new StringBuilder();
        int x = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == ' ' && i == result.length() - 1) {
                break;
            } else if (result.charAt(i) == ' ') {
                final_.append(res_.charAt(x));
                x++;
                i += 2;
            } else {
                char temp = result.charAt(i);
                String temp_string = String.valueOf(temp);
                final_.append(map.get(temp_string));
            }
        }
        return final_.toString();
    }
}
