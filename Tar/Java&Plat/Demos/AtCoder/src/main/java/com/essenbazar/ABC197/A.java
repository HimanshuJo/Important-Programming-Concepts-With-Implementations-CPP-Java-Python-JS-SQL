
package com.essenbazar.ABC197;

import java.util.Scanner;

/*
// Rotate
Problem Statement

Given is a string S
of length 3.
Move the first character of S to the end of S and print the resulting string S′.

*/

public class A {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String s = sc.nextLine();
			StringBuilder sbf = new StringBuilder();
			for (int i = 1; i < s.length(); ++i) {
				sbf.append(s.charAt(i));
			}
			sbf.append(s.charAt(0));
			System.out.println(sbf.toString());
		}
	}
}
