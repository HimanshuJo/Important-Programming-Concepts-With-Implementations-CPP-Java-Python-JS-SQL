package com.essenbazar.ABC211;

/*
 * You are given a string S
 * 
	How many ways are there to choose and underline eight of its characters so that those characters read 
	c, h, o, k, u, d, a, i from left to right?
	Since the count can be enormous, print it modulo (10^9+7)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class ChokudaiC {

	static PrintWriter out;

	static class CustomReader {

		BufferedReader br;
		StringTokenizer st;

		public CustomReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) {
		CustomReader cs = new CustomReader();
		int t = 1;
		while (t-- > 0) {
			String s;
			s = cs.nextLine();
			StringBuilder ss = new StringBuilder();
			ss.append(" ");
			ss.append(s);
			String temp = " chokudai";
			int mod = (int) 1e9 + 7;
			int m = ss.length();
			int n = temp.length();
			int[][] dp = new int[m + 1][n + 1];
			for (int i = 0; i <= n; ++i) {
				dp[0][i] = 0;
			}
			for (int i = 0; i <= m; ++i) {
				dp[i][0] = 1;
			}
			for (int i = 1; i < m; ++i) {
				for (int j = 1; j < n; ++j) {
					if (i >= 1 && i < m && j >= 1 && j < n && ss.charAt(i) != temp.charAt(j)) {
						dp[i][j] = dp[i - 1][j];
					} else if (i >= 1 && i < m && j >= 1 && j < n && ss.charAt(i) == temp.charAt(j)) {
						dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % mod;
					}
				}
			}
			out.println(dp[m - 1][n - 1]);
		}
		out.flush();
	}
}
