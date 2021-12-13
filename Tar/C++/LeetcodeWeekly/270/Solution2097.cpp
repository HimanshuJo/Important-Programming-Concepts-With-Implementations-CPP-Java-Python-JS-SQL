// 2097. Valid Arrangement of Pairs
/*
You are given a 0-indexed 2D integer array pairs where pairs[i] = [starti, endi]. 
An arrangement of pairs is valid if for every index i where 1 <= i < pairs.length, we have endi-1 == starti.

Return any valid arrangement of pairs.

Example 1:

Input: pairs = [[5,1],[4,5],[11,9],[9,4]]
Output: [[11,9],[9,4],[4,5],[5,1]]
Explanation:
This is a valid arrangement since endi-1 always equals starti.
end0 = 9 == 9 = start1 
end1 = 4 == 4 = start2
end2 = 5 == 5 = start3

Example 2:

Input: pairs = [[1,3],[3,2],[2,1]]
Output: [[1,3],[3,2],[2,1]]
Explanation:
This is a valid arrangement since endi-1 always equals starti.
end0 = 3 == 3 = start1
end1 = 2 == 2 = start2
The arrangements [[2,1],[1,3],[3,2]] and [[3,2],[2,1],[1,3]] are also valid.

Example 3:

Input: pairs = [[1,2],[1,3],[2,1]]
Output: [[1,2],[2,1],[1,3]]
Explanation:
This is a valid arrangement since endi-1 always equals starti.
end0 = 2 == 2 = start1
end1 = 1 == 1 = start2
*/

/*
Idea

if we view each start_i and end_i as nodes in a graph, elements in pairs as (directed) edges in the graph, 
then the problem is asking us to find a path in the corresponding directed graph.
the problem ask us to use up all edges, so we are basically asked to find a Eulerian Path, which is a path 
that walks through each edge exactly once.

Some Properties of Eulerian Path

I will use in[i] (and out[i]) to denote the in (and out) degree of a node i.
Existence:
A graph has an Eulerian Path if and only if
we have out[i] == in[i] for each node i. Or
we have out[i] == in[i] for all nodes i except exactly two nodes x and y, with out[x] = in[x] + 1, out[y] = in[y] - 1.
this problem guarantees that an Eulerian Path exists. So we don't need to check for its existence here.
In the first case (out[i] == in[i] for each node i), all Eulerian Paths are also Eulerian Circuits (Eulerian Path with starting point == ending point).
a node with out[i] == in[i] + 1 must be the starting point of an Eulerian Path (if there exists one).
Algorithm

find the starting point of an Eulerian Path.
if we have out[i] == in[i] for all i, we can start at an arbitrary node.
perform postorder DFS on the graph, as we "walk" through an edge, we erase (or mark it visited) the walked edge.
we may reach the same node many times, but we have to pass each edge exactly once.
I use stack in my code for erasing edges.
*/

#include<iostream>
#include<vector>
#include<unordered_map>
#include<stack>
#include<algorithm>
using namespace std;

class Solution {
public:
    vector<vector<int>> validArrangement(vector<vector<int>>& pairs) {
   		int m=pairs.size();
   		unordered_map<int, stack<int>>adj;
   		unordered_map<int, int>in;
   		unordered_map<int, int>out;
   		adj.reserve(m);
   		in.reserve(m);
   		out.reserve(m);
   		for(int i=0; i<m; ++i){
   			int u=pairs[i][0], v=pairs[i][1];
   			in[v]++;
   			out[u]++;
   			adj[u].push(v);
   		}
   		int start=-1;
   		for(auto &p: adj){
   			int i=p.first;
   			if(out[i]-in[i]==1) start=i;
   		}     
   		if(start==-1) start=adj.begin()->first;
   		vector<vector<int>>ans;
   		euler(adj, ans, start);
   		reverse(ans.begin(), ans.end());
   		return ans;
    }

private:
	void euler(unordered_map<int, stack<int>>&adj, vector<vector<int>>&ans, int curr){
		auto &stk=adj[curr];
		while(!stk.empty()){
			int nei=stk.top();
			stk.pop();
			euler(adj, ans, nei);
			ans.push_back({curr, nei});
		}
	}
};

int main(){
	Solution obj;
	vector<vector<int>>pairs{{999,990},{356,511},{192,879},{246,945},{322,602},{776,246},{248,126},{503,284},{126,164},{494,731},{862,382},{731,578},{511,277},{122,731},{578,99},{731,277},{847,538},{246,494},{284,138},{382,899},{811,439},{164,99},{485,307},{618,320},{494,511},{413,248},{945,356},{990,614},{138,18},{164,862},{277,164},{826,737},{277,322},{618,122},{291,639},{288,11},{624,485},{740,452},{614,740},{307,903},{457,412},{538,961},{439,122},{961,999},{639,822},{903,503},{961,776},{138,538},{122,826},{99,138},{949,175},{452,847},{320,624},{879,457},{511,961},{835,692},{18,949},{737,413},{822,999},{11,726},{692,618},{899,835},{726,192},{999,452},{602,811},{452,618},{175,246},{99,291},{412,494}};
	vector<vector<int>>res=obj.validArrangement(pairs);
	for(auto &vals: res){
		for(auto &nums: vals)
			cout<<nums<<" ";
		cout<<endl;
	}	
}