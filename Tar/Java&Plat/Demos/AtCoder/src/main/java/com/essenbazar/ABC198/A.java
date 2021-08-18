
package com.essenbazar.ABC198;

import java.util.Scanner;

/*

Problem Statement

Two boys, A and B, will share N indistinguishable sweets. 
How many ways are there to do this so that each boy gets a positive integer number of sweets?

*/

/*

In this problem, the sweets are indistinguishable, so we only have to consider how many sweets
    A and B receive

    There are N - 1 possible number of sweets that A may receive, spanning from 1 to N - 1

    This holds even if N == 1

*/
public class A {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			System.out.println(n - 1);
		}
	}
}
