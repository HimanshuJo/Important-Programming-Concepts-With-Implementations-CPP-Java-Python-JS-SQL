package com.essenbazar.ifPalindrome;

/**
 *
 * @author himanshu
 */
public class Solution {

    public static boolean isPalindrome(String s) {
        for (int i = 0; i < (int) s.length() / 2; ++i) {
            if (s.charAt(i) != s.charAt((int) s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "abacd";
        boolean res = false;
        res = isPalindrome(s);
        System.out.println(res);
    }
}
