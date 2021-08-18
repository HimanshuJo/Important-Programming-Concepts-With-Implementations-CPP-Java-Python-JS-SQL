package com.essenbazar._713;

/*

There is a square field of size n×n

in which two cells are marked. These cells can be in the same row or column.

You are to mark two more cells so that they are the corners of a rectangle with 
sides parallel to the coordinate axes.

For example, if n=4 and a rectangular field looks like this (there are asterisks in the marked cells):

..∗.....∗.......

Then you can mark two more cells as follows

∗.∗.....∗.∗.....

If there are several possible solutions, then print any of them.
Input

The first line contains a single integer t
(1≤t≤400). Then t test cases follow.

The first row of each test case contains a single integer n (2≤n≤400) — the number of rows and 
columns in the table.

The following n lines each contain n characters '.' or '*' denoting empty and marked cells, respectively.

It is guaranteed that the sums of n for all test cases do not exceed 400

It is guaranteed that there are exactly two asterisks on the field. They can be in the same row/column.

It is guaranteed that the solution exists.
Output

For each test case, output n
rows of n characters — a field with four asterisks marked corresponding to the statements. 
If there multiple correct answers, print any of them.

 */

import java.util.Scanner;
import java.util.*;

public class MainB {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			while (t-- > 0) {
				int n;
				n = sc.nextInt();
				sc.nextLine();
				List<List<String>> llist = new ArrayList<>();
				for (int i = 0; i < n; ++i) {
					List<String> list = new ArrayList<>();
					String s = sc.nextLine();
					list.add(s);
					llist.add(list);
				}
				List<Integer> l1 = new ArrayList<>();
				for (int i = 0; i < llist.size(); ++i) {
					List<String> temp = llist.get(i);
					String temp__ = temp.toString();
					for (int x = 0; x < temp__.length(); ++x) {
						if (temp__.charAt(x) == '*') {
							l1.add(i);
						}
					}
				}
				List<String> res1;
				List<String> res2;
				StringBuilder sbf1;
				StringBuilder sbf2;
				if (l1.get(0) == l1.get(1) && l1.get(0) == 0) {
					res1 = llist.get(l1.get(0));
					res2 = llist.get(1);
					sbf1 = new StringBuilder(res1.toString());
					sbf2 = new StringBuilder(res2.toString());
				} else if (l1.get(0) == l1.get(1) && l1.get(0) != 0) {
					if (l1.get(0) < llist.size() && l1.get(0) != llist.size() - 1) {
						res1 = llist.get(l1.get(0));
						res2 = llist.get(llist.size() - 1);
						sbf1 = new StringBuilder(res1.toString());
						sbf2 = new StringBuilder(res2.toString());
					} else {
						res1 = llist.get(l1.get(0));
						res2 = llist.get(llist.size() - 2);
						sbf1 = new StringBuilder(res1.toString());
						sbf2 = new StringBuilder(res2.toString());
					}
				} else {
					res1 = llist.get(l1.get(0));
					res2 = llist.get(l1.get(l1.size() - 1));
					sbf1 = new StringBuilder(res1.toString());
					sbf2 = new StringBuilder(res2.toString());
				}
				if (l1.get(0) == l1.get(1) && l1.get(0) == 0) {
					List<Integer> list = new ArrayList<>();
					for (int x = 1; x < sbf1.length() - 1; ++x) {
						if (sbf1.charAt(x) == '*') {
							list.add(x);
						}
					}
					sbf2.setCharAt(list.get(0), '*');
					sbf2.setCharAt(list.get(1), '*');
					List<String> res1__ = new ArrayList<>();
					List<String> res2__ = new ArrayList<>();

					res1__.add(sbf1.toString());
					res2__.add(sbf2.toString());

					llist.set(l1.get(0), res1__);
					llist.set(1, res2__);
				} else if (l1.get(0) == l1.get(1) && l1.get(0) != 0) {
					if (l1.get(0) < llist.size() && l1.get(0) != llist.size() - 1) {
						List<Integer> list = new ArrayList<>();
						for (int x = 1; x < sbf1.length() - 1; ++x) {
							if (sbf1.charAt(x) == '*') {
								list.add(x);
							}
						}
						sbf2.setCharAt(list.get(0), '*');
						sbf2.setCharAt(list.get(1), '*');
						List<String> res1__ = new ArrayList<>();
						List<String> res2__ = new ArrayList<>();

						res1__.add(sbf1.toString());
						res2__.add(sbf2.toString());

						llist.set(l1.get(0), res1__);
						llist.set(llist.size() - 1, res2__);
					} else {
						List<Integer> list = new ArrayList<>();
						for (int x = 1; x < sbf1.length() - 1; ++x) {
							if (sbf1.charAt(x) == '*') {
								list.add(x);
							}
						}
						sbf2.setCharAt(list.get(0), '*');
						sbf2.setCharAt(list.get(1), '*');
						List<String> res1__ = new ArrayList<>();
						List<String> res2__ = new ArrayList<>();
						res1__.add(sbf1.toString());
						res2__.add(sbf2.toString());

						llist.set(l1.get(0), res1__);
						llist.set(llist.size() - 2, res2__);
					}
				} else {
					int index1 = 0;
					int index2 = 0;
					for (int x = 1; x < sbf1.length() - 1; ++x) {
						if (sbf1.charAt(x) == '*') {
							index1 = x;
						}
					}
					for (int x = 1; x < sbf2.length() - 1; ++x) {
						if (sbf2.charAt(x) == '*') {
							index2 = x;
						}
					}
					sbf1.setCharAt(index2, '*');
					sbf2.setCharAt(index1, '*');
					if (index1 == index2 && index1 != 1) {
						sbf1.setCharAt(index1 - 1, '*');
						sbf2.setCharAt(index2 - 1, '*');
					} else if (index1 == index2 && index1 == 1) {
						sbf1.setCharAt(index1 + 1, '*');
						sbf2.setCharAt(index2 + 1, '*');
					}
					List<String> res1__ = new ArrayList<>();
					List<String> res2__ = new ArrayList<>();

					res1__.add(sbf1.toString());
					res2__.add(sbf2.toString());

					llist.set(l1.get(0), res1__);
					llist.set(l1.get(1), res2__);
				}
				for (int i = 0; i < llist.size(); ++i) {
					List<String> temp = llist.get(i);
					String list = Arrays.toString(temp.toArray()).replace("[", "").replace("]", "");
					System.out.println(list);
				}
			}
		}
	}
}
