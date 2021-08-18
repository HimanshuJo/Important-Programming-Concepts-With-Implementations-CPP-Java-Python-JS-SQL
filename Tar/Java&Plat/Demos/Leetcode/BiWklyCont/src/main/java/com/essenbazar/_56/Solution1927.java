package com.essenbazar._56;

import java.util.ArrayList;
import java.util.List;

// Sum Game
/*
 * Alice and Bob take turns playing a game, with Alice starting first.

	You are given a string num of even length consisting of digits and '?' characters. On each turn, a player will do the following
	if there is still at least one '?' in num:

	    Choose an index i where num[i] == '?'.
	    Replace num[i] with any digit between '0' and '9'.

	The game ends when there are no more '?' characters in num.

	For Bob to win, the sum of the digits in the first half of num must be equal to the sum of the digits in the second half.
	For Alice to win, the sums must not be equal.

	    For example, if the game ended with num = "243801", then Bob wins because 2+4+3 = 8+0+1.
	    If the game ended with num = "243803", then Alice wins because 2+4+3 != 8+0+3.

	Assuming Alice and Bob play optimally, return true if Alice will win and false if Bob will win.

	Example 1:

	Input: num = "5023"
	Output: false
	Explanation: There are no moves to be made.
	The sum of the first half is equal to the sum of the second half: 5 + 0 = 2 + 3.

	Example 2:

	Input: num = "25??"
	Output: true
	Explanation: Alice can replace one of the '?'s with '9' and it will be impossible for Bob to make the sums equal.

	Example 3:

	Input: num = "?3295???"
	Output: false
	Explanation: It can be proven that Bob will always win. One possible outcome is:
	- Alice replaces the first '?' with '9'. num = "93295???".
	- Bob replaces one of the '?' in the right half with '9'. num = "932959??".
	- Alice replaces one of the '?' in the right half with '2'. num = "9329592?".
	- Bob replaces the last '?' in the right half with '7'. num = "93295927".
	Bob wins because 9 + 3 + 2 + 9 = 5 + 9 + 2 + 7.

 */

/*
 * The idea is either alice or bob want to maximize the 1st half of string and minimize the 2nd half of string.
 * If alice want to maximize, bob trys to minimize and viceversa.

	-> let cnt1 be the number of places to be replaced in 1st half and cnt2 be the number of places replaced in 2nd half
		and sum is result of (sum of values in 1st half - sum of values in 2nd half) .
	-> It doesn't matter who wants to maximize(because both play optimally), sum will add up (cnt1/2)*9 in the 1st half and decrease by (cnt2/9).
	->  if final sum ans == 0 then BOB wins else Alice wins!!
	-> But if the total number of question marks are odd, then there is definite edge towards Alice because,
		she starts the game first and get a chance to replace one extra question mark. In this case, Alice will Win.
 */

class Solution1927 {

	public int sumL(StringBuilder sbfL) {
		int res = 0;
		for (int i = 0; i < sbfL.length(); ++i) {
			if (sbfL.charAt(i) != '?')
				res += Character.getNumericValue(sbfL.charAt(i));
		}
		return res;
	}

	public int sumR(StringBuilder sbfR) {
		int res = 0;
		for (int i = 0; i < sbfR.length(); ++i) {
			if (sbfR.charAt(i) != '?')
				res += Character.getNumericValue(sbfR.charAt(i));
		}
		return res;
	}

	public boolean sumGame(String num) {
		List<Integer> indexesL = new ArrayList<>();
		List<Integer> indexesR = new ArrayList<>();
		StringBuilder sbfL = new StringBuilder();
		StringBuilder sbfR = new StringBuilder();
		for (int i = 0; i < num.length() / 2; ++i) {
			sbfL.append(num.charAt(i));
		}
		for (int i = num.length() / 2; i < num.length(); ++i) {
			sbfR.append(num.charAt(i));
		}
		for (int x = 0; x < sbfL.length(); ++x) {
			if (sbfL.charAt(x) == '?') {
				indexesL.add(x);
			}
		}
		for (int x = 0; x < sbfR.length(); ++x) {
			if (sbfR.charAt(x) == '?') {
				indexesR.add(x);
			}
		}
		if (indexesL.size() == indexesR.size() && sumL(sbfL) == sumR(sbfR)) {
			return false;
		} else if (indexesL.size() == 1 && indexesR.size() == 0 || indexesR.size() == 1 && indexesL.size() == 0) {
			return true;
		}
		int check1 = 0;
		int check2 = 0;
		if (indexesL.isEmpty() && indexesR.isEmpty()) {
			for (int i = 0, j = 0; i < sbfL.length() && j < sbfR.length(); ++i, ++j) {
				check1 += Character.getNumericValue(sbfL.charAt(i));
				check2 += Character.getNumericValue(sbfR.charAt(j));
			}
			return check1 == check2 ? false : true;
		}
		if (indexesL.isEmpty() && !indexesR.isEmpty()) {
			int check = sumL(sbfL);
			if (check != 10 && indexesR.size() > 2) {
				return true;
			}
		}
		if (indexesR.isEmpty() && !indexesL.isEmpty()) {
			int check = sumR(sbfR);
			if (check != 10 && indexesL.size() > 2) {
				return true;
			}
		}
		if ((sumL(sbfL) - sumR(sbfR)) + (indexesL.size() / 2) * 9 - (indexesR.size() / 2) * 9 == 0) {
			return false;
		}
		return true;
	}
}