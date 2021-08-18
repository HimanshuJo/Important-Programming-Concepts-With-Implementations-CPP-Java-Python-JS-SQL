package com.essenbazar._aprilFool21;

import java.util.Scanner;

public class MainB {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t;
			t = sc.nextInt();
			if (t == 0)
				System.out.println(0);
			else if (t % 9 == 0)
				System.out.println(9);
			else
				System.out.println(t % 9);
		}
	}
}
