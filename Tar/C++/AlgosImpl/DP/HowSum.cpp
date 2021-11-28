#include<vector>
#include<iostream>
#include<map>
using namespace std;

int howSum(int targetSum, vector<int>&in, vector<int>&res){
	if(targetSum==0) return 1;
	if(targetSum<0) return INT_MAX;
	for(auto &vals: in){
		int remain=targetSum-vals;
		int currRes=howSum(remain, in, res);
		if(currRes!=INT_MAX){
			res.push_back(vals);
			return 1;
		}
	}
	return INT_MAX;
}

vector<int> howSumDp(int targetSum, vector<int>&in, vector<int>&res, map<int, vector<int>>&memo){
	if(targetSum==0) return res;
	if(targetSum<0) return {INT_MAX};
	auto it=memo.find(targetSum);
	if(it!=memo.end()){
		return memo[targetSum];
	}
	for(auto &vals: in){
		int remain=targetSum-vals;
		vector<int> currRes=howSumDp(remain, in, res, memo);
		if(currRes.size()>0&&currRes[0]==INT_MAX) continue;
		res.push_back(vals);
		return memo[targetSum]=res;
	}
	return memo[targetSum]={INT_MAX};
}


int main(){
	vector<int>in{7, 14};
	int targetSum=300;
	vector<int>res;
	map<int, vector<int>>memo;
	//howSum(targetSum, in, res);
	howSumDp(targetSum, in, res, memo);
	if(res.size()==0) cout<<"null\n";
	for(auto &nums: res){
		cout<<nums<<" ";
	}
}

