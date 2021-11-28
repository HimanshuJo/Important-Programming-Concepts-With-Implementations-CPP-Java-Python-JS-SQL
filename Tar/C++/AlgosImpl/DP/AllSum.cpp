#include<vector>
#include<iostream>
#include<map>
#include<set>
#include<algorithm>
using namespace std;

set<vector<int>>fnRes;

vector<int> bestSumDp(int targetSum, vector<int>&in, vector<int>&res, map<int, vector<int>>&memo, int idx){
	if(targetSum==0) return res;
	if(targetSum<0) return {INT_MAX};
	auto it=memo.find(targetSum);
	if(it!=memo.end()){
		return memo[targetSum];
	}
	for(int i=idx; i<in.size(); ++i){
		int remain=targetSum-in[i];
		vector<int> currRes=bestSumDp(remain, in, res, memo, i);
		if(currRes.size()>0&&currRes[0]==INT_MAX) continue;
		res.push_back(in[i]);
		return memo[targetSum]=res;
	}
	return memo[targetSum]={INT_MAX};
}

int main(){
	vector<int>in{1, 2, 5, 25};
	int targetSum=100;
	vector<int>res;
	map<int, vector<int>>memo;
	for(int i=0; i<in.size(); ++i){
		bestSumDp(targetSum, in, res, memo, i);
		sort(res.begin(), res.end());
		fnRes.insert(res);
		res.clear();
		memo.clear();
	}
	sort(in.begin(), in.end(), greater<int>());
	for(int i=0; i<in.size(); ++i){
		bestSumDp(targetSum, in, res, memo, i);
		sort(res.begin(), res.end());
		fnRes.insert(res);
		res.clear();
		memo.clear();
	}
	int fnLen=INT_MAX;
	vector<int>ans;
	for(auto &vals: fnRes){
		for(auto &nums: vals)
			cout<<nums<<" ";
		cout<<endl;
	}
	cout<<"-------\n";
	for(auto &vals: fnRes){
		if(vals.size()>0&&vals.size()<fnLen){
			ans=vals;
			fnLen=vals.size();
		}
	}
	for(auto &nums: ans)
		cout<<nums<<" ";
}

