#include<iostream>
#include<vector>
#include<unordered_map>
#include<cstring>
using namespace std;

int query(vector<int>&temp, int N){
	vector<int>curr={3, 2, 1, 5, 4};
	for(int i=0; i<N; ++i){
		temp[i]+=curr[i];
	}
	int res=INT_MAX;
	unordered_map<int, int>mp;
	for(int i=0; i<N; ++i){
		mp[temp[i]]++;
	}
	vector<int>dups;
	for(auto &entry: mp){
		if(entry.second>1){
			dups.push_back(entry.first);
		}
	}
	for(auto &vals: dups){
		for(int i=0; i<N; ++i){
			if(temp[i]==vals){
				res=min(res, i);
			}
		}
	}
	return res==INT_MAX?-1:res;
}


int main(){
	int N;
	cin>>N;
	int res[N];
	memset(res, 0, sizeof(res));
	res[N-1]=N;
	for(int i=1; i<N; ++i){
		vector<int>temp(N, i+1);
		temp[N-1]=1;
		if(query(temp, N)==-1){
			res[N-1]=i;
			break;
		}
	}
	for(int i=1; i<res[N-1]; ++i){
		vector<int>temp(N, i+1);
		temp[N-1]=1;
		int loc=query(temp, N);
		res[loc]=res[N-1]-i;
	}
	for(int i=1; i<=N-res[N-1]; ++i){
		vector<int>temp(N, i);
		temp[N-1]+=i;
		int loc=query(temp, N);
		res[loc]=res[N-1]+i;
	}
	for(int x: res){
		cout<<x<<" ";
	}
}
