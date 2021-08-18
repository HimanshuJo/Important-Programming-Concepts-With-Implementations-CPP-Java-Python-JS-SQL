package com.essenbazar.rottingOranges994;
/*
 * 
You are given an m x n grid where each cell can have one of three values:

    0 representing an empty cell,
    1 representing a fresh orange, or
    2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:

	Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
	Output: 4
 */

import java.util.LinkedList;

public class Solution {
	public int orangesRotting(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int ans = 0;
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		LinkedList<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == 2) {
					queue.offer(new int[] { i, j });
				}
			}
		}
		while (!queue.isEmpty()) {
			int queueLen = queue.size();
			for (int i = 0; i < queueLen; ++i) {
				int[] currCoord = queue.pop();
				int curri = currCoord[0];
				int currj = currCoord[1];
				for (int[] d : directions) {
					int newi = curri + d[0];
					int newj = currj + d[1];
					if (0 <= newi && newi < m && 0 <= newj && newj < n && grid[newi][newj] == 1) {
						queue.offer(new int[] { newi, newj });
						grid[newi][newj] = 2;
					}
				}
			}
			if (!queue.isEmpty()) {
				ans += 1;
			}
		}
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}
		return ans;
	}
}
