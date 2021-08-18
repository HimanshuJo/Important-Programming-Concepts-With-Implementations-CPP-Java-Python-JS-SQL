
package com.essenbazar.longSubString;

/*

Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0

*/
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	public int lengthOfLongestSubstring(String s) {
		int len_input = s.length();
		if (len_input == 0)
			return 0;
		int max_len = 0;
		int curr_len = 0;
		int curr_start = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < len_input; i++) {
			Integer offset = map.get(s.charAt(i));
			System.out.println("offset at: " + s.charAt(i) + " " + offset);
			if (offset == null) {
				curr_len++;
				System.out.println("curr length here: " + " " + curr_len);
			} else if (offset >= curr_start) {
				curr_len = i - offset;
				curr_start = offset + 1;
			} else
				curr_len++;

			map.put(s.charAt(i), i);
			if (curr_len > max_len)
				max_len = curr_len;
		}
		return max_len;
	}

	/*
	 * Brute Force Algo:
	 *
	 * Check all the substring one by one to see if it has no duplicate character
	 *
	 * -------
	 *
	 * Suppose we have a function 'boolean allUnique(String substring)' which will
	 * return true if the characters in the substring are all unique, otherwise
	 * false.
	 *
	 * We can iterate through all the possible substrings of the given string s and
	 * call the function allUnique.
	 *
	 * If it turns out to be true, then we update our answer of the maximum length
	 * of substring without duplicate characters.
	 *
	 * -------
	 *
	 * 1: To enumerate all substrings of a given string, we enumerate the start and
	 * end indices of them.
	 *
	 * Suppose the start and end indices are i and j, respectively.
	 *
	 * Then we have 0≤i<j≤n (here end index j is exclusive by convention).
	 *
	 * Thus, using two nested loops with i from 0 to n - 1 and j from i+1 to n, we
	 * can enumerate all the substrings of s.
	 *
	 * 2: To check if one string has duplicate characters, we can use a set.
	 *
	 * We iterate through all the characters in the string and put them into the set
	 * one by one.
	 *
	 * Before putting one character, we check if the set already contains it.
	 *
	 * If so, we return false. After the loop, we return true.
	 *
	 */

	// Time Complexity: O(n^3)
	// Space Complexity: O(k)
	// here k is the size of the set
	// the size of the set is upper bounded by the size of the string s and the size
	// of the
	// charset/alphabet m

	public int lengthOfLongestSubstring_BruteForce(String s) {
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j <= n; j++)
				if (allUnique(s, i, j))
					ans = Math.max(ans, j - i);
		return ans;
	}

	public boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if (set.contains(ch))
				return false;
			set.add(ch);
		}
		return true;
	}

	/*
	 *
	 * Sliding Window Algo:
	 *
	 * In the naive approaches, we repeatedly check a substring to see if it has
	 * duplicate character.
	 *
	 * But it is unnecessary.
	 *
	 * If a substring s_{ij} from index i to j - 1 is already checked to have no
	 * duplicate characters.
	 *
	 * We only need to check if s[j] is already in the substring s_{ij}
	 *
	 * To check if a character is already in the substring, we can scan the
	 * substring, which leads to an O(n^2) algorithm. But we can do better.
	 *
	 * By using HashSet as a sliding window, checking if a character in the current
	 * can be done in O(1)
	 *
	 * -------
	 *
	 * Sliding Window Concept:
	 *
	 * A sliding window is an abstract concept commonly used in array/string
	 * problems.
	 *
	 * A window is a range of elements in the array/string which usually defined by
	 * the start and end indices
	 *
	 * i.e. [i, j) (left-closed, right-open).
	 *
	 * A sliding window is a window "slides" its two boundaries to the certain
	 * direction.
	 *
	 * For example, if we slide [i, j) to the right by 1 element, then it becomes
	 * [i+1, j+1)(left-closed, right-open).
	 *
	 * ------- ​ here we will use HashSet to store the characters in the current
	 * window [i, j)
	 *
	 * Then we slide the index j to the right
	 *
	 * If it is not in the HashSet, we slide j further
	 *
	 * Doing so until s[j] is already in the HashSet
	 *
	 * At this point, we've found the maximum size of substrings without duplicate
	 * characters start with index i
	 *
	 */

	public int lengthOfLongestSubstring_SlidingWindow(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0;
		int i = 0;
		int j = 0;
		while (i < n && j < n) {
			// try extending range [i, j]
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}

	// Time Complexity: O(2n) = O(n)
	// Space Complexity: O(min(m, n))
	// we need O(k) space for the sliding window, where k is the size of the Set
	// the size of the Set is upper bounded by the size of the string n and the size
	// of the
	// charset/alphabet m

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		my_obj.lengthOfLongestSubstring("abcabcbb");
	}
}
