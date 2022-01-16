#include<iostream>
#include<vector>
using namespace std;

int dfs(vector<int>&coordsSgn, vector<int>&spdLim, int n, vector<vector<int>>&memo, int idx, int currT, int k){
	if(idx==n) return 0;
	if(memo[idx][k]!=-1) return memo[idx][k];
	int minT=INT_MAX;
	for(int rem=0; rem<=k; ++rem){
		if(idx+rem>=n) break;
		int currDist=abs(coordsSgn[idx]-coordsSgn[idx+rem+1]);
		int fct=spdLim[idx];
		currT=(currDist*fct);
		minT=min(minT, currT+dfs(coordsSgn, spdLim, n, memo, idx+rem+1, currT, k-rem));
	}
	return memo[idx][k]=minT;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int n, l, k;
	cin>>n>>l>>k;
	vector<int>coordsSgn(n+1);
	for(int i=0; i<n; ++i)
		cin>>coordsSgn[i];
	coordsSgn[n]=l;
	vector<int>spdLim(n);
	vector<vector<int>>memo(n+1, vector<int>(n+1, -1));
	for(int i=0; i<n; ++i)
		cin>>spdLim[i];
	int currT=0;
	int ans=dfs(coordsSgn, spdLim, n, memo, 0, currT, k);
	cout<<ans<<"\n";
}
