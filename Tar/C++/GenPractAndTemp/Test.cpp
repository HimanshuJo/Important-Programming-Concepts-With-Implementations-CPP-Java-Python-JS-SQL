#include<vector>
#include<iostream>
#include<set>
using namespace std;

int N, M;

bool dfs(vector<string>&grd, int i, int j, set<pair<int, int>>&seen){
	if(i<0||i>=grd.size()||j<0||j>=M||seen.find({i, j})!=seen.end()) return false;
	if(grd[i][j]=='#'){
		seen.insert({i, j});
		return true;
	}
	if(dfs(grd, i-1, j, seen)){
		grd[i][j]='+';
		seen.insert({i, j});
	}
	if(dfs(grd, i, j-1, seen)){
		grd[i][j]='+';
		seen.insert({i, j});
	}
	/*if(dfs(grd, i+1, j, seen)){
		grd[i][j]='+';
		seen.insert({i, j});
	}*/
	/*if(dfs(grd, i, j+1, seen)){
		grd[i][j]='+';
		seen.insert({i, j});
	}*/
	return false;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin>>t;
	while(t--){
		int n, m;
		cin>>n>>m;
		N=n;
		M=m;
		vector<string>grd(n);
		for(int i=0; i<n; ++i){
			string in;
			cin>>in;
			grd[i]=in;
		}
		set<pair<int, int>>seen;
		bool flag=false;
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				if(grd[i][j]=='L'){
					//cout<<grd[i][j]<<endl;
					dfs(grd, i, j, seen);
					flag=true;
					break;
				}
			}
			if(flag) break;
		}
		for(int i=0; i<n; ++i)
			cout<<grd[i]<<endl;
	}
}

