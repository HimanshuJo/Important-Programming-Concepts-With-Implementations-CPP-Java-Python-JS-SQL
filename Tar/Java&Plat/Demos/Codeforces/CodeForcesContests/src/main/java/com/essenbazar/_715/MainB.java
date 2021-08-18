package com.essenbazar._715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.*;

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

	public static int[] crInputArray(int n, Scanner sc) {
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		return arr;
	}

	public static List<Integer> crInputList(int n, Scanner sc) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			int temp = sc.nextInt();
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

	/*
	 * 
	 * The student council has a shared document file. Every day, some members of
	 * the student council write the sequence TMT (short for Towa Maji Tenshi) in
	 * it.
	 * 
	 * However, one day, the members somehow entered the sequence into the document
	 * at the same time, creating a jumbled mess.
	 * 
	 * Therefore, it is Suguru Doujima's task to figure out whether the document has
	 * malfunctioned. Specifically, he is given a string of length n whose
	 * characters are all either T or M, and he wants to figure out if it is
	 * possible to partition it into some number of disjoint subsequences, all of
	 * which are equal to TMT.
	 * 
	 * That is, each character of the string should belong to exactly one of the
	 * subsequences.
	 * 
	 * A string a is a subsequence of a string b if a can be obtained from b by
	 * deletion of several (possibly, zero) characters.
	 * 
	 */

	public static void main(String[] args) {
		CustomReader cs = new CustomReader();
		int t = cs.nextInt();
		while (t-- > 0) {
			int n = cs.nextInt();
			String s;
			s = cs.next();
			if (s.equals("TMT")) {
				System.out.println("YES");
				continue;
			} else if (s.length() == 3 && !s.equals("TMT")) {
				System.out.println("NO");
				continue;
			}
			Map<Character, Integer> map = stringCountMap(s);
			int TCount = map.containsKey('T') ? map.get('T') : 0;
			int MCount = map.containsKey('M') ? map.get('M') : 0;
			if ((2 * MCount) != TCount) {
				System.out.println("NO");
			} else {
				int countP = 0;
				int countM = 0;
				boolean flag = false;
				for (int i = 0; i < s.length(); ++i) {
					if (s.charAt(i) == 'M') {
						countM++;
						if (countM > countP) {
							flag = true;
						}
					} else {
						countP++;
					}
				}
				int countM2 = 0;
				int countP2 = 0;
				for (int i = n - 1; i >= 0; --i) {
					if (s.charAt(i) == 'M') {
						countM2++;
						if (countM2 > countP2) {
							flag = true;
						}
					} else {
						countP2++;
					}
				}
				if (flag) {
					System.out.println("NO");
				} else {
					System.out.println("YES");
				}
			}
		}
	}
}
