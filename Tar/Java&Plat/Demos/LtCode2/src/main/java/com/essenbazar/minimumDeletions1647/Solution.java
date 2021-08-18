
// Minimum Deletions to make Character Frequencies Unique

/*

A string s is called good if there are no two different characters in s that have
the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string.

For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.


Example 1:

Input: s = "aab"
Output: 0
Explanation: s is already good.
Example 2:

Input: s = "aaabbbcc"
Output: 2
Explanation: You can delete two 'b's resulting in the good string "aaabcc".
Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
Example 3:

Input: s = "ceabaacb"
Output: 2
Explanation: You can delete both 'c's resulting in the good string "eabaab".
Note that we only care about characters that are still in the string at the end
(i.e. frequency of 0 is ignored).


Constraints:

1 <= s.length <= 105
s contains only lowercase English letters.


*/

package com.essenbazar.minimumDeletions1647;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public int minDeletions(String s) {
		int cnt[] = new int[26], res = 0;
		Set<Integer> used = new HashSet<>();
		for (int i = 0; i < s.length(); ++i)
			++cnt[s.charAt(i) - 'a'];
		for (int i = 0; i < 26; ++i) {
			while (cnt[i] > 0 && !used.add(cnt[i])) {
				--cnt[i];
				++res;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		my_obj.minDeletions("ab");
	}
}
