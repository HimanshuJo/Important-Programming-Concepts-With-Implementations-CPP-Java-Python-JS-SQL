// 2054. Two Best Non-Overlapping Events
/*
You are given a 0-indexed 2D integer array of events where
events[i] = [startTimei, endTimei, valuei]. The ith event starts at startTimei and ends at endTimei,
and if you attend this event, you will receive a value of valuei.
You can choose at most two non-overlapping events to attend such that the sum of their 
values is maximized.

Return this maximum sum.

Note that the start time and end time is inclusive: that is, you cannot attend two events where
one of them starts and the other ends at the same time. More specifically, if you attend an event
with end time t, the next event must start at or after t + 1.

Examples:

Input: events = [[1,3,2],[4,5,2],[2,4,3]]
Output: 4
Explanation: Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.

Input: events = [[1,3,2],[4,5,2],[1,5,5]]
Output: 5
Explanation: Choose event 2 for a sum of 5.

Input: events = [[1,5,3],[1,5,1],[6,6,5]]
Output: 8
Explanation: Choose events 0 and 2 for a sum of 3 + 5 = 8.
*/

#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

class Solution{
public:
	
	int dfs(vector<vector<int>>&nums, int idx, int k, vector<vector<int>>&memo){
		if(k==2||idx>=nums.size()) return 0;
        if(memo[idx][k]!=-1) return memo[idx][k];
		vector<int>curr=nums[idx];
		int maxprof=0;
		for(int i=idx+1; i<nums.size(); ++i){
			vector<int>nxt=nums[i];
			if(nxt[0]>curr[1]){
				int prof=dfs(nums, i, k+1, memo);
				maxprof=max(maxprof, prof);
			}
		}
		maxprof+=curr[2];
		return memo[idx][k]=maxprof;;
	}

	int maxTwoEvents(vector<vector<int>>&events){
		int n=events.size();
		sort(events.begin(), events.end());
		vector<vector<int>>memo(n+1, vector<int>(2, -1));
		int fnprof=0;
		for(int i=0; i<n; ++i){
			int prof=dfs(events, i, 0, memo);
			fnprof=max(fnprof, prof);
		}
		return fnprof;
	}
};

int main(){
    Solution obj;
    vector<vector<int>>events{{}};
    int ans=obj.maxTwoEvents(events);
    cout<<ans<<endl;
}