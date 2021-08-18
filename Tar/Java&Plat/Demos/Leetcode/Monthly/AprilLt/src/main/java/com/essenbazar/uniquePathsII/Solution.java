/*
Project for solving some April_21 leetcode problems
 */
package com.essenbazar.uniquePathsII;

import java.util.Arrays;

/**
 *
 * @author himanshu
 */

/*

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid.

*/

/*

Recursive Solution: Bottom up solution

    DFS approach:

        From a given point we can only move in right and downward direction

        That means we can only go to (r,c+1) or (r+1,c)

            We will go an recursively call our function on these two directions and see whether
                we can reach the finish line

        There comes two condition:

            1. If we can reach the finish line, we will be adding 1 to the result
                (indicating that this was the unique path)
            
            2. We will be exiting only when we are going out of bounds of this particular grid
                or when we encounter an obstacle

            -------

            These will be our only exit condition, wherein we are sure that we cannot go any further
                in this particular dir, and we can return that the direction is unreachable now

*/

class Solution {
    
    //int paths=0;
    int[][] dp;
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return dfs(obstacleGrid, 0, 0);
        //return paths
        
    }
    
    int dfs(int[][] grid, int row, int col) {
        // exit condition
        if (row<0 || col<0 || row==grid.length || col==grid[0].length || grid[row][col]==1) {
            return 0;
        }
        
        // if my current row column is the bottom right row column or not
        if (row==grid.length-1 && col==grid[0].length-1) {
            //paths++;
            return 1;
        }
        
        // else dfs on right and down direction
        // before calling the dfs I will check whether I am having a positive result in the dp array or not
        if (dp[row][col] > -1) {
            return dp[row][col];
        }
        dp[row][col]=dfs(grid, row, col+1) + dfs(grid, row+1, col);
        //dfs(grid, row, col+1);
        //dfs(grid, row+1, col);
        
        return dp[row][col];
    }
}

/*

Iterative: Top Down approach

    As we know that from a particular point, we can go either in top or down direction

    So, when I am at some position say x, y
        I will be coming at this position either left to it or top to it, depending on where I am moving

        So I can simply fill the cells with the number of paths, I can come here from

        -------

        We can say that the first row and the first column would be filled with 1's

            Because I can simply travel either right or down 

            Other than that if I am at a particular position then I can come at that cell
                either from top or from the left

                so the result for that particular cell will simply be the addition of
                    the paths that I can reach here from

                        (r,c+1)+(r-1,c)

            When we fill all the cells like this, we will get the result in our bottom right corner for
                how many unique paths are possible from the start to the end

            We will be taking 1 at the start cell, if we encounter an obstacle during out travel
                we will not visit that cell and update that cell with 0
*/
class SolutionItr {
    
    public int uniquePathsWithObstacles(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        
        if (grid[0][0]==1) return 0;
        
        // here we won't be using any additional data structure and we will only update our grid
        for (int i=0; i<m; ++i) {
            for (int j=0; j<n; ++j) {
                // condition for the first row and first column
                if (i==0 || j==0) {
                    // the cell will be marked 0 only if it's previous cell was an obstacle
                        // or if current cell is an obstacle
                    if (grid[i][j]==1 || (i!=0 && grid[i-1][0]==0 ||(j!=0 && grid[i][j-1]==0))) {
                        grid[i][j]=0;
                    } else {
                        grid[i][j]=1;
                    }
                }
                
                // all the other cells
                else {
                    // first we will check if the particular cell is an obstacle or not
                    if (grid[i][j]==1) {
                        grid[i][j]=0;
                    } else {
                        grid[i][j]=grid[i-1][j]+grid[i][j-1];
                    }
                }
            }
        }
        
        return grid[m-1][n-1];
    }
}