#include<iostream>
#include<string>
using namespace std;

char parent[100], sz[100];
vector<bool>current(26, false);
vector<bool>temp(26, false);
unordered_map<char, int>mp;
unordered_map<int, char>mp2;

void initialize(){
	int counter=0;
	for(char ch='a'; ch<='z'; ++ch){
		parent[counter]=ch;
		sz[counter]=1;
		mp[ch]=counter;
		mp[counter]=ch;
		counter++;
	}
}

char root(char node){
	if(parent[mp[node]]==node) return node;
	return (parent[mp[node]]=root(parent[mp[node]]));
}

void connect(char a, char b){
	a=root(a), b=root(b);
	if(a!=b){
		if(sz[mp[a]]<sz[mp[b]]){
			swap(a, b);
		}
		sz[mp[a]]+=sz[mp[b]];
		parent[mp[b]]=a;
	}
}

int countDistinctGroupsUtil(){
	int distinctCnt=0;
	for(int i=0; i<26; ++i){
		if(temp[j]&&root(i))
	}
}

int countDistinctGroups(vector<string>&arr, int N){
	for(int i=0; i<N; ++i){
		string curr=arr[i];
		for(int j=0; j<26; ++j){
			current[j]=false;
		}
		int currsz=curr.length();
		for(int x=0; x<currsz; ++x){
			current[mp[curr[x]]]=true;
		}
		for(int k=0; k<26; ++k){
			if(current[k]==true){
				temp[j]=true;
				connect(curr[0], mp[k]);
			}
		}
	}
}

int main(){
	vector<string>arr{"hemnshh", "s", "a", "h", "o"};
	int N=arr.size();
	int res=countDistinctGroups(arr, N);
	cout<<res<<endl;
}