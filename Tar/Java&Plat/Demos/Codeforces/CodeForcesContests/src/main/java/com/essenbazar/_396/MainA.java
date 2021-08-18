package com.essenbazar._396;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 *
 * While Mahmoud and Ehab were practicing for IOI, they found a problem which
 * name was Longest common subsequence.
 *
 * They solved it, and then Ehab challenged Mahmoud with another problem.
 *
 * Given two strings a and b, find the length of their longest uncommon
 * subsequence, which is the longest string that is a subsequence of one of them
 * and not a subsequence of the other.
 *
 * A subsequence of some string is a sequence of characters that appears in the
 * same order in the string,
 *
 * The appearances don't have to be consecutive, for example, strings "ac",
 * "bc", "abc" and "a" are subsequences of string "abc" while strings "abbc" and
 * "acb" are not.
 *
 * The empty string is a subsequence of any string. Any string is a subsequence
 * of itself.
 *
 * Input
 *
 * The first line contains string a, and the second line — string b.
 *
 * Both of these strings are non-empty and consist of lowercase letters of
 * English alphabet. The length of each string is not bigger than 105
 * characters. Output
 *
 * If there's no uncommon subsequence, print "-1". Otherwise print the length of
 * the longest uncommon subsequence of a and b.
 *
 * Examples Input
 *
 * abcd defgh
 *
 * Output
 *
 * 5
 *
 */

public class MainA {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String a;
			String b;
			a = sc.nextLine();
			b = sc.nextLine();
			StringBuilder sbf;
			StringBuilder sbf_;
			if (a.length() > b.length()) {
				sbf = new StringBuilder(a);
				sbf_ = new StringBuilder(b);
			} else {
				sbf = new StringBuilder(b);
				sbf_ = new StringBuilder(a);
			}
			if (a.length() == b.length()) {
				if (a.equals(b)) {
					System.out.println(-1);
					return;
				}
			}
			if (!(sbf_.toString()).contains(sbf.toString())) {
				System.out.println(sbf.length());
				return;
			} else {
				int i = 1;
				while (true) {
					sbf.deleteCharAt(sbf.length() - i);
					if (!(sbf_.toString()).contains(sbf.toString())) {
						System.out.println(sbf.length());
						return;
					}
					i++;
					if (sbf.length() == 0)
						break;
				}
			}
			Map<Character, Character> map = new HashMap<>();
			for (char ch : b.toCharArray()) {
				map.put(ch, ch);
			}
			for (char ch : a.toCharArray()) {
				if (!map.containsKey(ch)) {
					System.out.println(1);
					return;
				}
			}
		}
		System.out.println(-1);
	}
}
