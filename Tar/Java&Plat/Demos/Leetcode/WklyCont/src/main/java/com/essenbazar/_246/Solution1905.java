package com.essenbazar._246;

import java.util.Arrays;
import java.util.LinkedList;

// Count Sub Islands

/*
 * You are given two m x n binary matrices grid1 and grid2 containing only 0's
 * (representing water) and 1's (representing land). An island is a group of 1's
 * connected 4-directionally (horizontal or vertical).
 *
 * Any cells outside of the grid are considered water cells.

   An island in grid2 is considered a sub-island if there is an island in grid1 that
   contains all the cells that make up this island in grid2.

   Return the number of islands in grid2 that are considered sub-islands.

Input: grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]],
	   	 grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
Output: 3
Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
The 1s colored red in grid2 are those considered to be part of a sub-island.
There are three sub-islands.
 */

/*
 *  We can perform a DFS/BFS on grid2 matrix, similar to 'Number of islands task'
 *
 *  For a current island in gird2, check for every cell in that island if they are present in grid1
 *  	This will ensure that if this is a sub-island of grid1
 *
 *  Maintain a flag and mark it false, if we encounter any cell which is a part of island in grid2
 *  	and not a part of island in grid1
 *
 *  Increase the count for each of the island of grid2, when the flag is true
 *
 *  Return the count, as this will be the number of islands in grid2 that are considered sub-islands
 */

import java.util.Queue;

class Solution1905 {
	public int countSubIslands(int[][] grid1, int[][] grid2) {
		int m = grid1.length;
		int n = grid1[0].length;
		boolean[][] vis = new boolean[m][n];
		int count = 0;
		int[] dir = { 1, 0, -1, 0, 1 };
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid2[i][j] == 0 || vis[i][j]) {
					continue;
				}
				Queue<int[]> queue = new LinkedList<>();
				boolean flag = true;
				vis[i][j] = true;
				queue.add(new int[] { i, j });
				while (!queue.isEmpty()) {
					int[] vtx = queue.remove();
					if (grid1[vtx[0]][vtx[1]] == 0) {
						flag = false;
					}
					for (int k = 0; k < 4; ++k) {
						int x = vtx[0] + dir[k];
						int y = vtx[1] + dir[k + 1];
						if (x >= 0 && x < m && y >= 0 && y < n && grid2[x][y] == 1 && !vis[x][y]) {
							vis[x][y] = true;
							queue.add(new int[] { x, y });
						}
					}
				}
				if (flag) {
					count++;
				}
			}
		}
		return count;
	}
}

class Solution {
	public int countSubIslands(int[][] grid1, int[][] grid2) {
		int m = grid1.length;
		int n = grid1[0].length;
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		boolean[][] vis = new boolean[m][n];
		int count = 0;
		for (boolean[] arr : vis) {
			Arrays.fill(arr, false);
		}
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid2[i][j] == 0 || vis[i][j]) {
					continue;
				}
				if (grid2[i][j] == 1) {
					LinkedList<int[]> queue = new LinkedList<>();
					queue.offer(new int[] { i, j });
					vis[i][j] = true;
					boolean flag = true;
					while (!queue.isEmpty()) {
						int curri = queue.peek()[0];
						int currj = queue.peek()[1];
						if (grid1[curri][currj] == 0) {
							flag = false;
						}
						queue.pop();
						for (int[] d : directions) {
							int newi = curri + d[0];
							int newj = currj + d[1];
							if (0 <= newi && newi < m && 0 <= newj && newj < n && grid2[newi][newj] == 1) {
								if (!vis[newi][newj]) {
									queue.offer(new int[] { newi, newj });
									vis[newi][newj] = true;
								}
							}
						}
					}
					if (flag) {
						count++;
					}
				}
			}
		}
		return count;
	}
}
