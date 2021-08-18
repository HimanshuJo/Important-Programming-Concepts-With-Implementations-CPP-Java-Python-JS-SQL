package com.essenbazar.algoSet1;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	static long factorialLong(long a) {
		if (a == 0L || a == 1L) {
			return 1L;
		}
		return a * factorialLong(a - 1L);
	}

	public static int gcdInt(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcdInt(b, a % b);
		}
	}

	public static long gcdLong(long a, long b) {
		if (b == 0) {
			return a;
		} else {
			return gcdLong(b, a % b);
		}
	}

	public static int lcmInt(int a, int b) {
		int gc = gcd(a, b);
		return (a / gc) * b;
	}

	public static long lcmLong(long a, long b) {
		long gc = gcd(a, b);
		return (a / gc) * b;
	}

	public static int lcmMultipleInt(int a, int b, int c, int d) {
		int temp = lcm(a, b, c);
		int ans = lcm(temp, d);
		return ans;
	}

	public static int lcmThreeInt(int a, int b, int c) {
		int temp = lcm(a, b);
		int ans = lcm(temp, c);
		return ans;
	}

	static boolean isPrimeLong(long n) {
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

	static boolean isPrimeInt(int n) {
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

	public static int countLongDigits(long n) {
		return (int) Math.floor(Math.log10(n) + 1);
	}

	public static int sumOfLongDigits(long n) {
		if (n < 0) {
			return -1;
		}
		int sum = 0;
		while (n > 0) {
			sum = sum + (int) (n % 10);

			n /= 10;
		}
		return sum;
	}

	public static long arraySum(int[] arr, int start, int end) {
		long ans = 0;
		for (int i = start; i <= end; i++) {
			ans += arr[i];
		}
		return ans;
	}

	public static void swapArray(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	static long factorial(long a) {
		if (a == 0L || a == 1L) {
			return 1L;
		}
		return a * factorial(a - 1L);
	}

	public static boolean isPowerOfTwo(long n) {
		if (n == 0) {
			return false;
		}
		return ((n) & (n - 1)) == 0;
	}

	public static String reverse(String input) {
		StringBuilder str = new StringBuilder("");
		for (int i = input.length() - 1; i >= 0; i--) {
			str.append(input.charAt(i));
		}
		return str.toString();
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

	public static long countSubarraysSumToK(long[] arr, long sum) {
		HashMap<Long, Long> map = new HashMap<>();
		int n = arr.length;
		long prefixsum = 0;
		long count = 0L;
		for (int i = 0; i < n; i++) {
			prefixsum = prefixsum + arr[i];
			if (sum == prefixsum) {
				count = count + 1;
			}
			if (map.containsKey(prefixsum - sum)) {
				count = count + map.get(prefixsum - sum);
			}
			if (map.containsKey(prefixsum)) {
				map.put(prefixsum, map.get(prefixsum) + 1);
			} else {
				map.put(prefixsum, 1L);
			}
		}
		return count;
	}

	// KMP ALGORITHM : TIME COMPLEXITY:O(N+M)
	// FINDS THE OCCURENCES OF PATTERN AS A SUBSTRING IN STRING
	// RETURN THE ARRAYLIST OF INDEXES
	// IF SIZE OF LIST IS ZERO MEANS PATTERN IS NOT PRESENT IN STRING
	public static ArrayList<Integer> kmpAlgorithm(String str, String pat) {
		ArrayList<Integer> list = new ArrayList<>();
		int n = str.length();
		int m = pat.length();
		String q = pat + "#" + str;
		int[] lps = new int[n + m + 1];
		longestPefixSuffix(lps, q, (n + m + 1));
		for (int i = m + 1; i < (n + m + 1); i++) {
			if (lps[i] == m) {
				list.add(i - 2 * m);
			}
		}
		return list;
	}

	public static void longestPefixSuffix(int[] lps, String str, int n) {
		lps[0] = 0;
		for (int i = 1; i <= n - 1; i++) {
			int l = lps[i - 1];
			while (l > 0 && str.charAt(i) != str.charAt(l)) {
				l = lps[l - 1];
			}
			if (str.charAt(i) == str.charAt(l)) {
				l++;
			}
			lps[i] = l;
		}
	}

	public static long nCr(int n, int k) {
		long ans = 1L;
		k = k > n - k ? n - k : k;
		int j = 1;
		for (; j <= k; j++, n--) {
			if (n % j == 0) {
				ans *= n / j;
			} else if (ans % j == 0) {
				ans = ans / j * n;
			} else {
				ans = (ans * n) / j;
			}
		}
		return ans;
	}

	public static ArrayList<Integer> allFactors(int n) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				if (i * i == n) {
					list.add(i);
				} else {
					list.add(i);
					list.add(n / i);
				}
			}
		}
		return list;
	}

	public static ArrayList<Long> allFactors(long n) {
		ArrayList<Long> list = new ArrayList<>();
		for (long i = 1L; i * i <= n; i++) {
			if (n % i == 0) {
				if (i * i == n) {
					list.add(i);
				} else {
					list.add(i);
					list.add(n / i);
				}
			}
		}
		return list;
	}

	// Max sum of any subarray in given array
	public static long kadanesAlgorithm(long[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		long[] dp = new long[arr.length];
		dp[0] = arr[0];
		long max = dp[0];
		for (int i = 1; i < arr.length; i++) {
			if (dp[i - 1] > 0) {
				dp[i] = dp[i - 1] + arr[i];
			} else {
				dp[i] = arr[i];
			}
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		return max;
	}

	public static long kadanesAlgorithm(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		long[] dp = new long[arr.length];
		dp[0] = arr[0];
		long max = dp[0];
		for (int i = 1; i < arr.length; i++) {
			if (dp[i - 1] > 0) {
				dp[i] = dp[i - 1] + arr[i];
			} else {
				dp[i] = arr[i];
			}
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		return max;
	}

	public static long lowerBound(long[] arr, long k) {
		long ans = -1;
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] <= k) {
				ans = arr[mid];
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return ans;
	}

	public static int lowerBound(int[] arr, int k) {
		int ans = -1;
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] <= k) {
				ans = arr[mid];
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return ans;
	}

	public static long upperBound(long[] arr, long k) {
		long ans = -1;
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] >= k) {
				ans = arr[mid];
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return ans;
	}

	public static int upperBound(int[] arr, int k) {
		int ans = -1;
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] >= k) {
				ans = arr[mid];
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		long a1 = 6L;
		long a2 = 9L;
		System.out.println(gcd(a1, a2));
	}
}
