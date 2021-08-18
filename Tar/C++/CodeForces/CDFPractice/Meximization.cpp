/*

MEX:

    For a set of given integers, MEX is the smallest non-negative integer which is not there

    For example, for MEX({1, 2, 3}) = 0, MEX({0, 1, 2, 4, 5}) = 3

/**/ 

#include<iostream>
#include<vector>
#include<map>
#include<algorithm>
using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int a[n];
        vector<int> p1;
        vector<int> p2;
        map<int, int> map;
        for (int i = 0; i < n; ++i) {
            cin >> a[i];
            if (map[a[i]] == 1) {
                p2.push_back(a[i]);
            } else {
                p1.push_back(a[i]);
                map[a[i]]++;
            }
        }
        sort(p1.begin(), p1.end());
        for (int i = 0; i < p1.size(); ++i)
            cout << p1[i] << " ";
        for (int i = 0; i < p2.size(); ++i)
            cout << p2[i] << " ";
        cout << endl;
    }
}