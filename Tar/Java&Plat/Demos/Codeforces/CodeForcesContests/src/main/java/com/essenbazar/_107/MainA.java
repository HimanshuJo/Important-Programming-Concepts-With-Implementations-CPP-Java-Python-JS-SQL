package com.essenbazar._107;

/*

You are an upcoming movie director, and you have just released your first movie.
You have also launched a simple review site with two buttons to press — upvote and downvote.

However, the site is not so simple on the inside.
There are two servers, each with its separate counts for the upvotes and the downvotes.

n reviewers enter the site one by one. Each reviewer is one of the following types:

    type 1 : a reviewer has watched the movie, and they like it — they press the upvote button;

    type 2 : a reviewer has watched the movie, and they dislike it — they press the downvote button;

    type 3 : a reviewer hasn't watched the movie — they look at the current number
        of upvotes and downvotes of the movie on the server they are in and decide what button to press.
        If there are more downvotes than upvotes, then a reviewer downvotes the movie. Otherwise,
        they upvote the movie.

Each reviewer votes on the movie exactly once.

Since you have two servers, you can actually manipulate the votes so that your movie
gets as many upvotes as possible. When a reviewer enters a site, you know their type,
and you can send them either to the first server or to the second one.

What is the maximum total number of upvotes you can gather over both servers if you
decide which server to send each reviewer to?
Input

The first line contains a single integer t(1≤t≤10^4) — the number of testcases.

Then the descriptions of t testcases follow.

The first line of each testcase contains a single integer n
(1≤n≤50) — the number of reviewers.

The second line of each testcase contains n
integers r1,r2,…,rn (1≤ri≤3) — the types of the reviewers in the same order they enter the site.
Output

For each testcase print a single integer — the maximum total number of upvotes you can
gather over both servers if you decide which server to send each reviewer to.

Example
Input

4
1
2
3
1 2 3
5
1 1 1 1 1
3
3 3 2

Output

0
2
5
2

 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainA {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t;
			t = sc.nextInt();
			while (t-- > 0) {
				int n;
				n = sc.nextInt();
				int[] arr = new int[n];
				for (int i = 0; i < n; ++i) {
					arr[i] = sc.nextInt();
				}
				int res = 0;
				if (arr.length == 1 && arr[0] == 2) {
					System.out.println(0);
				} else if (arr.length == 1 && arr[0] == 1) {
					System.out.println(1);
				} else {
					int count = 0;
					Map<Integer, Integer> map = new HashMap<>();
					for (int i = 0; i < arr.length; ++i) {
						if (arr[i] == 1) {
							count++;
						}
						map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
					}
					if (count == arr.length) {
						System.out.println(arr.length);
					} else {
						res += map.containsKey(1) ? map.get(1) : 0;
						res += map.containsKey(3) ? map.get(3) : 0;
						System.out.println(res);
					}
				}
			}
		}
	}
}
