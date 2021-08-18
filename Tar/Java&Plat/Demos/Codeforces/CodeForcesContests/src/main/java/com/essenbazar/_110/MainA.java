package com.essenbazar._110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
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
			}
			return str;
		}
	}

	public static void main(String[] args) {
		CustomReader cs = new CustomReader();
		int t = cs.nextInt();
		while (t-- > 0) {
			int[] arr = new int[4];
			int[] minArr = new int[2];
			int[] maxArr = new int[2];
			for (int i = 0; i < 4; ++i) {
				arr[i] = cs.nextInt();
			}
			int j = 0;
			int k = 0;
			for (int i = 0; i < 4 - 1; ++i) {
				minArr[j++] = Math.min(arr[i], arr[i + 1]);
				maxArr[k++] = Math.max(arr[i], arr[i + 1]);
				i += 1;
			}
			int[] arrDesc = Arrays.stream(minArr).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue)
					.toArray();
			Arrays.sort(maxArr);
			if (maxArr[0] < arrDesc[0]) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}
