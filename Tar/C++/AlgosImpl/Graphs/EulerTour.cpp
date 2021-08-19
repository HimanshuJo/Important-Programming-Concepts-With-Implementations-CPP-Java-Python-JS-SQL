#include<bits/stdc++.h>
using namespace std;
#define MAX 1001

// We need an Adjacency list representation of the tree
vector<int>adj[MAX];

// We need a visited array to keep track of all the visited nodes on the tour
int vis[MAX];

// We need an array to store the Euler Tour
int euler[2*MAX];

void addEdge(int u,int v){
    adj[u].push_back(v);
    adj[v].push_back(u);
}

void eulerTour(int u,int &indx){
    vis[u]=1;
    euler[indx++]=u;
    for (auto it: adj[u]){
        if (!vis[it]){
            eulerTour(it, indx);
            euler[indx++]=u;
        }
    }
}

void printEulerTour(int root,int N){
    int index=0;
    eulerTour(root, index);
    for (int i=0; i<(2*N-1); ++i){
        cout<<euler[i]<<" ";
    }
}

int main(){
    int N=4;
    addEdge(1,2);
    addEdge(2,3);
    addEdge(2,4);
    printEulerTour(1,N);
    return 0;
}