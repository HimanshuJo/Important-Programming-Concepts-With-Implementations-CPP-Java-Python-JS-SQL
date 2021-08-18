
/*

Given two integers dividend and divisor, divide two integers without using multiplication, 
division, and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero, which means losing its fractional part. 
For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

Note: Assume we are dealing with an environment that could only store integers within 
the 32-bit signed integer range: [−231, 231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.


*/

class Solution {

    public int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1)
            return Integer.MAX_VALUE;
        boolean sign = (dividend >= 0) == (divisor >= 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;
        while (dividend - divisor >= 0) {
            int count = 0;
            while (dividend - (divisor << 1 << count) >= 0)
                count++;
            result += 1 << count;
            dividend -= divisor << count; 
        }
    }
}

class Solution_2 {
    
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) return dividend;
        else if (divisor == -1) return dividend * (-1);
        else if (divisor == dividend) return 1;
        int count = 0;
        int divid = Math.abs(dividend);
        int divis = Math.abs(divisor);
        while ((divid - divis) >= 0) {
            if (count == Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else {
                count++;
                divid -= divis;
            }
        }
        if ((divisor < 0 && dividend >= 0) || (divisor >= 0 && dividend < 0))
            return count * (-1);
        return count;
    }
}