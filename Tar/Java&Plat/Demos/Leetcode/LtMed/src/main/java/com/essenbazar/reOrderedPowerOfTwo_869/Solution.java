/*
Project for solving some common algorithm problems
 */
package com.essenbazar.reOrderedPowerOfTwo_869;

import java.util.Arrays;

/**
 *
 * @author himanshu
 */

/*

You are given an integer n. We reorder the digits in any order (including the original order)
such that the leading digit is not zero.

Return true if and only if we can do this so that the resulting number is a power of two.

Example 1:

Input: n = 1
Output: true

Example 2:

Input: n = 10
Output: false


 */
class Solution {

    private int[] count(int N) {
        int[] arr = new int[10];

        while (N > 0) {
            arr[N % 10]++;
            N /= 10;
        }
        return arr;
    }

    public boolean reorderedPowerOf2(int N) {
        int[] countN = count(N);
        int num = 1;

        for (int i = 0; i < 31; ++i) {
            if (Arrays.equals(countN, count(num))) {
                return true;
            }
            num *= 2;
        }

        return false;
    }
}
