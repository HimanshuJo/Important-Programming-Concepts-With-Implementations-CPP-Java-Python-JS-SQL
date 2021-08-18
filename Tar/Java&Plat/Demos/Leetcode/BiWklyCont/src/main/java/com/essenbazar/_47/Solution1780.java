package com.essenbazar._47;

/*
 * 
 * Given an integer n, return true if it is possible to represent n as the sum
 * of distinct powers of three. Otherwise, return false.
 * 
 * An integer y is a power of three if there exists an integer x such that y ==
 * 3x.
 * 
 * Example 1:
 * 
 * Input: n = 12 Output: true Explanation: 12 = 31 + 32
 * 
 * Example 2:
 * 
 * Input: n = 91 Output: true Explanation: 91 = 30 + 32 + 34
 * 
 * Example 3:
 * 
 * Input: n = 21 Output: false
 * 
 * 
 */

/*
 * 
 * Suppose we have a number 331
 * 
 * which is: 331 = 3^0 + 3^2 + 3^4 + 3^5
 * 
 * as 3^0 = 1, so lets suppose we get rid of 1
 * 
 * now we have 330
 * 
 * that is: 330 = 3^2 + 3^4 + 3^5
 * 
 * on simplification
 * 
 * 330 = 3^2 (1 + 3^2 + 3^3)
 * 
 * on getting rid of 3^2 and 1 we have
 * 
 * 36 = 3^2 + 3^3
 * 
 * on simplification
 * 
 * 36 = 3^2(1 + 3)
 * 
 * on getting rid = 3^2
 * 
 * we can continue and generalize this for each number that can be represented
 * as the sum of distinct powers
 * 
 * Note that if n % 2 == 0 at any point, that number cannot be represented
 * 
 */
public class Solution1780 {

	boolean checkPowerOfThree(int n) {
		while (n > 2 && n % 3 != 2) {
			n = n % 3 == 1 ? n - 1 : n / 3;
		}
		return n == 3;
	}

	public static void main(String[] args) {
		Solution1780 obj = new Solution1780();
		System.out.println(obj.checkPowerOfThree(345));
	}
}

class SolutionusingRecur {

	public static boolean recurse(int n, int sum, int pow) {
		if (sum > n) {
			return false;
		}
		if (sum == n) {
			return true;
		}
		boolean ans = false;
		for (int i = pow; Math.pow(3, i) <= n; ++i) {
			ans = ans || recurse(n, sum + (int) Math.pow(3, i), i + 1);
		}
		return ans;
	}

	public boolean checkPowerOfThree(int n) {
		return recurse(n, 0, 0);
	}
}
