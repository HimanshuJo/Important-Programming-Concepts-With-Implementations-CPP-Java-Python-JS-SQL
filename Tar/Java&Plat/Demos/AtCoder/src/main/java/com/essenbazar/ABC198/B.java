
package com.essenbazar.ABC198;

import java.util.Scanner;

/*
// Palindrome with leading zeros
Problem Statement

Given is an integer N

Is it possible to add zero or more 0s at the beginning of the string representing N
    in base ten to get a palindrome?

 */

public class B {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			long n;
			n = sc.nextLong();
			if (n <= 10) {
				System.out.println("Yes");
				return;
			}
			String num = String.valueOf(n);
			int left = 0;
			int right = num.length() - 1;
			boolean isGood = true;
			while (left < right) {
				if (num.charAt(left) == num.charAt(right)) {
					left++;
					right--;
				} else {
					isGood = false;
					break;
				}
			}
			if (isGood) {
				System.out.println("Yes");
			} else {
				int count = 0;
				for (int i = num.length() - 1; i >= 1; --i) {
					if (num.charAt(i) == '0') {
						count++;
					}
				}
				if (count != 0) {
					StringBuilder sbf = new StringBuilder(num);
					while (count-- > 0) {
						sbf.insert(0, '0');
					}
					int left_ = 0;
					int right_ = sbf.length() - 1;
					boolean isGood_ = true;
					while (left_ < right_) {
						if (sbf.charAt(left_) == sbf.charAt(right_)) {
							left_++;
							right_--;
						} else {
							isGood_ = false;
							break;
						}
					}
					if (isGood_) {
						System.out.println("Yes");
					} else {
						System.out.println("No");
					}
				} else {
					System.out.println("No");
				}
			}
		}
	}
}
