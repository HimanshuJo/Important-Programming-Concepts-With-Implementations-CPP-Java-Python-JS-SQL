package com.essenbazar._366;

/*

Dr. Bruce Banner hates his enemies (like others don't).
As we all know, he can barely talk when he turns into the incredible Hulk.
That's why he asked you to help him to express his feelings.

Hulk likes the Inception so much, and like that his feelings are complicated.
They have n layers.
The first layer is hate, second one is love, third one is hate and so on...

For example if n = 1, then his feeling is "I hate it" or if n = 2 it's "I hate that I love it",
and if n = 3 it's "I hate that I love that I hate it" and so on.

Please help Dr. Banner.

Input

The only line of the input contains a single integer n (1 ≤ n ≤ 100) — the number of layers of love and hate.

Output

Print Dr.Banner's feeling in one line.

Examples

Input

1

Output

I hate it

 */

import java.util.Scanner;

public class MainA {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n;
			n = sc.nextInt();
			String n1 = "I hate ";
			String n2 = "I love ";
			String it = "it";
			String that = "that ";
			switch (n) {
			case 1 -> {
				System.out.println(n1 + it);
			}
			case 2 -> {
				System.out.println(n1 + that + n2 + it);
			}
			default -> {
				StringBuilder sbf = new StringBuilder();
				int count = 0;
				while (true) {
					sbf.append(n1);
					count++;
					if (count == n) {
						break;
					}
					sbf.append(that);
					sbf.append(n2);
					count++;
					if (count == n) {
						break;
					}
					sbf.append(that);
				}
				sbf.append(it);
				System.out.println(sbf.toString());
			}
			}
		}
	}
}
