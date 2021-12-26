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

/*
Approach #1 Using Longest Common Subsequence [Time Limit Exceeded]
Algorithm

In order to determine the minimum number of delete operations needed, we can make use of the length of the 
longest common sequence among the two given strings s1 and s2, say given by lcs. 
If we can find this lcs value, we can easily determine the required result as m + n - 2*lcs. 
Here, m and n refer to the length of the two given strings s1 and s2.

The above equation works because in case of complete mismatch(i.e. if the two strings can't be equalized at all), 
the total number of delete operations required will be m + n. 
Now, if there is a common sequence among the two strings of length lcs, we need to do lcs lesser deletions in both 
the strings leading to a total of 2lcs lesser deletions, which then leads to the above equation.

In order to find the length of the longest common sequence, we make use of a recursive function lcs(s1,s2,i,j)
which returns the length of the longest common sequence among the strings s1 and s2 considering their 
lengths upto i and j respectively. For evaluating the function, we check if the characters s1[m-1] and s2[n-1] for equality.
If they match, we can consider the corresponding strings upto 1 lesser lengths since the last characters have already been 
considered and add 1 to the result to be returned for strings of 1 lesser lengths. 
Thus, we make the function call lcs(s1, s2, i-1, j-1).

If the last characters don't match, we have two options, either we can consider the second last 
character of s1 and the last character of s2, or we can consider the second last character of s2 
and the last character of s1. We need to consider the larger result obtained out of the two considerations 
for getting the required length.

Thus, the function call lcs(s1,s2,m,n) returns the required lcs value.

class Solution{
	public:
	int minDistance(string s1, string s2){
		return s1.length()+s2.length()-2*lcs(s1, s2, s1.length(), s2.length());
	}

	int lcs(string s1, string s2, int m, int n){
		if(m==0||n==0) return 0;
		if(s1[m-1]==s2[n-1]) return 1+lcs(s1, s2, m-1, n-1);
		else return max(lcs(s1, s2, m, n-1), lcs(s1, s2, m-1, n));
	}

};

Complexity Analysis

Time complexity : O(2^{max(m,n)})
Size of recursion tree will be 2^(m+n) Here, m and n refer to the lengths of s1s1 and s2s2 respectively.

Space complexity : O(max(m,n)). The depth of the recursion tree will go upto max(m,n).

*/

/*
Approach #2 Longest Common Subsequence with Memoization [Accepted]
Algorithm

We can observe that in the last approach, while determining the lcs value, a lot of redundant function calls are made, 
since the same m and n values to be used for the function calls could be obtained going through many different paths.
We can remove this redundancy by making use of a memo array to store the value to be returned for these function calls if they have been called once 
with the corresponding parameters. Thus, memo[i][j] is used to store the result for the function call lcs(s1,s2,i,j).

Thus, by returning the already stored values from the memo array, we can prune the search space to a great extent.

class Solution{
	public:
	int minDistance(string s1, string s2){
		map<pair<int, int>, int>memo;
		return s1.length()+s2.length()-2*lcs(s1, s2, s1.length(), s2.length(), memo);
	}

	int lcs(string s1, string s2, int m, int n, map<pair<int, int>, int>&memo){
		if(m==0||n==0) return 0;
		if(memo.find({m, n})!=memo.end()) return memo[{m, n}];
		if(s1[m-1]==s2[n-1]) return memo[{m, n}]=1+lcs(s1, s2, m-1, n-1, memo);
		else return memo[{m, n}]=max(lcs(s1, s2, m, n-1, memo), lcs(s1, s2, m-1, n, memo));
	}

};

Complexity Analysis

Time complexity : O(m*n). memo array of size mxn needs to be filled once. 
Here, m and n refer to the length of the strings s1 and s2 respectively.

Space complexity : O(m*n). memo array of size mmxnn is used. Also, The depth of the recursion tree will go upto max(m,n).
*/

/*
Approach #3 Using Longest Common Subsequence- Dynamic Programming [Accepted]
Algorithm

Another method to obtain the value of lcslcs is to make use of Dynamic Programming. We'll look at the implemenation and carry-on alongside the idea behind it.
We make use of a 2-D dp, in which dp[i][j] represents the length of the longest common subsequence among the strings s1 and s2 considering their lengths 
upto (i-1)^th index and (j-1)^{th} index only respectively. We fill the dp array in row-by-row order.

In order to fill the entry for dp[i][j], we can have two cases:

In order to fill the entry for dp[i][j], we can have two cases:

The characters s1[i-1] and s2[j-1] match with each other. 
In this case, the entry for dp[i][j] will be one more than the entry obtained for the strings considering their 
lengths upto one lesser index, since the matched character adds one to the length of LCS formed till the current indices. 
Thus, the dp[i][j] entry is updated as dp[i][j] = 1 + dp[i-1][j-1]=1+dp[i−1][j−1]. 
Note that dp[i-1][j-1] has been used because the matched character belongs to both s1 and s2.

The characters s1[i-1] and s2[j-1] don't match with each other. 
In this case, we can't increment the current entry as compared to entries corresponding to the previous indices, 
but we need to replicate the previous entry again to indicate that the length of LCS upto the current indices also 
remains the same. But, which entry to pick up? Now, since the current character hasn't matched, we have got two options. 
We can remove the current character from consideration from either s1 or s2 and use the corresponding dp entries given by 
dp[i-1][j] and dp[i][j-1] respectively. Since we are considering the length of LCS upto the current indices we need to pick up 
the larger entry out of these two to update the current dpdp entry.

At the end, again, we obtain the number of deletions required as m + n - 2*dp[m][n], 
where mm and nn refer to the lengths of s1 and s2. dp[m][n] now refers to the length of LCS among the two given strings.

class Solution {
  public:
    int minDistance(string s1, string s2) {
      vector<vector<int>> dp(s1.length() + 1, vector<int>(s2.length() + 1, 0));
      for (int i = 0; i <= s1.length(); ++i) {
        for (int j = 0; j <= s2.length(); ++j) {
          if (i == 0 || j == 0) continue;
          if (s1[i - 1] == s2[j - 1]) dp[i][j] = 1 + dp[i - 1][j - 1];
          else dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
      return s1.length() + s2.length() - 2 * dp[s1.length()][s2.length()];
    }
};

Complexity Analysis

Time complexity : O(m*n). memo array of size mxn needs to be filled once. 
Here, m and n refer to the length of the strings s1 and s2 respectively.

Space complexity : O(m*n). memo array of size mmxnn is used. Also, The depth of the recursion tree will go upto max(m,n).
*/

#include<bits/stdc++.h>
using namespace std;

class Solution {
  public:
    int minDistance(string s1, string s2) {
      vector < vector < int >> dp(s1.length() + 1, vector < int > (s2.length() + 1, 0));
      for (int i = 0; i <= s1.length(); ++i) {
        for (int j = 0; j <= s2.length(); ++j) {
          if (i == 0 || j == 0) continue;
          if (s1[i - 1] == s2[j - 1]) dp[i][j] = 1 + dp[i - 1][j - 1];
          else dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
      return s1.length() + s2.length() - 2 * dp[s1.length()][s2.length()];
    }
};

int main() {
    Solution obj;
    obj.minDistance("sea", "ea");
}
