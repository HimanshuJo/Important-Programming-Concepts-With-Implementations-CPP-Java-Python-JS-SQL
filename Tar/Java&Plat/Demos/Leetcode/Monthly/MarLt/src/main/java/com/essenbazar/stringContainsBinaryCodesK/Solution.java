/*
Project for solving some Mar_21 leetcode problems
 */
package com.essenbazar.stringContainsBinaryCodesK;

/**
 *
 * @author himanshu
 */

/*

Given a binary string s and an integer k.

Return True if every binary code of length k is a substring of s. Otherwise, return False.

 

Example 1:

Input: s = "00110110", k = 2
Output: true
Explanation: The binary codes of length 2 are "00", "01", "10" and "11". 

They can be all found as substrings at indicies 0, 1, 3 and 2 respectively.


 */
class Solution {

    boolean res = true;

    private void generateAllBinaryStrings(int n, int[] arr, int i, String s) {
        if (i == n) {
            StringBuilder sbf = new StringBuilder();
            for (int x = 0; x < n; x++) {
                sbf.append(String.valueOf(arr[x]));
            }
            if (!s.contains(sbf.toString())) {
                res = false;
                return;
            }
            return;
        }
        arr[i] = 0;
        generateAllBinaryStrings(n, arr, i + 1, s);
        arr[i] = 1;
        generateAllBinaryStrings(n, arr, i + 1, s);
    }

    public boolean hasAllCodes(String s, int k) {

        int[] arr = new int[k];

        generateAllBinaryStrings(k, arr, 0, s);

        return res;
    }

    public static void main(String[] args) {
        Solution my_obj = new Solution();
        String s = "00110110";
        System.out.println(my_obj.hasAllCodes(s, 2));
    }
}
