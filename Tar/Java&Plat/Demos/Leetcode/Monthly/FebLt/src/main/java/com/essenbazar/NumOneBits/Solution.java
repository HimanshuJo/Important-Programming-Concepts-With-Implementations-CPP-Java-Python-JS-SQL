/*
Project for solving some common algorithm problems
 */
package com.essenbazar.NumOneBits;

/**
 *
 * @author himan
 */

/*

Write a function that takes an unsigned integer and returns the number of '1' bits
it has (also known as the Hamming weight).

Note that in some languages such as Java, there is no unsigned integer type.
In this case, the input will be given as a signed integer type.

It should not affect your implementation, as the integer's internal binary
representation is the same, whether it is signed or unsigned.

In Java, the compiler represents the signed integers using 2's complement notation.
Therefore, in Example 3 above, the input represents the signed integer. -3.

Input: n = 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.

*/

/*

Algo 1:

Looping on each bit and counting if it is a set bit

E.g. Given n = 11 (1011)  --> in the actual scenario it would be a 32 bit integer
     
     We will also take a mask (a mask would be a number that has a one in the bit position that we're
     going to check

     So we will start with setting the last bit as 1 (so mask would be 0001
        and then perform and operation

     We will shift the one bit one place in the left

     In this approach we are looping 32 times as we've a 32 bit integer

 */

/*

Algo 2:

    Flipping the least significant 1 bit

    here we will take the number and we'll do an 'and' operation with num - 1
        
        This operation will give us a result with the flipped bit for the last 1 that was
            present in the original number

                e.g. 1011 & 1010 will give us 1010
                
                    The result has a flipped bit as 0 for the last 1 that was present
                        in the number
        
        Each time we are flipping we're incrementing the count (counting number of 1's in the res)

        We basically have to count the number of 1's in the new number that is the result
            of the 'and' operation between num and num - 1

*/

public class Solution {

    public int hammingWeight(int n) {
        
        int count = 0;
        int mask = 1;
        
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) count ++;
            mask = mask << 1;  // mask left shift by one
        }
        
        return count;
        
    }
}
