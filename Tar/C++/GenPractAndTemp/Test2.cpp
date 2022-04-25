#include<iostream>
#include<vector>
using namespace std;

int diffWaysSumGrEqM(int n, int m){
	vector<vector<int>>dp(n+2, vector<int>(n+2, 0));
	dp[0][n+1]=1;
	for(int num=n; num>=m; --num){
		for(int sum=0; sum<=n; ++sum){
			dp[sum][num]=dp[sum][num+1];
			if(sum-num>=0){
				dp[sum][num]+=dp[sum-num][num];
			}
		}
	}
	return dp[n][m];
}

int main(){
	int n=30, m=1;
	int ans=diffWaysSumGrEqM(n, m);
	cout<<ans<<endl;
}