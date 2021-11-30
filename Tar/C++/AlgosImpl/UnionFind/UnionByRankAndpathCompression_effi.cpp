#include<vector>
#include<iostream>
using namespace std;

int parent[100000];
int uRank[100000];

void makeSet(int n){
	for(int i=1; i<=n; ++i){
		parent[i]=i;
		uRank[i]=0;
	}
}

int findParent(int node){
	if(node==parent[node]) return node;

	return parent[node]=findParent(parent[node]);
}

void doUnion(int u, int v){
	u=findParent(u);
	v=findParent(v);
	if(uRank[u]<uRank[v]) parent[u]=v;
	else if(uRank[v]<uRank[u]) parent[v]=u;
	else{
		parent[v]=u;
		uRank[u]++;
	}
}

int main(){
	int N;
	//cin>>N;
	N=10;
	makeSet(N);
	int M;
	//cin>>M;
	M=1;
	while(M--){
		int u, v;
		//cin>>u>>v;
		u=2, v=3;
		doUnion(u, v);
		if(findParent(u)!=findParent(v)){
			cout<<"Different\n";
		} else cout<<"Same\n";
	}
}
