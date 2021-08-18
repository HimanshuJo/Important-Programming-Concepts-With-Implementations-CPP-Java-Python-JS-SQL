package com.essenbazar._deltixRound;

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
			}
			return str;
		}
	}

	public static void main(String[] args) {
		CustomReader cs = new CustomReader();
		int t = cs.nextInt();
		while (t-- > 0) {
			int n = cs.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) {
				arr[i] = cs.nextInt();
			}
			out.println(3 * n);
			for (int i = 0; i < n; i += 2) {
				out.println("2 " + (i + 1) + " " + (i + 2));
				out.println("2 " + (i + 1) + " " + (i + 2));
				out.println("1 " + (i + 1) + " " + (i + 2));
				out.println("2 " + (i + 1) + " " + (i + 2));
				out.println("2 " + (i + 1) + " " + (i + 2));
				out.println("1 " + (i + 1) + " " + (i + 2));
			}
		}
		out.flush();
	}
}
