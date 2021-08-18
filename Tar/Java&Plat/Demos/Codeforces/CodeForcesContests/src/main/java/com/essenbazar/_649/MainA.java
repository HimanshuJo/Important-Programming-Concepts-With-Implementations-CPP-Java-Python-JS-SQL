package com.essenbazar._649;

import java.util.Scanner;

/*
 * 
 * Ehab loves number theory, but for some reason he hates the number x. Given an
 * array a, find the length of its longest subarray such that the sum of its
 * elements isn't divisible by x or determine that such subarray doesn't exist.
 * 
 * An array a is a subarray of an array b if a can be obtained from b by
 * deletion of several (possibly, zero or all) elements from the beginning and
 * several (possibly, zero or all) elements from the end.
 * 
 * Input
 * 
 * The first line contains an integer t(1≤t≤5)
 * 
 * — the number of test cases you need to solve. The description of the test
 * cases follows.
 * 
 * The first line of each test case contains 2 integers n and x (1≤n≤105,
 * 1≤x≤104) — the number of elements in the array a and the number that Ehab
 * hates.
 * 
 * The second line contains n space-separated integers a1, a2, …, an (0≤ai≤104)
 * — the elements of the array a
 * 
 * Output
 * 
 * For each testcase, print the length of the longest subarray whose sum isn't
 * divisible by x If there's no such subarray, print −1
 * 
 * Example Input
 * 
 * 3 3 3 1 2 3 3 4 1 2 3 2 2 0 6
 * 
 * Output
 * 
 * 2 3 -1
 * 
 */

public class MainA {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t;
			t = sc.nextInt();
			while (t-- > 0) {
				int n, x;
				n = sc.nextInt();
				x = sc.nextInt();
				int[] arr = new int[n];
				long sum = 0;
				boolean flag = false;
				int left = -1, right = -1;
				for (int i = 0; i < n; ++i) {
					arr[i] = sc.nextInt();
					sum += arr[i];
					if (arr[i] % x != 0) {
						flag = true;
						if (left == -1) {
							left = i;
						}
						right = i;
					}
				}
				if (!flag) {
					System.out.println(-1);
				} else if (sum % x != 0) {
					System.out.println(n);
				} else {
					System.out.println(n - Math.min(left + 1, n - right));
				}
			}
		}
	}
}
