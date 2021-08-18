package com.essenbazar.helpfulMaths_339A;

/*

Xenia the beginner mathematician is a third year student at elementary school. 
She is now learning the addition operation.

The teacher has written down the sum of multiple numbers. 
Pupils should calculate the sum. To make the calculation easier, 
the sum only contains numbers 1, 2 and 3. Still, that isn't enough for Xenia. 
She is only beginning to count, so she can calculate a sum only if the summands follow in 
non-decreasing order. 

For example, she can't calculate sum 1+3+2+1 but she can calculate sums 1+1+2 and 3+3.

You've got the sum that was written on the board. Rearrange the summans and print 
the sum in such a way that Xenia can calculate the sum.

Input

The first line contains a non-empty string s — the sum Xenia needs to count. 
String s contains no spaces. It only contains digits and characters "+". 
Besides, string s is a correct sum of numbers 1, 2 and 3. String s is at most 100 characters long.

Examples
Input

3+2+1

Output

1+2+3

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner my_obj = new Scanner(System.in)) {
			String input;
			input = my_obj.nextLine();
			List<Integer> list = new ArrayList<>();
			StringBuilder sbf = new StringBuilder();
			for (int i = 0; i < input.length(); ++i) {
			    if (input.charAt(i) != '+') {
			        int x = Character.getNumericValue(input.charAt(i));
			        list.add(x);
			    }
			}
			Collections.sort(list);
			for (int i = 0; i < list.size(); i++) {
			    sbf.append(String.valueOf(list.get(i)));
			    if (i < list.size() - 1) {
			        sbf.append("+");
			    }
			}

			System.out.println(sbf.toString());
		}
    }
}
