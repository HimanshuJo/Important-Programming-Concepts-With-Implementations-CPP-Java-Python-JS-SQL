package com.essenbazar._724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class MainA {

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
		while (t-- > 0) {
			int n = cs.nextInt();
			int[] arr = new int[n];
			boolean flag = false;
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < n; ++i) {
				arr[i] = cs.nextInt();
				if (arr[i] < 0) {
					flag = true;
				}
			}
			if (!flag) {
				Arrays.sort(arr);
				int max = arr[arr.length - 1];
				for (int i = 0; i <= max; ++i) {
					set.add(i);
				}
				out.println("YES");
				out.println(set.size());
				for (int num : set) {
					out.print(num + " ");
				}
				out.println();
			} else {
				out.println("NO");
			}
		}
		out.flush();
	}
}
