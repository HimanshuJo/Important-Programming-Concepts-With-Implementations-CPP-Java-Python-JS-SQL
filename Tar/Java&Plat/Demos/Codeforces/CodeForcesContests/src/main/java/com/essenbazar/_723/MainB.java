package com.essenbazar._723;

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

public class MainB {

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
	 * Funny thing about here is that, if we look at any of the number in which we have at-least
	 * 		4 1's, then we can notice straight away that this number can be formed only using 11's
	 * 			e.g. for 1111
	 * 				I take 11 -> 1 times then 11 -> 100 times
	 * 			
	 * 			e.g. for 11111
	 * 				I can take 111 -> 1 times then 11 -> 1000 times 
	 * 
	 *  	so in essence if any number can be formed using 11, 111, 1111, ... and so on
	 *  		it has to be formed with 11 and 111
	 *  
	 *  	so if I can form a number using only 11 and 111 then YES else NO
	 *  
	 *  	so the equation is like 11a + 111b = x -> have any solutions or not
	 *  
	 *  	To solve this we can just take the mod of the entire equation with 111
	 *  		so (11a) % 111 = x % 111 will be our equation
	 *  			(111b) % 111 = 0, so we won't consider it
	 *  
	 *  		Now we will multiply both sides by the inverse of 11
	 *  				a = x * 11^-1
	 *  			
	 *  		to get the inverse we use couple of standard techniques
	 *  			one other thing we can do is to iterate from 1 till 110 and actually
	 *  				find the multiplicative inverse of 11
	 *  
	 *  		let's suppose a % 111 = k
	 *  			so the actual value of a = 111 * n + k
	 *  			we can ignore 111 * n because we can add that n to b
	 *  			so we can just say that, for the purpose of the question:
	 *  				a % 111 = a (or a is smaller than 111)
	 *  
	 *  		so in essence our equation is:
	 *  			a = (x % 111) * (11^-1 % 111)
	 *  
	 *  			once we have a, we can easily get b
	 *  				b = x - 11a / 111
	 *  			we will find x - 11a and we must confirm that it is >= 0 && divisible by 111
	 *  
	 *  		Sample Code:
	 *  			// need mod_inv to calculate the multiplicative inverse of the number
	 *  			int32_t mod_inv(int32_t a, int32_t m) {
	 *  				int32_t g = m, r = a, x = 0, y = 1;
	 *  				while (r != 0) {
	 *  					int32_t q = g / r;
	 *  					g %= r;
	 *  					swap(g, r);
	 *  					x -= q * y;
	 *  					swap(x, y);
	 *  				}
	 *  				return x < 0 ? x + m : x;	
	 *  			}
	 *  
	 *  			void solve() {
	 *  				int x;
	 *  				cin >> x;
	 *  				int ea = x % 111;  // value of 11a
	 *  				int a = ea * mod_inv(11, 111) % 111;  // finding a using ea 
	 *  				int ooob = x - 11 * a;  // finding 111b
	 *  				if (ooob >= 0 && ooob % 111 == 0) {
	 *  					cout << "YES\n";
	 *  				} else {
	 *  					cout << "NO\n";
	 *  				}	
	 *  			}
	 */

	public static void main(String[] args) {
		CustomReader cs = new CustomReader();
		int t = cs.nextInt();
		while (t-- > 0) {
			int x = cs.nextInt();
			if (x < 11) {
				System.out.println("NO");
			} else {
				int r = x % 11;
				System.out.println("x: " + x);
				System.out.println("r: " + r);
				System.out.println("r * 111: " + r * 111);
				System.out.println("-------");
				if (x >= r * 111) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
}
