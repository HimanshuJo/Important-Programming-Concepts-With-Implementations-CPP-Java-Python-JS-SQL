/*
Project for solving some DFS problems
 */
package com.essenbazar.islandPerimieter463;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author himanshu
 */

/*
 *
 * You are given row x col grid representing a map where grid[i][j] = 1
 * represents land and grid[i][j] = 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally).
 *
 * The grid is completely surrounded by water, and there is exactly one island
 * (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes", meaning the water inside isn't connected to
 * the water around the island. One cell is a square with side length 1. The
 * grid is rectangular, width and height don't exceed 100. Determine the
 * perimeter of the island.
 *
 */

/*
 *
 * How can we get the total perimeter of the island
 *
 * one of the observations we need to think about is that
 *
 * suppose we have just one square, if there is just one square, then obviously
 * the perimeter is 4
 *
 * and every time if we find an another square which is its neighbor no matter
 * what direction is the neighbor is in
 *
 * to calculate the total perimeter, we have to subtract one from the perimeter
 * of the current square (4 - 1)
 *
 * similarly we loop through all the 1's which denotes the land if that 1 has
 * any neighbor in any four directions
 *
 * for each neighbor we subtract one from the perimeter of that particular
 * square
 *
 * In essence if two ones are connected to each other, the total edges we need
 * to decrease is 2 so we have to decrease 1 from the perimeter of one square
 *
 * and 1 from the perimeter of the other square
 *
 */
class SolutionWithoutBfs {

	public int islandPerimeter(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		// we need four dirctions: up, down, left, right
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int ans = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == 1) {
					ans += 4;
					for (int[] d : directions) {
						int newi = i + d[0];
						int newj = j + d[1];
						if (0 <= newi && newi < m && 0 <= newj && newj < n && grid[newi][newj] == 1) {
							ans -= 1;
						}
					}
				}
			}
		}
		return ans;
	}
}

// 20 ms
class Solution_LinkedList {

	public int islandPerimeter(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		boolean[][] visited = new boolean[m][n];
		for (boolean[] arr : visited) {
			Arrays.fill(arr, false);
		}
		int ans = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == 1) {
					LinkedList<int[]> queue = new LinkedList<>();
					queue.offer(new int[] { i, j });
					visited[i][j] = true;
					while (!queue.isEmpty()) {
						int[] temp = queue.poll();
						int curri = temp[0];
						int currj = temp[1];
						ans += 4;
						for (int[] d : directions) {
							int newi = curri + d[0];
							int newj = currj + d[1];
							if (0 <= newi && newi < m && 0 <= newj && newj < n) {
								if (grid[newi][newj] == 1) {
									ans -= 1;
									if (!visited[newi][newj]) {
										queue.offer(new int[] { newi, newj });
										visited[newi][newj] = true;
									}
								}
							}
						}
					}
					return ans;
				}
			}
		}
		return -1;
	}
}

// Solution with BFS: 80 ms
class Solution {

	public int islandPerimeter(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		Set<ArrayList<Integer>> set = new HashSet<>();
		int ans = 0;
		boolean flag = false;
		// int numBlocks = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == 1) {
					flag = true;
					// PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a,b) -> (a.get(0) -
					// b.get(0)));
					PriorityQueue<List<Integer>> queue = new PriorityQueue<>(
							(a, b) -> (a.get(0) + a.get(1) - b.get(0) - b.get(1)));
					ArrayList<Integer> list = new ArrayList<>();
					list.add(i);
					list.add(j);
					queue.offer(list);
					set.add(list);
					while (!queue.isEmpty()) {
						// numBlocks++;
						List<Integer> temp = queue.poll();
						int curri = temp.get(0);
						int currj = temp.get(1);
						ans += 4;
						for (int[] d : directions) {
							int newi = curri + d[0];
							int newj = currj + d[1];
							if (0 <= newi && newi < m && 0 <= newj && newj < n) {
								if (grid[newi][newj] == 1) {
									ans -= 1;
									ArrayList<Integer> temp_ = new ArrayList<>();
									temp_.add(newi);
									temp_.add(newj);
									if (!set.contains(temp_)) {
										queue.offer(temp_);
										set.add(temp_);
									}
								}
							}
						}
					}
				}
				if (flag) {
					break;
				}
			}
			if (flag) {
				break;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		int[][] grid = new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		System.out.println(obj.islandPerimeter(grid));
	}
}
