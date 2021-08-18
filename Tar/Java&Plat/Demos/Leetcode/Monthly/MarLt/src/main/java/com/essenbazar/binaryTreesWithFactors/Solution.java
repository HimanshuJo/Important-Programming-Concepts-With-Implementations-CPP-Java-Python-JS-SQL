/*
Project for solving some Mar_21 leetcode problems
 */
package com.essenbazar.binaryTreesWithFactors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author himanshu
 */

/*

Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.

We make a binary tree using these integers, and each number may be used for any number of times.

Each non-leaf node's value should be equal to the product of the values of its children.

Return the number of binary trees we can make. The answer may be too large so return the answer modulo 10^9 + 7.

 
Example 1:

Input: arr = [2,4]
Output: 3
Explanation: We can make these trees: [2], [4], [4, 2, 2]

Example 2:

Input: arr = [2,4,5,10]
Output: 7
Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].

 */

/*

DP:

    the largest value 'v' used must be the root node in the tree
    say dp(v) is the number of ways to make a tree with root node v

    if the root node of the tree (with value v) has children with values x and y
        and x * y == v, then there are dp(x) * dp(y) ways to make this tree

    -------

Algo:

    Let dp[i] be the number of ways to have a root node with a value A[i]

    Since, we will have x < v and y < v, we cn calculate the values of dp[i] in increasing order using DP

    For some root value A[i], let's try to find the candidate for the children with values A[j] and A[i] / A[j]

        so that evidently A[j] * (A[i] / A[j]) = A[i]

        To do this quickly we will need index, which looks up this value
            if A[k] = A[i] / A[j], then index [A[i] / A[j]] = k

    After we will add all the possible dp[j] * dp[k] (with j < i, k < i) to our answer dp[i]

    In java we can use long to avoid overflow issue

*/

class Solution {

    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1_000_000_007;
        int N = arr.length;
        Arrays.sort(arr);
        long [] dp = new long[N];
        Arrays.fill(dp, 1);
        System.out.println(Arrays.toString(dp));
        System.out.println("-------");
        Map<Integer, Integer> index = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            index.put(arr[i], i);
        }
        System.out.println(index.toString());
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];
                    System.out.println("i: " + i);
                    System.out.println("j: " + j);
                    System.out.println("Right: " + right);
                    if (index.containsKey(right)) {
                        dp[i] = dp[i] + dp[j] * dp[index.get(right)] % MOD;
                        System.out.println(Arrays.toString(dp));
                    }
                }
            }
        }
        
        long ans = 0;
        for (long x : dp) ans += x;
        return (int) (ans % MOD);
    }

    public static void main(String[] args) {
        Solution my_obj = new Solution();
        int[] arr = {2,4,5,10,23,45,23,4,67,5,78,5,99,56};
        my_obj.numFactoredBinaryTrees(arr);
    }
}
