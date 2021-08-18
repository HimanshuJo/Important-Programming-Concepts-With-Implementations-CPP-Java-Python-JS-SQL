package com.essenbazar._2050;

import java.util.*;

public class MainC {

	static int[][] arr;
	static boolean[][] vis;
	static int n;
	static int cnt;

	static void dfs(int r, int c, int val) {
		// imp base condition for each call stack
		if (r > n || c > n || r <= 0 || c <= 0 || cnt <= 0 || vis[r][c]) {
			return;
		}
		vis[r][c] = true;
		arr[r][c] = val;
		cnt--;
		dfs(r, c - 1, val);
		dfs(r + 1, c, val);
		dfs(r, c + 1, val);
	}

	public static void solve() {
		try (Scanner scn = new Scanner(System.in)) {
			n = scn.nextInt();
			arr = new int[n + 1][n + 1];
			vis = new boolean[n + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i][i] = scn.nextInt();
				vis[i][i] = true;
			}
		}
		for (int i = 1; i <= n; i++) {
			cnt = arr[i][i];
			vis[i][i] = false;
			for (int[] arr_ : arr) {
				System.out.println(Arrays.toString(arr_));
			}
			System.out.println("***---***");
			for (boolean[] arr_ : vis) {
				System.out.println(Arrays.toString(arr_));
			}
			System.out.println("-------");
			dfs(i, i, arr[i][i]);
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		solve();
	}
}
