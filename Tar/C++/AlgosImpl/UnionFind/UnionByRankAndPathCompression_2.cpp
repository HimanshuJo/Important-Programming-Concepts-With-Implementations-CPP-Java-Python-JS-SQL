#include<bits/stdc++.h>
using namespace std;

class UnionFind {
    vector<int> id, rank;
    int cnt; // `cnt` is the number of connected components in the graph
public:
    UnionFind(int n) : id(n), rank(n, 0), cnt(n) {
        iota(begin(id), end(id), 0);
    }

    int find(int a) {
        return id[a] == a ? a : (id[a] = find(id[a]));
    }

    void connect(int i, int j) {
        int p = find(i), q = find(j);
        if (p == q) return;
        if (rank[p] > rank[q]) id[p] = q;
        else {
            id[q] = p;
            if (rank[p] == rank[q]) rank[p]++;
        }
        --cnt;
    }

    bool connected(int i, int j) { return find(i) == find(j); }
    
    int getCount() { return cnt; }
};