#include <bits/stdc++.h>

#define forn(i, n) for (int i = 0; i < int(n); i++)
#define x first
#define y second

using namespace std;

struct point{
    int a, b, c, d;
};

typedef pair<long long, long long> frac;
typedef pair<int, int> pt;

int n;
vector<point> a;
map<frac, int> sv;

frac norm(long long x, long long y){
    long long g = __gcd(x, y);
    return {x / g, y / g};
}

vector<vector<pt>> g;
vector<int> used;
vector<pt> ans;

int dfs(int v){
    used[v] = 1;
    int cur = -1;
    for (auto it : g[v]){
        int u = it.x;
        int i = it.y;
        if (used[u] == 1) continue;
        int nw = i;
        if (!used[u]){
            int tmp = dfs(u);
            if (tmp != -1){
                ans.push_back({nw, tmp});
                nw = -1;
            }
        }
        if (nw != -1){
            if (cur != -1){
                ans.push_back({cur, nw});
                cur = -1;
            }
            else{
                cur = nw;
            }
        }
    }
    used[v] = 2;
    return cur;
}

int main() {
    scanf("%d", &n);
    a.resize(n);
    forn(i, n) scanf("%d%d%d%d", &a[i].a, &a[i].b, &a[i].c, &a[i].d);
    g.resize(2 * n);
    forn(i, n){
        frac f1 = norm((a[i].a + a[i].b) * 1ll * a[i].d, a[i].b * 1ll * a[i].c);
        frac f2 = norm(a[i].a * 1ll * a[i].d, a[i].b * 1ll * (a[i].c + a[i].d));
        if (!sv.count(f1)){
            int k = sv.size();
            sv[f1] = k;
        }
        if (!sv.count(f2)){
            int k = sv.size();
            sv[f2] = k;
        }
        g[sv[f1]].push_back({sv[f2], i});
        g[sv[f2]].push_back({sv[f1], i});
    }
    used.resize(sv.size());
    forn(i, sv.size()) if (!used[i])
        dfs(i);
    printf("%d\n", int(ans.size()));
    for (auto it : ans) printf("%d %d\n", it.x + 1, it.y + 1);
}