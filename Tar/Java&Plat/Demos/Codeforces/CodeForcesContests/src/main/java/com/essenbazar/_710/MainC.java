package com.essenbazar._710;

import java.util.Scanner;

/*
 * 
 * Intution:
 * 
 * The task is to find the minimum operations we can apply to make the strings a
 * and b equal
 * 
 * The final string that we will arrive in the end will always be the substring
 * of 'a' (continuous)
 * 
 * as we can delete from the start or from the end, we can't delete from the
 * beginning
 * 
 * -------
 * 
 * In essence we have to find, how many minimum elements we have to delete, to
 * make a equal to b
 * 
 * -------
 * 
 * In the end we will be left with final of a = final of b
 * 
 * the final string is nothing but the 'maximum common substring'
 * 
 * Suppose a has the length '10' and b has the length '16' and the longest
 * common substring has the length '8'
 * 
 * That basically means we have to delete 2 from a
 * 
 * and from b we have to delete 8
 * 
 * -------
 * 
 * We basically have to do length of a - l length of b - l
 * 
 * and take the summation of both
 * 
 */

public class MainC {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t;
			t = sc.nextInt();
			for (int i = 0; i < t; ++i) {
				String x, y;
				x = sc.nextLine();
				y = sc.nextLine();
				int m = x.length();
				int n = y.length();
				int lcs = LCSubStr(x.toCharArray(), y.toCharArray(), m, n);
				System.out.println(m - lcs + n - lcs);
			}
		}
	}

	static int LCSubStr(char X[], char Y[], int m, int n) {
		int LCStuff[][] = new int[m + 1][n + 1];
		int result = 0;
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					LCStuff[i][j] = 0;
				} else if (X[i - 1] == Y[j - 1]) {
					LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1;
					result = Integer.max(result, LCStuff[i][j]);
				} else {
					LCStuff[i][j] = 0;
				}
			}
		}
		return result;
	}

}
