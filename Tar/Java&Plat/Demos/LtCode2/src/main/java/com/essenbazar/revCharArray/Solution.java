
package com.essenbazar.revCharArray;

public class Solution {

	public void charArrayRev(String s1) {
		char[] chars = s1.toCharArray();
		int start = 0;
		int end = chars.length - 1;
		while (start < end) {
			char temp = chars[start];
			chars[start++] = chars[end];
			chars[end--] = temp;
		}
		System.out.println(chars);
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		String my_string = "himanshh";
		my_obj.charArrayRev(my_string);
	}
}
