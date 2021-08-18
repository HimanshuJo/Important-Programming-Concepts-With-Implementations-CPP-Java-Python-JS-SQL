package com.essenbazar.wayTooLong_71A_800;

/*
Sometimes some words like "localization" or "internationalization" are so long that writing them
many times in one text is quite tiresome.

Let's consider a word too long, if its length is strictly more than 10 characters.
All too long words should be replaced with a special abbreviation.

This abbreviation is made like this: we write down the first and the last letter of a word and
between them we write the number of letters between the first and the last letters.

That number is in decimal system and doesn't contain any leading zeroes.

Thus, "localization" will be spelt as "l10n", and "internationalization» will be spelt as "i18n".

You are suggested to automatize the process of changing the words with abbreviations.
At that all too long words should be replaced by the abbreviation and the words that are not too
long should not undergo any changes.

Input

The first line contains an integer n (1 ≤ n ≤ 100). Each of the following n lines contains one word.
All the words consist of lowercase Latin letters and possess the lengths of from 1 to 100 characters.

Output

Print n lines. The i-th line should contain the result of replacing of the i-th word from the input data.


Examples

Input

4
word
localization
internationalization
pneumonoultramicroscopicsilicovolcanoconiosis

Output

word
l10n
i18n
p43s
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Solution {

    private static String generateGoodWord(String words) {
        if (words.length() > 10) {
            StringBuilder sbf = new StringBuilder();
            sbf.append(words.charAt(0));
            sbf.append(words.length() - 1 - 1);
            sbf.append(words.charAt(words.length() - 1));
            return sbf.toString();
        }

        return words;
    }

    public static void main(String[] args) {
        try (Scanner obj = new Scanner(System.in)) {
			List<String> res = new ArrayList<>();
			String[] string = new String[obj.nextInt()];
			obj.nextLine();
			for (int i = 0; i < string.length; i++) {
			    string[i] = obj.nextLine();
			}

			for (int i = 0; i < string.length; ++i) {
			    res.add(generateGoodWord(string[i]));
			}

			for (int i = 0; i < res.size(); ++i) {
			    System.out.println(res.get(i));
			}
		}
    }
}
