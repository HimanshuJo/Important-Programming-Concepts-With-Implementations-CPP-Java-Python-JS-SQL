
package com.essenbazar.ABC199;

import java.util.Scanner;
// Square inequality
/*

Problem Statement

You are given integers A, B, and C.

Determine whether A^2+B^2<C^2 holds.

Constraints

    0≤A≤1000
    0≤B≤1000
    0≤C≤1000

A, B, and C are integers.

*/

public class A {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			long A, B, C;
			A = sc.nextLong();
			B = sc.nextLong();
			C = sc.nextLong();
			boolean res = C * C > (A * A) + (B * B);
			if (res)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}
