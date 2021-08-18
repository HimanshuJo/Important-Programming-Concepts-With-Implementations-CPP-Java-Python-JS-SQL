package com.essenbazar._728Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MainB {

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

	public static int check(int i, int j, long arr, long arr2) {
		int res = -1;
		if (arr * arr2 == i + j) {
			res = 1;
			return res;
		}
		return res;
	}

	public static void main(String[] args) {
		CustomReader cs = new CustomReader();
		int t = cs.nextInt();
		while (t-- > 0) {
			int n;
			n = cs.nextInt();
			long[] arr = new long[n];
			int res = 0;
			for (int i = 0; i < n; ++i) {
				arr[i] = cs.nextInt();
			}
			for (int i = 0; i < n - 1; ++i) {
				for (int j = i + 1; j < n; ++j) {
//					System.out.println((i + 1) + " " + (j + 1));
//					System.out.println("-------");
					int temp = check(i + 1, j + 1, arr[i], arr[j]);
					res = temp == -1 ? res : res + 1;
				}
			}
			out.println(res);
		}
		out.flush();
	}
}
