
package com.essenbazar.reverseString344;

class Solution {
	public void reverseString(char[] s) {
		int left = 0;
		int right = s.length - 1;
		while (left < right) {
			char temp = s[left];
			s[left++] = s[right];
			s[right--] = temp;
		}
		System.out.println(s);
	}

	public static void main(String[] args) {
		char[] s = { 'h', 'e' };
		Solution my_obj = new Solution();
		my_obj.reverseString(s);
	}
}
