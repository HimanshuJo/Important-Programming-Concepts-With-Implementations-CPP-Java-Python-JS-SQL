package com.essenbazar._725;

//  Another Problem About Dividing Numbers

/*
 * You are given two integers a and b
 * 
 * In one turn, you can do one of the following operations:

    Take an integer c (c>1 and a should be divisible by c) and replace a with a/c;
    
	Take an integer c (c>1 and b should be divisible by c) and replace b with b/c;

	Your goal is to make a equal to b using exactly k turns.

	For example, the numbers a=36 and b=48 can be made equal in 4 moves:

    	c=6, divide b by c ⇒ a=36, b=8;
		
		c=2, divide a by c ⇒ a=18, b=8;
		
		c=9, divide a by c ⇒ a=2, b=8;
		
		c=4, divide b by c ⇒ a=2, b=2

	For the given numbers a and b, determine whether it is possible to make them equal 
		using exactly k turns.

	Input:

		The first line contains one integer t (1≤t≤104). Then t test cases follow.

	Each test case is contains three integers a, b and k (1≤a,b,k≤109).

	Output:
	
		For each test case output:
		
			"Yes", if it is possible to make the numbers a and b equal in exactly k turns;
    		
    		"No" otherwise. 

		The strings "Yes" and "No" can be output in any case.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class MainD {

	final static int N = 50000;
	static boolean[] isPrime = new boolean[N];
	static List<Integer> primes = new ArrayList<>();

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
					e.printStackTrace();
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
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void fillPrimes() {
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 0; i * i < N; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j < N; j += i) {
					isPrime[j] = false;
				}
			}
		}
		for (int i = 2; i < N - 1; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}
	}

	static int countPrime(int num) {
		int count = 0;
		int i = 0;
		int prime = primes.get(i);
		while (prime * prime <= num) {
			if (num % prime == 0) {
				while (num % prime == 0) {
					count++;
					num /= prime;
				}
			}
			i++;
			if (i < primes.size())
				prime = primes.get(i);
			else
				break;
		}
		if (num != 1)
			count++;
		return count;
	}

	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	/*
	 *  Let's denote for n the maximum number of moves for which the numbers a and b can be
	 *  	made equal.
	 *  
	 *  It is easy to understand that the number of moves is maximum when a = b = 1,
	 *  	and each time we divide a and b by a prime number
	 *  
	 *  That is, n = sum of exponents of prime divisors of a + 
	 *  			 sum of exponents of prime divisors of b
	 *  
     *  -------
     *  
     *  Suppose 'm' is the minimum number of moves for which the numbers a and b can be made
     *  	equal
     *  
     *    Consider few cases:
     *    
     *    		if (a = b), then m = 0
     *    		if (gcd(a, b) = a or gcd(a, b) = b, then m = 1;
     *    		else m = 2
     *    
     *    -------
     *    
     *    Then the answer is "YES" is the following cases:
     *    		1. m <= k <= n and k = 1 and m = 1
     *    		
     *    		2. m <= k <= n and k != 1		
	 */
	
	public static void main(String[] args) {
		CustomReader cs = new CustomReader();
		fillPrimes();
		int t = cs.nextInt();
		while (t-- > 0) {
			int a = cs.nextInt();
			int b = cs.nextInt();
			int k = cs.nextInt();
			int primeA = countPrime(a);
			int primeB = countPrime(b);
			int max = primeA + primeB;
			int min = 2;
			int gcd = gcd(a, b);
			if (gcd == a || gcd == b) {
				min = 1;
			}
			if (a == b) {
				min = 0;
			}
			if (k == 1) {
				if (min == 1) {
					out.println("YES");
				} else {
					out.println("NO");
				}
			} else if (k >= min && k <= max) {
				out.println("YES");
			} else {
				out.println("NO");
			}
		}
		out.flush();
	}
}
