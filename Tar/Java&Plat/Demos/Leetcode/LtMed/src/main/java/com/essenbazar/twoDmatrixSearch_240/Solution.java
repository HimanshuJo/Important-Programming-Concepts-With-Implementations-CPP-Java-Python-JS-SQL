/*
Project for solving some common algorithm problems
 */
package com.essenbazar.twoDmatrixSearch_240;

/**
 *
 * @author himan
 */

/*

Write an efficient algorithm that searches for a target value in an m x n integer matrix.
The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

 */
class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] matrix1 : matrix) {
            for (int num : matrix1) {
                if (num == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
