#include<bits/stdc++.h>
using namespace std;

class UnionFind{
public:
    vector<int>parent;
    UnionFind(int n) {
        parent.resize(n + 1, -1);
    }

    int find(int x) {
        int root = x;
        while (parent[root] >= 0) {
            root = parent[root];
        }
        while (parent[x] >= 0) {
            int next = parent[x];
            parent[x] = root;
            x = next;
        }
        return root;
    }

    void doUnion(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        if (root1 == root2) return;
        if (parent[root1] < parent[root2]) {
            parent[root1] += parent[root2];
            parent[root2] = root1;
        } else {
            parent[root2] += parent[root1];
            parent[root1] = root2;
        }
    }
};

class Solution {
public:
    vector<bool>friendRequests(int n, vector<vector<int>>&restrictions, vector<vector<int>>&requests) {
        int m = requests.size();
        vector<bool>ans(m, 0);
        UnionFind unionFind(n);
        for (int i = 0; i < m; ++i) {
            UnionFind temp = unionFind;
            temp.doUnion(requests[i][0], requests[i][1]);
            bool flag = true;
            for (vector<int>&vec : restrictions) {
                if (temp.find(vec[0]) == temp.find(vec[1])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans[i] = true;
                unionFind.doUnion(requests[i][0], requests[i][1]);
            }
        }
        return ans;
    }
};