#include<bits/stdc++.h>
#define endl "\n"
#define all(x) (x).begin(), (x).end()
typedef long long ll;
using namespace std;

void solve() {
    ll n;
    cin >> n;
    vector<ll> v[n + 1];
    ll arr[n];
    for (ll i = 0; i < n; ++i) {
        cin >> arr[i];
    }
    ll x;
    for (ll i = 0; i < n; ++i) {
        cin >> x;
        v[arr[i]].push_back(x);
    }
    for (ll i = 1; i <= n; ++i) {
        sort(all(v[i]));
        reverse(all(v[i]));
    }
    ll ans[n + 1];
    for (ll i = 1; i <= n; ++i) {
        ans[i] = 0;
    }
    for (ll i = 1; i <= n; ++i) {
        for (ll j = 1; j < v[i].size(); ++j) {
            v[i][j] += v[i][j - 1];
        }
        for (ll j = 1; j <= v[i].size(); ++j) {
            ll temp = v[i].size() % j;
            ans[j] += v[i][v[i].size() - temp - 1];
        }
    }
    for (ll i = 1; i <= n; ++i) {
        cout << ans[i] << " ";
    }
    cout << endl;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int t;
    cin >> t;
    while (t--) {
        solve();
    }
}