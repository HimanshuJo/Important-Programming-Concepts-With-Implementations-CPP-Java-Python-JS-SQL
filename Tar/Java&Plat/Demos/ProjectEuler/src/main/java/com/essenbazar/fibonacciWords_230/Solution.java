
package com.essenbazar.fibonacciWords_230;

import java.math.BigInteger;
import java.util.*;

public class Solution {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			int t = Integer.parseInt(sc.nextLine());

			while (t-- > 0) {
				String a = sc.next();
				String b = sc.next();
				String ns = sc.next();

				BigInteger n = new BigInteger(ns);
				int res = getResult(a, b, n);
				System.out.println(res);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public static int getResult(String one, String two, BigInteger n) {
		List<BigInteger> fcount = new ArrayList<>();
		BigInteger oneInt = BigInteger.valueOf(one.length());
		BigInteger twoInt = BigInteger.valueOf(two.length());
		fcount.add(oneInt);
		fcount.add(twoInt);

		int result = -1;

		do {
			fcount.add(oneInt.add(twoInt));
			oneInt = twoInt;
			twoInt = fcount.get(fcount.size() - 1);
		} while (twoInt.compareTo(n) < 0);

		int i = fcount.size() - 3;
		int currentIndex = i;

		while (i >= 0) {
			BigInteger current = fcount.get(i);
			if (n.compareTo(current) > 0) {
				n = n.subtract(current);
				i--;
				currentIndex = i;
			} else {
				if (i == 0)
					result = one.charAt(n.intValue() - 1);
				if (i == 1)
					result = two.charAt(n.intValue() - 1);
				i = currentIndex - 2;
				currentIndex = i;
			}
		}

		if (result == -1)
			result = two.charAt(n.intValue() - 1);
		return (result - 48);
	}
}