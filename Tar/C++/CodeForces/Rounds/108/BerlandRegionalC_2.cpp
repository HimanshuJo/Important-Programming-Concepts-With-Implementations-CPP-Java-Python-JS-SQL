/*

Polycarp is an organizer of a Berland ICPC regional event. 
There are n universities in Berland numbered from 1 to n. 
Polycarp knows all competitive programmers in the region. 

There are n students: the i-th student is enrolled at a university ui and has a programming skill si

Polycarp has to decide on the rules now. In particular, the number of members in the team.

Polycarp knows that if he chooses the size of the team to be some integer k
, each university will send their k strongest (with the highest programming skill s) 
students in the first team, the next k strongest students in the second team and so on. 

If there are fewer than k students left, then the team can't be formed. 

Note that there might be universities that send zero teams.

The strength of the region is the total skill of the members of all present teams. 

If there are no teams present, then the strength is 0.

Help Polycarp to find the strength of the region for each choice of k
from 1 to n.

*/

/*

Suppose we have the university no. and the programming skills of a particular student as follows

    1 2 1 2 1 2 1
    6 8 3 1 5 1 5

    In this case:

        Uni 1 will send 4 teams in this order 6 5 3 3

        Uni 2 will send 3 teams in this order 8 1 1

        For k = 1

            all the students will form an individual teams and the skills can be added
                so 6 + 5 + 3 + 3 + 8 + 1 + 1

        For k = 2

            the universtiy has to form a group of two members from the available students according
                to their skill
            the team which is less than k, won't participate
                so 6 + 5 + 3 + 3 + 8 + 1

        and so on

    -------

    Constraints given are : The sum of n over all testcases doesn't exceed 2⋅10^5

        The number of students are from different universities, so what we can say is
            all the students from university 1 + all the students from university 2 and so on will be equal to n

        Some key points to note is that:

            Let's say the maximum length of the team that a university1 can make is k1
            similary max length of the team uni2 can make is k2
            and so on

            and we know that k1+ k2 + k3... kn = n

            How much time complexity we will require

                Let's suppose we have a university that has 'm' students
                    and let's say we were making the team of size k

                    Let's count the number of teams we are able to make in this case
                        no. of teams would be
                            m / k

                            with this we can actually see that

                                the number of people that will be left will be equal to
                                    m - (m / k) * k

                                    this is equal to m % k (remainder when m / k)

                                these m % k people are with limited skills
            
            So we actually have to run a loop from very first index till m - (m % k)

                suppose we have k = 3, so in our array we will already calculate the prefix sum
                    till k and leaving the extra values behind

            For every k we can calculate the corresponding value in O(1) time

*/

#include<bits/stdc++.h>
#define endl "\n"
#define cust ios_base::sync_withstdio(0); \
             cin.tie(0); \
             cout.tie(0);
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
        for (ll j = i; j <= v[i].size(); ++j) {
            ll temp = v[i].size() % j;
            ans[j] += v[i][v[i].size() - temp - 1]; 
        }
    }
    for (ll i = 1; i <= n; ++i) {
        cout << ans[i] << " ";
        cout << "-------" << endl; 
    }
    cout << endl;
}

int main() {
    cust;
    int t;
    cin >> t;
    while (t--) {
        solve();
    }
}