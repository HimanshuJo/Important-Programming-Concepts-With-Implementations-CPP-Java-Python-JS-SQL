// 1851. Minimum Interval to Include Each Query
/*
You are given a 2D integer array intervals, where intervals[i] = [lefti, righti] describes the ith interval 
starting at lefti and ending at righti (inclusive). The size of an interval is defined as the number of integers 
it contains, or more formally righti - lefti + 1.

You are also given an integer array queries. The answer to the jth query is the size of the smallest interval i 
such that lefti <= queries[j] <= righti. If no such interval exists, the answer is -1.

Return an array containing the answers to the queries.

Example 1:

Input: intervals = [[1,4],[2,4],[3,6],[4,4]], queries = [2,3,4,5]
Output: [3,3,1,4]
Explanation: The queries are processed as follows:
- Query = 2: The interval [2,4] is the smallest interval containing 2. The answer is 4 - 2 + 1 = 3.
- Query = 3: The interval [2,4] is the smallest interval containing 3. The answer is 4 - 2 + 1 = 3.
- Query = 4: The interval [4,4] is the smallest interval containing 4. The answer is 4 - 4 + 1 = 1.
- Query = 5: The interval [3,6] is the smallest interval containing 5. The answer is 6 - 3 + 1 = 4.
Example 2:

Input: intervals = [[2,3],[2,5],[1,8],[20,25]], queries = [2,19,5,22]
Output: [2,-1,4,6]
Explanation: The queries are processed as follows:
- Query = 2: The interval [2,3] is the smallest interval containing 2. The answer is 3 - 2 + 1 = 2.
- Query = 19: None of the intervals contain 19. The answer is -1.
- Query = 5: The interval [2,5] is the smallest interval containing 5. The answer is 5 - 2 + 1 = 4.
- Query = 22: The interval [20,25] is the smallest interval containing 22. The answer is 25 - 20 + 1 = 6.
 

Constraints:

1 <= intervals.length <= 105
1 <= queries.length <= 105
intervals[i].length == 2
1 <= lefti <= righti <= 107
1 <= queries[j] <= 107
*/

class Solution2 {
public:
    vector<int> minInterval(vector<vector<int>>& intervals, vector<int>& queries) {
        unordered_map<int, int>mp;
        vector<int>res;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>>pq;
        int i=0, szI=intervals.size();
        vector<int>tmp=queries;
        int szT=tmp.size();
        sort(queries.begin(), queries.end());
        sort(intervals.begin(), intervals.end());
        for(int q: queries){
            // prepare pq for current query, take into account all possible intervals
            while(i<szI&&intervals[i][0]<=q){
                if(intervals[i][1]>=q){
                    int sz=intervals[i][1]-intervals[i][0]+1;
                    pq.push({sz, intervals[i][1]});   
                }
                ++i;
            }
            while(!pq.empty()&&pq.top().second<q){
                pq.pop();
            }
            if(!pq.empty()){
                mp[q]=pq.top().first;
            } else mp[q]=-1;
        }
        for(int i=0; i<szT; ++i){
            res.push_back(mp[tmp[i]]);
        }
        return res;
    }
};


class Solution {
public:
    
    void update(int *tree, int *lazy, int treeidx, int left, int right, int lo, int hi, int val){
        int lidx=2*treeidx+1, ridx=2*treeidx+2;
        int mid=(hi+lo)/2;
        if(lazy[treeidx]!=INT_MAX){
            if(lazy[treeidx]<tree[treeidx]){
                tree[treeidx]=lazy[treeidx];
                if(lo!=hi){
                    lazy[lidx]=min(lazy[treeidx], lazy[lidx]);
                    lazy[ridx]=min(lazy[treeidx], lazy[ridx]);
                }
            }
            lazy[treeidx]=INT_MAX;
        }
        if(lo>right||hi<left) return;
        if(lo>=left&&hi<=right){
            lazy[treeidx]=min(lazy[treeidx], val);
            return;
        }
        update(tree, lazy, lidx, left, right, lo, mid, val);
        update(tree, lazy, ridx, left, right, mid+1, hi, val);
    }
    
    int query(int *tree, int *lazy, int treeidx, int lo, int hi, int idx){
        int lidx=2*treeidx+1, ridx=2*treeidx+2;
        int mid=(hi+lo)/2;
        if(lazy[treeidx]!=INT_MAX){
            if(lazy[treeidx]<tree[treeidx]){
                tree[treeidx]=lazy[treeidx];
                if(lo!=hi){
                    lazy[lidx]=min(lazy[treeidx], lazy[lidx]);
                    lazy[ridx]=min(lazy[treeidx], lazy[ridx]);
                }
            }
            lazy[treeidx]=INT_MAX;
        }
        if(lo==hi){
            return tree[treeidx];
        }
        if(idx<=mid){
            return query(tree, lazy, lidx, lo, mid, idx);
        } else{
            return query(tree, lazy, ridx, mid+1, hi, idx);   
        }
    }
    
    vector<int> minInterval(vector<vector<int>>& intervals, vector<int>& queries) {
        int n=0;
        int szI=intervals.size();
        for(int i=0; i<szI; ++i){
            n=max(n, intervals[i][1]);
        }
        int szQ=queries.size();
        for(int i=0; i<szQ; ++i){
            n=max(n, queries[i]);
        }
        n++;
        int *tree=new int[4*n], *lazy=new int[4*n];
        for(int i=0; i<4*n; ++i){
            tree[i]=INT_MAX, lazy[i]=INT_MAX;
        }
        for(int i=0; i<szI; i++){
            int val=intervals[i][1]-intervals[i][0]+1;
            update(tree, lazy, 0, intervals[i][0], intervals[i][1], 0, n-1, val);
        }
        vector<int>ans(szQ);
        for(int i=0; i<szQ; ++i){
            int temp=query(tree, lazy, 0, 0, n-1, queries[i]);
            if(temp==INT_MAX){
                ans[i]=-1;
            } else ans[i]=temp;
        }
        delete[] tree, delete[] lazy;
        return ans;
    }
};