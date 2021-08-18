package com.essenbazar._473;

import java.util.Scanner;

public class MainA {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n;
			n = sc.nextInt();
			if (n % 2 == 0)
				System.out.println("Mahmoud");
			else
				System.out.println("Ehab");
		}
	}
}
