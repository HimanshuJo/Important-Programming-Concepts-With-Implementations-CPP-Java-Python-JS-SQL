/*
Project for solving some April_21 leetcode problems
 */
package com.essenbazar.longestIncreasingPathMatrix;

/**
 *
 * @author himanshu
 */

/*

Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. 

You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].

*/

/*

Algo:

    Important steps that we need to follow:

        we need to find the longest increasing path from each and every point in the matrix

            as any of the points in the matrix can be the starting point from our longest increasing
                path

            so in the end we will select the one with the longest length

*/

// Brute force

public class Solution {
    
    int [][] dir = {{1, 0} /* down */, {-1, 0} /* up */, {0 ,1} /* right */, {0, -1} /* left */};
    
    public int longestIncreasingPath(int [][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        // else we will call dfs at each point
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int [][] mem = new int [m][n];
        
        int longestPath = 0;
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int path = dfs(matrix, m, n, i, j, mem);  // length of the current path with starting i and j
                longestPath = Math.max(path, longestPath);
            }
        }
        
        return longestPath;
    }
    
    public int dfs(int [][] matrix, int m, int n, int i, int j, int [][] mem) {
        
        // what to do with memo matrix
        if (mem[i][j] > 0) return mem[i][j];
        
        int max = 0;
        
        for (int [] d : dir) {
            int x = i + d[0], y = j + d[1];  // to produce new x and y
            
            // we need to check our conditions whether x and y are inside the boundaries
                // of our matrix and whether the new points are greater than the current position
            if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, dfs(matrix, m, n, x, y, mem));
            }
        }
        mem[i][j] = max + 1;
        return max + 1;  // +1 to add for the current position
    }   
}

/*

Time Complexity:

    O(mn)

Space Complexity:

    O(mn)

*/