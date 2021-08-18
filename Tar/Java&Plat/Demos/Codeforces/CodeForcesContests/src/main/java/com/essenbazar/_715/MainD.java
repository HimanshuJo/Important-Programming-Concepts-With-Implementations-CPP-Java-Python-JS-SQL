package com.essenbazar._715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.*;

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

	public static long[] crInputLongArray(int n, Scanner sc) {
		long[] arr = new long[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = sc.nextLong();
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

	public static List<Long> crInputLongList(int n, Scanner sc) {
		List<Long> list = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			long temp = sc.nextInt();
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

	/*
	 * 
	 * A bitstring is a string that contains only the characters 0 and 1.
	 * 
	 * Koyomi Kanou is working hard towards her dream of becoming a writer. To
	 * practice, she decided to participate in the Binary Novel Writing Contest.
	 * 
	 * The writing prompt for the contest consists of three bitstrings of length 2n
	 * 
	 * A valid novel for the contest is a bitstring of length at most 3n that
	 * contains at least two of the three given strings as subsequences.
	 * 
	 * Koyomi has just received the three prompt strings from the contest
	 * organizers. Help her write a valid novel for the contest.
	 * 
	 * A string a is a subsequence of a string b if a can be obtained from b by
	 * deletion of several (possibly, zero) characters.
	 * 
	 * -------
	 * 
	 * Hints:
	 * 
	 * Hint 1:
	 * 
	 * Consider two of the strings
	 * 
	 * We can obviously achieve our goals using at most 4n characters
	 * 
	 * How can we save some of them?
	 * 
	 * We can take advantage of any common subsequence in our two strings by
	 * including the characters in it only once
	 * 
	 * -------
	 * 
	 * Hint 2:
	 * 
	 * For a long common subsequence that has a simple structure, we have to involve
	 * the third string as well
	 * 
	 * -------
	 * 
	 * Hint 3:
	 * 
	 * Either 00...0 or 11...1 is a subsequence of each string
	 * 
	 * -------
	 * 
	 * Algo 1:
	 * 
	 * Let's focus on two substrings s and t
	 * 
	 * How can we get a short string that has them both as a subsequences
	 * 
	 * Well suppose both the strings have a common subsequence of length L
	 * 
	 * Then we can include this subsequence as a part of our string
	 * 
	 * Then we can just place the remaining characters of both the sequences in the
	 * correct positions between the characters of this common sequence to make both
	 * the strings a subsequence of the result
	 * 
	 * This saves us L characters compared to just concatenating s and t since the
	 * characters of the common subsequence only have to be included once
	 * 
	 * this uses |s| + |t| - L characters
	 * 
	 * -------
	 * 
	 * Now in our problem all our strings have a length of 2n
	 * 
	 * so this algorithm will use a total of 4n - L characters
	 * 
	 * This means if we can find two strings that have a common subsequence of
	 * length n we can finish the problem
	 * 
	 * However the usual algorithm for computing the longest common subsequence
	 * works in O(n)^2 which is unlikely to pass the time limit
	 * 
	 * Therefore it is necessary to construct the LCS more concretely
	 * 
	 * -------
	 * 
	 * The observation is that because each character is either 0 or 1, one of these
	 * characters must appear at least n times
	 * 
	 * Call such a character frequent
	 * 
	 * Now since each string has at least one frequent character, two of these
	 * frequent characters are equal
	 * 
	 * Considering these two strings and their frequent character we find a common
	 * sequence of length n equal to either 000...0 or 111...1
	 * 
	 */

	public static void main(String[] args) {
		CustomReader cs = new CustomReader();
		int t = cs.nextInt();
		while (t-- > 0) {
		}
	}
}
