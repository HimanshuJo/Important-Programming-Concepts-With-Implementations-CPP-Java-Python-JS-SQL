package com.essenbazar.alterBinaryString1758;

/*
 * 
 * Minimum Changes To Make Alternating Binary String
 * 
 * You are given a string s consisting only of the characters '0' and '1'. In
 * one operation, you can change any '0' to '1' or vice versa.
 * 
 * The string is called alternating if no two adjacent characters are equal. For
 * example, the string "010" is alternating, while the string "0100" is not.
 * 
 * Return the minimum number of operations needed to make s alternating.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "0100" Output: 1 Explanation: If you change the last character to
 * '1', s will be "0101", which is alternating.
 * 
 */

/*
 * 
 * Suppose we have a string
 * 
 * s = 0 0 0 1 0 1 0 1 1 1 --> this is the false condition
 * 
 * case 1: 0 1 0 1 0 1 0 1 0 1 --> at even places we have 0, at odd places we
 * have 1
 * 
 * case 2: 1 0 1 0 1 0 1 0 1 0 --> at even places we have 1, at odd places we
 * have 0
 * 
 * -------
 * 
 * Either we can convert our string in the case 1 or we can convert our string
 * in case 2
 * 
 * -------
 * 
 * We will check for two cases: in the first case, we can make an assumption
 * that the string is following the case 1
 * 
 * in the second case, we can make an assumption that the sting is following the
 * case 2
 * 
 * and take the minimum of those
 * 
 * -------
 * 
 * Solving for the first case:
 * 
 * we can check our original string with the case 1, and check if in the even
 * places we have all 0's and in the odd places we have all 1's then
 * it's ok
 * 
 * if even a single position is wrong, we have to flip
 * 
 * Solving for the second case:

 * We can iterate the original string, and check for the even position if at
 * even position the number is 1 and at the odd places we have number 0
 * 
 * there we can increase our original count
 * 
 */
class Solution {

	public int minOperations(String s) {
		int count1 = 0;
		int count2 = 0;
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; ++i) {
			if (i % 2 == 0 && arr[i] != '0') {
				count1++;
			}
			if (i % 2 != 0 && arr[i] != '1') {
				count1++;
			}
			if (i % 2 == 0 && arr[i] != '1') {
				count2++;
			}
			if (i % 2 != 0 && arr[i] != '0') {
				count2++;
			}
		}
		return count1 < count2 ? count1 : count2;
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		String s = "0100";
		System.out.println(my_obj.minOperations(s));
	}
}
