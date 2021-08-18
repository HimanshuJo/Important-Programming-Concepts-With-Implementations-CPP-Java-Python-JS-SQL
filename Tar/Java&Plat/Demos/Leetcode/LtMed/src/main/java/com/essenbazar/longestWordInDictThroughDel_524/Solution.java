/*
Project for solving some common algorithm problems
 */
package com.essenbazar.longestWordInDictThroughDel_524;

import java.util.List;

/**
 *
 * @author himanshu
 */

/*

Given a string s and a string array dictionary, return the longest string in the
dictionary that can be formed by deleting some of the given string characters.

If there is more than one possible result, return the longest word with the smallest
lexicographical order. If there is no possible result, return the empty string.

Example 1:

Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
Output: "apple"

 */
class Solution {

    public String findLongestWord(String s, List<String> d) {

        String result = "";

        d.sort((String a, String b)
                -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());

        for (String str : d) {
            if (isSubsequence(s, str)) {
                return result = str;
            }
        }

        return result;

    }

    private boolean isSubsequence(String s, String str) {
        int i = 0;
        int j = 0;

        if (str.length() > s.length()) {
            return false;
        }

        while (i < s.length() && j < str.length()) {
            if (s.charAt(i) == str.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == str.length();
    }
}
