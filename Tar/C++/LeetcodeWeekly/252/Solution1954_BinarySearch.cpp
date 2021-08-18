#include <bits/stdc++.h>
using ll = long long;
using namespace std;

class Solution
{
public:
   long long minimumPerimeter(long long x) {
        long long l = 1,  r = 100000, m;
        while (l < r) {
            m = (l + r) / 2;
            if (m * m * m * 4 + m * m * 6 + m * 2 >= x)
                r = m;
            else
                l = m + 1;
        }
        return l * 8;
    }
};

int main()
{
    Solution obj;
    obj.minimumPerimeter(1000000000);
}