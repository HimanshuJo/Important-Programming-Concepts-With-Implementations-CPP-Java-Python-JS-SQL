
package com.essenbazar.onesAndZeros;

/**
 *
 * @author himanshu
 */

/*

You are given an array of binary strings strs and two integers m and n.

Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

A set x is a subset of a set y if all elements of x are also elements of y.


Example 1:

Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3

Output: 4

Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.

Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
{"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.


*/

/*

    For each of the value present in the string array, we will be having two possible scenarios
        either we can accept that value and put into out subset, or we can reject that value

        suppose our example is:

            ["10", "0001", "111001", "1", "0"] and m = 5, and n = 3

            let's start with 10

                if we accept this, the value of m and n changes
                    m will become 4
                    n will become 2

                if we reject that, m and n will still remain same

            From 10 we come to the second value

                     10
                    /   \
                   0001 0001

                here also either we can accept 0001 or reject it
                
                if we accept it, the value of m and n changes
                    m will become 1
                    n will become 1

                if we reject it, the value of m and n remains what it was before

            Similary for these two values again we can build the further tree of either accepting it or
                rejecting it

            -------

            So in this approach, initially we first accept a value and then we reject the value
                and then we find the maximum that we are getting from both of these values

            So in essence it will be a recursive solution
*/

/*

Adding Memoization:

    We will basically be functioning on 3 particular values, 0, 1 and the index of the string array
        if we store the value against these three values, we can again use that value if the same scenario comes
        again into our code

*/

public class Solution {
    
    // adding memo
    int [][][] dp;
    
    private int helper(String [] strs, int zero, int one, int index) {
        
        // if the current index has reached the length of the String, we know that there are no
            // more elements, and we can directly return zero
            
            // if zero + one  == 0, that means that there are no zero or one left that we can now add
                // into this subset
            if (index == strs.length || zero + one == 0) return 0;
            
            
            
            if (dp[zero][one][index] > 0) return dp[zero][one][index];
            
            // as we need to find the number of zeros and ones present in this string
                // we need to loop over this String
                
            int [] count = count(strs[index]);
            
            // we have two scenarios over here
                // we can either the string into our subset that way we need to change the value of
                // 0 and 1 according to the 0 and 1 present in the string
                
            int consider = 0;
            
            if (zero >= count[0] && one >= count[1])
                consider = 1 + helper(strs, zero - count[0], one - count[1], index + 1);
                
            // in the other case, we can just skip this value
            
            int skip = helper(strs, zero, one, index + 1);
            
            
            dp[zero][one][index] = Math.max(consider, skip);
            return dp[zero][one][index];
    }
    
    int [] count(String s) {
        int [] count = new int [2];
        
        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }
        
        return count;
    }
    
    
    public int findMaxForm(String [] strs, int m, int n) {
        dp = new int[m + 1][n + 1][strs.length];
        
        return helper(strs, m, n, 0);
    }
    
}
