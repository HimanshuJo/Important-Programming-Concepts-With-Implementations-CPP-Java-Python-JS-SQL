package com.essenbazar._586;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MainC {

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
		String s = cs.nextLine();
		char sm = s.charAt(0);
		char S[] = s.toCharArray();
		out.println("Mike");
		for (int k = 1; k < S.length; ++k) {
			boolean flag = false;
			if (S[k] <= sm) {
				sm = S[k];
			} else {
				flag = true;
			}
			if (flag) {
				out.println("Ann");
			} else {
				out.println("Mike");
			}
		}
		out.flush();
	}
}
