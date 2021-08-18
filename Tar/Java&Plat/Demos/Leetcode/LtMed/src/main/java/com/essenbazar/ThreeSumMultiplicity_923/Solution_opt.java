/*
Project for solving some common algorithm problems
 */
package com.essenbazar.threeSumMultiplicity_923;

/**
 *
 * @author himanshu
 */

/*

We are given three constraints

    3 <= arr.length <= 3000
    0 <= arr[i] <= 100  -->very important constraints
    0 <= target <= 300

    -------

    In essence we need to find all the combinations of the numbers such that

        the sum of those numbers (arr[i] + arr[j] + arr[k]) is equivalent to the target

    We can use the occurrences of that number to find the combinations

        With this way we don't have to iterate over all the numbers all the times

    -------

    We will take a count array of size 101
        and store the count of occurrences of the numbers in the array

    We need to loop for i and j on all the numbers 0 to 900 and find if there exists a 'k' such that
        k = target - i - j is in range

    Over her we can have three cases:

        1. when i == j == k

            e.g. we have an array that is having numbers let's say [2, 2, 2, 2]
                and I need to make 6 out of it
                
                in this case I will be using all the 2's
            
            the count array will have 4 in the place of 2nd index

        2. Only two numbers are equal

        3. All the numbers are distinct
*/

public class Solution_opt {
    
    public int threeSumMulti(int [] arr, int target) {
        int mod = 1_000_000_007;
        long result = 0;
        long [] c = new long[101];

        for (int i : arr) {
            c[i]++;
        }
        
        for (int i = 0; i <= 100; ++i) {
            for (int j = i; j <= 100; ++j) {
                int k = target - i - j;
                
                // edge case
                if (k < 0 || k > 100) continue;
                
                if (i == j && j == k) {
                    result += (c[i] * (c[i] - 1) * (c[i] - 2) / 6);
                } else if (i == j && j != k) {
                    result += ((c[i] * (c[i] - 1) / 2) * c[k]);
                } else if (i < j &&  j <  k) {
                    result += (c[i] * c[j] * c[k]);
                }
            }
        }
        
        return (int) (result % mod);
    }
}