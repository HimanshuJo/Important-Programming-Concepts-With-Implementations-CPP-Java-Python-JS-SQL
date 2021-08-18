/*

You have r red and b blue beans. 

You'd like to distribute them among several (maybe, one) packets in such a way that each packet:

    has at least one red bean (or the number of red beans ri≥1);
    
    has at least one blue bean (or the number of blue beans bi≥1);

the number of red and blue beans should differ in no more than d(or |ri−bi|≤d) 

Can you distribute all beans?

*/

#include<bits/stdc++.h>
#define endl "\n"
#define cust ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
typedef long long ll;
using namespace std;

void solve() {
    ll r, b, d;
    cin >> r >> b >> d;
    if (r > b) {
        swap(r, b);
    }
    if ((d + 1) * r >= b)
        cout << "YES" << endl;
    else cout << "NO" << endl;
}


int main() {
    cust;
    ll t = 1;
    cin >> t;
    while (t--) {
        solve();
    }
}