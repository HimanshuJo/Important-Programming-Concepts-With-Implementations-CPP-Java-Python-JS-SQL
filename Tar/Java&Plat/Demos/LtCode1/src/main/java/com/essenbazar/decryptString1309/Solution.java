package com.essenbazar.decryptString1309;

/**
 *
 * @author hjoshi
 */
import java.util.*;

class Solution {

	public String freqAlphabets(String s) {
		Map<String, Character> map = new HashMap<>();
		StringBuilder res_ = new StringBuilder();
		StringBuilder sbf__ = new StringBuilder();
		StringBuilder res = new StringBuilder(s);
		int x_ = 1;
		for (char ch = 'a'; ch <= 'z'; ++ch) {
			if (ch < 'j') {
				map.put(String.valueOf(x_), ch);
				x_++;
			} else {
				map.put((x_) + "#", ch);
				x_++;
			}
		}
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '#') {
				sbf__.append(s.charAt(i - 2));
				sbf__.append(s.charAt(i - 1));

				res.setCharAt(i, ' ');
				res.setCharAt(i - 1, ' ');
				res.setCharAt(i - 2, ' ');
			}
		}
		for (int i = 0; i < sbf__.length(); ++i) {
			StringBuilder temp_ = new StringBuilder();
			temp_.append(sbf__.charAt(i));
			temp_.append(sbf__.charAt(i + 1));
			temp_.append('#');
			res_.append(map.get(temp_.toString()));
			i += 1;
		}
		StringBuilder final_ = new StringBuilder();
		int x = 0;
		for (int i = 0; i < res.length(); ++i) {
			if (res.charAt(i) == ' ' && i == res.length() - 1) {
				break;
			} else if (res.charAt(i) == ' ') {
				// final StringBuilder will be without any spaces
				// take the corresponding value in the res_ StringBuilder
				final_.append(res_.charAt(x));
				x++;
				i += 2;
			} else {
				char temp = res.charAt(i);
				String tempString = String.valueOf(temp);
				final_.append(map.get(tempString));
			}
		}
		return final_.toString();
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		String s = "12345678910#11#12#13#14#15#16#17#18#7891019#20#21#22#23#24#25#26#";
		System.out.println(my_obj.freqAlphabets(s));
	}
}
