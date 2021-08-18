package com.essenbazar._249;

// Painting a Grid With Three Different Colors
/*
 * You are given two integers m and n. Consider an m x n grid where each cell is initially white.
 * You can paint each cell red, green, or blue. All cells must be painted.

	Return the number of ways to color the grid with no two adjacent cells having the same color.
	Since the answer can be very large, return it modulo 10^9 + 7.

	Example 1:

	Input: m = 1, n = 1
	Output: 3
	Explanation: The three possible colorings are shown in the image above.

	Example 3:

	Input: m = 5, n = 5
	Output: 580986
 */
import java.util.ArrayList;
import java.util.Arrays;

class Solution1931 {
	ArrayList<String> allString = new ArrayList<>();
	int[][] dp;
	int N = (int) Math.pow(10, 9) + 7;

	public int colorTheGrid(int m, int n) {

		// Generating all the possible string
		this.generateAllPossibleString(m, '$', "");
		dp = new int[this.allString.size()][n];
		for (int[] arr : dp) {
			Arrays.fill(arr, -1);
		}
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] graph = new ArrayList[this.allString.size()];
		for (int i = 0; i < this.allString.size(); i++) {
			graph[i] = new ArrayList<>();
		}

		// for each string we are storing in the graph , what other string we can put in
		// adjacent to it
		for (int i = 0; i < this.allString.size(); i++) {
			for (int j = 0; j < this.allString.size(); j++) {
				boolean flag = true;
				for (int k = 0; k < m; k++) {
					if (this.allString.get(i).charAt(k) == this.allString.get(j).charAt(k)) {
						flag = false;
						break;
					}
				}
				if (flag && i != j) {
					graph[i].add(j);
				}
			}
		}

		// Collecting the answer by traversing the graph
		long ans = 0;
		for (int i = 0; i < this.allString.size(); i++)
			ans = (ans % this.N + getTheAnswer(graph, i, n - 1) % this.N) % this.N;
		return (int) ans;

	}

	private void generateAllPossibleString(int m, char prev, String sb) {
		if (m == 0) {
			this.allString.add(sb);
			return;
		}
		char colors[] = new char[] { 'R', 'G', 'B' };
		for (char ch : colors) {
			if (ch != prev) {
				generateAllPossibleString(m - 1, ch, sb + ch);
			}
		}
	}

	private long getTheAnswer(ArrayList<Integer>[] graph, int i, int col) {
		if (col == 0)
			return 1;
		if (dp[i][col] != -1)
			return dp[i][col];
		long ans = 0;
		for (int temp : graph[i]) {
			ans = (ans % this.N + getTheAnswer(graph, temp, col - 1) % this.N) % this.N;
		}
		dp[i][col] = (int) ans;
		return dp[i][col];
	}
}