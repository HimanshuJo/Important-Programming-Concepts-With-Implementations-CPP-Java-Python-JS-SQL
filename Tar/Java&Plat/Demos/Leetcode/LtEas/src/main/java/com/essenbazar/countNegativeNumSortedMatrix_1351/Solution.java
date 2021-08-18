package com.essenbazar.countNegativeNumSortedMatrix_1351;

/*

Given a m x n matrix grid which is sorted in non-increasing order both row-wise
and column-wise, return the number of negative numbers in grid.

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.

 */

class Solution {

    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] grid1 : grid) {
            for (int arr : grid1) {
                if (arr < 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
