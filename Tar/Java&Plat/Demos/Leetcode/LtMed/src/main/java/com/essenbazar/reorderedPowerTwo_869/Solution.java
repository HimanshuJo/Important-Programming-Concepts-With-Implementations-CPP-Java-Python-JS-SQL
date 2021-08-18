
package com.essenbazar.reorderedPowerTwo_869;

import java.util.Arrays;

/**
 *
 * @author himanshu
 */

/*

Starting with a positive integer N, we reorder the digits in any order (including the original order) 
such that the leading digit is not zero.

Return true if and only if we can do this in a way such that the resulting number is a power of 2.

Example 1:

Input: 1
Output: true


*/

/*

Algo:

    As we know that there are limited number of power of 2 till 10^9 (which is less than 30)

    We can check these 30 numbers as their digits with the number given, and check if the number matches
        or not

*/

class Solution {
    
    private int [] count(int N) {
        int [] arr = new int [10];  // as there can be only 0 to 9 digits
        
        while (N > 0) {
            
            System.out.println("N is " + N);
            System.out.println("Earlier Array " + Arrays.toString(arr));
            
            arr[N % 10]++;  // increment the value for the last digit
            
            System.out.println("New Array " + Arrays.toString(arr));
            
            N /= 10;  // reduce this N by removing the last digit
        }
        
        return arr;
    }
    
    public boolean reorderedPowerOf2(int N) {
        int [] countN = count(N);  // return count of numbers present in this number
        int num = 1;
        
        for (int i = 0; i < 31; ++i) {
            if (Arrays.equals(countN, count(num))) {
                return true;
            }
            num = num << 1;  // increment num by doubling it everytime
        }
        
        return false;
    }
}
