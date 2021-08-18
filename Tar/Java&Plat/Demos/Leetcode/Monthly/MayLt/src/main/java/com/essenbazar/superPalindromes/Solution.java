/*
Project for solving some May_21 leetcode problems
 */
package com.essenbazar.superPalindromes;

/**
 *
 * @author himanshu
 */

/*

Let's say a positive integer is a super-palindrome if it is a palindrome, 
and it is also the square of a palindrome.

Given two positive integers left and right represented as strings, 
return the number of super-palindromes integers in the inclusive range [left, right].

Input: left = "4", right = "1000"
Output: 4
Explanation: 4, 9, 121, and 484 are superpalindromes.
Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.

*/
class Solution {

    public boolean isPalindrome(long n) {
        return n == reverse(n);
    }

    public long reverse(long n) {
        long rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }

        return rev;

    }

    public int superpalindromesInRange(String left, String right) {
        int ans = 0;
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);

        int range = 100000;

        for (int i = 1; i < range; ++i) {
            String s1 = String.valueOf(i);

            StringBuilder temp = new StringBuilder();

            for (int ii = s1.length() - 2; ii >= 0; --ii) {
                temp.append(s1.charAt(ii));
            }

            String s2 = temp.toString();

            String s = s1 + s2;

            long num = Long.parseLong(s);
            num *= num;

            if (num > r) {
                break;
            }

            if (num >= l && isPalindrome(num)) {
                ans += 1;
            }
        }

        for (int i = 1; i < range; ++i) {
            String s1 = String.valueOf(i);

            StringBuilder temp = new StringBuilder();

            for (int ii = s1.length() - 1; ii >= 0; --ii) {
                temp.append(s1.charAt(ii));
            }

            String s2 = temp.toString();

            String s = s1 + s2;

            long num = Long.parseLong(s);
            num *= num;

            if (num > r) {
                break;
            }

            if (num >= l && isPalindrome(num)) {
                ans += 1;
            }
        }

        return ans;
    }
}
