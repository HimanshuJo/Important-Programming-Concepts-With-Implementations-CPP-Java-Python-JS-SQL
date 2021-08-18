
package com.essenbazar.KYOCERA21;

import java.util.Scanner;
import java.util.TreeMap;
// Which century
/*
Problem Statement

In what century is the year N?

What is century?
A century is a period of 100 years. 
For example, the -st century consists of the years through , 
the -nd century consists of the years through , and so on.
Constraints

    1≤N≤3000
*/

public class A {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			TreeMap<Integer, Integer> map = new TreeMap<>();
			int count = 1;
			for (int i = 1; i <= 3000; ++i) {
				//int x = i;
				for (int j = i; j <= i + 99; ++j) {
					map.put(j, count);
				}
				count++;
				i += 99;
			}
			System.out.println(map.toString());
			int res = map.containsKey(n) ? map.get(n) : 0;
			System.out.println("-------");
			System.out.println(res);
		}
	}
}
