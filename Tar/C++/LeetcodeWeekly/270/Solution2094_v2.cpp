#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:

	set<int>ans;
	
    void dfs(int data, int val, int length, vector<int>&digits, vector<bool>&seen){
		val=val*10+data;
        if(memo.count(val)>0) return;
		if(length==3){
			if(data%2==0){
				ans.insert(val);
			}
			return;
		}
		for(int i=0; i<digits.size(); ++i){
			if(length==0&&digits[i]==0) continue;
			if(seen[i]) continue;
			seen[i]=true;
			dfs(digits[i], val, length+1, digits, seen);
			seen[i]=false;
		}
	}

    vector<int> findEvenNumbers(vector<int>& digits) {
        int n=digits.size();
        vector<bool>seen(n, false);
        dfs(0, 0, 0, digits, seen);
        return {ans.begin(), ans.end()};
    }
};