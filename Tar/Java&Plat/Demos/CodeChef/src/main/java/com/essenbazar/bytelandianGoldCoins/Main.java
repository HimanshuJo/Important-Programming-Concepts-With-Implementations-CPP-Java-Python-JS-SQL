
package com.essenbazar.bytelandianGoldCoins;

import java.util.Scanner;

/*

In Byteland they have a very strange monetary system.

Each Bytelandian gold coin has an integer number written on it. 

A coin n can be exchanged in a bank into three coins: n/2, n/3 and n/4. 
But these numbers are all rounded down (the banks have to make a profit).

You can also sell Bytelandian coins for American dollars. 
The exchange rate is 1:1. But you can not buy Bytelandian coins.

You have one gold coin. What is the maximum amount of American dollars you can get for it? 

 */
public class Main {

	public static void main(String[] args) {
		try {
			try (Scanner sc = new Scanner(System.in)) {
				while (sc.hasNext()) {
					int num = sc.nextInt();
					System.out.println(maxDollar(num));
				}
			}
		} catch (Exception e) {
		}
	}

	public static long maxDollar(int n) {
		if (n >= 12) {
			long x = maxDollar(n / 2);
			long y = maxDollar(n / 3);
			long z = maxDollar(n / 4);
			return x + y + z;
		}

		return n;
	}
}
