package com.essenbazar.wordCapitalization_281A;
/*

Capitalization is writing a word with its first letter as a capital letter. 
Your task is to capitalize the given word.

Note, that during capitalization all the letters except the first one remains unchanged.
Input

A single line contains a non-empty word. This word consists of lowercase and uppercase English letters. The length of the word will not exceed 103.
Output

Output the given word after capitalization.

Examples

Input

ApPLe

Output

ApPLe

 */
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner my_obj = new Scanner(System.in)) {
			StringBuilder sbf = new StringBuilder();
			String input;
			input = my_obj.nextLine();
			char temp = Character.toUpperCase(input.charAt(0));
			sbf.append(String.valueOf(temp));

			for (int x = 1; x < input.length(); ++x) {
			    sbf.append(String.valueOf(input.charAt(x)));
			}

			System.out.println(sbf.toString());
		}
    }
}
