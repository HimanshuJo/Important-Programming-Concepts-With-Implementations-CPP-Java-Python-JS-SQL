
package com.essenbazar.ABC197;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Visibility
/*

Problem Statement

We have a grid of H horizontal rows and W vertical columns, 
where some of the squares contain obstacles.

Let (i,j) denote the square at the i-th row from the top and j-th column from the left.

You are given H strings S1,S2,S3,…,SH. 
The j-th character of Si describes the square (i,j); # means the square 
contains an obstacle, and . means it does not.

We say a square is visible from another when it is on the same row or 
the same column, and there is no obstacle between them (including themselves).

Print the number of squares visible from the square (X,Y) (including (X,Y) itself).

 */

public class B {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int H, X, Y;
			H = sc.nextInt();
			X = sc.nextInt();
			Y = sc.nextInt();
			sc.nextLine();
			List<char[]> list = new ArrayList<>();
			for (int i = 0; i < H; ++i) {
				String temp = sc.nextLine();
				list.add(temp.toCharArray());
			}
			int r = X - 1;
			int c = Y - 1;
			int count1 = 0;
			char[] temp = list.get(r);
			if (c < temp.length - 1) {
				for (int i = c + 1; i < temp.length; ++i) {
					if (temp[i] != '#') {
						count1++;
					} else {
						break;
					}
				}
			}
			if (c > 0) {
				for (int i = c - 1; i >= 0; --i) {
					if (temp[i] != '#') {
						count1++;
					} else {
						break;
					}
				}
			}
			int count2 = 0;
			if (r > 0) {
				for (int i = r - 1; i >= 0; --i) {
					char[] temp_ = list.get(i);
					if (temp_[c] != '#') {
						count2++;
					} else {
						break;
					}
				}
			}
			if (r < list.size() - 1) {
				for (int i = r + 1; i < list.size(); ++i) {
					char[] temp_ = list.get(i);
					if (temp_[c] != '#') {
						count2++;
					} else {
						break;
					}
				}
			}
			int check = temp[c] == '.' ? 1 : 0;
			System.out.println(count1 + count2 + check);
		}
	}
}
