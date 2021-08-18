package com.essenbazar._711;

import java.util.Scanner;
import java.util.TreeMap;

/*
 * 
 * You are given n rectangles, each of height 1. Each rectangle's width is a
 * power of 2 (i. e. it can be represented as 2x for some non-negative integer
 * x).
 * 
 * You are also given a two-dimensional box of width W. Note that W may or may
 * not be a power of 2. Moreover, W is at least as large as the width of the
 * largest rectangle.
 * 
 * You have to find the smallest height of this box, such that it is able to fit
 * all the given rectangles. It is allowed to have some empty space left in this
 * box after fitting all the rectangles.
 * 
 * You cannot rotate the given rectangles to make them fit into the box.
 * Moreover, any two distinct rectangles must not overlap, i. e., any two
 * distinct rectangles must have zero intersection area.
 * 
 * See notes for visual explanation of sample input.
 * 
 * Input
 * 
 * The first line of input contains one integer t (1≤t≤5⋅10^3) — the number of
 * test cases. Each test case consists of two lines.
 * 
 * For each test case: the first line contains two integers n (1≤n≤10^5) and W
 * (1≤W≤10^9);
 * 
 * the second line contains n integers w1,w2,…,wn (1≤wi≤10^6), where wi is the
 * width of the i-th rectangle.
 * 
 * Each wi is a power of 2; additionally, maxi=1nwi≤W
 * 
 * The sum of n over all test cases does not exceed 10^5
 * 
 * Output
 * 
 * Output t integers.
 * 
 * The i-th integer should be equal to the answer to the i-th test case — the
 * smallest height of the box.
 * 
 */

public class MainB {

	private static void remove(int val, TreeMap<Integer, Integer> map) {
		if (!map.containsKey(val))
			return;
		if (map.get(val) == 1) {
			map.remove(val);
			return;
		}
		map.put(val, map.get(val) - 1);
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t;
			t = sc.nextInt();
			TreeMap<Integer, Integer> map = new TreeMap<>();
			while (t-- > 0) {
				int n, w;
				n = sc.nextInt();
				w = sc.nextInt();
				int[] arr = new int[n];
				for (int i = 0; i < n; ++i) {
					arr[i] = sc.nextInt();
					map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
				}
				int res = 1;
				int curr = w;
				for (int i = 0; i < n; ++i) {
					Integer val = map.lowerKey(curr + 1);
					if (val == null) {
						res++;
						curr = w;
						int x = map.lastKey();
						remove(x, map);
						curr -= x;
					} else {
						remove(val, map);
						curr -= val;
					}
				}
				System.out.println(res);
			}
		}
	}
}
