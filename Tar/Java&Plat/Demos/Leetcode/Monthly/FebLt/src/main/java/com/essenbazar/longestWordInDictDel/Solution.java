/*
Project for solving some feb_21 leetcode problems
 */
package com.essenbazar.longestWordInDictDel;

/**
 *
 * @author himan
 */

/*

Given a string and a string dictionary, find the longest string in the dictionary
that can be formed by deleting some characters of the given string.

If there are more than one possible results, return the longest word with
the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output: 
"apple"

*/

/*

Imp Points:

    Firstly it is important to find whether a string or a dictionary word is the
        subsequence of a given string

    Second, if there are more than one subsequences present we need to find the largest one
        and if we have more than one strings of equal length, then we need to find the
        lexicographically smallest string
    
    -------

    To check if a string is a subsequence of another string
        
        suppose String s = abpcplea
                String toCheck = apple
            
            to check whether apple is the subsequence of s
        
            Start with comparing all the characters in both the strings
                one pointer at the start of s, and other at toCheck
                    if both the characters are equal, then we'll move the pointers from both the
                        strings one step ahead
                    if the characters in the both the strings doesn't match at a particular index
                        then pointer at toCheck stays there, and pointer at s moves ahead

            In case length of both the longest strings we have are equal
                to find the lexicographically smallest string, two approaches

                    a. sorting
    
*/

import java.util.*;

class Solution {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        
        // give me highest preferred string first
        d.sort((String a, String b) -> 
                a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
        for (String str : d) {
            if (isSubsequence(s, str)) return result = str;
        }
        
        return result;
    }

    private boolean isSubsequence(String s, String str) {
        int i = 0;
        int j = 0;
        
        if (str.length() > s.length()) return false;
        
        while (i < s.length() && j < str.length()) {
            if (s.charAt(i) == str.charAt(j)) j++;
            i++;
        }
        
        return j == str.length();
    }
}