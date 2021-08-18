package com.essenbazar._722;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MainC_2 {

	// private static final int MOD = (int) 1e9 + 7;

	static class CustomReader {

		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public CustomReader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public CustomReader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64];
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n') {
					if (cnt != 0) {
						break;
					} else {
						continue;
					}
				}
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ') {
				c = read();
			}
			boolean neg = (c == '-');
			if (neg) {
				c = read();
			}
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg) {
				return -ret;
			}
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ') {
				c = read();
			}
			boolean neg = (c == '-');
			if (neg) {
				c = read();
			}
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg) {
				return -ret;
			}
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ') {
				c = read();
			}
			boolean neg = (c == '-');
			if (neg) {
				c = read();
			}
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}
			if (neg) {
				return -ret;
			}
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1) {
				buffer[0] = -1;
			}
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead) {
				fillBuffer();
			}
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null) {
				return;
			}
			din.close();
		}
	}

	public static int sumOfArray(Integer[] a, int n) {
		if (n == 0) {
			return a[n];
		} else {
			return a[n] + sumOfArray(a, n - 1);
		}
	}

	public static long sumOfLongArray(Long[] a, int n) {
		if (n == 0) {
			return a[n];
		} else {
			return a[n] + sumOfLongArray(a, n - 1);
		}
	}

	public static boolean countSameStrB(StringBuilder sbf) {
		int count = 0;
		char a = sbf.charAt(0);
		for (int i = 0; i < sbf.length(); ++i) {
			if (sbf.charAt(i) == a) {
				count++;
			}
		}
		return count == sbf.length();
	}

	public static boolean countSameIntArr(int[] arr) {
		int count = 0;
		int num = arr[0];
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] == num) {
				count++;
			}
		}
		return count == arr.length;
	}

	public static boolean countSameIntList(List<Integer> list) {
		int count = 0;
		int num = list.get(0);
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i) == num) {
				count++;
			}
		}
		return count == list.size();
	}

	public static int[] crInputArray(int n, CustomReader cs) throws IOException {
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = cs.nextInt();
		}
		return arr;
	}

	public static long[] crInputLongArray(int n, CustomReader cs) throws IOException {
		long[] arr = new long[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = cs.nextLong();
		}
		return arr;
	}

	public static List<Integer> crInputList(int n, CustomReader cs) throws IOException {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			int temp = cs.nextInt();
			list.add(temp);
		}
		return list;
	}

	public static List<Long> crInputLongList(int n, CustomReader cs) throws IOException {
		List<Long> list = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			long temp = cs.nextInt();
			list.add(temp);
		}
		return list;
	}

	public static Map<Integer, Integer> arrayNumsCountMap(int[] arr) {
		int n = arr.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		return map;
	}

	public static Map<Integer, Integer> listNumsCountMap(List<Integer> list) {
		int n = list.size();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
		}
		return map;
	}

	public static TreeMap<Integer, Integer> listNumsCountTreeMap(List<Integer> list) {
		int n = list.size();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < n; ++i) {
			map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
		}
		return map;
	}

	public static Map<Character, Integer> stringCountMap(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); ++i) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		return map;
	}

	public static Map<Character, Integer> stringCountTreeMap(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); ++i) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		return map;
	}

	public static Set<Integer> arrayNumsSet(int[] arr) {
		int n = arr.length;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; ++i) {
			set.add(arr[i]);
		}
		return set;
	}

	public static Set<Integer> listNumsSet(List<Integer> list) {
		int n = list.size();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; ++i) {
			set.add(list.get(i));
		}
		return set;
	}

	/*
	 * For every vertex we will have two choices, either the vertex can take the
	 * value of l or r to produce the max result
	 * 
	 * Hence we have two states
	 * 
	 * So if I say we have two dp arrays dpl and dpr so, dpl -> max. beauty obtained
	 * from the subtrees of vertex v if l is selected and dpr -> max. beauty
	 * obtained from the subtrees of vertex v if r is selected
	 * 
	 * For the leaves nodes we don't need to calculate the dp values For the nodes,
	 * that has children: Suppose we have assign a vertex the value l, so in this
	 * case the dp looks like: For each vertex we will add to it the dp values of
	 * all its neighbors <- DFS will do the work here
	 * 
	 * dpl[v] += Math.abs(l(at v) - l(at neighbor1)) + dpl[neighbor1] ,
	 * Math.abs(l(at(v) - r(at neighbor1)) + dpr(neighbor1]
	 * 
	 * And if suppose we assign the same vertex the value r, so in that case, the dp
	 * looks like:
	 * 
	 * dpr[v] += Math.abs(r(at v) - r(at neighbor1)) + dpr[neighbor1] ,
	 * Math.abs(r(at v) - l(at neighbor1)) + dpl(neighbor1]
	 */

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		CustomReader cs = new CustomReader();
		int t = cs.nextInt();
		long[] dpl, dpr;
		int[] l, r;
		// for which vertex is connected to which vertex
		List<Integer>[] adj;
		while (t-- > 0) {
			int n = cs.nextInt();
			l = new int[n];
			r = new int[n];
			adj = new List[n];
			for (int i = 0; i < n; ++i) {
				l[i] = cs.nextInt();
				r[i] = cs.nextInt();
			}
			for (int i = 0; i < n; ++i) {
				adj[i] = new ArrayList<>();
			}
			for (int i = 0; i < n - 1; ++i) {
				int u = cs.nextInt() - 1;
				int v = cs.nextInt() - 1;
				adj[u].add(v);
				adj[v].add(u);
			}
			dpl = new long[n];
			dpr = new long[n];
			dfs(0, -1, adj, dpl, dpr, l, r);
			System.out.println(Math.max(dpl[0], dpr[0]));
		}
	}

	public static void dfs(int u, int p, List<Integer>[] adj, long[] dpl, long[] dpr, int[] l, int[] r) {
		long suml = 0, sumr = 0;
		for (int v : adj[u]) {
			if (v == p) {
				continue;
			}
			dfs(v, u, adj, dpl, dpr, l, r);
			suml += Math.max((long) Math.abs((long) l[u] - (long) l[v]) + dpl[v],
					(long) Math.abs((long) l[u] - (long) r[v]) + dpr[v]);
			sumr += Math.max((long) Math.abs((long) r[u] - (long) l[v]) + dpl[v],
					(long) Math.abs((long) r[u] - (long) r[v]) + dpr[v]);
		}
		dpl[u] = suml;
		dpr[u] = sumr;
	}
}
