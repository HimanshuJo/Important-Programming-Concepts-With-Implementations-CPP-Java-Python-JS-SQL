/*
Project for solving some May_21 leetcode problems
 */
package com.essenbazar.delOperationForTwoStrings;

import java.util.Arrays;

/**
 *
 * @author himanshu
 */

/*

Given two strings word1 and word2, return the minimum number of steps 
required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4

 */

 /*

Intution:

    If we just try start performing delete operations, the approach is going to be hard, since we don't
        know which character to delete

    Having a much closer look at the problem
        In order to return the minimum number of steps, we need to delete from both the strings

        Approach is very similar to finding the longest common string among the two words

    If we can find the longest common string between the two words

        we can simply calculate the resultant length using the formula

            m + n - 2 * longestCommonString

                m is the length of the first word

                n is the length of the second word

    In order to find the longest common string, the approach is very classic DP problem

    -------

    In essence the whole approach is a very typical two string DP problem

        In this approach we always start with defining a two dimensional DP

            dp[i][j]  --> for dp we always want to define the states

            for these two words, we always need two states

                here dp[i][j] basically indicates

                    for the first i's letters from word1 and first j's letter from word2
                        what is the longest common string

                dp[i][j] is kind of like a state transition function

                    dp[i][j] will depend on the current state
                        whether the i's letter in the word1 and the j's letter in the word2
                        are same or not

                    if word1[i] == word2[j]  --> this basically denotes that
                        we will have at least one common substring between the two strings
                        so 1 + dp[i - 1][j - 1]

                    else
                        max(dp[i][j - 1], dp[i - 1][j])

            That basically denotes, suppose we have two strings

                    word1 = abcdef

                    word2 = cdef

                so i is currently at word1 'f' and j is currently at word2 'f'

                at this kind of state we are comparing i and j
                    if these two are same, then that basically means that at least
                    we have one common string here

                    the remainings are the sub-problems
                        the i - 1 string from the word1

                        and j - 1 string from the word2

        The base case for the above approach

            we are starting from 1,1 here

            so for dp[0][j]  --> it means that the first word or string is empty and the second one is not
                    so, between the empty string and the non-empty string the LCS will always be 0

                    same thing is for dp[i][0]

 */
class Solution {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, 0);
        }

        for (int i = 1; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return m + n - 2 * dp[m][n];
    }
}

/*

The above equation works because in case of complete mismatch
(i.e. if the two strings can't be equalized at all), 
the total number of delete operations required will be m+n. 

Now, if there is a common sequence among the two strings of length lcs, 

    we need to do lcs lesser deletions in both the strings leading to a total of 
        2lcs lesser deletions, which then leads to the above equation.

*/