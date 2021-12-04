#include<vector>
#include<iostream>
#include<set>
using namespace std;

bool isValid(vector<string>&grd, int N, int M, int i, int j){
	if(i<0||i>=N||j<0||j>=M||grd[i][j]!='.') return false;
	return true;
}

void dfs(vector<string>&grd, vector<pair<int, int>>&dir, int N, int M, int i, int j){
	int cnt=0;
	for(auto &vals: dir){
		pair<int, int>curr=vals;
		if(isValid(grd, N, M, i+curr.first, j+curr.second)){
			cnt++;
		}
	}
	if(cnt<=1){
		grd[i][j]='+';
		for(auto &vals: dir){
			pair<int, int>curr=vals;
			if(isValid(grd, N, M, i+curr.first, j+curr.second)){
				dfs(grd, dir, N, M, i+curr.first, j+curr.second);
			}
		}
	}
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin>>t;
	while(t--){
		int n, m;
		cin>>n>>m;
		vector<string>grd(n);
		for(int i=0; i<n; ++i){
			string in;
			cin>>in;
			grd[i]=in;
		}
		bool flag=false;
		int i_, j_;
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				if(grd[i][j]=='L'){
					i_=i, j_=j;
					flag=true;
					break;
				}
			}
			if(flag) break;
		}
		vector<pair<int, int>>dir{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
		for(auto &vals: dir){
			pair<int, int>curr=vals;
			if(isValid(grd, n, m, i_+curr.first, j_+curr.second)){
				dfs(grd, dir, n, m, i_+curr.first, j_+curr.second);
			}
		}
		for(int i=0; i<n; ++i)
			puts(grd[i].c_str());
	}
}
