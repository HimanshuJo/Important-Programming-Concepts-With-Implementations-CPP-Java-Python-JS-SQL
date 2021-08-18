
package com.essenbazar.latestTimeByReplacing;

/*

You are given a string time in the form of hh:mm, where some of the digits in the
string are hidden (represented by ?).

The valid times are those inclusively between 00:00 and 23:59.

Return the latest valid time you can get from time by replacing the hidden digits.

Input: time = "2?:?0"
Output: "23:50"
Explanation: The latest hour beginning with the digit '2' is 23 and the
latest minute ending with the digit '0' is 50.
Example 2:

Input: time = "0?:3?"
Output: "09:39"
Example 3:

Input: time = "1?:22"
Output: "19:22"

 */

/*
what can be the atmost number in the respective places

??:50: If both are hidden, turn them into 23
?2:12 and ?9:15: If only digit 0 is hidden, check digit 1
1?:12 and 2?:15: If only digit 1 is hidden, check digit 0
12:?5 and 12:??: digit 3 is at most 5
12:5? and 12:??: digit 4 is at most 9
*/

public class Solution {

	public String maximumTime(String time) {
		char[] nums = time.toCharArray();
		if (nums[0] == '?' && nums[1] == '?') {
			nums[0] = '2';
			nums[1] = '3';
		} else if (nums[0] == '?') {
			nums[0] = (nums[1] > '3') ? '1' : '2';
		} else if (nums[1] == '?') {
			nums[1] = (nums[0] < '2') ? '9' : '3';
		}
		if (nums[3] == '?')
			nums[3] = '5';
		if (nums[4] == '?')
			nums[4] = '9';
		return new String(nums);
	}
}
