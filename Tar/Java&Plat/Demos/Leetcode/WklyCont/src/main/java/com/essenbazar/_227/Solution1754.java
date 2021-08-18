package com.essenbazar._227;

/*

You are given two strings word1 and word2. You want to construct a string merge in the following way:
while either word1 or word2 are non-empty, choose one of the following options:

If word1 is non-empty, append the first character in word1 to merge and delete it from word1.

    For example, if word1 = "abc" and merge = "dv", then after choosing this operation,
        word1 = "bc" and merge = "dva".

If word2 is non-empty, append the first character in word2 to merge and delete it from word2.

    For example, if word2 = "abc" and merge = "", then after choosing this operation,
        word2 = "bc" and merge = "a".

Return the lexicographically largest merge you can construct.

A string a is lexicographically larger than a string b (of the same length)
if in the first position where a and b differ, a has a character strictly larger
than the corresponding character in b.

For example, "abcd" is lexicographically larger than "abcc" because the first position
they differ is at the fourth character, and d is greater than c.

 */
class Solution1754 {

	public String largestMerge(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0)
			return s1 + s2;

		if (s1.compareTo(s2) > 0)
			return s1.charAt(0) + largestMerge(s1.substring(1), s2);
		return s2.charAt(0) + largestMerge(s1, s2.substring(1));
	}
}

// Example: "daaa" and "caaac". Making "dc" is easy,
// but then we need to draw from the second string ("aaac" > "aaa") so the result is
// "dcaaacaaa" instead of "dcaaaaaac".

class SolutionGreedy {

	public String largestMerge(String word1, String word2) {
		StringBuilder sbf = new StringBuilder();
		int i = 0, j = 0;
		char[] w1 = word1.toCharArray();
		char[] w2 = word2.toCharArray();
		int n1 = w1.length;
		int n2 = w2.length;

		// we will loop until we exhaust any one of the 2 words completely
		while (i < n1 && j < n2) {
			// if both the chars are same we have to loop until the end of the string to
			// make
			// a decision
			if (w1[i] == w2[j]) {
				if (check(w1, i, w2, j)) {
					sbf.append(w1[i++]);
				} else {
					sbf.append(w2[j++]);
				}
			}

			// else we greedily choose the largest of the two characters
			else if (w1[i] > w2[j]) {
				sbf.append(w1[i++]);
			} else {
				sbf.append(w2[j++]);
			}
		}

		// at the end of the loop we will append any of the remaining word
		sbf.append(word1.substring(i));
		sbf.append(word2.substring(j));
		return sbf.toString();
	}

	public boolean check(char[] w1, int i, char[] w2, int j) {

		// we will return true if we need to extract from word1 else false
		while (i < w1.length && j < w2.length) {
			if (w1[i] == w2[j]) {
				i++;
				j++;
			} else if (w1[i] > w2[j]) {
				return true;
			} else {
				return false;
			}
		}

		// if we are unable to find any exhaustible character till the end of the loop
		// we can use the one having larger length
		if (i < w1.length) {
			return true;
		}
		return false;
	}
}
