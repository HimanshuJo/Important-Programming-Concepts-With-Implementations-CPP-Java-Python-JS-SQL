package com.essenbazar._710;

import java.util.Scanner;

/*
 * 
 * You are given a number k and a string s of length n , consisting of the
 * characters '.' and '*'.
 * 
 * You want to replace some of the '*' characters with 'x' characters so that
 * the following conditions are met:
 * 
 * The first character '*' in the original string should be replaced with 'x';
 * The last character '*' in the original string should be replaced with 'x';
 * The distance between two neighboring replaced characters 'x' must not exceed
 * k
 * 
 * (more formally, if you replaced characters at positions i and j (i<j) and at
 * positions [i+1,j−1] there is no "x" symbol, then j−i must be no more than k).
 * 
 * For example, if n=7, s=.**.*** and k=3, then the following strings will
 * satisfy the conditions above:
 * 
 * .xx.*xx; .x*.x*x; .xx.xxx.
 * 
 * But, for example, the following strings will not meet the conditions:
 * 
 * .**.*xx (the first character '*' should be replaced with 'x'); .x*.xx* (the
 * last character '*' should be replaced with 'x'); .x*.*xx (the distance
 * between characters at positions 2 and 6 is greater than k=3).
 * 
 * Given n, k, and s, find the minimum number of '*' characters that must be
 * replaced with 'x' in order to meet the above conditions.
 * 
 * Input
 * 
 * The first line contains one integer t (1≤t≤500). Then t test cases follow.
 * 
 * The first line of each test case contains two integers n and k (1≤k≤n≤50).
 * 
 * The second line of each test case contains a string s of length n, consisting
 * of the characters '.' and '*'.
 * 
 * It is guaranteed that there is at least one '*' in the string s.
 * 
 * It is guaranteed that the distance between any two neighboring '*' characters
 * does not exceed k
 * 
 * Output
 * 
 * For each test case output the minimum number of '*' characters that must be
 * replaced with 'x' characters in order to satisfy the conditions above.
 * 
 * Example
 * 
 * Input
 * 
 * 5 7 3 .**.*** 5 1 ..*.. 5 2 .*.* 3 2 .* 1 1
 *
 * 
 * Output
 * 
 * 3 1 3 2 1
 * 
 * 
 */

/*
 * 
 * Algo:
 * 
 * As the constraint as too small, brute force can be applied comfortably
 * 
 * In essence I just have to find out the first star, the last star, and also
 * the middle position
 * 
 * -------
 * 
 * Iterate from left to right, and check where is the first star, and change it
 * to x increment the counter
 * 
 * Iterate from right to left, and check where is the first star from back, and
 * change it to x increment the counter
 * 
 * Again iterate from left to right, find out the first x as there will always
 * be first x, as we have converted it in the first iteration
 * 
 * Now here we have to insure that
 * 
 * the next x should be placed such that the difference between them should not
 * be >= k
 * 
 * if there is an x which is in this range then continue;
 * 
 * else
 * 
 * we have to replace that * with some another x, such that the difference
 * between two consecutive x's should not be >= k
 * 
 * which means that we have to insure that, the difference between two
 * consecutive x's should be <= k
 * 
 */

public class MainB {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t;
			t = sc.nextInt();
			while (t-- > 0) {
				int[] arr = new int[2];
				arr[0] = sc.nextInt();
				arr[1] = sc.nextInt();
				sc.nextLine();
				String s;
				s = sc.nextLine();
				int count = 0;
				StringBuilder sbf = new StringBuilder(s);
				if (arr[0] == 1) {
					if (sbf.charAt(0) == '*')
						System.out.println(1);
					else
						System.out.println(0);
					return;
				}
				for (int i = 0; i < arr[0]; ++i) {
					if (sbf.charAt(i) == '*') {
						sbf.setCharAt(i, 'x');
						count++;
						break;
					}
				}
				for (int i = arr[0] - 1; i >= 0; --i) {
					if (sbf.charAt(i) == '*') {
						sbf.setCharAt(i, 'x');
						count++;
						break;
					}
				}
				for (int i = 0; i < arr[0]; ++i) {
					if (sbf.charAt(i) == '.')
						continue;
					if (sbf.charAt(i) == 'x') {

						// here finding out whether in a range of k there is another x
						// if there is another x which we have already find out then we can just
						// continue

						boolean flag = false;
						for (int j = 1; j <= arr[1]; ++j) {
							if (i + j < arr[0] && sbf.charAt(i + j) == 'x') {
								flag = true;
								break;
							} else if (i + j >= arr[0]) {
								flag = true;
								break;
							}
						}

						// else if we found no x in that range, then we can move from right to left
						// find out the first star
						// whenever we found out the first star, we convert it to x and increment the
						// total
						// and move forward

						if (flag == false) {
							for (int j = i + arr[1]; j > i; --j) {
								if (j < arr[0] && sbf.charAt(j) == '*') {
									sbf.setCharAt(j, 'x');
									count++;
									break;
								}
							}
						}

					}
				}
				// System.out.println(sbf.toString());
				System.out.println(count);
			}
		}
	}
}
