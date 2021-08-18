'''

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

'''

class Solution:
	def minDistance(self, word1: str, word2: str) -> int:
		m = len(word1)
		n = len(word2)

		# n + 1 and m + 1 so that we don't have to worry about i - 1 and j - 1
		# i and j will be starting from 1
		dp = [[0] * (n + 1) for _ in range(m + 1)]

		for i in range(1, m + 1):
			for j in range(1, n + 1):
				# since i starts from 1 and the word1 is 0 based
				if word1[i - 1] == word2[j - 1]:
					dp[i][j] = 1 + dp[i - 1][j - 1]

				else:
					dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

		return m + n - 2 * dp[-1][-1]

'''

The base case for the above approach

we are starting from 1,1 here

so for dp[0][j]  --> it means that the first word or string is empty and the second one is not
	so, between the empty string and the non-empty string the LCS will always be 0

	same thing is for dp[i][0]

'''