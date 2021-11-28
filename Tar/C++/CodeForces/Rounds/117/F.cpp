#include<iostream>
#include<vector>
#include<set>
#include<algorithm>
using namespace std;
using ll=long long;

int n, m;
int ans=INT_MAX;
set<int>st[200001];

void dfs(int currArm, int currWep, bool arm, bool wep, int currT){
	int currS=currArm+currWep+(st[currArm].find(currWep)!=st[currArm].end());
	if(currS>=n&&!wep){
		dfs(n, currWep, 0, 1, ++currT);
		return;
	}
	if(currS>=m){
		ans=min(ans, currT);
		return;
	}
	if(currArm+currS>=n&&!wep){
		dfs(currArm, currS, 0, 0, ++currT);
	}
	if(currArm==n){
		dfs(n, currS, 0, 1, currT+1);
		return;
	}
	if(arm) dfs(currS, currWep, !arm, wep, ++currT);
	else dfs(currArm, currS, !arm, wep, ++currT);
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin>>n>>m;
	int q;
	cin>>q;
	for(int i=0; i<q; ++i){
		int a, b;
		cin>>a>>b;
		if(n>m) swap(a, b);
		st[a].insert(b);
	}
	if(n>m) swap(n, m);
	dfs(1, 1, 0, 0, 0);
	dfs(1, 1, 1, 0, 0);
	cout<<ans+1<<"\n";
}
