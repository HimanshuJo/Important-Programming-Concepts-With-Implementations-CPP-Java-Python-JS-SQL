package com.essenbazar._247;

// Number of Wonderful Substrings

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * A wonderful string is a string where at most one letter appears an odd number of times.

    For example, "ccjjc" and "abab" are wonderful, but "ab" is not.

	Given a string word that consists of the first ten lowercase English letters ('a' through 'j'),
	return the number of wonderful non-empty substrings in word. If the same substring appears multiple times
	in word, then count each occurrence separately.

	A substring is a contiguous sequence of characters in a string.

	Example 1:

	Input: word = "aba"
	Output: 4
	Explanation: The four wonderful substrings are underlined below:
	- "aba" -> "a"
	- "aba" -> "b"
	- "aba" -> "a"
	- "aba" -> "aba"

	Example 2:

	Input: word = "aabb"
	Output: 9
	Explanation: The nine wonderful substrings are underlined below:
	- "aabb" -> "a"
	- "aabb" -> "aa"
	- "aabb" -> "aab"
	- "aabb" -> "aabb"
	- "aabb" -> "a"
	- "aabb" -> "abb"
	- "aabb" -> "b"
	- "aabb" -> "bb"
	- "aabb" -> "b"

	Example 3:

	Input: word = "he"
	Output: 2
	Explanation: The two wonderful substrings are underlined below:
	- "he" -> "h"
	- "he" -> "e"

	Constraints:

	    1 <= word.length <= 105
	    word consists of lowercase English letters from 'a' to 'j'.
 */

/*
 * Intuition:
 *
 * 	We can track whether we have an odd(1) or even(0) number of characters using a bit mask
 * 	Every time we see a character - we just flip the corresponding bit.
 *
 * 		here the trick is; we don't track the minimum position for each bit mask,
 * 			here we count how many times we have arrived at that bitmask (count[mask])
 */
/*
 *  Question requires working with parity

    A parity of the occurrence of some letters

    Constraints are important to notice here:

        we have only letters from 'a' till 'j' -> only 10 letters

    Brute force won't work because just to find out all the substrings we need O(n^2) complexity

    -------

    For these kind of problems we can use a DP
        For this the tricky part is how can we efficiently check at the current index, what are the wonderful strings
            so far

        For this problem we can use DP with a bit mask
            the reason being, suppose we have a substring as:
                xxxxxxxxxx

            we have 10 bit masks
                suppose our bit mask is: 1010101010

            * The way we're maintaining this mask is that, whenever we see any value either 0 or 1, we simply
                revert them

                That basically means that each of the bit value represent the parity for a particular letter

            So our setting for the string and bit mask is as follows:
                j i h g f e d c b a
                1 0 1 0 1 0 1 0 1 0

            so for a=0 for example, it means that at that particular index we've even number of a's
            and for b=1 for example, it means that at that location we've odd number of c's

             Please note that, at each index we have a full bit mask.
                Why do we need to maintain that, because

                    Assuming at two indices we have the same bit mask, that basically means that:
                        for the substring in between the appearance of all the letters must be even

                        because parity is same: (Odd - Odd = Even)
                            * for info (Even - Even = Even)

                    This covers one scenario that, we have found all the substrings that has 0 odd appearance
                        (In other words, for all the characters, count of a particular character in the string is even)
             -------

             For the scenario of at-most 1:

                Thinking more deeply about the bit masks, how to find the case when for all the characters, the
                    count of each character in the string is at most 1

                    we can simply try to revert each of the bit value
                        for example suppose our substring and bit mask is:
                            h g f e d c b a
                            1 0 1 0 0 1 0 0
                        here if we revert the bit value for 'a' from 0 to 1 and we keep everything else as same
                            the mask will look like: 1 0 1 0 0 1 0 1

                        and if we find the same substring some-where earlier also, that means that
                            the substring has 'a' appears odd number of times
                            because all the other letters in the string are same

                            Basically:
                                Odd - Even = Odd
                                Even - Odd = Odd

            -------

            To store the appearances of each of the bit mask we'll use a dictionary
                Taking an example for the even case:
                    suppose our sub-string and mask is as follows:
                        j i h g f e d c b a
                        1 0 1 0 1 0 1 0 1 0

                suppose at index=0, bitMask1 appears for the first time
                then at index=2, same bitmask appears again
                and finally at index=8, same bitmask appears for the third time

                    so, in total if we have three appearances of the same bitMask, so how many substrings
                        ending with the character at index=8 are wonderful strings
                            ans = 2 (because we have two same masks before)

                Therefore we need a counter to store the appearance of each of the masks
 */
class Solution {
	public long wonderfulSubstring(String word) {
		long[] count = new long[1024];
		long res = 0;
		int mask = 0;
		count[0] = 1;
		for (var ch : word.toCharArray()) {
			mask ^= 1 << (ch - 'a');
			res += count[mask];
			for (var n = 0; n < 10; ++n) {
				res += count[mask ^ (1 << n)];
			}
			++count[mask];
		}
		return res;
	}
}

class Solution_TLE {
	static List<String> list = new ArrayList<>();

	public long wonderfulSubstrings(String word) {
		allSubStrings(word);
		Map<String, Integer> map = new HashMap<>();
		for (String str : list) {
			System.out.println(str);
			Map<Character, Integer> temp = new HashMap<>();
			for (int i = 0; i < str.length(); ++i) {
				temp.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
			}
			boolean flag = false;
			int count = 0;
			for (Map.Entry<Character, Integer> entry : temp.entrySet()) {
				if (entry.getValue() % 2 != 0) {
					flag = true;
					count++;
				}
			}
			if (flag && count <= 1) {
				map.put(str, 1);
			}
			if (!flag) {
				map.put(str, -1);
			}
		}
		int res = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if ((int) entry.getValue() != -1) {
				res++;
			}
		}
		return res;
	}

	public static void allSubStrings(String s) {
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char[] temp = new char[n - i + 1];
			int tempindex = 0;
			for (int j = i; j < n; j++) {
				temp[tempindex++] = s.charAt(j);
				temp[tempindex] = '\0';
				if (!String.valueOf(temp).isBlank()) {
					list.add(String.valueOf(temp).trim());
				}
			}
		}
	}
}
