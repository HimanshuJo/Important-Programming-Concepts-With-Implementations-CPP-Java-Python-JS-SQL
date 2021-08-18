package com.essenbazar._713;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*

Let us denote by d(n) the sum of all divisors of the number n, i.e. d(n)=∑k|nk

For example, d(1)=1, d(4)=1+2+4=7, d(6)=1+2+3+6=12

For a given number c, find the minimum n such that d(n)=c.

 */

/*

Note that n <= d(n) <= 10^7

   10^7 is the maximum power in the question

   so it is enough for every n = 1...10^7 to calculate the value of d(n)

   -------

   To calculate the value of d(n) we can use the 'sieve of Erathosthenes' and get the solution
       for O(10^7 log(10^7))

   Also we can use the linear sieve of Erathosthenes to find the minimum divisor for each
       n = 1..10^7 and use the multiplicativity of the function d(n)

           d(a.b)=d(a).d(b) if gcd(a,b)=1

*/

public class MainG {

	// private static final int N = (int) 1e7 + 100;
	private static final int N = 20;

	public static void main(String[] args) throws IOException {
		long[] s = new long[N];
		int[] d = new int[N];
		int[] res = new int[N];
		Arrays.fill(d, -1);

		// filling d
		d[1] = 1;
		for (int i = 2; i * i < N; ++i) {
			if (d[i] == -1) {
				d[i] = i;
			}
			// setting all the multiples of i as their own value
			// standard prime checking procedure
			for (int j = i * i; j < N; j += i) {
				if (d[j] == -1) {
					d[j] = i;
				}
			}
		}
		System.out.println(Arrays.toString(d));
		System.out.println("-------");

		// filling s
		s[1] = 1;
		for (int i = 2; i < N; ++i) {
			if (d[i] == -1) {
				d[i] = i;
				s[i] = i + 1;
			} else {
				int j = i;
				s[i] = 1;
				while (j % d[i] == 0) {
					j /= d[i];
					s[i] = s[i] * d[i] + 1;
				}
				s[i] *= s[j];
			}
		}
		System.out.println(Arrays.toString(s));
		System.out.println("-------");
		Arrays.fill(res, -1);
		for (int i = N - 1; i >= 0; --i) {
			if (s[i] < N) {
				res[(int) s[i]] = i;
			}
		}
		System.out.println(Arrays.toString(res));
		System.out.println("-------");

		// int t = cs.nextInt();
		int t = 1;
		while (t-- > 0) {
			// int c = cs.nextInt();
			int c = 19;
			System.out.println(res[c]);
		}
	}

	static List<Integer> returnDivisors(int n) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i * i < n; i++) {
			if (n % i == 0) {
				list.add(i);
			}
		}
		for (int i = (int) Math.sqrt(n); i >= 1; i--) {
			if (n % i == 0) {
				list.add(n / i);
			}
		}
		return list;
	}

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
}
