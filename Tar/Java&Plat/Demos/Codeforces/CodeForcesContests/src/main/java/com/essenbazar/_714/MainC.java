package com.essenbazar._714;

/*
 * You are given an integer n. You have to apply m operations to it.

In a single operation, you must replace every digit d
of the number with the decimal representation of integer d+1.

For example, 1912 becomes 21023 after applying the operation once.

You have to find the length of n after applying m operations.
Since the answer can be very large, print it modulo 109+7.

Example
Input

5
1912 1
5 6
999 1
88 2
12 100

Output

5
2
6
4
2115

Note

For the first test, 1912
becomes 21023 after 1 operation which is of length 5

For the second test, 5
becomes 21 after 6 operations which is of length 2

For the third test, 999
becomes 101010 after 1 operation which is of length 6

For the fourth test, 88
becomes 1010 after 2 operations which is of length 4.
 */
/*
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class MainC {

	private static final int MOD = (int) 1e9 + 7;

	public static boolean numInArrayBinarySearch(int[] arr, int targetValue) {
		int a = Arrays.binarySearch(arr, targetValue);
		return a > 0;
	}

	public static long modExp(long a, long b) {
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

	/*
	 * About the question: We have in essence a number n and we have to perform m
	 * operations in that number
	 * 
	 * After the operations we need to identify what is the length of n
	 * 
	 * Key points to note is that: m has a value in the range 1 to 2*10^5
	 * 
	 * At the end we essentially have to apply the brute force, but have to
	 * converted that to dp
	 * 
	 * How to perform that: Suppose we have a number, and in that we have a lot of
	 * digits, and every digit will lie in the range from 0 to 9
	 * 
	 * and in each of the digit we will perform 'm' operations
	 * 
	 * It is not necessary to apply m operations individually in each of the digits
	 * 
	 * -------
	 * 
	 * How to apply memoization here: Suppose we have a 2D array, in this array we
	 * have to store for each digit after x operations what will be the length of
	 * that digit
	 * 
	 * e.g. suppose a is that number so for 'a' we will store in that array what is
	 * the length of a after 1 operations after 2 operations after 3 operations
	 * 
	 * after 2*10^5 operations
	 * 
	 * -------
	 * 
	 * Next after creating such an array, we will start traversing each digit in the
	 * num array, we will reach to our dp array and access what is a after m
	 * operations
	 * 
	 * -------
	 * 
	 * While implementing we have to create two arrays let's suppose we have 'a' and
	 * 'b' we will fill the array a with 0
	 * 
	 * a[0] = 1
	 * 
	 * Arrays 'a' is of length 10, have indices from 0 to 9 Each index of array a
	 * will store, how many such digits are there in our number e.g. for 0 how many
	 * 0's are there in the array for 1 how many 1's are there in the array etc.
	 * 
	 * So this array will change after each operations
	 * 
	 * -------
	 * 
	 * b array will store let's say after x + 1'th operation what is the value of
	 * array a
	 * 
	 * So that means Array a is storing, at the current moment what is the frequency
	 * of each digit in the array
	 * 
	 * Array b will store, what will be the frequency of each digit in the next
	 * step,
	 * 
	 * From then on we already have a cycle for the next digit
	 * 
	 * -------
	 * 
	 * Sample code:
	 * 
	 * #include<iostream> using namespace std; typedef long long ll; ll t, n, k, z,
	 * m; ll a[10]; ll b[10]; ll ans[200017] int main() {
	 * ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0); n = 0; m = 200000;
	 * fill(a, a + 10, 0); ll s = 0; a[0] = 1; // j is running until 10^5 + 10 //
	 * suppose we want to find at a digit 5, after m operations what would have
	 * happen // our ans array will work in the jth index and at the beginning j ==
	 * 0 // then j become 1, then 2 and so on then finally 5 // and when we are
	 * doing ans[j] it will return // at 0 after j operations what is the length,
	 * but we want to find out for digit 5 // so for 5, the resultant length after m
	 * operations will be way ahead as compared to 0 // so we have to come first 5
	 * steps, then we have to add m (to get after m operations) // therefore our
	 * loop will run 10 steps more, because we are simulating values not just for 0,
	 * but // for all the values from 0 till 9, because we have to perform m
	 * operations at 0, at 1, at 2... till 9 for (int j = 0; j < m + 10; ++j) { s =
	 * 0; b[0] = a[9] % MOD; // 9 is the special case, as 9 will make 1 as well as 0
	 * b[1] = a[9] % MOD + a[0] % MOD; b[2] = a[1] % MOD; // for example here all
	 * the 1's will be converted to 2 b[3] = a[2] % MOD; b[4] = a[3] % MOD; b[5] =
	 * a[4] % MOD; b[6] = a[5] % MOD; b[7] = a[6] % MOD; b[8] = a[7] % MOD; b[9] =
	 * a[8] % MOD; for (int l = 0; l < 10; ++l) { // a[l] = b[l] means we have
	 * conducted one operation a[l] = b[l]; // the new length of array a will be
	 * added to s s += a[l]; } // ans[j] means here after j operations what will be
	 * stored in the place of 0 ans[j] = s % MOD; } cin >> t; for (int i = 0; i < t;
	 * ++i) { cin >> n >> m; ll res = 0; while (n > 0) { // we will extract all the
	 * digits of n, how can we actually do that // by first taking the mod to get
	 * the last digit // why is the need of doing ans[m + n % 10 - 1] // if we will
	 * do just ans[m], then it will be just performing m operations just on 0 // but
	 * we want m operations on n % 10 // for that we have to do m + n % 10 - 1 //
	 * the above expression will result what is the value of n after performing m
	 * operations res += ans[m + n % 10 - 1]; // then we will divide n by 10 to
	 * delete the last digit n /= 10; } cout << res % MOD; } }
	 */

	public static void main(String[] args) {
		CustomReader cs = new CustomReader();
		int t = cs.nextInt();
		int[][] counts = new int[10][200_001];
		for (int i = 0; i < 10; ++i) {
			counts[i] = sim(i, 2_000_01);
		}
		while (t-- > 0) {
			int n = cs.nextInt();
			int steps = cs.nextInt();
			long ans = 0;
			for (char c : (n + "").toCharArray()) {
				ans += counts[c - '0'][steps];
			}
			out.println(ans % MOD);
		}
		out.close();
	}

	static int[] sim(int start, int steps) {
		int[] counts = new int[10];
		counts[start]++;
		int[] ans = new int[steps];
		ans[0] = 1;
		int sum = 1;
		int[] newCounts = new int[10];
		for (int step = 1; step < steps; ++step) {
			Arrays.fill(newCounts, 0);
			for (int i = 0; i < 9; ++i) {
				newCounts[i + 1] = counts[i];
			}
			newCounts[0] = counts[9];
			newCounts[1] = add(newCounts[1], counts[9]);
			sum = add(sum, counts[9]);
			int[] temp = counts;
			counts = newCounts;
			newCounts = temp;
			ans[step] = sum;
		}
		return ans;
	}

	static int add(int a, int b) {
		if (a + b >= MOD) {
			return a + b - MOD;
		}
		return a + b;
	}
}