package com.essenbazar._715;

import java.util.Scanner;
import java.util.*;

public class MainC {

	static int MAX = 2000;

	static long[][] mem = new long[MAX][MAX];
	static long[] a = new long[MAX];

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
	 * The student council is preparing for the relay race at the sports festival.
	 * 
	 * The council consists of n members. They will run one after the other in the
	 * race, the speed of member i is si.
	 * 
	 * The discrepancy di of the i-th stage is the difference between the maximum
	 * and the minimum running speed among the first i members who ran
	 * 
	 * Formally, if ai denotes the speed of the i-th member who participated in the
	 * race, then di=max(a1,a2,…,ai) − min(a1,a2,…,ai).
	 * 
	 * You want to minimize the sum of the discrepancies d1+d2+⋯+dn.
	 * 
	 * To do this, you are allowed to change the order in which the members run.
	 * 
	 * What is the minimum possible sum that can be achieved?
	 * 
	 */
	/*
	 * 
	 * Discrepancy of the last stage How can we make it smaller?
	 * 
	 * The discrepancy of the last stage is always the difference between the
	 * largest and the smallest ai
	 * 
	 * We can make it smaller in the previous stages by placing the smallest or the
	 * largest ai at the end
	 * 
	 * -------
	 * 
	 * Assume that the array of speeds is sorted i.e s1 <= s2 <= s3 ... <= sn
	 * 
	 * The key observation is that the last running can be assumed to be either s1
	 * or sn
	 * 
	 * This is because of s1 and sn are both in the prefix of length i, then clearly
	 * di = sn - s1 (max element - min element)
	 * 
	 * which is the maximum possible value of any discrepancy
	 * 
	 * Similary di+1, di+2, ... dn are all equal to sn - s1
	 * 
	 * This moving either s1 or sn (whichever appears last) to the very end of the
	 * array cannot possibly increase the sum of these discrepancies, since they
	 * already have the largest possible value
	 * 
	 * If we repeat the previous observation, we can deduce that for each i, the
	 * prefix of length i in an optimal solution forms a contiguous subarray of the
	 * sorted array
	 * 
	 * Therefore we may solve the problem through dp (dp(l, r)) represents the
	 * minimum possible answer if we solve for the sub-array s[l...r]
	 * 
	 * clearly dp(x, x) = 0
	 * 
	 * The transition is given by:
	 * 
	 * dp(l, r) = sr - sl + min(dp(l + 1, r), dp(l, r-1))
	 * 
	 * Which basically corresponds to placing either the smallest or the largest
	 * element at the end of the sequence
	 * 
	 * -------
	 * 
	 * The final answer is dp(l, r), allows us to solve the problem in O(n^2)
	 * 
	 */
	private static long dp(int l, int r) {
		if (mem[l][r] != -1) {
			for (int i = 0; i < mem.length;) {
				// System.out.println("mem array " + Arrays.toString(mem[l]));
				// System.out.println("-------");
				return mem[l][r];
			}
		}
		if (l == r) {
			return 0;
		}

		return mem[l][r] = a[r] - a[l] + Math.min(dp(l + 1, r), dp(l, r - 1));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = crInputLongArray(n, sc);
		Arrays.sort(a);
		for (int i = 0; i < mem.length; ++i) {
			for (int j = 0; j < mem[i].length; ++j) {
				mem[i][j] = -1;
			}
		}
		System.out.println(dp(0, n - 1));
	}
}
