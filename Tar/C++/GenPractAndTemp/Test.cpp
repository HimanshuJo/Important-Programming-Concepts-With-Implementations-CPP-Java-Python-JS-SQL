#include<vector>
#include<iostream>
using namespace std;

int main(){
	vector<vector<vector<int>>>dp(5+5, {{INT_MAX}});
	dp[0]={{}};
	for(auto &vals: dp[0])
		vals.push_back(12);
	for(auto &vals: dp[0]){
		for(auto &nums: vals)
			cout<<nums<<" ";
		cout<<"\n-------\n";
	}
	cout<<dp[1].size();
}
