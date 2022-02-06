// 410. Split Array Largest Sum
/*
Given an array nums which consists of non-negative integers and an integer m, you can
split the array into m non-empty continuous subarrays.

Write an algorithm to minimize the largest sum among these m subarrays.

Example 1:

Input: nums = [7,2,5,10,8], m = 2
Output: 18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.

Step 1: construct a prefix sum

Step 2: the dp[i][j] means the min of the max sum among j splits in arr[0 to i], 0 and i are inclusive

Step 3: init dp, init all dp[i][1] to prefix sum, since it does not split (only one group together)

Step 4: iterating all the dp[i][j]

	for i in [0, n - 1]:
		for j in [2, m]:
			for k in all possible splitting point in (this time we split only once, since the 
			                                          subproblem has been solved)
			[ 0 <- k -> (splitted with j - 1 times)| (altogether, so not split) ]
				max(dp[k][j - 1], |prefix_sum[i] - prefix_sum[k]))

Analysis:

Time complexity: O(m * n * n)
Space complexoty: O(m * n)
*/

#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

class Solution {
public:
	int splitArray(vector<int>& nums, int m) {
		int n = nums.size();

		vector<unsigned int> prefix_sum(n, 0);
		vector<vector<unsigned int>> dp(n + 1, vector<unsigned int>(m + 1, INT_MAX));
		prefix_sum[0] = nums[0];
		for (int i = 1; i < n; i++) {
			prefix_sum[i] = prefix_sum[i - 1] + nums[i];
		}
		for (int i = 0; i < n; i++) {
			dp[i][1] = prefix_sum[i];
		}
		dp[0][0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 2; j <= m; j++) {
				for (int k = 0; k < i; k++) {
					dp[i][j] = min(dp[i][j], max(dp[k][j - 1], prefix_sum[i] - prefix_sum[k]));
				}
			}
		}
		return dp[n - 1][m];
	}
};

int main(){
	vector<int>nums{7,2,5,10,8};
	int m=2;
	Solution obj;
	int ans=obj.splitArray(nums, m);
	cout<<ans<<endl;
}