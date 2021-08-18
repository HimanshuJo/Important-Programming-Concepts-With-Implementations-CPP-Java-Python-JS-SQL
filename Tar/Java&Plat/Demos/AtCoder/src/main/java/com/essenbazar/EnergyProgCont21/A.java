
package com.essenbazar.EnergyProgCont21;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// UFO invasion
/*

Problem Statement

You are given a string S of length 12

How many occurrences of ZONes does it contain as contiguous substrings?

Constraints

    S is a string of length 12 consisting of English letters.

*/

public class A {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String s = sc.nextLine();
			String toSearch = "ZONe";
			int count = 0, fromIndex = 0;
			Pattern p = Pattern.compile(toSearch, Pattern.LITERAL);
			Matcher m = p.matcher(s);
			while (m.find(fromIndex)) {
				count++;
				fromIndex = m.start() + 1;
			}
			System.out.println(count);
		}
	}
}
