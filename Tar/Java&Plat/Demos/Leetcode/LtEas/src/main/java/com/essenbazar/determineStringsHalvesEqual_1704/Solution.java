package com.essenbazar.determineStringsHalvesEqual_1704;

import java.util.Map;
import java.util.TreeMap;

/*

You are given a string s of even length. Split this string into two halves of equal lengths,
and let a be the first half and b be the second half.

Two strings are alike if they have the same number of vowels
('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
Notice that s contains uppercase and lowercase letters.

Return true if a and b are alike. Otherwise, return false.

Example 1:

Input: s = "book"
Output: true
Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.

 */

class Solution {

    public boolean halvesAreAlike(String s) {
        Map<Character, Character> map = new TreeMap<>();
        map.put('a', 'a');
        map.put('e', 'e');
        map.put('i', 'i');
        map.put('o', 'o');
        map.put('u', 'u');
        map.put('A', 'A');
        map.put('E', 'E');
        map.put('I', 'I');
        map.put('O', 'O');
        map.put('U', 'U');
        int comp_res = 0;
        int comp_res_ = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (map.containsKey(s.charAt(i))) {
                comp_res += 1;
            }
        }
        for (int i = s.length() / 2; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                comp_res_ += 1;
            }
        }
        return (comp_res == comp_res_);
    }
}
