#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int dfs(vector<int>&in, const int sz, int idx, vector<int>&memo){
	if(memo[idx]!=-1) return memo[idx];
	if(idx==sz) return 0;
	int res=1;
	if(idx+1<=sz-1&&in[idx]<in[idx+1]){
		res=max(res, max(1+dfs(in, sz, idx+1, memo), dfs(in, sz, idx+1, memo)));
	} else{
		res=max(res, dfs(in, sz, idx+1, memo));
	}
	return memo[idx]=res;
}

int lisRec(vector<int>&in, const int sz, int idx){
	vector<int>memo(sz+1, -1);
	return dfs(in, sz, idx, memo);
}

int lisDp(vector<int>&in, const int sz){
	vector<int>dp(sz+1, 0);
	for(int i=0; i<sz; ++i){
		for(int j=0; j<i; ++j){
			if(in[i]>in[j]&&dp[i]<dp[j]+1){
				dp[i]=dp[j]+1;
			}
		}
	}
	sort(dp.begin(), dp.end());
	return dp[sz];
}

int lisLCS(vector<int>&in, vector<int>&temp, const int sz){
	vector<vector<int>>dp(sz+1, vector<int>(sz+1, 0));
	for(int i=1; i<=sz; ++i){
		for(int j=1; j<=sz; ++j){
			if(in[i-1]==temp[j-1]){
				dp[i][j]=dp[i-1][j-1]+1;
			} else{
				dp[i][j]=max(dp[i-1][j], dp[i][j-1]);
			}
		}
	}
	return dp[sz][sz];
}

vector<int> returnLIS(vector<int>&in, vector<int>&temp, const int sz){
	vector<vector<int>>dp(sz+1, vector<int>(sz+1, 0));
	for(int i=1; i<=sz; ++i){
		for(int j=1; j<=sz; ++j){
			if(in[i-1]==temp[j-1]){
				dp[i][j]=dp[i-1][j-1]+1;
			} else{
				dp[i][j]=max(dp[i-1][j], dp[i][j-1]);
			}
		}
	}
	int i=sz, j=sz, index=dp[sz][sz];
	vector<int>res(index, 0);
	while(i>0&&j>0){
		if(in[i-1]==temp[j-1]){
			res[index-1]=in[i-1];
			--i, --j, --index;
		} else if(dp[i-1][j]>dp[i][j-1]){
			--i;
		} else --j;
	}
	return res;
}

int main(){
	vector<int>in{50, 3, 10, 7, 40, 80};
	int sz=in.size();
	int res=lisRec(in, sz, 0, memo);
	cout<<res<<endl;
	cout<<"-------\n";
	vector<int>temp=in;
	sort(temp.begin(), temp.end());
	int res2=lisLCS(in, temp, sz);
	cout<<res2<<endl;
	cout<<"-------\n";
	int res3=lisDp(in, sz);
	cout<<res3<<endl;
	cout<<"-------\n";
	vector<int>res4=returnLIS(in, temp, sz);
	for(auto &vals: res4){
		cout<<vals<<" ";
	}
}