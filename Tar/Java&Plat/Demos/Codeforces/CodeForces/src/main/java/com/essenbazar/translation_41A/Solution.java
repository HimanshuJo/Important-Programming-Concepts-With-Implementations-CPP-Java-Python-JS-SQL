package com.essenbazar.translation_41A;

/*

The translation from the Berland language into the Birland language is not an easy task. 
Those languages are very similar: a berlandish word differs from a birlandish word with the same 
meaning a little: it is spelled (and pronounced) reversely. 

For example, a Berlandish word code corresponds to a Birlandish word edoc. 
However, it's easy to make a mistake during the «translation». 

Vasya translated word s from Berlandish into Birlandish as t. Help him: find out if he translated the word correctly.

Input

The first line contains word s, the second line contains word t. 
The words consist of lowercase Latin letters. The input data do not consist unnecessary spaces. 
The words are not empty and their lengths do not exceed 100 symbols.

Output

If the word t is a word s, written reversely, print YES, otherwise print NO.

Examples

Input

code
edoc

Output

YES

Input

abb
aba

Output

NO

Input

code
code

Output

NO

 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			String t;
			String tt;
			t = sc.nextLine();
			tt = sc.nextLine();
			StringBuilder sbf = new StringBuilder();
			for (int i = t.length() - 1; i >= 0; --i) {
			    sbf.append(t.charAt(i));
			}
			boolean res = false;
			res = sbf.toString().equals(tt);
			if (res) {
			    System.out.println("YES");
			} else {
			    System.out.println("NO");
			}
		}
    }
}
