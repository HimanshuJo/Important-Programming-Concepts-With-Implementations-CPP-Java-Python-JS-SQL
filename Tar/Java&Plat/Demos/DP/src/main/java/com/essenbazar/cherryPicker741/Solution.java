/*
Project for solving some DP problems
 */
package com.essenbazar.cherryPicker741;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author himanshu
 */
class Solution {
    public int cherryPickup(int[][] grid) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        int n = grid.length;
        int res = dp(0, 0, 0, 0, grid, map, n);
        int finalRes = res > 0 ? res : 0;
        return finalRes;
    }
    
    private int dp(int r1, int c1, int r2, int c2, int[][] grid, Map<List<Integer>, Integer> map, int n) {
        List<Integer> temp = Arrays.asList(r1, c1, r2, c2);
        if (map.containsKey(temp)) {
            return map.get(temp);
        }
        if (r1 > n - 1 || c1 > n - 1 || r2 > n - 1 || c2 > n - 1 || 
                grid[r1][c1] == -1 || grid[r2][c2] == -1 || 
                r1 < 0 || r2 < 0 || c1 < 0 || c2 < 0) {   
            return Integer.MIN_VALUE; 
        }
        if (r1 == c1 && c1 == n - 1) {
            return grid[r1][c1];
        }
        int currCherry = 0;
        if (r1 == r2 && c1 == c2) {
            currCherry = grid[r1][c1];
        } else {
            currCherry = grid[r1][c1] + grid[r2][c2];
        }
        int[][] dir = {{1, 0}, {0, 1}};
        int nextCherry = Integer.MIN_VALUE;
        for (int[] d1 : dir) {
            for (int[] d2 : dir) {
                int nr1 = r1 + d1[0];
                int nc1 = c1 + d1[1];
                int nr2 = r2 + d2[0];
                int nc2 = c2 + d2[1];                
                nextCherry = Math.max(nextCherry, dp(nr1, nc1, nr2, nc2, grid, map, n));
            }
        }
        currCherry += nextCherry;
        map.put(temp, currCherry);
        return currCherry;
    } 
}