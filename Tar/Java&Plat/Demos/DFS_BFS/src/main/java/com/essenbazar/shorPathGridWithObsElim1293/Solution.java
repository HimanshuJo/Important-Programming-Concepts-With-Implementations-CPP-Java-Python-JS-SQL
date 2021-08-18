package com.essenbazar.shorPathGridWithObsElim1293;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * Given a m * n grid, where each cell is either 0 (empty) or 1 (obstacle). In one step, you can move up, down, left 
 * or right from and to an empty cell.

	Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower 
	right corner (m-1, n-1) given that you can eliminate at most k obstacles. 
	If it is not possible to find such walk return -1.
	
	Example 1:
	
	Input: 
	grid = 
	[[0,0,0],
	 [1,1,0],
	 [0,0,0],
	 [0,1,1],
	 [0,0,0]], 
	k = 1
	Output: 6
	Explanation: 
	The shortest path without eliminating any obstacle is 10. 
	The shortest path with one obstacle elimination at position (3,2) is 6. 
	Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).

 */

class Solution {
	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

	public int shortestPath(int[][] grid, int k) {
		int m = grid.length, n = grid[0].length;
		Deque<int[]> queue = new LinkedList<>();
		queue.offerLast(new int[] { 0, 0, 0 });
		int[][] visited = new int[m][n];
		for (int[] i : visited)
			Arrays.fill(i, Integer.MAX_VALUE);
		visited[0][0] = 0;
		int dist = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int[] curr = queue.poll();
				if (curr[0] == m - 1 && curr[1] == n - 1)
					return dist;
				for (int[] dir : DIRECTIONS) {
					int newX = curr[0] + dir[0];
					int newY = curr[1] + dir[1];
					// 1). continue if out of bound
					if (newX < 0 || newY < 0 || newX >= m || newY >= n)
						continue;
					// 2). continue if out of elimination
					int newK = curr[2] + grid[newX][newY];
					if (newK > k)
						continue;
					// 3). continue if we have more optimal result
					if (visited[newX][newY] <= newK)
						continue;
					visited[newX][newY] = newK;
					queue.offerLast(new int[] { newX, newY, newK });
				}
			}
			dist++;
		}
		return -1;
	}
}