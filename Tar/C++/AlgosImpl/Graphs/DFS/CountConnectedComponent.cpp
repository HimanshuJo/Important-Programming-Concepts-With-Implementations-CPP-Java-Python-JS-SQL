#include<iostream>
#include<vector>
#include<unordered_Set>
#include<unordered_map>
#include<set>
using namespace std;

vector<set<int>>allComps;

bool explore(unordered_map<int, vector<int>>&gr, int node, unordered_set<int>&seen, set<int>&currComp){
	if(seen.find(node)!=seen.end()) return false;
	seen.insert(node);
	for(auto &nei: gr[node]){
		explore(gr, nei, seen, currComp);
	}
	currComp.insert(node);
	return true;
}

int countConnectedComponent(unordered_map<int, vector<int>>&gr){
	unordered_set<int>seen;
	int count=0;
	for(auto &entries: gr){
		set<int>currComp;
		currComp.insert(entries.first);
		if(explore(gr, entries.first, seen, currComp)){
			count+=1;
			allComps.push_back(currComp);
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
	cout<<"-------\n";
	for(auto &vals: allComps){
		for(auto &nums: vals){
			cout<<nums<<" ";
		}
		cout<<endl;
	}
}
