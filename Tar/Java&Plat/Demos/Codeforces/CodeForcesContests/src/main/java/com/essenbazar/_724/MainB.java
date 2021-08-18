package com.essenbazar._724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

	public static void main(String[] args) {
		CustomReader cs = new CustomReader();
		List<String> all = new ArrayList<>();
		for (char i = 'a'; i <= 'z'; ++i) {
			all.add("" + i);
		}
		for (char i = 'a'; i <= 'z'; ++i) {
			for (char j = 'a'; j <= 'z'; ++j) {
				all.add("" + i + j);
			}
		}
		for (char i = 'a'; i <= 'z'; ++i) {
			for (char j = 'a'; j <= 'z'; ++j) {
				for (char k = 'a'; k <= 'z'; ++k)
					all.add("" + i + j + k);
			}
		}
		int t = cs.nextInt();
		while (t-- > 0) {
			int n = cs.nextInt();
			String s = cs.nextLine();
			Set<String> set = new HashSet<>();
			for (int i = 1; i <= 3; ++i) {
				for (int j = 0; j + i <= n; ++j) {
					set.add(s.substring(j, i + j));
				}
			}
			for (String str : all) {
				if (!set.contains(str)) {
					out.println(str);
					break;
				}
			}
		}
		out.flush();
	}
}
