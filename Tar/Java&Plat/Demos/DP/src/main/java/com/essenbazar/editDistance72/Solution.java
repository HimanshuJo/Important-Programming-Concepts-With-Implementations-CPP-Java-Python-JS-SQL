/*
Project for solving some DP problems
 */
package com.essenbazar.editDistance72;

import java.util.Arrays;

/**
 *
 * @author himanshu
 */

/*

Given two strings word1 and word2, return the minimum number of operations 
required to convert word1 to word2.

You have the following three operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

 */

 /*

Here we can utilize Bottom-Up DP
	
	dp[i][j]  -> here in dp[i][j], i is the length of word1, and j is the length of word2

	With the current length of the word1:
		e.g if i = 1
			it will be "h"

			if i = 2
			it will be "ho"

			if i = 3
			it will be "hor" and so on

			same for j also

		so do[i][j] means with the current word1 and word2 length what is the minimum distance

		-------

		Then we keep on building up our dp all the way up
			until we finish looping up all the words in word1 and word2

		In the end the last element of our 2D DP array will store the result

	-------
 
	How can we deduce dp[i][j]

		Let's assume we have i = 3 and j = 2 here

			so we have "hor" from word1 and "ro" from word2

				'r' will be our current character
				'o' will be our current character

			So how can we reach to dp[i][j] from the previous result

				First step we need to check is

					if word1[i] == word2[j]

						particular if the last current in both of these words that we are looping right now
							are same or not

						if they are same, it means that by adding these two characters in both of our
							words will not increase our overall result

							so the result which we have to minimize will be not increase in this case

						so in essence if both of the characters are same, we don't need to worry about them

						therefore:
							dp[i][j] = dp[i - 1][j - 1]

								it will be same as the previous result

								e.g. "hor" and "rr"

									so in this particular case dp[i][j] will be same as for the state
										when the words were "ho" and "r"

								In essence as long as we know the result of dp[i - 1][j - 1]
									that means if we know the result for "ho" to "r"

									we will know the result for "hor" and "rr"

					-------

					else if word1[i] != word2[j]

						then we need to consider all the three possibilities

						1. Initially we perform the 'remove' operation

							suppose we have "hor" and "ro"

								let's say we remove r from the word1 and make the last character same as word2

							dp[i][j] = dp[i - 1][j]  --> deleting last character from word1

							it means that as long as we know the result from "ho" to "ro"
								then we just need to add 1 to our final dp result

						2. We can also 'insert' a character to word1 remove from word2

							so this time instead of removing a character from word1 and we add a character
								to word1,

								that character will be the last character of word2

								so now we have "horo" and "ro"

								so again here we can ignore the last characters in both the words
									because we already have a state for that which is dp[i - 1][j]

									so in essence the current dp become
										dp[i + 1 - 1][j - 1]
										=> dp[i][j - 1]

						3. We can also 'replace' a character

							suppose we have "hor" and "ro"

								we can replace the last character of "hor" to 'o'

								now we have "hoo" and "ro"

								again here the last characters are same, so we can just ignore them
									as we already know how to compute that state

									so the words become "ho" and "ro"
										dp[i - 1][j - 1]

							Final DP:

								dp[i][j] = min (dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1)

 */
class Solution {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, 0);
        }
        for (int i = 1; i <= m; ++i) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int j = 1; j <= n; ++j) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
