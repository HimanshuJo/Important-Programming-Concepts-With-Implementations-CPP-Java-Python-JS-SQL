package com.essenbazar._729;

//Odd Set

/*
You are given a multiset (i. e. a set that can contain multiple equal integers) containing 2n integers.
Determine if you can split it into exactly n pairs (i. e. each element should be in exactly one pair)
so that the sum of the two elements in each pair is odd (i. e. when divided by 2, the remainder is 1).

Input

The input consists of multiple test cases. The first line contains an integer t (1≤t≤100) — the number of test cases.
The description of the test cases follows.

The first line of each test case contains an integer n (1≤n≤100)

The second line of each test case contains 2n integers a1,a2,…,a2n (0≤ai≤100) — the numbers in the set.

Output

For each test case, print "Yes" if it can be split into exactly n
 pairs so that the sum of the two elements in each pair is odd, and "No" otherwise.

 You can print each letter in any case.

Example
Input

5
2
2 3 4 5
3
2 3 4 5 5 5
1
2 4
1
2 3
4
1 5 3 2 6 7 3 4

Output

Yes
No
No
Yes
No

Note

In the first test case, a possible way of splitting the set is (2,3), (4,5)

In the second, third and fifth test case, we can prove that there isn't any possible way.

In the fourth test case, a possible way of splitting the set is (2,3)

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
			int n;
			n = cs.nextInt();
			List<Integer> arr = new ArrayList<>();
			new HashMap<>();
			for (int i = 0; i < 2 * n; ++i) {
				arr.add(i, cs.nextInt());
			}
			boolean flag = false;
			if (!flag) {
				int countE = 0;
				int countO = 0;
				for (int i = 0; i < arr.size(); ++i) {
					if (arr.get(i) % 2 == 0) {
						countE++;
					} else {
						countO++;
					}
				}
				if (countE != countO) {
					out.println("NO");
				} else {
					out.println("YES");
				}
			}
		}
		out.flush();
	}
}
