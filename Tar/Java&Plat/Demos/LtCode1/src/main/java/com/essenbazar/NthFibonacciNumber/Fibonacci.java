/*

Directory to test few algorithm tasks

 */
package com.essenbazar.NthFibonacciNumber;

/**
 *
 * @author hjoshi
 */
/*
 * Write a function int fib(int n) that returns Fn. For example, if n = 0, then
 * fib() should return 0. If n = 1, then it should return 1. For n > 1, it
 * should return Fn-1 + Fn-2
 * 
 * For n = 9 Output:34
 * 
 * Following are different methods to get the nth Fibonacci number.
 */
public class Fibonacci {

	public double fib(int n) {
		double phi = (1 + Math.sqrt(5)) / 2;
		return (int) Math.round(Math.pow(phi, n) / Math.sqrt(5));
	}

	public static void main(String[] args) {
		Fibonacci my_fib = new Fibonacci();
		System.out.println(my_fib.fib(4));
	}
}

/*
 * Using Dynamic Programming
 */

class FibUsingDp {
	static int fib(int n) {
		int[] f = new int[n + 2];
		f[0] = 0;
		f[1] = 1;
		for (int i = 2; i <= n; ++i) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n];
	}
}