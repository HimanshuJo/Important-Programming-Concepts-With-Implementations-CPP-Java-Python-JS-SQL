package com.essenbazar._200;

/*

Mad scientist Mike entertains himself by arranging rows of dominoes.
He doesn't need dominoes, though: he uses rectangular magnets instead.
Each magnet has two poles, positive (a "plus") and negative (a "minus").

If two magnets are put together at a close distance, then the like poles will repel each other
and the opposite poles will attract each other.

Mike starts by laying one magnet horizontally on the table. During each following step
Mike adds one more magnet horizontally to the right end of the row.
Depending on how Mike puts the magnet on the table, it is either attracted to the
previous one (forming a group of multiple magnets linked together) or repelled by it
(then Mike lays this magnet at some distance to the right from the previous one).

We assume that a sole magnet not linked to others forms a group of its own.

Mike arranged multiple magnets in a row. Determine the number of groups that the magnets formed.

Input

The first line of the input contains an integer n (1 ≤ n ≤ 100000) — the number of magnets.
Then n lines follow. The i-th line (1 ≤ i ≤ n) contains either characters "01",
if Mike put the i-th magnet in the "plus-minus" position, or characters "10",
if Mike put the magnet in the "minus-plus" position.

Output

On the single line of the output print the number of groups of magnets.

Examples

Input

6
10
10
10
01
10
10

Output

3

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainA {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n;
			n = sc.nextInt();
			sc.nextLine();
			List<String> list = new ArrayList<>();
			while (n-- > 0) {
				String s;
				s = sc.nextLine();
				list.add(s);
			}
			int res = 1;
			String toCheck__ = list.get(0);
			char[] chh = toCheck__.toCharArray();
			char toCheck = chh[1];
			for (int i = 1; i < list.size(); ++i) {
				String temp = list.get(i);
				char[] ch = temp.toCharArray();
				char toCheck_ = ch[0];
				if (toCheck == toCheck_) {
					res++;
				}
				toCheck = ch[1];

			}
			System.out.println(res);
		}
	}
}
