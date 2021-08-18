/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essenbazar.uglyNumberII_264;

/**
 *
 * @author himanshu
 */

/*

Given an integer n, return the nth ugly number.

Ugly number is a positive number whose prime factors only include 2, 3, and/or 5.

 
Example 1:

Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.


*/

/*

DP:

    the ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … 
    
    Because every number can only be divided by 2, 3, 5 one way to look at the sequence is to split the sequence
        to three groups as below
        
        In essence up to a number the sequence of ugly numbers will be sum of all the below three subsequences

            (1) 1x2, 2x2, 3x2, 4x2, 5x2 ...
            (2) 1x3, 2x3, 3x3, 4x3, 5x3 ...
            (3) 1x5, 2x5, 3x5, 4x5, 5x5 ...

    we can find that every subsequnce is the ugly-sequence itself (1,2,3,4,5,...) multiply 2,3,5
        the we use similar merge method as merge sort, to get every ugly number from the three subsequence

    Every step we choose the smallest one, and move one step after.

    -------

    initialize

        ugly[] =  | 1 |
        i2 =  i3 = i5 = 0;

    First iteration

        ugly[1] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)

                 = Min(2, 3, 5)
                 = 2
        ugly[] =  | 1 | 2 |

        i2 = 1,  i3 = i5 = 0  (i2 got incremented)

    Second iteration

        ugly[2] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)

                 = Min(4, 3, 5)
                 = 3

        ugly[] =  | 1 | 2 | 3 |

        i2 = 1,  i3 =  1, i5 = 0  (i3 got incremented)

    Third iteration

        ugly[3] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)

                 = Min(4, 6, 5)
                 = 4

        ugly[] =  | 1 | 2 | 3 |  4 |

        i2 = 2,  i3 =  1, i5 = 0  (i2 got incremented)

    ...

*/

class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        
        int [] res = new int [n];
        int res_ = 0;
        
        res[0] = 1;
        
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        
        int nextMulTwo = res[i2] * 2;
        int nextMulThree = res[i3] * 3;
        int nextMulFive = res[i5] * 5;
        
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            
            if (nextMulTwo < min) min = nextMulTwo;
            if (nextMulThree < min) min = nextMulThree;
            if (nextMulFive < min) min = nextMulFive;
            res_ = min;
            
            res[i] = res_;
            
            if (res_ == nextMulTwo) {
                i2 += 1;
                nextMulTwo = res[i2] * 2;
            }
            
            if (res_ == nextMulThree) {
                i3 += 1;
                nextMulThree = res[i3] * 3;
            }
            
            if (res_ == nextMulFive) {
                i5 += 1;
                nextMulFive = res[i5] * 5;
            }
        }
        
        return res_;
    }
}