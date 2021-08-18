package com.essenbazar.implementStrStr_28;

/*

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string.
This is consistent to C's strstr() and Java's indexOf().

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2

 */

class Solution {

    public int strStr(String haystack, String needle) {
        int res = 0;
        if ("".equals(needle) && "".equals(haystack)) {
            return 0;
        }
        if ("".equals(needle) && !(haystack.isEmpty())) {
            return 0;
        }
        if (haystack.contains(needle)) {
            res = haystack.indexOf(needle);
        } else {
            res = -1;
        }
        return res;
    }

    // Solution with less memory
    public int strStr_lessMem(String str1, String str2) {
        int i = 0, j = 0;
        int strLength1 = str1.length();
        int strLength2 = str2.length();

        if (strLength1 < strLength2) {
            return -1;
        } else if (strLength2 == 0 || strLength1 == 0) {
            return 0;
        }

        /* if the first element of str2 is not present in first strLength1-strLength2 
            chatacteres of str1, then there is no use of searching further as it will not be
            completely present  */
        
        for (i = 0; i <= strLength1 - strLength2; i++) {
            for (j = 0; j < strLength2; j++) {
                if (str1.charAt(i + j) != str2.charAt(j)) {
                    break;
                }
            }
            if (j == strLength2) {
                return i;
            }
        }
        return -1;
    }
}
