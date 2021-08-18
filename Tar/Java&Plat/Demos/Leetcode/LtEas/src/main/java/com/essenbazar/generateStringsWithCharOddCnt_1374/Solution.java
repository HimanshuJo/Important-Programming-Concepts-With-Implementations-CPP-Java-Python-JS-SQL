package com.essenbazar.generateStringsWithCharOddCnt_1374;

import java.util.HashMap;
import java.util.Map;

/*

Given an integer n, return a string with n characters such that each character in such
string occurs an odd number of times.

The returned string must contain only lowercase English letters.
If there are multiples valid strings, return any of them.  

Example 1:

Input: n = 4
Output: "pppz"
Explanation: "pppz" is a valid string since the character 'p' occurs three times
and the character 'z' occurs once. Note that there are many other valid strings such
as "ohhh" and "love".

 */

class Solution {

    public String generateTheString(int n) {
        StringBuilder sbf = new StringBuilder();
        Map<Integer, Character> map = new HashMap<>();
        int x = 1;
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(x, c);
            x++;
        }
        if (n > 26) {
            if (n % 2 != 0) {
                for (int i = 0; i < n; i++) {
                    sbf.append(map.get(1));
                }
            } else {
                for (int i = 0; i < n - 1; i++) {
                    sbf.append(map.get(1));
                }
                sbf.append(map.get(2));
            }
        } else {
            for (int i = 1; i <= n; i++) {
                sbf.append(map.get(i));
            }
        }
        return sbf.toString();
    }
}
