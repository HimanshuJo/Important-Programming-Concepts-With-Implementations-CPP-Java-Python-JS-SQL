package com.essenbazar._582;

import java.util.Scanner;

/*
 * 
 * Polycarp analyzes the prices of the new berPhone. At his disposal are the
 * prices for n last days: a1,a2,…,an, where ai is the price of berPhone on the
 * day i
 * 
 * Polycarp considers the price on the day i to be bad if later (that is, a day
 * with a greater number) berPhone was sold at a lower price. For example, if
 * n=6 and a=[3,9,4,6,7,5], then the number of days with a bad price is 3 —
 * these are days 2 (a2=9), 4 (a4=6) and 5 (a5=7).
 * 
 * Print the number of days with a bad price.
 * 
 * You have to answer t independent data sets.
 * 
 * Input
 * 
 * The first line contains an integer t(1≤t≤10000) — the number of sets of input
 * data in the test. Input data sets must be processed independently, one after
 * another.
 * 
 * Each input data set consists of two lines. The first line contains an integer
 * n (1≤n≤150000) — the number of days.
 * 
 * The second line contains n integers a1,a2,…,an (1≤ai≤106), where ai is the
 * price on the i-th day.
 * 
 * It is guaranteed that the sum of n over all data sets in the test does not
 * exceed 150000
 * 
 * Output
 * 
 * Print t integers, the j-th of which should be equal to the number of days
 * with a bad price in the j -th input data set.
 * 
 * Example Input
 * 
 * 5 6 3 9 4 6 7 5 1 1000000 2 2 1 10 31 41 59 26 53 58 97 93 23 84 7 3 2 1 2 3
 * 4 5
 * 
 * Output
 * 
 * 3 0 1 8 2
 * 
 */

/*
 * 
 * Last day cannot be counted as the bad day because there is no such price,
 * that could be greater than that day
 * 
 * We can start looping from the last index - 1 and keep track of the minimum
 * price from right to left
 * 
 * e.g. suppose our array is [3 2 1 2 3 4 5] 0 1 2 3 4 5 6
 * 
 * at the last index (6th day) our minimum value is 5
 * 
 * at the 5th day our value is 4, so it will not be considered as bad as 4 < 5
 * (only a greater value is considered as bad)
 * 
 * at the index 5, the min value will become 4 again we check at day 4, if the
 * value is greater than 4
 * 
 * as 3 < 4 so it will also not be considered as bad
 * 
 * we will keep on updating our min value like than and do the comparison
 * 
 */

public class MainB {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t;
			t = sc.nextInt();
			while (t-- > 0) {
				int n;
				n = sc.nextInt();
				int[] arr = new int[n];
				for (int i = 0; i < n; ++i) {
					arr[i] = sc.nextInt();
				}
				int min = arr[arr.length - 1];
				int res = 0;
				for (int i = arr.length - 1; i >= 0; --i) {
					if (arr[i] > min) {
						res++;
					}
					if (arr[i] < min)
						min = arr[i];
				}
				System.out.println(res);
			}
		}
	}
}
