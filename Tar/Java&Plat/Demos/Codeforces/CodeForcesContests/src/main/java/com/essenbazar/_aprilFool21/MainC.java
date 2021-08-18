package com.essenbazar._aprilFool21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainC {

	private static boolean isPerfectSquare(int x) {
		int s = (int) Math.sqrt(x);
		return (s * s == x);
	}

	// A number is Fibonacci if and only if one or both of (5*n^2 + 4) or (5*n^2 –
	// 4) is a perfect square

	private static boolean isFibNum(int n) {
		return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String s;
			s = sc.nextLine();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < s.length(); ++i) {
				list.add((int) (s.charAt(i) - 'A'));
			}
			int sum = 0;
			int count = 0;
			boolean ifOkay = false;

			if (list.size() <= 2) {
				for (int i = 0; i < list.size(); ++i) {
					if (isFibNum(list.get(i))) {
						ifOkay = true;
					} else
						ifOkay = false;
				}
				if (ifOkay)
					System.out.println("YES");
				else
					System.out.println("NO");
			} else if (list.size() == 3) {
				int val1 = list.get(0);
				int val2 = list.get(1);
				int sum_ = (val1 + val2) % 26;
				boolean res = (sum_) == list.get(2);
				if (res)
					System.out.println("YES");
				else
					System.out.println("NO");
			} else {
				int val1 = list.get(0);
				int val2 = list.get(1);
				for (int i = 2; i < list.size(); ++i) {
					sum += val1 + val2;
					sum %= 26;
					if (sum == list.get(i))
						count++;
					val1 = val2;
					val2 = list.get(i);
					if (val2 == list.get(list.size() - 1))
						break;
				}
				if (count == list.size() - 3)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}
}
