package com.essenbazar._141;

/*

Valera the Horse is going to the party with friends.
He has been following the fashion trends for a while, and he knows that it is
very popular to wear all horseshoes of different color.
Valera has got four horseshoes left from the last year, but maybe some of them have the same color.
In this case he needs to go to the store and buy some few more horseshoes, not to lose face in
front of his stylish comrades.

Fortunately, the store sells horseshoes of all colors under the sun and Valera has enough
money to buy any four of them.
However, in order to save the money, he would like to spend as little money as possible,
so you need to help Valera and determine what is the minimum number of horseshoes he needs
to buy to wear four horseshoes of different colors to a party.

Input

The first line contains four space-separated integers s1, s2, s3, s4 (1 ≤ s1, s2, s3, s4 ≤ 109) —
the colors of horseshoes Valera has.

Consider all possible colors indexed with integers.
Output

Print a single integer — the minimum number of horseshoes Valera needs to buy.
Examples
Input
Copy

1 7 3 3

Output

1

Input

7 7 7 7

Output

3

 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainA {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int s1, s2, s3, s4;
			s1 = sc.nextInt();
			s2 = sc.nextInt();
			s3 = sc.nextInt();
			s4 = sc.nextInt();
			int[] arr = new int[4];
			arr[0] = s1;
			arr[1] = s2;
			arr[2] = s3;
			arr[3] = s4;
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < arr.length; ++i) {
				set.add(arr[i]);
			}
			System.out.println(Math.abs(set.size() - 4));
		}
	}
}
