package com.essenbazar._714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class MainD {

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
			int n;
			long x;
			n = cs.nextInt();
			x = cs.nextLong();
			List<Long> a = new ArrayList<>();
			for (int i = 0; i < n; ++i) {
				a.add(cs.nextLong());
			}
			boolean[] seen = new boolean[n];
			Arrays.fill(seen, false);
			TreeMap<Long, Integer> map = new TreeMap<>();
			long ans = 0;
			for (int i = 0; i < n; ++i) {
				map.put(a.get(i), i);
			}
			for (Entry<Long, Integer> entry : map.entrySet()) {
				long curVal = entry.getKey();
				int i = entry.getValue();
				if (curVal >= x) {
					break;
				}
				while (i > 0) {
					if (seen[i - 1]) {
						break;
					}
					if (a.get(i - 1) % curVal == 0) {
						seen[i - 1] = true;
						ans += curVal;
						i--;
					} else {
						break;
					}
				}
				i = entry.getValue();
				while (i < n - 1) {
					if (seen[i])
						break;
					if (a.get(i + 1) % curVal == 0) {
						seen[i] = true;
						ans += curVal;
						i++;
					} else {
						break;
					}
				}
			}
			for (int i = 0; i < n - 1; ++i) {
				if (!seen[i]) {
					ans += x;
				}
			}
			out.println(ans);
		}
		out.flush();
	}
}
