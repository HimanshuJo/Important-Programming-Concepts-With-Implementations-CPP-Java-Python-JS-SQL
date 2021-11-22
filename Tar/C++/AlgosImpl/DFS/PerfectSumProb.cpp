#include<vector>
#include<iostream>
using namespace std;

bool **dp;

void disp(const vector<int>&vec){
	for(int i=0; i<vec.size(); ++i){
		cout<<vec[i]<<" ";
	}
	cout<<"\n";
}

void pspUtil(int arr[], int idx, int sum, vector<int>&vec){
	if(idx==0&&sum!=0&&dp[0][sum]){
		vec.push_back(arr[idx]);
		if(arr[idx]==sum){
			disp(vec);
		}
		return;
	}
	if(idx==0&&sum==0){
		disp(vec);
		return ;
	}
	if(dp[idx-1][sum]){
		vector<int>temp=vec;
		pspUtil(arr, idx-1, sum, temp);
	}
	if(sum>=arr[idx]&&dp[idx-1][sum-arr[idx]]){
		vec.push_back(arr[idx]);
		pspUtil(arr, idx-1, sum-arr[idx], vec);
	}
}

void psp(int arr[], int n, int sum){
	if(n==0||sum<0){
		return ;
	}
	dp=new bool*[n];
	for(int i=0; i<n; ++i){
		dp[i]=new bool[sum+1];
		dp[i][0]=true;
	}
	for(int i=1; i<n; ++i){
		for(int j=0; j<sum+1; ++j){
			dp[i][j]=(arr[i]<=j)?dp[i-1][j]||dp[i-1][j-arr[i]]:dp[i-1][j];
			if(dp[n-1][sum]==false){
				return;
			}
		}
	}
	vector<int>p;
	pspUtil(arr, n-1, sum, p);
}

int main(){
	int arr[]={2, 3, 5, 6, 8, 10};
	int sum=10;
	int n=sizeof(arr)/sizeof(int);
	psp(arr, n, sum);
}
