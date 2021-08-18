package com.essenbazar.subProdAndSumDigits1281;

import java.util.LinkedList;

/**
 *
 * @author hjoshi
 */

/*
 * 
 * Given an integer number n, return the difference between the product of its
 * digits and the sum of its digits.
 * 
 * Example 1:
 * 
 * Input: n = 234 Output: 15 Explanation: Product of digits = 2 * 3 * 4 = 24 Sum
 * of digits = 2 + 3 + 4 = 9 Result = 24 - 9 = 15
 * 
 */
class Solution {

	public int subtractProductAndSum(int n) {
		LinkedList<Integer> stack = new LinkedList<>();
		LinkedList<Integer> sum_stack = new LinkedList<>();
		while (n > 0) {
			stack.push(n % 10);
			sum_stack.push(n % 10);
			n = n / 10;
		}
		int prod = 1;
		int sum = 0;
		while (!stack.isEmpty()) {
			prod *= stack.pop();
		}
		while (!sum_stack.isEmpty()) {
			sum += sum_stack.pop();
		}
		return (prod - sum);
	}
}

class Solution2 {

	public int subtractProductAndSum(int n) {
		String s = String.valueOf(n);
		int prod = 1;
		int sum = 0;
		for (int i = 0; i < s.length(); ++i) {
			prod *= Character.getNumericValue(s.charAt(i));
			sum += Character.getNumericValue(s.charAt(i));
		}
		return (prod - sum);
	}
}
