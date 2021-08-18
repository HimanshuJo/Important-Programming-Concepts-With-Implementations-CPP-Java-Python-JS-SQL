package com.essenbazar.petyaAndStrings_112A;

import java.util.Scanner;

/*

Little Petya loves presents. His mum bought him two strings of the same size for his birthday. 

The strings consist of uppercase and lowercase Latin letters. 

Now Petya wants to compare those two strings lexicographically. 

The letters' case does not matter, that is an uppercase letter is considered equivalent 
to the corresponding lowercase letter. Help Petya perform the comparison.

Input

Each of the first two lines contains a bought string. 
The strings' lengths range from 1 to 100 inclusive. 
It is guaranteed that the strings are of the same length and also consist of 
uppercase and lowercase Latin letters.

Output

If the first string is less than the second one, print "-1". 
If the second string is less than the first one, print "1". 
If the strings are equal, print "0". 

Note that the letters' case is not taken into consideration when the strings are compared.


 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();

			String s1_ = s1.toLowerCase();
			String s2_ = s2.toLowerCase();

			int res = 0;

			for (int i = 0; i < s1_.length(); ++i) {
			    if ((int) s1_.charAt(i) > (int) s2_.charAt(i)) {
			        res = 1;
			        break;
			    } else if ((int) s1_.charAt(i) < (int) s2_.charAt(i)) {
			        res = -1;
			        break;
			    }
			    if (i == s1_.length()) {
			        res = 0;
			    }
			}

			System.out.println(res);
		}
    }
}
