/*
Project for solving some April_21 leetcode problems
 */
package com.essenbazar.rotateImage;

/**
 *
 * @author himanshu
 */

/*

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D 
matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 */

 /*

Intution:

    In essence in the input matrix the columns are getting converted into rows in reverse order
        to form the output matrix

    Transpose of a matrix

        The transpose of a matrix is writing the column in a row
    
    Similary we can use here the transpose operation of the matrix
        and in addition to that, we need to reverse the order in the row

    In essence, the result can be broken down into two parts:

        Finding a transpose and then reversing the rows

    -------

    The transpose of a matrix is simply given as
        for example, a[i, j] of the matrix will be replaced with the a[j, i]

        In essence we are just flipping our matrix across the diagonal

    Finally we can convert our transpose into the final out by reversing each row
        we can go in each row from i=0 to n/2
        and replace 1st index with last index, and replace 2nd index with second last index

        we will not go beyond n/2 because then it would simply revert the matrix back into the
            transpose state

 */

class Solution {

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // performing transpose
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                // swap matrix of [i][j] with [j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // revering the row
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n / 2; ++j) {
                // swap matrix [i][j] with matrix [i][n - j - 1]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][i - j - 1] = temp;
            }
        }
    }
}

/*

Time Complexity:

    O(N*N) no of cells we have in the matrix

Space Complexity:

    O(1)

*/

/*

Solution 2:

    In essence we have to perform 90 degree rotation

        all the four corner values will take the adjacent corners in clock wise direction

    Similary the next values/cells will shift three cells ahead in clock wise direction

    After completing the rotation for the outer circles, we have to go for the inner circles as well

    -------

    Few things to notice:
        How many layers do we have:

            No. of layers would be
                length of the matrix/2

        For the inner layer:
            the start point would be given by
                layer number
            
            and the end point would be
                n - layer - 1
                    n is 1 indexed, however the actual indexing in the matrix is 0 indexing
                        therefore we have to subtract 1 from the whole equation
                    subtracting layer because we've to subtract the same layer from the side as well
        
        Formula for rotating the matrix:

            At a particular given time:
                we are always having something moving in the 'top', 'right', 'bottom' and 'left' sides

                Let's suppose we have 4 variables

                    left -> for the left we are going to move in a fixed column (start column) across different rows
                        therefore left = [n - 1 - i][start]

                    top  --> we are going to move in a fixed row (start row) across the column left to right
                        therefore top = [start][i]

                    right  -> we are going to move in a fixed column (end column) across different rows
                        therefore right = [i][end]
                    
                    bottom  --> we are going to move in a fixed row acorss (end row) different columns
                        therefore bottom = [end][n - 1 - i]
                            last cell is (n - 1) and for the given boundary we also need to subtract the
                                value of i to get the particular column we are currently on
            -------

            Finally the value of the left side will be subsitituted to the top
                    the value of the top will be subsitituted to the right
                    the value of the right will be subsituted to the bottom
                    the value of the bottom will be subsituted to the left
*/

class Solution2 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int layers = n/2;
        for(int layer=0; layer<layers; ++layer) {
            int start=layer;
            int end=n-1-layer;
            for(int i=start; i<end; ++i) {
                //top -> [start][i]
                //left -> [n-1-i][start]
                //bottom -> [end][n-1-i]
                //right -> [i][end]
                int temp = matrix[start][i];
                //putting left in top
                matrix[start][i] = matrix[n-1-i][start];
                //bottom in left
                matrix[n-1-i][start] = matrix[end][n-1-i];
                //right in bottom
                matrix[end][n-1-i] = matrix[i][end];
                //top in right
                matrix[i][end] = temp;
            }
        }
    }
}