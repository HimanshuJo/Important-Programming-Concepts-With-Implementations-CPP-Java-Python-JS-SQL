#include<vector>
#include<algorithm>
#include<iostream>
using namespace std;

class Solution {
public:

	long long dfs(vector<vector<int>>&rides, int idx, vector<int>&memo){
		if(idx<rides.size()&&memo[idx]!=-1){
			return memo[idx];
		}
		vector<int>curr=rides[idx];
		long long maxProf=0;
		for(int i=idx+1; i<rides.size(); ++i){
			vector<int>nxt=rides[i];
			if(nxt[0]>=curr[1]){
				long long prof=dfs(rides, i, memo);
				maxProf=max(maxProf, prof);
			}
		}
		maxProf+=(curr[1]-curr[0]+curr[2]);
		memo[idx]=maxProf;
		return maxProf;
	}

    long long maxTaxiEarnings(int n, vector<vector<int>>& rides) {
       vector<int>memo(n+1, -1);
	   sort(rides.begin(), rides.end());
	   long long fnprof=0;
	   for(int i=0; i<rides.size(); ++i){
		   long long prof=dfs(rides, i, memo);
		   fnprof=max(fnprof, prof);
	   }
	   return fnprof;
    }
};

int main(){
	int n=5;
	vector<vector<int>>rides={{2, 5, 4}, {1, 5, 1}};
	Solution obj;
	cout<<obj.maxTaxiEarnings(n, rides);
}
