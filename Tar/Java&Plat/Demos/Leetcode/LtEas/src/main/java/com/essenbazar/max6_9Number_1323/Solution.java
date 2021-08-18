package com.essenbazar.max6_9Number_1323;

/*

Given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).

Example 1:

Input: num = 9669
Output: 9969
Explanation: 
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666. 
The maximum number is 9969.

 */

class Solution {

    public int maximum69Number(int num) {
        String s1 = Integer.toString(num);
        int max = num;
        for (int i = 0; i < s1.length(); i++) {
            StringBuilder sbf = new StringBuilder(s1);
            if (s1.charAt(i) == '6') {
                sbf.setCharAt(i, '9');
                if (Integer.parseInt(sbf.toString()) > max) {
                    max = Integer.parseInt(sbf.toString());
                }
            } else if (s1.charAt(i) == '9') {
                sbf.setCharAt(i, '6');
                if (Integer.parseInt(sbf.toString()) > max) {
                    max = Integer.parseInt(sbf.toString());
                }
            }
        }
        return max;
    }
}
