#include <bits/stdc++.h>
using namespace std;

void dfsHp(int u, vector<vector<int>> &adj, bool visited[])
{
    if (visited[u])
    {
        return;
    }
    visited[u] = true;
    for (auto v : adj[u])
    {
        if (!visited[v])
        {
            dfsHp(v, adj, visited);
        }
    }
}

// Of the transpose graph of the given graph
// store adj list in transAdj
void getTransposeGr(vector<vector<int>> &adj, vector<vector<int>> &transAdj)
{
    for (int u = 0; u < adj.size(); ++u)
    {
        for (auto v : adj[u])
        {
            transAdj[v].push_back(u);
        }
    }
}

void iniVisited(bool visited[], int n)
{
    for (int u = 0; u < n; ++u)
    {
        visited[u] = false;
    }
}

vector<int> findAllMthVerti(vector<vector<int>> &adj)
{
    int n = adj.size();
    bool visited[n];
    iniVisited(visited, n);
    int lastDfsCalledOn = -1;
    for (int u = 0; u < n; ++u)
    {
        if (!visited[u])
        {
            dfsHp(u, adj, visited);
            lastDfsCalledOn = u;
        }
    }
    iniVisited(visited, n);
    dfsHp(lastDfsCalledOn, adj, visited);
    for (int u = 0; u < n; ++u)
    {
        if (!visited[u])
        {
            vector<int> emptyVec;
            emptyVec.push_back(-1);
            return emptyVec;
        }
    }
    int mthVerti = lastDfsCalledOn;
    vector<vector<int>> transAdj(n);
    getTransposeGr(adj, transAdj);
    iniVisited(visited, n);
    dfsHp(mthVerti, transAdj, visited);
    vector<int> ans;
    for (int u = 0; u < n; ++u)
    {
        if (visited[u])
        {
            ans.push_back(u);
        }
    }
    return ans;
}

int main() {
    int V = 8;
    vector<vector<int>> adj(V);
    adj[0].push_back(1);
    adj[1].push_back(2);
    adj[1].push_back(4);
    adj[1].push_back(5);
    adj[2].push_back(3);
    adj[2].push_back(6);
    adj[3].push_back(2);
    adj[3].push_back(7);
    adj[4].push_back(0);
    adj[4].push_back(5);
    adj[5].push_back(6);
    adj[6].push_back(5);
    adj[6].push_back(7);
    vector<int> mthVerti = findAllMthVerti(adj);
    if (mthVerti[0] == -1) {
        cout << "None exist" << "\n";
    } else {
        for (int v : mthVerti) {
            cout << v << " ";
        }
        return 0;
    }
}