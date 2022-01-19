#include<vector>
#include<iostream>
using namespace std;
using ll=long long;

const int mod=998244353;
ll dp[1005][1005][2];


int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	string x, y;
	cin>>x>>y;
	int n=x.length(), m=y.length();
	x.push_back('#'), y.push_back('#');
	vector<ll>suff1(n+1);
	suff1[n-1]=1;
	for(int i=n-2; i>=0; --i){
		int j;
		for(j=i; j<n-1; ++j){
			if(x[j]==x[j+1]) break;
		}
		suff1[i]=j-i+1;
	}
	cout<<"-------\n";
	for(auto &vals: suff1){
		cout<<vals<<" ";
	}
	cout<<"\n-------\n";
	vector<ll>suff2(m+1);
	suff2[m-1]=1;
	for(int i=m-2; i>=0; --i){
		int j;
		for(j=i; j<m-1; ++j){
			if(y[j]==y[j+1]) break;
		}
		suff2[i]=j-i+1;
	}
	for(auto &vals: suff2){
		cout<<vals<<" ";
	}
	for(int i=0; i<1005; ++i){
		for(int j=0; j<1005; ++j){
			dp[i][j][0]=dp[i][j][1]=0;
		}
	}
	for(int i=n-1; i>=0; --i){
		for(int j=m-1; j>=0; --j){
			dp[i][j][0]=(x[i]==x[i+1]?0:dp[i+1][j][0])+(x[i]==y[j]?0:dp[i+1][j][1])+(x[i]==y[j]?0:suff2[j]);
			dp[i][j][0]%=mod;
			dp[i][j][1]=(y[j]==y[j+1]?0:dp[i][j+1][1])+(x[i]==y[j]?0:dp[i][j+1][0])+(x[i]==y[j]?0:suff1[i]);
			dp[i][j][1]%=mod;
		}
	}
	ll ans=0;
	for(int i=0; i<n; ++i){
		for(int j=0; j<m; ++j){
			ans=(ans+dp[i][j][0]+dp[i][j][1])%mod;
		}
	}
	cout<<endl;
	cout<<ans;
}
