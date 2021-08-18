package com.essenbazar._525;

import java.util.Scanner;

public class MainA {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int x;
			x = sc.nextInt();
			if (x == 1) {
				System.out.println(-1);
				return;
			} else
				System.out.println(x + " " + x);
		}
	}
}
