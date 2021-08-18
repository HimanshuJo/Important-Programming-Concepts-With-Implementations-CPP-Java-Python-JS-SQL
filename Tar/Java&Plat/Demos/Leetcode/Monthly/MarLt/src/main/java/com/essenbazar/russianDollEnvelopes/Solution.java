/*
Project for solving some Mar_21 leetcode problems
 */
package com.essenbazar.russianDollEnvelopes;

import java.util.Arrays;

/**
 *
 * @author himanshu
 */

/*

You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] 
represents the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one 
envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.

Example 1:

Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3

Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

Example 2:

Input: envelopes = [[1,1],[1,1],[1,1]]
Output: 1


*/


/*

Algo:

    Firstly we can just concentrate only on the width of the envelope

        in the above example we can easily put:

            2,3 -> into 5,4 and -> into 6,7

        so here the widths, 2, 5, and 6 are in increasing fashion

        we can easily make this array in an increasing fashion, by sorting this array based on the
            width

        -------

        Initially we can sort the array initially based on the width, the resulting array will be:
            
            [[2,3], [5,4], [6,4], [6,7]]

        Now all we need to take care of is the height of the envelope

            they must be in the increasing fashion and no two envelope should have the same width

        -------

            Considering the above resulting array:

                we can use a brute force approach as how to find an increasing subsequence made from
                    these second digits

                that is in this case 3, 4, 4, 7

        Brute force approach to find this sub-sequence:

            We will be using an array

                1       null    null    null    null

                [2,3]   [5,4]   [6,5]   [6,7]   [7.6]

            In the index we will be having the width and height

                the value at the 0th index of this array will always be 1
                
                because the result will be at least one

                -------

                from every value from [5,4] till the end, we need to compare the heights with
                    all the previous heights in the array

                    e.g. we will be comparing 4 in [5,4] with 3 in [2,3]

                        and finding out what is the maximum value we can get

                            1        2       null    null    null

                            [2,3]   [5,4]   [6,5]   [6,7]   [7.6]

                        next we will be comapring 5 in [6,5] with 4 in [5,4] and 3 in [2,3]

                        we get

                              1        2     3      null    null

                            [2,3]   [5,4]   [6,5]   [6,7]   [7.6]

                -------

                when we come across [6,7] and we compare 7 with 5, 4, 3 we will still get 3
                    as we still have to take it's width into consideration

*/

public class Solution {
    
    public int maxEnvelopes(int [][] envelopes) {
        // sort the envelopes array based on the width of envelopes
        
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        
        // we need an array to store the intermediate results
        int [] dp = new int[envelopes.length];
        int maxlen = 0;
        
        dp[0] = 1;
        
        for (int i = 1; i < dp.length; ++i) {
            // as there will be at least one envelop that will be returned
            // so we can put 1 in each position
            dp[i] = 1;
            
            // for all the envelopes before this envelope
            for (int j = 0; j < i; ++j) {
                
                // we will update the dp[i] based on the condition that the width of the two
                    // is not equal, and the height is greater
                
                // then the envelope present at the jth index
                
                if (envelopes[i][0] != envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                
            }
            
            maxlen = Math.max(maxlen, dp[i]);
        }
        
        return maxlen;
    }
    
}

// Time :  O(n^2)
// Space : O(n)

// -------*******-------

/*

Suppose we have an array and we have sorted the array based on the width only is
    [[2,3], [5,4], [6,5], [6,7], [7,6]]
            
    as we are doing the brute force on the height value
        
    Now instead of storing the count of the envelopes that we can fit in till that
        envelop we will be storing the value (height) in this array
            
    we will first store 3

        3    4   5   7  --> here we can't put [6,5] and [6,7] as their width are equal
            
        here as we were putting in the values into this array, we were trying to find
            the smallest value greater than the current value that we are trying to put in
            basically the height of the next envelope which is min and also greater than the
            last envelope
                
            Since here we are not taking into consideration here the width factor
                we have no idea that we can't put in 7 after 5
                
            Now just for a thought, if we sort the height in descending order when the width is same
                e.g. [[2,3], [5,4], [6,7], [6,5], [7,6]]

                so [6, 5] won't be considered when 7 is already there
                
                Now if we traverse array and reach [6, 5] it will still point to the
                    index where 7 is, and we will still have the count of 3
                
            Next we can put 6, the array will look like:
            
                3, 4, 5, 6

    -------

    When we are trying to find the smallest value that is higher than the current value that we are trying
        to put in, we can use binary search

        as the data in the given array will be sorted

*/

class SolutionOpt {
    
    int binarySearch(int [] arr, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return start;
    }
    
    
    public int maxEnvelopes(int [][] envelopes) {
        
        // sorting the envelopes based on the height (descending order) ONLY when
        // the width of the two envelopes are equal
        // otherwise it is based on the width
        
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        int [] arr = new int[envelopes.length];
        int maxLen = 0;
        
        for (int i = 0; i < arr.length; ++i) {
            
            // we will try to find out the position for every value of the envelope
                // or more precisely find the height of the envelope[i]
                
                int index = binarySearch(arr, 0, maxLen, envelopes[i][1]);
                
                arr[index] = envelopes[i][1];
                
                if(index == maxLen) {
                    // we have added one more value into this array
                    maxLen++;
                }
        }
        
        return maxLen;
    }
}