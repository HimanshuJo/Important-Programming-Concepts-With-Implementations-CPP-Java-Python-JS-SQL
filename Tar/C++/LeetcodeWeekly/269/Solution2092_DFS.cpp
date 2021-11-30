/*
// Find All People With Secret
You are given an integer n indicating there are n people numbered from 0 to n - 1. 
You are also given a 0-indexed 2D integer array meetings where meetings[i] = [xi, yi, timei] indicates that person xi and person yi have a
meeting at timei. A person may attend multiple meetings at the same time. Finally, you are given an integer firstPerson.

Person 0 has a secret and initially shares the secret with a person firstPerson at time 0. This secret is then shared every time a meeting takes 
place with a person that has the secret. More formally, for every meeting, if a person xi has the secret at timei, then they will share the secret 
with person yi, and vice versa.

The secrets are shared instantaneously. That is, a person may receive the secret and share it with people in other meetings within the same time frame.

Return a list of all the people that have the secret after all the meetings have taken place. You may return the answer in any order.

Example 1:

Input: n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
Output: [0,1,2,3,5]
Explanation:
At time 0, person 0 shares the secret with person 1.
At time 5, person 1 shares the secret with person 2.
At time 8, person 2 shares the secret with person 3.
At time 10, person 1 shares the secret with person 5.
Thus, people 0, 1, 2, 3, and 5 know the secret after all the meetings.
*/

#include<vector>
#include<iostream>
#include<set>
#include<map>
#include<algorithm>
using namespace std;

class Solution {
public:

	void dfs(map<int, vector<int>>&gr, int src, vector<bool>&seen, vector<bool>&sec){
		if(seen[src]) return;
		if(!sec[src]) return;
		seen[src]=true;
		for(auto &vals: gr[src]){
			sec[vals]=true;
            if(!seen[vals]){
                dfs(gr, vals, seen, sec);
			}
		}
	}

    vector<int> findAllPeople(int n, vector<vector<int>>& meetings, int firstPerson) {
		sort(meetings.begin(), meetings.end(), [](auto &a, auto &b){return a[2]<b[2];});
		int i=0, sz=meetings.size();
		int t=1;
		vector<bool>sec(n, false);
		sec[0]=true;
		sec[firstPerson]=true;
		while(t<100000&&i<sz){
        	map<int, vector<int>>gr;
			while(i<sz&&meetings[i][2]<=t){
				gr[meetings[i][0]].push_back(meetings[i][1]);
				gr[meetings[i][1]].push_back(meetings[i][0]);
				++i;
			}
			vector<bool>seen(n, false);
			for(auto &entry: gr)
				dfs(gr, entry.first, seen, sec);
			t++;
		}
        vector<int>ans;
        for(int i=0; i<n; ++i)
			if(sec[i])
	            ans.push_back(i);
		return ans;
    }
};

int main(){}
