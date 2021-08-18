
package com.essenbazar.ABC199;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

Problem Statement

You are given sequences of length N each: A=(A1,A2,A3,…,AN) and B=(B1,B2,B3,…,BN).

Find the number of integers x satisfying the following condition:

    Ai≤x≤Bi holds for every integer i such that 1≤i≤N

Constraints

    1≤N≤100

1≤Ai≤Bi≤1000

All values in input are integers.

 */

public class IntersectionB {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n;
			n = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];
			for (int i = 0; i < n; ++i) {
				int temp = sc.nextInt();
				a[i] = temp;
			}
			for (int i = 0; i < n; ++i) {
				int temp = sc.nextInt();
				b[i] = temp;
			}
			List<List<Integer>> llist = new ArrayList<>();
			for (int i = 0; i < a.length; ++i) {
				int temp1 = a[i];
				int temp2 = b[i];
				List<Integer> list = new ArrayList<>();
				for (int j = temp1; j <= temp2; ++j) {
					list.add(j);
				}
				llist.add(list);
			}
			List<Integer> first = llist.get(0);
			boolean flag = false;
			int count = 0;
			for (int i = 1; i < llist.size(); ++i) {
				List<Integer> next = llist.get(i);
				List<Integer> temp = new ArrayList<>();
				for (int num : next) {
					if (first.contains(num)) {
						temp.add(num);
					} else {
						count++;
					}
				}
				if (count == next.size()) {
					flag = true;
					break;
				}
				first.retainAll(temp);

			}
			if (flag) {
				System.out.println(0);
			} else {
				System.out.println(first.size());
			}
		}
	}
}
