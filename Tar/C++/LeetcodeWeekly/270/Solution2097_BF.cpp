#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:
    
    void dfs(vector<vector<int>>&pairs, vector<vector<int>>&res, int n, int idx, vector<bool>&seen){
        if(idx>=n) return;
        if(res.size()==n) return;
        vector<int>curr=pairs[idx];
        for(int i=0; i<n; ++i){
            if(seen[i]!=true){
                vector<int>next=pairs[i];
                if(next[0]==curr[1]){
                    res.push_back(next);
                    seen[i]=true;
                    dfs(pairs, res, n, i, seen);
                }
            }
        }
		if(res.size()!=n){
            res.pop_back();
            seen[idx]=false;
        }
    }
    
    vector<vector<int>> validArrangement(vector<vector<int>>& pairs) {
        vector<vector<int>>res;
        int n=pairs.size();
        vector<bool>seen(n+1);
        for(int i=0; i<n; ++i){
            for(int i=0; i<n; ++i)
                seen[i]=false;
            res.push_back(pairs[i]);
            seen[i]=true;
            dfs(pairs, res, n, i, seen);
            if(res.size()==n) return res;
            res.clear();
            seen.clear();
        }
        return res;
    }
};