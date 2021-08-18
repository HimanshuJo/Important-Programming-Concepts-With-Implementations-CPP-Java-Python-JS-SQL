
package com.essenbazar.ABC200;

// Ringo favourite number

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			long[] arr = new long[n];
			for (int i = 0; i < n; ++i) {
				long num = sc.nextInt();
				arr[i] = num;
			}
		}
		int ans = 0;
		System.out.println(ans);
	}
}
