/*
Project for solving some common algorithm problems
 */
package com.essenbazar.pacificAtalanticWaterFlow_417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author himanshu
 */

/*

You are given an m x n integer matrix heights representing the height of each unit cell in a continent.

The Pacific ocean touches the continent's left and top edges, and the Atlantic ocean touches the continent's right and bottom edges.

Water can only flow in four directions: up, down, left, and right. Water flows from a cell to an adjacent
one with an equal or lower height.

Return a list of grid coordinates where water can flow to both the Pacific and Atlantic oceans.

 */

/*

Algo:

    First find all the cells in the matrix from where water can only flow to the Pacific
        (there might be few cells in the corner, where water can go to both the oceans, we can include them anyway)

        take care of the constraint, that a water can flow only from a bigger cell to smaller cell

    Next find all the cells in the matrix from where water can only flow to the Atlantic
        (there might be few cells in the corner, where water can go to both the oceans, we can include them anyway)

        take care of the constraint, that a water can flow only from a bigger cell to smaller cell

    Lastly find the common cells in both the above steps

        once we have all the common cells marked up, we can easily find out their coordinates

        for finding the coordinates, we can use either bfs or dfs

*/


// using DFS

class Solution {
    int [][] dir = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    
    
    // dfs util for iterating and filling up the ocean
    
    public void dfsUtil(int [][] matrix, int i, int j, int prev, boolean [][] ocean) {
        // first have to check the bounday condition for i and j
        if (i < 0 || i > ocean.length || j < 0 || j > ocean[0].length) return;
        
        // next thing we are going to do is to check whether we can go to that particular
            // location or not
            
        // if current value is less than the previous value or the place is already true, we can return
        if (matrix[i][j] < prev || ocean[i][j]) return;
        ocean[i][j] = true;
        
        // call dfs on all the four direction
        for (int [] d : dir) {
            dfsUtil(matrix, i + d[0], j + d[1], matrix[i][j], ocean);
        }
    }
    
    
    public List<List<Integer>> pacificAtlantic(int [][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        // checking the edge case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
        int row = matrix.length;
        int col = matrix[0].length;
        
        boolean [][] pacific = new boolean [row][col];
        boolean [][] atlantic = new boolean [row][col];
        
        // With DFS I can fill the above two matrices
            // for that I need a dfsUtil function
        
        // writing dfs for cols initially
        for (int i = 0; i < col; ++i) {
            // in the first dfs call row will remain 0 and col will be i, prev will be int min val, and since will we first use
                // 0th row, the ocean near to it is Pacific
            dfsUtil(matrix, 0, i, Integer.MIN_VALUE, pacific);
            
            // in the second dfs call row will become row - 1, and because row - 1 is nearest to the bottom, so this will become
                // atlantic ocean
            dfsUtil(matrix, row - 1, i, Integer.MIN_VALUE, atlantic);
        }
        
        // writing dfs for row
        for (int i = 0; i < row; ++i) {
            // here in the first dfs call my row will be i, and col will be 0, and the 0th column is nearer to
                // the pacific ocean
            dfsUtil(matrix, i, 0, Integer.MIN_VALUE, pacific);
            
            // in the second dfs call my col will be col - 1, and since this is closer to atlantic ocean, so that will go to
                // the atlantic
            dfsUtil(matrix, i, col - 1, Integer.MIN_VALUE, atlantic);
        }
        
        // After the above two matrices are filled
        
        // For adding everything into res, we have to iterate over the above two matices and find the coordinates
            // wherein the value is true for both pacific and atlantic
            
        // preparation of the result
        
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        
        return res;
    }
}

/*

Time Complexity:

    O(MN)

Space Complexity:

    O(MN)

*/