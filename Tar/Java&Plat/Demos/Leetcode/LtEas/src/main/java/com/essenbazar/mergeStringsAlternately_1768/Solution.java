package com.essenbazar.mergeStringsAlternately_1768;

/*

You are given two strings word1 and word2.
Merge the strings by adding letters in alternating order,
starting with word1. If a string is longer than the other,
append the additional letters onto the end of the merged string.

Return the merged string.

Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

 */

public class Solution {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sbf = new StringBuilder(word1 + word1);
        int len = word1.length() + word1.length();
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                sbf.setCharAt(i, word1.charAt(j));
                j++;
            } else {
                sbf.setCharAt(i, ' ');
            }
        }
        StringBuilder sbf2 = new StringBuilder(word2 + word2);
        int len_ = word2.length() + word2.length();
        int x = 0;
        for (int i = 0; i < len_; i++) {
            if (i % 2 != 0) {
                sbf2.setCharAt(i, word2.charAt(x));
                x++;
            } else {
                sbf2.setCharAt(i, ' ');
            }
        }
        int m = 1;
        int g = 0;
        if (sbf.length() >= sbf2.length()) {
            for (int z = 0; z < sbf.length(); z++) {
                if (z % 2 != 0) {
                    sbf.setCharAt(z, sbf2.charAt(m));
                    if (m == sbf2.length() - 1) {
                        break;
                    } else {
                        m += 2;
                    }
                }
            }
        } else if (sbf2.length() > sbf.length()) {
            for (int z = 0; z < sbf2.length(); z++) {
                if (z % 2 == 0) {
                    sbf2.setCharAt(z, sbf.charAt(g));
                    if (g == sbf.length() - 2) {
                        break;
                    } else {
                        g += 2;
                    }
                }
            }
        }
        for (int i = 0; i < sbf.length(); i++) {
            if (sbf.charAt(i) == ' ') {
                sbf.deleteCharAt(i);
            }
        }
        for (int i = 0; i < sbf2.length(); i++) {
            if (sbf2.charAt(i) == ' ') {
                sbf2.deleteCharAt(i);
            }
        }
        return (sbf.toString().length() > sbf2.toString().length() ? sbf.toString() : sbf2.toString());
    }
}
