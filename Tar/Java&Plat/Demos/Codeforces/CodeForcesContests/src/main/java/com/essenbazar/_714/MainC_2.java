package com.essenbazar._714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MainC_2 {

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
		int t = cs.nextInt();
		int max = 200005;
		int mod = (int) 1e9 + 7;
		long[] dp = new long[max];
		for (int i = 0; i < 9; ++i) {
			dp[i] = 2;
		}
		dp[9] = 3;
		for (int i = 10; i < max; ++i) {
			dp[i] = (dp[i - 9] + dp[i - 10]) % mod;
		}
		while (t-- > 0) {
			long n, m;
			n = cs.nextLong();
			m = cs.nextLong();
			long ans = 0;
			while (n > 0) {
				long x = n % 10;
				ans += ((m + x < 10) ? 1 : dp[(int) (m + x - 10)]);
				ans %= mod;
				n /= 10;
			}
			out.println(ans);
		}
		out.flush();
	}
}
