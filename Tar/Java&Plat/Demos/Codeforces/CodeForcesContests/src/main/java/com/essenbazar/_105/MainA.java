package com.essenbazar._105;

/*

«One dragon. Two dragon. Three dragon», — the princess was counting. 
She had trouble falling asleep, and she got bored of counting lambs when she was nine.

However, just counting dragons was boring as well, so she entertained herself at best she could. 
Tonight she imagined that all dragons were here to steal her, and she was fighting them off. 
Every k-th dragon got punched in the face with a frying pan. 
Every l-th dragon got his tail shut into the balcony door. 

Every m-th dragon got his paws trampled with sharp heels. 
Finally, she threatened every n-th dragon to call her mom, and he withdrew in panic.

How many imaginary dragons suffered moral or physical damage tonight, 
if the princess counted a total of d dragons?

Input

Input data contains integer numbers k, l, m, n and d, each number in a separate 
line (1 ≤ k, l, m, n ≤ 10, 1 ≤ d ≤ 105).

Output

Output the number of damaged dragons.
Examples
Input

1
2
3
4
12

Output

12

Input

2
3
4
5
24

Output

17

Note

In the first case every first dragon got punched with a frying pan. 
Some of the dragons suffered from other reasons as well, but the pan alone would be enough.

In the second case dragons 1, 7, 11, 13, 17, 19 and 23 escaped unharmed.

 */

import java.util.*;
import java.util.Scanner;

public class MainA {
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int k, l, m, n, d;
			int res = 0;
			k = sc.nextInt();
			l = sc.nextInt();
			m = sc.nextInt();
			n = sc.nextInt();
			d = sc.nextInt();
			Set<Integer> set = new HashSet<>();
			set.add(k);
			set.add(l);
			set.add(m);
			set.add(n);
			List<Integer> set_ = new ArrayList<>(set);
			for (int i = 0; i < set_.size(); ++i) {
				if (set_.get(i) <= d) {
					res++;
				}
			}
			boolean flag;
			int check1 = k;
			int check2 = l;
			int check3 = m;
			int check4 = n;
			for (int i = 1; i <= d; ++i) {
				if (set_.contains(i)) {
					continue;
				} else {
					int num = i;
					flag = false;
					flag = num % check1 == 0 ? true
							: num % check2 == 0 ? true : num % check3 == 0 ? true : num % check4 == 0;

				}
				if (flag) {
					res++;
				}
			}
			System.out.println(res);
		}
	}
}
