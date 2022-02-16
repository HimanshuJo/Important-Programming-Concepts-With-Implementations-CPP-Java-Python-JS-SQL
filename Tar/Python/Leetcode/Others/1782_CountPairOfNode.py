'''
You are given an undirected graph represented by an integer n, which is the number of nodes, 
and edges, where edges[i] = [ui, vi] which indicates that there is an undirected edge 
between ui and vi. You are also given an integer array queries.

The answer to the jth query is the number of pairs of nodes (a, b) that satisfy the following conditions:

    a < b

    cnt is strictly greater than queries[j], where cnt is the number of edges incident to a or b.

Return an array answers such that answers.length == queries.length and 
answers[j] is the answer of the jth query.

Note that there can be repeated edges.

Input: n = 4, edges = [[1,2],[2,4],[1,3],[2,3],[2,1]], queries = [2,3]
Output: [6,5]
Explanation: The number of edges incident to at least one of each pair is shown above.

Example 2:

Input: n = 5, edges = [[1,5],[1,5],[3,4],[2,5],[1,3],[5,1],[2,3],[2,5]], queries = [1,2,3,4,5]
Output: [10,10,9,8,6]

'''
'''
Brute Force:

class Solution {
public:
    vector<int> countPairs(int n, vector<vector<int>>& edges, vector<int>& queries) {
        map<pair<int, int>, vector<vector<int>>>mp1;
        for(int i=1; i<=n; ++i){
            for(int j=1; j<=n; ++j){
                if(i!=j&&i<j){
                    vector<vector<int>>temp;
                    for(auto &vals: edges){
                        if(vals[0]==i||vals[1]==i||vals[0]==j||vals[1]==j){
                            temp.push_back(vals);
                        }
                    }
                    mp1[{i, j}]=temp;
                }
            }
        }
        map<pair<int, int>, int>mp2;
        for(auto &entries: mp1){
            mp2[entries.first]=entries.second.size();
        }
        vector<int>ans;
        for(auto &vals: queries){
            int curans=0;
            for(auto &entries: mp2){
                if(entries.second>vals){
                    curans++;
                }
            }
            ans.push_back(curans);
        }
        return ans;
    }
};
'''

'''
Solution 2

Answer for each query is: total pairs of (u,v) such that

degree[u] + degree[v] - edgeCount(u,v) > query
This is O(n^2), which will give TLE.

But it can be broken into two steps, which will help in optimization.
The bifurcation of problem :

First count such pairs of (u,v) : degree[u] + degree[v] > val (using two pointer approach)
Then consider the edgeCount and remove the contribution of edge

class Solution {
public:
    map<pair<int, int>, int>edgeCount;
    vector<int>degree;
    
    vector<int> countPairsHelper(vector<int>&indegree, vector<int>&queries, int n){
        vector<int>ans;
        
        // for each query, time: O(2*n) for two pointer and O(uniqueEdgesCount)
        for(int query: queries){         
            // two pointer 
            int i = 0, j = n-1, total = 0;
            while(i != j){
                if(degree[i] + degree[j] > query){
                    j--;
                }
                else{
                    total += (n-j-1);
                    i++;
                }
            }
            while(i < n){
                total += (n-i-1);
                i++;
            }
            
            
            // remove the negative contribution of edgeCount from all the pairs so far counted
            for(auto i: edgeCount){
                int u = i.first.first, v = i.first.second, w = i.second;
                // cout<<indegree[u] + indegree[v] - w<<endl;
                if(indegree[u] + indegree[v] > query && indegree[u] + indegree[v] - w <= query){
                    total -= 1;
                }
            }
            ans.push_back(total);
        }
        return ans;
    }
    vector<int> countPairs(int n, vector<vector<int>>& edges, vector<int>& queries) {
        
        vector<int>indegree(n, 0);
        for(auto edge: edges){
            int x = edge[0], y = edge[1];
            int u = min(x,y);
            int v = max(x,y);
            --u, --v;
            edgeCount[{u,v}] += 1;
            indegree[u]++;
            indegree[v]++;
        }
        
        for(int i = 0; i < n; ++i){
            degree.push_back(indegree[i]);
        }
        sort(degree.begin(), degree.end()); // sort degree to apply smart two pointer
        return countPairsHelper(indegree, queries, n);
    }
};
'''

class Solution:
    def countPairs(self, n: int, edges: List[List[int]], queries: List[int]) -> List[int]:
        degree = [0] * (n + 1)
        edgeCount = defaultdict(int)
        for u, v in edges:
        	degree[u] += 1
        	degree[v] += 1
        	if u > v:
        		u, v = v, u
    		edgeCount[(u, v)] += 1
		sortedDegree = sorted(degree[1:])
		ans = []
		for val in queries:
			count = 0
			r = n
			for l in range(n - 1):
				while r - 1 > l and sortedDegree[l] + sortedDegree[r - 1] > val:
					r -= 1 
				if l < r:
					count += n - r
				else:
					count += n - l - 1

			# remove invalid pairs
			# only the pairs who have a common edge could potentially affect our count
			for u, v in edgeCount:
				if degree[u] + degree[v] > val and degree[u] + degree[v] - edgeCount[(u, v)] <= val:
					count -= 1
			ans.append(count)
		return ans