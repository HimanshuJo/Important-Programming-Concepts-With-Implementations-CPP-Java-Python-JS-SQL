#include<vector>
#include<algorithm>
#include<iostream>
#include<cstring>
#include<set>
using namespace std;

class Solution {
public:

	void dfs(vector<vector<pair<int, int>>>&gr, int src, int time, bool sec[], set<int>&res, set<int>&seen){
		if(seen.find(src)!=seen.end()) return;
        if(!sec[src])
            return;
		seen.insert(src);
		for(auto &vals: gr[src]){
			pair<int, int>curr=vals;
            if(curr.first>=time){
                if(seen.find(curr.second)==seen.end()){
                    sec[curr.second] = true;
                    dfs(gr, curr.second, curr.first, sec, res, seen);
                }
			}
		}
	}

	bool custComp(pair<int, int>A, pair<int, int>B){
		return A.second<B.second;
	}

    vector<int> findAllPeople(int n, vector<vector<int>>& meetings, int firstPerson) {
        vector<vector<pair<int, int>>>gr(n);
        bool secretKnown[n];
        memset(secretKnown, false, sizeof(secretKnown));
		gr[0].push_back({0, firstPerson});
		gr[firstPerson].push_back({0, 0});
		for(auto &vals: meetings){
			gr[vals[0]].push_back({vals[2], vals[1]});
			gr[vals[1]].push_back({vals[2], vals[0]});
		}
		for(auto &vals: gr)
		    sort(vals.begin(), vals.end());
        secretKnown[0]=true;
        secretKnown[firstPerson]=true;
		set<int>res;
		res.insert(0);
		set<int>seen;
		dfs(gr, 0, 0, secretKnown, res, seen);
        vector<int>ans;
        for(int i=0; i<n; ++i)
            if(secretKnown[i])
                ans.push_back(i);
		return ans;
    }
};

int main(){}
