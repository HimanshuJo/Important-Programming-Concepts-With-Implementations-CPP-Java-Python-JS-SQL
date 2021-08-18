package com.essenbazar._711;

/*

The gcdSum of a positive integer is the gcd of that integer with its sum of digits. 

Formally, gcdSum(x)=gcd(x, sum of digits of x) for a positive integer x. gcd(a,b) denotes the 
greatest common divisor of a and b — the largest integer d such that both integers a and b are divisible by d.

For example: gcdSum(762)=gcd(762,7+6+2)=gcd(762,15)=3

Given an integer n, find the smallest integer x≥n such that gcdSum(x)>1

Input

The first line of input contains one integer t
(1≤t≤104)

— the number of test cases.

Then t lines follow, each containing a single integer n (1≤n≤1018).

All test cases in one test are different.
Output

Output t lines, where the i-th line is a single integer containing the answer to the i-th test case.

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.BigInteger;

public class MainA {

	static long gcd(long a, long b) {
		// Everything divides 0
		if (a == 0) {
			return b;
		}
		if (b == 0) {
			return a;
		}

		// base case
		if (a == b) {
			return a;
		}

		// a is greater
		if (a > b) {
			return gcd(a - b, b);
		}
		return gcd(a, b - a);
	}

	private static long calSum(long n) {
		List<Long> list = new ArrayList<>();
		while (n > 0) {
			list.add(n % 10);
			n = n / 10;
		}
		long res = 0;
		for (long num : list) {
			res += num;
		}
		return res;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t;
			t = sc.nextInt();
			long result = 0;
			while (t-- > 0) {
				long n;
				n = sc.nextLong();
				while (true) {
					long val1 = calSum(n);
					String temp__ = String.valueOf(val1);
					String temp___ = String.valueOf(n);
					BigInteger big2 = new BigInteger(temp__);
					BigInteger big1 = new BigInteger(temp___);
					BigInteger bigVal = big1.gcd(big2);
					Integer i1;
					i1 = bigVal.intValue();
					if (i1 > 1) {
						result = n;
						break;
					} else {
						n++;
					}
				}
				System.out.println(result);
			}
		}
	}
}
