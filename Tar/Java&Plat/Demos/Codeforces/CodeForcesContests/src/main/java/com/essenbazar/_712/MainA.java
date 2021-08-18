package com.essenbazar._712;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class MainA {

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
		char a = 'a';
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

	public static boolean isPalindrome(String s) {
		StringBuilder temp = new StringBuilder(s);
		StringBuilder temp2 = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; --i) {
			temp2.append(s.charAt(i));
		}
		return temp.toString().equals(temp2.toString());
	}

	static PrintWriter out;

	static class CustomReader1 {

		BufferedReader br;
		StringTokenizer st;

		public CustomReader1() {
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

	public static void main(String[] args) throws IOException {
		CustomReader1 cs = new CustomReader1();
		int t = cs.nextInt();
		while (t-- > 0) {
			String s = cs.nextLine();
			StringBuilder sbf = new StringBuilder(s);
			boolean flag = countSameStrB(sbf);
			if (flag) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
				String temp = "a" + s;
				if (isPalindrome(temp)) {
					System.out.println(s + "a");
				} else {
					System.out.println(temp);
				}
			}
		}
	}
}
