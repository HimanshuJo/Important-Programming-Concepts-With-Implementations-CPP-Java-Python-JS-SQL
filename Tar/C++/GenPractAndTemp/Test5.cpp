#include<vector>
#include<iostream>
#include<set>
using namespace std;

int parent[100000];

int root(int a){
	if(a==parent[a]) return a;
	return (parent[a]=root(parent[a]));
}

void connect(int a, int b){
	a=root(a);
	b=root(b);
	if(a!=b){
		parent[b]=a;
	}
}

int connectedComponentsUtil(int n){
	set<int>s;
	for(int i=0; i<n; ++i){
		s.insert(root(parent[i]));
	}
	return s.size();
}

int connectedComponents(int n, vector<vector<int>>&edges){
	for(int i=0; i<=n; ++i){
		parent[i]=i;
	}
	int sz=edges.size();
	for(int i=0; i<sz; ++i){
		connect(edges[i][0], edges[i][1]);
	}
	int ans=connectedComponentsUtil(n);
	return ans;
}

int main(){
	int n=8;
	vector<vector<int>>edges{{1, 0},  {0, 2}, {5, 3}, {3, 4}, {6, 7}};
	int cnt=connectedComponents(n, edges);
	cout<<cnt<<endl;
}