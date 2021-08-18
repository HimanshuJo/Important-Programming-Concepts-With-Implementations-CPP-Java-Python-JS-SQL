package com.essenbazar._110;

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

	public static int gcdInt(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcdInt(b, a % b);
		}
	}

	public static void main(String[] args) {
		CustomReader cs = new CustomReader();
		int t = cs.nextInt();
		while (t-- > 0) {
			int n = cs.nextInt();
			int[] res = new int[n];
			int left = 0;
			int right = n - 1;
			for (int i = 0; i < n; i++) {
				int a = cs.nextInt();
				if ((a & 1) == 1) {
					res[right] = a;
					right--;
				} else {
					res[left] = a;
					left++;
				}
			}
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					int x = gcdInt(res[i], 2 * res[j]);
					if (x > 1)
						count++;
				}
			}
			System.out.println(count);
		}
	}
}
