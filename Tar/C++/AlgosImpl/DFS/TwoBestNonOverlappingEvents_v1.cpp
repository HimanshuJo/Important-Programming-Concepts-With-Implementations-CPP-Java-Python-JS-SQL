#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

class Solution{
public:
	int maxTwoEvents(vector<vector<int>>&events){
		int n=events.size();
		vector<vector<int>>memo(n, vector<int>(2, -1));
		sort(events.begin(), events.end());
		return dfs(events, 0, 0, memo);
	}

	int dfs(vector<vector<int>>&nums, int idx, int k, vector<vector<int>>&memo){
		if(k==2||idx>=nums.size()) return 0;
		if(memo[idx][k]!=-1) return memo[idx][k];
		vector<int>ans={nums[idx][1], INT_MAX, INT_MAX};
		int nextIndex=upper_bound(begin(nums), end(nums), ans)-begin(nums);
		return memo[idx][k]=max(dfs(nums, idx+1, k, memo), nums[idx][2]+dfs(nums, nextIndex, k+1, memo));
	}

};

int main(){}