package com.essenbazar._716;

import java.io.BufferedReader;
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

/*

Baby Badawy's first words were "AND 0 SUM BIG", so he decided to solve the following problem. 
Given two integers n and k, count the number of arrays of length n such that:
    all its elements are integers between 0 and 2k−1 (inclusive); the bitwise AND of all its elements is 0

the sum of its elements is as large as possible. 

Since the answer can be very large, print its remainder when divided by 109+7

Input

    The first line contains an integer t (1≤t≤10) — the number of test cases you need to solve.

    Each test case consists of a line containing two integers n and k (1≤n≤105, 1≤k≤20).

Output

    For each test case, print the number of arrays satisfying the conditions. 
    Since the answer can be very large, print its remainder when divided by 109+7

Example
Input

2
2 2
100000 20

Output

4
226732710

 */

public class MainB {

	private static final int MOD = (int) 1e9 + 7;

	public static void main(String[] args) {
		CustomReader cs = new CustomReader();
		int t = cs.nextInt();
		while (t-- > 0) {
			long n = cs.nextInt();
			long k = cs.nextInt();
			long res = modExp(n, k);
			System.out.println(res);
		}
	}

	private static long modExp(long a, long b) {
		if (b == 0) {
			return 1;
		}
		a %= MOD;
		long exp = modExp(a, b / 2);
		if (b % 2 == 0) {
			return (exp * exp) % MOD;
		} else {
			return (a * ((exp * exp) % MOD)) % MOD;
		}
	}

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

	public static int[] crInputArray(int n, CustomReader cs) {
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = cs.nextInt();
		}
		return arr;
	}

	public static long[] crInputLongArray(int n, CustomReader cs) {
		long[] arr = new long[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = cs.nextLong();
		}
		return arr;
	}

	public static List<Integer> crInputList(int n, CustomReader cs) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			int temp = cs.nextInt();
			list.add(temp);
		}
		return list;
	}

	public static List<Long> crInputLongList(int n, CustomReader cs) {
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

	static long factorial(long a) {
		if (a == 0L || a == 1L) {
			return 1L;
		}
		return a * factorial(a - 1L);
	}

	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	public static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	public static int lcm(int a, int b) {
		int gc = gcd(a, b);
		return (a / gc) * b;
	}

	public static long lcm(long a, long b) {
		long gc = gcd(a, b);
		return (a / gc) * b;
	}

	public static int lcm(int a, int b, int c, int d) {
		int temp = lcm(a, b, c);
		int ans = lcm(temp, d);
		return ans;
	}

	public static int lcm(int a, int b, int c) {
		int temp = lcm(a, b);
		int ans = lcm(temp, c);
		return ans;
	}

	static boolean isPrime(long n) {
		if (n == 1) {
			return false;
		}
		boolean ans = true;
		for (long i = 2L; i * i <= n; i++) {
			if (n % i == 0) {
				ans = false;
				break;
			}
		}
		return ans;
	}

	static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		boolean ans = true;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				ans = false;
				break;
			}
		}
		return ans;
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

	static boolean isPerfectSquare(int n) {
		for (int i = 1; i * i <= n; i++) {
			if ((n % i == 0) && (n / i == i)) {
				return true;
			}
		}
		return false;
	}
}
