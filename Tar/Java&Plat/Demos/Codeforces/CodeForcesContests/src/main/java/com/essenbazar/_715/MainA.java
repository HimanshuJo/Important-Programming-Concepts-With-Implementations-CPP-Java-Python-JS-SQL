package com.essenbazar._715;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MainA {

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

	/*
	 *
	 * Sayaka Saeki is a member of the student council, which has n other members
	 * (excluding Sayaka). The i-th member has a height of ai millimeters.
	 *
	 * It's the end of the school year and Sayaka wants to take a picture of all
	 * other members of the student council.
	 *
	 * Being the hard-working and perfectionist girl as she is, she wants to arrange
	 * all the members in a line such that the amount of photogenic consecutive
	 * pairs of members is as large as possible.
	 *
	 * A pair of two consecutive members u and v on a line is considered photogenic
	 * if their average height is an integer, i.e. (au+av) / 2 is an integer.
	 *
	 * Help Sayaka arrange the other members to maximize the number of photogenic
	 * consecutive pairs.
	 *
	 * Input
	 *
	 * The first line contains a single integer t(1≤t≤500) — the number of test
	 * cases.
	 *
	 * The first line of each test case contains a single integer n(2≤n≤2000) — the
	 * number of other council members.
	 *
	 * The second line of each test case contains n integers a1, a2, ..., an
	 * (1≤ai≤2⋅10^5) — the heights of each of the other members in millimeters.
	 *
	 * It is guaranteed that the sum of n over all test cases does not exceed 2000
	 *
	 * Output
	 *
	 * For each test case, output on one line n integers representing the heights of
	 * the other members in the order, which gives the largest number of photogenic
	 * consecutive pairs.
	 *
	 * If there are multiple such orders, output any of them.
	 *
	 * Example Input
	 *
	 * 4 3 1 1 2 3 1 1 1 8 10 9 13 15 3 16 9 13 2 18 9
	 *
	 * Output
	 *
	 * 1 1 2 1 1 1 13 9 13 15 3 9 16 10 9 18
	 *
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		while (t-- > 0) {
			int n;
			n = sc.nextInt();
			List<Integer> list = crInputList(n, sc);
			for (int i = 0; i < list.size(); ++i) {
				if (list.get(i) % 2 == 1) {
					System.out.println(list.get(i));
				}
			}
			for (int i = 0; i < list.size(); ++i) {
				if (list.get(i) % 2 == 1) {
				} else
					System.out.println(list.get(i));
			}
		}
	}
}

/*
 *
 * Understanding count pairs in array whose sum is divisible by k
 *
 * public static int countKdivPairs(int A[], int n, int K) {
 *
 * // creating a frequency array to count occurrences of all the remainders when
 * // divided by K int freq[] = new int[K];
 *
 * // count occurrences of all the remainders // how many are such numbers that
 * are getting the same remainder when divided by 2 for (int i = 0; i < n; ++i)
 * { ++freq[A[i] % k]; }
 *
 * // if in a pair both the pairs are divisibly by 'K' e.g. (let a pair be (4,
 * 4) and k be 2) int count = freq[0] * (freq[0] - 1) / 2; // basically apply
 * operations on the zeroth index of freq
 *
 * // count for all i and (k - i) // freq pairs for (int i = 1; i <= k / 2 && i
 * != (k - i); ++i) { count += freq[i] * freq[K - i]; }
 *
 * if (K % 2 == 0) { count += freq[K / 2] * (freq[K / 2] - 1) / 2); }
 *
 * return sum; }
 *
 */
