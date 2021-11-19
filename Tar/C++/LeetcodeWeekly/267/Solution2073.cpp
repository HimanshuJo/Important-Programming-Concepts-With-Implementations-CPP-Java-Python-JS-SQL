#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        int ans = 0;
        bool flag = false;
        while (tickets[k] != 0) {
            for (int i = 0; i < tickets.size(); ++i) {
                if (tickets[k] == 0) break;
                else {
                    if (tickets[i] > 0) {
                        tickets[i] -= 1;
                        ans++;
                    }
                }
            }
        }
        cout << ans << endl;
        return ans;
    }

    int timeRequiredToBuy3(vector<int>&vec, int k) {
        int ans = 0, n = vec.size();
        for (int i = 0; i < n; ++i) {
            ans += (i <= k ? min(vec[i], vec[k]) : min(vec[i], vec[k] - 1));
        }
        cout << ans << endl;
        return ans;
    }

    int timeRequiredToBuy2(vector<int>& t, int k) {
        int res = 0, sz = t.size(), cap = t[k];
        for (int i = 0; i < sz; ++i)
            res += min(cap - (i > k), t[i]);
        cout << res << endl;
        return res;
    }

};

int main() {
    Solution obj;
    int k = 0;
    vector<int>tickets{1000000000, 2, 12, 13, 23};
    //cout << (tickets.size());
    struct timespec start, end;
    clock_gettime(CLOCK_MONOTONIC, &start);
    ios_base::sync_with_stdio(false);
    obj.timeRequiredToBuy(tickets, k);
    clock_gettime(CLOCK_MONOTONIC, &end);
    double time_taken;
    time_taken = (end.tv_sec - start.tv_sec) * 1e9;
    time_taken = (time_taken + (end.tv_nsec - start.tv_nsec)) * 1e-9;
    cout << "Time taken by program is : " << fixed
         << time_taken << setprecision(9);
    cout << " sec" << endl;
    struct timespec start2, end2;
    clock_gettime(CLOCK_MONOTONIC, &start2);
    ios_base::sync_with_stdio(false);
    obj.timeRequiredToBuy3(tickets, k);
    clock_gettime(CLOCK_MONOTONIC, &end2);
    double time_taken_;
    time_taken_ = (end2.tv_sec - start2.tv_sec) * 1e9;
    time_taken_ = (time_taken_ + (end2.tv_nsec - start2.tv_nsec)) * 1e-9;
    cout << "Time taken by program is : " << fixed
         << time_taken_ << setprecision(9);
    cout << " sec" << endl;
    return 0;
}