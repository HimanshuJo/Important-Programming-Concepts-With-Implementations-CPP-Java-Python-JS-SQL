package com.essenbazar._56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// Nearest Exit from Entrance in Maze
/*
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and
 * walls (represented as '+'). You are also given the entrance of the maze, where
 * entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

	In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall,
	and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance.
	An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

	Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

	Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
	Output: 1
	Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
	Initially, you are at the entrance cell [1,2].
	- You can reach [1,0] by moving 2 steps left.
	- You can reach [0,2] by moving 1 step up.
	It is impossible to reach [2,3] from the entrance.
	Thus, the nearest exit is [0,2], which is 1 step away.
 */
// 7ms
class Solution_Opt {
	public int nearestExit(char[][] maze, int[] entrance) {
		int rows = maze.length, cols = maze[0].length, queueSize;
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[rows][cols];
		int[] curr;
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		int x, y, steps = 0;

		queue.offer(entrance);
		visited[entrance[0]][entrance[1]] = true;

		while (!queue.isEmpty()) {
			queueSize = queue.size();
			steps++;

			for (int i = 0; i < queueSize; i++) {
				curr = queue.poll();

				for (int[] dir : dirs) {
					x = dir[0] + curr[0];
					y = dir[1] + curr[1];

					if (x < 0 || x >= rows || y < 0 || y >= cols)
						continue;
					if (visited[x][y] || maze[x][y] == '+')
						continue;

					// check if we have reached boundary
					if (x == 0 || x == rows - 1 || y == 0 || y == cols - 1)
						return steps;

					queue.offer(new int[] { x, y });
					visited[x][y] = true;
				}
			}
		}

		return -1;
	}
}

// almost TLE
public class Solution1926 {
	public int nearestExit(char[][] maze, int[] entrance) {
		int rw = maze.length;
		int col = maze[0].length;
		ArrayList<Integer> ent = new ArrayList<>(Arrays.asList(entrance[0], entrance[1]));
		ArrayList<ArrayList<Integer>> exits = new ArrayList<>();
		for (int i = 0; i < rw; ++i) {
			for (int j = 0; j < col; ++j) {
				if (i == 0) {
					if (maze[i][j] == '.') {
						if (!exits.contains(new ArrayList<>(Arrays.asList(i, j)))
								&& !(new ArrayList<>(Arrays.asList(i, j))).equals(ent))
							exits.add(new ArrayList<>(Arrays.asList(i, j)));
					}
				} else if (i == rw - 1) {
					if (maze[i][j] == '.') {
						if (!exits.contains(new ArrayList<>(Arrays.asList(i, j)))
								&& !(new ArrayList<>(Arrays.asList(i, j))).equals(ent))
							exits.add(new ArrayList<>(Arrays.asList(i, j)));
					}
				} else {
					if (maze[i][0] == '.') {
						if (!exits.contains(new ArrayList<>(Arrays.asList(i, 0)))
								&& !(new ArrayList<>(Arrays.asList(i, 0))).equals(ent))
							exits.add(new ArrayList<>(Arrays.asList(i, 0)));
					}
					if (maze[i][col - 1] == '.') {
						if (!exits.contains(new ArrayList<>(Arrays.asList(i, col - 1)))
								&& !(new ArrayList<>(Arrays.asList(i, col - 1))).equals(ent))
							exits.add(new ArrayList<>(Arrays.asList(i, col - 1)));
					}
				}
			}
		}
		int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		Set<ArrayList<Integer>> seen = new HashSet<>();
		Queue<int[]> queue = new LinkedList<>();
		queue.add(entrance);
		seen.add(ent);
		int ans = 0;
		while (!queue.isEmpty()) {
			ans++;
			int len = queue.size();
			for (int i = 0; i < len; ++i) {
				int[] currLoc = queue.poll();
				for (int[] dir : directions) {
					int newi = currLoc[0] + dir[0];
					int newj = currLoc[1] + dir[1];
					if (exits.contains(new ArrayList<>(Arrays.asList(newi, newj)))) {
						return ans;
					}
					if (newi <= rw - 1 && newi >= 0 && newj <= col - 1 && newj >= 0
							&& !seen.contains(new ArrayList<>(Arrays.asList(newi, newj))) && maze[newi][newj] != '+') {
						queue.add(new int[] { newi, newj });
						seen.add(new ArrayList<>(Arrays.asList(newi, newj)));
					}
				}
			}
		}
		return -1;
	}
}