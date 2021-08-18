/*
Given two strings word1 and word2, return the minimum number of steps required to 
make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4
*/

#include<bits/stdc++.h>
using namespace std;

class Solution {
    public:
    int minDistance(string word1, string word2) {
        int m = word1.length();
        int n = word2.length();
        word1.insert(0, " ");
        word2.insert(0, " ");
        int dp[m + 1][n + 1];
        for (int i = 0; i <= n; ++i) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= m; ++i) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (word1.at(i) == word2.at(j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        cout << dp[m - 1][n - 1];
        return dp[m - 1][n - 1];
    }
};

int main() {
    Solution obj;
    obj.minDistance("sea", "ea");
}