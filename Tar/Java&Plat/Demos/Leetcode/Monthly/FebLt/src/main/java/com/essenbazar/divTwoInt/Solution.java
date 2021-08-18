/*
Project for solving some feb_21 leetcode problems
 */
package com.essenbazar.divTwoInt;

/**
 *
 * @author himan
 */

/*

Given two integers dividend and divisor, divide two integers without using multiplication,
division, and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero, which means losing its fractional part.
For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

Note:

Assume we are dealing with an environment that could only store integers within the 32-bit signed
integer range: [−231,  231 − 1].

For this problem, assume that your function returns 231 − 1 when the division result overflows.
 
Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.

 */

/*

While we can subtract divisor from the dividend
    if yes, then we can double the divisor
    increment the count
    check again

Add count to the result

Subtract temp variable from the dividend

-------

Main operation we have to perform:
    a << b
        shifting bits of variable a, b times
        e.g. 4 << 2
        in this case the 4 in-bit representation is 00100
            Now 4 << 2 will be 10000 (16)

*/

class Solution {

    public int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1) return Integer.MAX_VALUE;
        
        boolean sign = (dividend >= 0) == (divisor >= 0);
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;
        while (dividend - divisor >= 0) {
            int count = 0;
            while (dividend - (divisor << 1 << count) >= 0) {
                count++;
            }
            
            result += 1 << count;
            dividend -= divisor << count;
        }
        
        return sign ? result : - result;
    }
}
