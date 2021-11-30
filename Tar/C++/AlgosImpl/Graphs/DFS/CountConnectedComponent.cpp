#include<iostream>
#include<vector>
#include<unordered_Set>
#include<unordered_map>
using namespace std;

bool explore(unordered_map<int, vector<int>>&gr, int node, unordered_set<int>&seen){
	if(seen.find(node)!=seen.end()) return false;
	seen.insert(node);
	for(auto &nei: gr[node]){
		explore(gr, nei, seen);
	}
	return true;
}

int countConnectedComponent(unordered_map<int, vector<int>>&gr){
	unordered_set<int>seen;
	int count=0;
	for(auto &entries: gr){
		if(explore(gr, entries.first, seen)){
			count+=1;
		}
	}
	return count;
}

int main(){
	unordered_map<int, vector<int>>graph(10);
	graph[0]={8, 1, 5};
	graph[1]={0};
	graph[5]={0, 8};
	graph[8]={0, 5};
	graph[2]={3, 4};
	graph[3]={2, 4};
	graph[4]={3, 2};
	int ans=countConnectedComponent(graph);
	cout<<ans<<"\n";
}
