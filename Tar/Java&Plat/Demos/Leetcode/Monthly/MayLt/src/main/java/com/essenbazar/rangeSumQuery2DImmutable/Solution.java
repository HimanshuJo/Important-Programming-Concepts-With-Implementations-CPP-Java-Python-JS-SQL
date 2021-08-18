/*
Project for solving some May_21 leetcode problems
 */
package com.essenbazar.rangeSumQuery2DImmutable;

/**
 *
 * @author himanshu
 */

/*

Given a 2D matrix matrix, handle multiple queries of the following type:

    Calculate the sum of the elements of matrix inside the rectangle defined by 
    its upper left corner (row1, col1) and lower right corner (row2, col2).

Implement the NumMatrix class:

    NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
    
    int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the 
        elements of matrix inside the rectangle defined by its upper left corner (row1, col1) 
        and lower right corner (row2, col2).

Input
["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], 
[2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]

Output
[null, 8, 11, 12]

Explanation
NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], 
[4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)

 */

/*

We can form a matrix wherein at each cell we will store what is the sum of this matrix
    starting from the 0,0 cell

One approach:

    We can find the prefix sum of all the columns (for each row)
        and prefix sum of each of the rows (for every columns)

    Each value represents the value starting from the cell 0,0

*/

class NumMatrix {
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        // finding the prefix sum for all the columns in every row
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        // finding the prefix sum for all the rows in every column
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = matrix[row2][col2];
        // finding the extras
        int extra = (col1 != 0 ? matrix[row2][col1 - 1] : 0) + 
                (row1 != 0 ? matrix[row1 - 1][col2] : 0) - 
                ((row1 != 0 && col1 != 0) ? matrix[row1 - 1][col1 - 1] : 0);
        return total - extra;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such: 
 *  NumMatrix obj = new NumMatrix(matrix); 
 *  int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
