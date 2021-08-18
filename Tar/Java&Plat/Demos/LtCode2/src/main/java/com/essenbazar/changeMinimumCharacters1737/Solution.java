
package com.essenbazar.changeMinimumCharacters1737;

/*

You are given two strings a and b that consist of lowercase letters.
In one operation, you can change any character in a or b to any lowercase letter.

Your goal is to satisfy ONE of the following three conditions:

Every letter in a is strictly less than every letter in b in the alphabet.
Every letter in b is strictly less than every letter in a in the alphabet.
Both a and b consist of only one distinct letter.
Return the minimum number of operations needed to achieve your goal.

Example 1:

Input: a = "aba", b = "caa"
Output: 2
Explanation: Consider the best way to make each condition true:
1) Change b to "ccc" in 2 operations, then every letter in a is less than every letter in b.
2) Change a to "bbb" and b to "aaa" in 3 operations, then every letter in b is less than every letter in a.
3) Change a to "aaa" and b to "aaa" in 2 operations, then a and b consist of one distinct letter.
The best way was done in 2 operations (either condition 1 or condition 3).
Example 2:

Input: a = "dabadd", b = "cda"
Output: 3
Explanation: The best way is to make condition 1 true by changing b to "eee".

 */

/*
Algo:

   Condition 1 and condition 2 are symmetrical, so generally we've 2 operations:
       Op 1 -> make a below b
       Op 2 -> make a and b only one distinct letter

   Operation 1:

       There is definitely a character which separates the String a and String b
       We can try this boundary condition from b to z and see

           how many steps to make String a below it
           how many steps to make String b above or equal it
           
           -------
           
           e.g. suppose we have all the letters present for operations: a,b,c,......z
           
           	let String a = "abcde", String b = "cda"
           	
           		So, the first character from a till z where both the strings differ is 'e'
           		
           		Now we just have to check, whether making string a entirely to 'e' takes less step
           			or making string b will results in less steps
           			
       			Any string which takes less steps will defintiely be strictly bigger than the other
       			
   			-------

       Return the smallest steps among all the boundary characters
   
   Operation 2:

       We just need to count the most frequent character of String(a + b)
       The operation we need to take is
           a.length() + b.length() - count

*/

class Solution {

	public int minCharacters(String a, String b) {
		return Math.min(Math.min(operation1(a, b), operation1(b, a)), operation2(a, b));
	}

	private int operation1(String a, String b) {
		int res = Integer.MAX_VALUE;
		for (int i = 1; i < 26; i++) {
			int count = 0;
			for (char c : a.toCharArray()) {
				if ((c - 'a') >= i) {
					count++;
				}
			}
			for (char c : b.toCharArray()) {
				if ((c - 'a') < i) {
					count++;
				}
			}
			res = Math.min(res, count);
		}
		return res;
	}

	private int operation2(String a, String b) {
		int[] A = new int[26];
		for (char c : a.toCharArray()) {
			A[c - 'a']++;
		}
		for (char c : b.toCharArray()) {
			A[c - 'a']++;
		}
		int res = 0;
		for (int i = 0; i < 26; i++) {
			res = Math.max(res, A[i]);
		}
		return a.length() + b.length() - res;
	}
}
