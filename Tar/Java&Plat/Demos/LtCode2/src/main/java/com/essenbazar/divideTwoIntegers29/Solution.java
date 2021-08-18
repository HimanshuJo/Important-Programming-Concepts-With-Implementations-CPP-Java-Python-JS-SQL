
package com.essenbazar.divideTwoIntegers29;

/*
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, 
 * and mod operator.

	Return the quotient after dividing dividend by divisor.

	The integer division should truncate toward zero, which means losing its fractional part. 
	For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

	Note: Assume we are dealing with an environment that could only store integers within the 32-bit 
		signed integer range: [−2^31, 2^31 − 1]. 
		
	For this problem, assume that your function returns 2^31 − 1 when the division result overflows.
	
	Example 1:

	Input: dividend = 10, divisor = 3
	Output: 3
	Explanation: 10/3 = truncate(3.33333..) = 3.
	
	Example 2:
	
	Input: dividend = 7, divisor = -3
	Output: -2
	Explanation: 7/-3 = truncate(-2.33333..) = -2.
	
	Example 3:
	
	Input: dividend = 0, divisor = 1
	Output: 0
	
	Example 4:
	
	Input: dividend = 1, divisor = 1
	Output: 1

 */

/*
 * Dividend / Divisor = quotient
 * 
 * 	Intuition:
 * 
 * 		Binary Long Division:
 * 				
 * 				Let a = dividend, and b = divisor
 * 
 * 				Figure out the first position of 'b' to align 'a' and start the binary long division
 * 					and shift divisor to the right until it can't be shifted further
 * 
 * 				So also need to know the right time to stop the binary long division
 * 
 * 		Time:
 * 
 * 			O(log b^a)
 * 		
 * 		Space:
 * 
 * 			O(1)
 * 				
 */

class Solution {
	public int divide(int A, int B) {
		if (A == 1 << 31 && B == -1)
			return (1 << 31) - 1;
		int a = Math.abs(A), b = Math.abs(B), res = 0, x = 0;
		while (a - b >= 0) {
			for (x = 0; a - (b << x << 1) >= 0; x++)
				res += 1 << x;
			a -= b << x;
		}
		return (A > 0) == (B > 0) ? res : -res;
	}
}

class Solution2 {
	public int divide(int dividend, int divisor) {
		// reducing the problem to positive long integer to make it easier
		// using long to avoid integer overflow cases
		int sign = 1;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
			sign = -1;
		}
		long ldividend = Math.abs((long) dividend);
		long ldivisor = Math.abs((long) divisor);
		// Taking care of the edge cases
		if (ldivisor == 0) {
			return Integer.MAX_VALUE;
		}
		if ((ldividend == 0) || (ldividend < ldivisor)) {
			return 0;
		}
		long lans = ldivide(ldividend, ldivisor);
		int ans = 0;
		if (lans > Integer.MAX_VALUE) {
			ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		} else {
			ans = (int) (sign * lans);
		}
		return ans;
	}

	private long ldivide(long ldividend, long ldivisor) {
		// exit condition for the recursion
		if (ldividend < ldivisor) {
			return 0;
		}
		long sum = ldivisor;
		long multiple = 1;
		while ((sum + sum) <= ldividend) {
			sum += sum;
			multiple += multiple;
		}
		return multiple + ldivide(ldividend - sum, ldivisor);
	}
}
