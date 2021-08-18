/*
Project for solving some CodeForces problems
 */
package com.essenbazar.beautifulYear_271A;

/**
 *
 * @author himanshu
 */

/*

It seems like the year of 2013 came only yesterday. Do you know a curious fact? 
The year of 2013 is the first year after the old 1987 with only distinct digits.

Now you are suggested to solve the following problem: given a year number, 
find the minimum year number which is strictly larger than the given one and has only distinct digits.

Input

The single line contains integer y (1000 ≤ y ≤ 9000) — the year number.

Output

Print a single integer — the minimum year number that is strictly larger than y and all 
it's digits are distinct. It is guaranteed that the answer exists.

Examples
Input

1987

Output

2013

Input

2013

Output

2014

 */
import java.util.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int year;
			year = sc.nextInt();
			boolean isNotGood = true;
			year++;
			while (isNotGood) {
			    Map<Character, Integer> map = new HashMap<>();
			    String s = String.valueOf(year);
			    char[] a = s.toCharArray();
			    for (int i = 0; i < a.length; ++i) {
			        map.put(a[i], map.getOrDefault(a[i], 0) + 1);
			    }
			    int count = 0;
			    for (@SuppressWarnings("rawtypes") Map.Entry entry : map.entrySet()) {
			        if ((int) entry.getValue() != 1) {
			            continue;
			        } else {
			            count++;
			        }
			    }
			    if (count == 4) {
			        isNotGood = false;
			        break;
			    }
			    year++;
			}
			System.out.println(year);
		}
    }
}
