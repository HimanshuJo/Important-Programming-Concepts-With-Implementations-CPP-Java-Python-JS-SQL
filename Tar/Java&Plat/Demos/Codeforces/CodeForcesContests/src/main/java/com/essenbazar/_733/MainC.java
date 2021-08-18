package com.essenbazar._733;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
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
		int t = cs.nextInt();
		while (t-- > 0) {
			int n = cs.nextInt();
			PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
			for (int i = 0; i < n; i++) {
				pq1.add(cs.nextInt());
			}
			for (int i = 0; i < n; i++) {
				pq2.add(cs.nextInt());
			}
			int x = n - (n / 4);
			long sum1 = 0;
			long sum2 = 0;
			Deque<Integer> qq1 = new ArrayDeque<>();
			Deque<Integer> qq2 = new ArrayDeque<>();
			for (int i = 0; i < x; i++) {
				sum1 += pq1.peek();
				qq1.add(pq1.poll());
				sum2 += pq2.poll();
			}
			while (!pq2.isEmpty()) {
				qq2.add(pq2.poll());
			}
			int ans = 0;
			while (sum1 < sum2) {
				ans++;
				n++;
				if (n % 4 == 0) {
					if (!qq1.isEmpty()) {
						sum1 += (100 - qq1.pollLast());
					}
				} else {
					sum1 += 100;
					if (!qq2.isEmpty()) {
						sum2 += qq2.pollFirst();
					}
				}
			}
			out.println(ans);
		}
		out.flush();
	}
}
