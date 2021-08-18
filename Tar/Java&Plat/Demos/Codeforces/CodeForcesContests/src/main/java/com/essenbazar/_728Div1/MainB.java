package com.essenbazar._728Div1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
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

	static final long MOD = (long) (1e9 + 7L);
	static long[] fac;
	static long[] invFac;
	static ArrayDeque<Integer>[] edges;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		CustomReader cs = new CustomReader();
		fac = new long[420];
		invFac = new long[420];
		fac[0] = invFac[0] = 1L;
		for (int i = 1; i < 420; ++i) {
			fac[i] = (fac[i - 1] * i) % MOD;
			invFac[i] = power(fac[i], MOD - 2, MOD);
		}
		// dp[a][b] = prob. that a becomes 0 before b
		long[][] dp = new long[201][201];
		for (int a = 0; a <= 200; ++a) {
			for (int b = 0; b <= 200; ++b) {
				dp[a][b] = -1;
			}
		}
		for (int i = 1; i <= 200; ++i) {
			dp[0][i] = 1L;
			dp[i][0] = 0L;
		}
		for (int a = 1; a <= 200; ++a) {
			for (int b = 1; b <= 200; ++b) {
				dfs(a, b, dp);
			}
		}
		int N = cs.nextInt();
		edges = new ArrayDeque[N + 1];
		for (int i = 1; i <= N; ++i) {
			edges[i] = new ArrayDeque<Integer>();
		}
		for (int i = 1; i < N; ++i) {
			int a = cs.nextInt();
			int b = cs.nextInt();
			edges[a].add(b);
			edges[b].add(a);
		}
		long res = 0L;
		for (int a = 1; a <= N; ++a) {
			for (int b = 1; b < a; ++b) {
				boolean[] seen = new boolean[N + 1];
				int[] parent = new int[N + 1];
				seen[a] = true;
				parent[a] = -1;
				ArrayDeque<Integer> q = new ArrayDeque<Integer>();
				q.add(a);
				while (q.size() > 0) {
					int curr = q.poll();
					for (int next : edges[curr]) {
						if (!seen[next]) {
							seen[next] = true;
							parent[next] = curr;
							q.add(next);
						}
					}
				}
				boolean[] onLine = new boolean[N + 1];
				ArrayList<Integer> line = new ArrayList<>();
				int currLineNode = b;
				while (currLineNode != a) {
					line.add(currLineNode);
					onLine[currLineNode] = true;
					currLineNode = parent[currLineNode];
				}
				line.add(a);
				onLine[a] = true;
				Collections.reverse(line);
				DSU union = new DSU(N + 1);
				for (int v = 1; v <= N; ++v) {
					for (int next : edges[v]) {
						if ((!onLine[v] || !onLine[next]) && union.find(v) != union.find(next)) {
							union.merge(v, next);
						}
					}
				}
				for (int i = 0; i < line.size(); ++i) {
					int distFromA = i;
					int distFromB = line.size() - i - 1;
					long temp = (union.size[union.find(line.get(i))] * invFac[N]) % MOD;
					temp = (temp * fac[N - 1]) % MOD;
					temp = (temp * dp[distFromA][distFromB]) % MOD;
					res += temp;
					if (res >= MOD) {
						res -= MOD;
					}
				}
			}
		}
		out.println(res);
		out.flush();
	}

	public static long dfs(int a, int b, long[][] dp) {
		if (dp[a][b] != -1) {
			return dp[a][b];
		}
		long res = (invFac[2] * dfs(a - 1, b, dp)) % MOD;
		res += (invFac[2] * dfs(a, b - 1, dp)) % MOD;
		if (res >= MOD) {
			res -= MOD;
		}
		return dp[a][b] = res;
	}

	public static long power(long x, long y, long p) {
		long res = 1L;
		x = x % p;
		while (y > 0) {
			if ((y & 1) == 1) {
				res = (res * x) % p;
			}
			y >>= 1;
			x = (x * x) % p;
		}
		return res;
	}
}

class DSU {
	public int[] dsu;
	public int[] size;

	public DSU(int N) {
		dsu = new int[N + 1];
		size = new int[N + 1];
		for (int i = 0; i <= N; ++i) {
			dsu[i] = i;
			size[i] = 1;
		}
	}

	public int find(int x) {
		return dsu[x] == x ? x : (dsu[x] = find(dsu[x]));
	}

	public void merge(int x, int y) {
		int fx = find(x);
		int fy = find(y);
		size[fy] += size[fx];
		dsu[fx] = fy;
	}
}
