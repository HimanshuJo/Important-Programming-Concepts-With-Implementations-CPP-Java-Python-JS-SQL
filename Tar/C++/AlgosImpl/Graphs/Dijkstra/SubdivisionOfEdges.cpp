#include<iostream>
#include<vector>
#include<queue>
#include<map>
using namespace std;
#define pii pair<int, int>

class Solution{
public:
	int reachableNodes(vector<vector<int>>&edges, int maxMoves, int N){
		vector<vector<pii>>gr(N);
		for(vector<int>edg: edges){
			int u=edg[0], v=edg[1], w=edg[2];
			gr[u].push_back({v, w});
			gr[v].push_back({u, w});
		}
		map<int, int>dist;
		dist[0]=0;
		for(int i=1; i<N; ++i){
			dist[i]=maxMoves+1;
		}
		map<pii, int>seen;
		int ans=0;
		priority_queue<pii, vector<pii>, greater<pii>>pq;
		pq.push({0, 0});
		while(!pq.empty()){
			pii curr=pq.top();
			pq.pop();
			int d=curr.first;
			int node=curr.second;
			if(d>dist[node]) continue;
			ans++;
			for(auto &pair: gr[node]){
				int nei=pair.first;
				int weight=pair.second;
				seen[{node, nei}]=min(weight, maxMoves-d);
				if((d+weight+1)<min(dist[nei], maxMoves+1)){
					dist[nei]=d+weight+1;
					pq.push({dist[nei], nei});
				}
			}
		}
		for(vector<int>edge: edges){
			int u=edge[0], v=edge[1], w=edge[2];
			ans+=min(w, seen[{u, v}]+seen[{v, u}]);
		}
		cout<<ans<<endl;
		return ans;
	}
};

int main(){
	Solution obj;
	vector<vector<int>>edges{{0, 1, 10}, {0, 2, 1}, {1, 2, 2}};
	int maxMoves=6;
	int N=3;
	obj.reachableNodes(edges, maxMoves, N);
}