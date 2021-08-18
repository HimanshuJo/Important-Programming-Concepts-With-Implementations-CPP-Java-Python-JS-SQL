package com.essenbazar.nearLuckyNumber_110A;
/*

Petya loves lucky numbers. We all know that lucky numbers are the positive integers whose decimal
representations contain only the lucky digits 4 and 7.

For example, numbers 47, 744, 4 are lucky and 5, 17, 467 are not.

Unfortunately, not all numbers are lucky. Petya calls a number nearly lucky if the number of
lucky digits in it is a lucky number. He wonders whether number n is a nearly lucky number.

Input

The only line contains an integer n (1 ≤ n ≤ 1018).

Please do not use the %lld specificator to read or write 64-bit numbers in С++.
It is preferred to use the cin, cout streams or the %I64d specificator.

Output

Print on the single line "YES" if n is a nearly lucky number. Otherwise, print "NO" (without the quotes).

Examples

Input

40047

Output

NO

Input

7747774

Output

YES

Input
Copy

1000000000000000000

Output

NO

Note

In the first sample there are 3 lucky digits (first one and last two), so the answer is "NO".

In the second sample there are 7 lucky digits, 7 is lucky number, so the answer is "YES".

In the third sample there are no lucky digits, so the answer is "NO".

 */
import java.util.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			long t;
			t = sc.nextLong();
			String temp = String.valueOf(t);
			char[] a = temp.toCharArray();
			Map<Character, Long> map = new HashMap<>();
			for (int i = 0; i < a.length; ++i) {
			    if (a[i] == '4') {
			        map.put(a[i], map.getOrDefault(a[i], 0L) + 1);
			    } else if (a[i] == '7') {
			        map.put(a[i], map.getOrDefault(a[i], 0L) + 1);
			    }
			}

			long count4 = map.containsKey('4') ? map.get('4') : 0;
			long count7 = map.containsKey('7') ? map.get('7') : 0;

			long total = count4 + count7;
			if (total == 4 || total == 7) {
			    System.out.println("YES");
			} else {
			    System.out.println("NO");
			}
		}
    }
}
