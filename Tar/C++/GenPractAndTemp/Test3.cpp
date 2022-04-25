#include<iostream>
#include<vector>
using namespace std;

vector<vector<int>>res;

int dfs(int n, int m, int runN, int currSum, vector<int>temp){
	if(runN<m) return 0;
	if(currSum>n) return 0;
	if(currSum==n){
		res.push_back(temp);
		return 1;
	}
	currSum+=runN;
	temp.push_back(runN);
	int lft=dfs(n, m, runN, currSum, temp);
	currSum-=runN;
	temp.pop_back();
	int rght=dfs(n, m, runN-1, currSum, temp);
	return lft+rght;
}

int diffWaysSumGrEqM(int n, int m){
	int bgn=n;
	int currSum=0;
	vector<int>temp;
	return dfs(n, m, bgn, currSum, temp);
}

int main(){
	int n=30, m=1;
	int ans=diffWaysSumGrEqM(n, m);
	cout<<ans<<endl;
	cout<<"-------\n";
	for(auto &entries: res){
		for(auto &vals: entries){
			cout<<vals<<" ";
		}
		cout<<endl;
	}
}