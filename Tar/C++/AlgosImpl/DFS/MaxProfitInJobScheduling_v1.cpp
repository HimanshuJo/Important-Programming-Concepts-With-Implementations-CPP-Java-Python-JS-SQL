#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N = 5e+7;

class Solution {
public:
	int dfs(vector<vector<int>>&nums, int idx, vector<int>&memo) {
		if(idx<nums.size()&&memo[idx]!=-1){
			return memo[idx];
		}
		vector<int>curr=nums[idx];
		int maxprof=0;
		for(int i=idx+1; i<nums.size(); ++i){
			vector<int>nxt=nums[i];
			if(nxt[0]>=curr[1]){
				int prof=dfs(nums, i, memo);
				maxprof=max(maxprof, prof);
			}
		}
		maxprof+=curr[2];
		memo[idx]=maxprof;
		return maxprof;
	}

	int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
		vector<vector<int>>nums;
		int n = startTime.size();
		for (int i = 0; i < n; ++i) {
			nums.push_back({startTime[i], endTime[i], profit[i]});
		}
		vector<int>memo(N + 1, -1);
		sort(nums.begin(), nums.end());
		int fnProf=0;
		for(int i=0; i<n; ++i){
			int prof=dfs(nums, i, memo);
			fnProf=max(fnProf, prof);
		}
		return fnProf;
	}
};

int main() {

}