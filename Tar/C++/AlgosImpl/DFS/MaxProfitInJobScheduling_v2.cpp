#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N = 5e+7;

class Solution {
public:

	int dfs(vector<vector<int>>&nums, int idx, int last, vector<int>&memo) {
		if (idx >= nums.size()) return 0;
		if (memo[idx] != -1) return memo[idx];
		int low = idx + 1, high = nums.size() - 1;
		int nextJobTime = nums.size() + 1;
		while (low <= high) {
			int mid = (low + high) >> 2;
			if (nums[mid][0] >= nums[idx][1]) {
				nextJobTime = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return memo[idx] = max(dfs(nums, idx + 1, last, memo), nums[idx][2] + dfs(nums, nextJobTime, nums[idx][1], memo));
	}

	int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
		int n = startTime.size();
		vector<vector<int>> nums;
		for (int i = 0; i < n; ++i)
			nums.push_back({startTime[i], endTime[i], profit[i]});

		vector<int> memo(N + 1, -1);
		sort(nums.begin(), nums.end());
		return dfs(nums, 0, 1, memo);
	}

	int main() {

	}