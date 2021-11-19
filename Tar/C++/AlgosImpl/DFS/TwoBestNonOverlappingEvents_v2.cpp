#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

class Solution {
public:

	int dfs(vector<vector<int>>&nums, int idx, int k, vector<vector<int>>&memo) {
		if (k == 2 || idx >= nums.size()) return 0;
		if (memo[idx][k] != -1) return memo[idx][k];
		vector<int>curr = nums[idx];
		int maxprof = 0;
		for (int i = idx + 1; i < nums.size(); ++i) {
			vector<int>nxt = nums[i];
			if (nxt[0] > curr[1]) {
				int prof = dfs(nums, i, k + 1, memo);
				maxprof = max(maxprof, prof);
			}
		}
		maxprof += curr[2];
		memo[idx][k] = maxprof;
		return maxprof;
	}

	int maxTwoEvents(vector<vector<int>>&events) {
		int n = events.size();
		sort(events.begin(), events.end());
		vector<vector<int>>memo(n + 1, vector<int>(2, -1));
		int fnprof = 0;
		for (int i = 0; i < n; ++i) {
			int prof = dfs(events, i, 0, memo);
			fnprof = max(fnprof, prof);
		}
		return fnprof;
	}
};

int main() {}