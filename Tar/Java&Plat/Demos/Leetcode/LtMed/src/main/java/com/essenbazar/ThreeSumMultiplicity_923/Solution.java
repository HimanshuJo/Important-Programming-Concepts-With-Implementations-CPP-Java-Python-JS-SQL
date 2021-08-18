/*
Project for solving some common algorithm problems
 */
package com.essenbazar.ThreeSumMultiplicity_923;

/**
 *
 * @author himanshu
 */

/*

Given an integer array arr, and an integer target,

return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.

As the answer can be very large, return it modulo 109 + 7.

Example 1:

Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
Output: 20
Explanation: 
Enumerating by the values (arr[i], arr[j], arr[k]):
(1, 2, 5) occurs 8 times;
(1, 3, 4) occurs 8 times;
(2, 2, 4) occurs 2 times;
(2, 3, 3) occurs 2 times.


 */
class Solution {

    public int threeSumMulti(int[] arr, int target) {
        int mod = 10_000_000_07;
        long result = 0;

        for (int i = 0; i < arr.length; ++i) {
            int count[] = new int[101];
            for (int j = i + 1; j < arr.length; ++j) {
                int k = target - arr[i] - arr[j];

                if (k >= 0 && k <= 100 && count[k] > 0) {
                    result += count[k];
                    result %= mod;
                }
                count[arr[j]]++;
            }
        }

        return (int) result;
    }
}
