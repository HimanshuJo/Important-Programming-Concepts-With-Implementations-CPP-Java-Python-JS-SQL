/*
Project for solving some Mar_21 leetcode problems
 */
package com.essenbazar.coinChange;

import java.util.Arrays;

/**
 *
 * @author himanshu
 */

/*

You are given coins of different denominations and a total amount of money amount.

Write a function to compute the fewest number of coins that you need to make up that amount.

If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

*/

/*

Bottom up:
    
    taking the smallest coin and then go up to the highest coin and try to make up the amount that is given
        and reduce the number of coins required by the end

    Initially we take a dp array that would of size amount + 1
        so that our last index would be equal to the amount that we are going to get

    Initially in the dp array we will store smount + 1 as the value and for the 0th position
        we will store 0
        
        then we will start iterating over our coins and check what are the number of coins that I require
            to make that particular amount

        supose we have an example  1, 2, 5  --> 11

        
        0   1   2   12  12  12  12  12  12  12  12  12 

        0   1   2   3   4   5   6   7   8   9   10  11

            we will start with 1

                Formular would be
                    
                    dp[i] = MIN(dp[i], dp[i - coin] + 1)

                        for each denomination, the one thing that we are going to keep in mind is that
                            we will start from the index that is equal to the denominations
                                because anything less than that particular amount would not be using the coin
                                    that I am calculating for

                        so as we have our first coin as 1, I will start from my index 1 and check
                            what are the number of coins that are going to be required if I'm considering
                                the denomination 1
                            
                            for making the amount 1, I can either use the number that is currently present in the
                                dp array or I can use a number that is
                                    my current dp index- the coin that I am using
                                        + 1 (for that particular coin that I am using)

                            For 1 it boils down to
                                MIN(12, dp[i - coin] + 1)
                                = MIN(12, dp[1 - 1] + 1) = 1

                            if I am using just the coin of 1, the dp table will at the end look like this
                            
                                    0   1   2   3   4   5   6   7   8   9   10  11 

                                    0   1   2   3   4   5   6   7   8   9   10  11

                            For 2 it boils down to (for 2 I will be considering both the coins 1 and 2)

                                for 2 I can directly start at 2nd index

                                MIN(dp[2], dp[2 - coin] + 1)
                                = MIN(12, dp[2 - 2] + 1) = 1

                            if I am using just the coins 1 and 2, the dp table will at the end look like this
                            
                                    0   1   1   2   2   3   3   4   4   5   5   6 

                                    0   1   2   3   4   5   6   7   8   9   10  11

                                    the numbers has been reduced as I am using 2 denominations
                            

                            For 5 it boild down to (for 5 I will be considering all three coins)

                                for 5 I can directly start at 5th index

                                MIN(dp[5], dp[5 - 5] + 1)
                                = MIN(3, dp[0] + 1)
                                = MIN(3, 1) = 1


                             if I am using all three coins, the dp table will at the end look like this
                            
                                    0   1   1   2   2   1   2   2   3   3   2   3 

                                    0   1   2   3   4   5   6   7   8   9   10  11

                        Since I have used all the coins given to me,
                            the answer would be in the amount, that is the dp[amount]

                        there can be a condition wherein my dp[amount] has not changed, so this would still be greater
                            than amount, that is the case where I will be returning -1
                                I can't form the particular amount from the given coins that I have

    -------

    Time Complexity:
        
        Number of coins * amount (c * n)

    Space Complexity:

        Space used for the dp array which is amount

*/


public class Solution {
    
    public int coinChange(int [] coins, int amount) {
        int [] dp = new int[amount + 1];
        
        Arrays.fill(dp, amount + 1);
        
        dp[0] = 0;
        
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        return dp[amount] <= amount ? dp[amount] : -1;
    }
    
}
