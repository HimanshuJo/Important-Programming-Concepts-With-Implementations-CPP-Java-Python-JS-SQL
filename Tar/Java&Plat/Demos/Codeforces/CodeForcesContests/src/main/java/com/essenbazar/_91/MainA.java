package com.essenbazar._91;

/*

Petya loves lucky numbers. Everybody knows that lucky numbers are positive integers 
whose decimal representation contains only the lucky digits 4 and 7. 

For example, numbers 47, 744, 4 are lucky and 5, 17, 467 are not.

Petya calls a number almost lucky if it could be evenly divided by some lucky number. 
Help him find out if the given number n is almost lucky.

Input

The single line contains an integer n (1 ≤ n ≤ 1000) — the number that needs to be checked.

Output

In the only line print "YES" (without the quotes), if number n is almost lucky. 
Otherwise, print "NO" (without the quotes).

Examples

Input

47

Output

YES

Input

16

Output

YES

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainA {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n;
			n = sc.nextInt();
			String s1 = String.valueOf(n);
			int count = 0;
			List<Integer> list = new ArrayList<>();
			list.add(4);
			list.add(7);
			list.add(44);
			list.add(47);
			list.add(77);
			list.add(444);
			list.add(777);
			for (int i = 0; i < s1.length(); ++i) {
				if (s1.charAt(i) == '4' || s1.charAt(i) == '7') {
					count++;
				}
			}
			if (count == s1.length()) {
				System.out.println("YES");
				return;
			} else {
				for (int i = 0; i < list.size(); ++i) {
					if (n % list.get(i) == 0) {
						System.out.println("YES");
						return;
					}
				}
			}
		}
		System.out.println("NO");
	}
}
