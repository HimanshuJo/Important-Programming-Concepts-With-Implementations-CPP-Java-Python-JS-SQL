package com.essenbazar._01;

/*

Theatre Square in the capital city of Berland has a rectangular shape with the size n × m meters. 

On the occasion of the city's anniversary, a decision was taken to pave the Square with square 
    granite flagstones. Each flagstone is of the size a × a.

What is the least number of flagstones needed to pave the Square? It's allowed to cover 
    the surface larger than the Theatre Square, but the Square has to be covered. 

It's not allowed to break the flagstones. 

The sides of flagstones should be parallel to the sides of the Square.

Input

The input contains three positive integer numbers in the first line: n,  m and a (1 ≤  n, m, a ≤ 109).

Output

Write the needed number of flagstones.

Examples

Input

6 6 4

Output

4

 */

import java.util.Scanner;

public class MainA {

	static long closestMultiple(long n, long x) {
		long remain = n % x;
		if (remain == 0) {
			return n;
		}
		return n + x - remain;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			long n, m, a;
			n = sc.nextLong();
			m = sc.nextLong();
			a = sc.nextLong();
			long newN = 0;
			long newM = 0;
			long total = 0;
			if (n % a != 0) {
				newN = closestMultiple(n, a);
			}
			if (m % a != 0) {
				newM = closestMultiple(m, a);
			}
			if (n % a != 0 && m % a == 0) {
				total = newN * m;
			} else if (n % a == 0 && m % a != 0) {
				total = n * newM;
			} else if (n % a != 0 && m % a != 0) {
				total = newN * newM;
			} else {
				total = n * m;
			}
			System.out.println(total / (a * a));
		}
	}
}
