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
	cout << "urank " << u << " " << uRank[u] << endl;
	cout << "urank " << v << " " << uRank[v] << endl;
	cout << "parent " << u << " " << parent[u] << endl;
	cout << "parent " << v << " " << parent[v] << endl;
	cout << "-------\n";
}

int main(){
	int N;
	//cin>>N;
	N=7;
	makeSet(N);
	int M;
	//cin>>M;
	M=6;
	int u1, v1, u2, v2, u3, v3, u4, v4, u5, v5, u6, v6;
	//cin>>u>>v;
	u1=1, v1=2;
	u2=3, v2=4;
	u3=2, v3=4;
	u4=7, v4=6;
	u5=6, v5=5;
	u6=1, v6=7;
	doUnion(u1, v1);
	doUnion(u2, v2);
	doUnion(u3, v3);
	doUnion(u4, v4);
	doUnion(u5, v5);
	doUnion(u6, v6);
}
