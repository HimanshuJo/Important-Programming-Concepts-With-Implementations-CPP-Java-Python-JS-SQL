#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;
        string eP;
        string gP;
        cin >> eP;
        cin >> gP;
        int ans = 0;
        for (int i = 0; i < n; ++i)
        {
            if (eP[i] == '0' && gP[i] == '1')
            {
                ans++;
                eP[i] = '2';
            }
            else if (i > 0 && eP[i - 1] == '1' && gP[i] == '1')
            {
                ans++;
                eP[i - 1] = '2';
            }
            else if (eP[i + 1] == '1' && gP[i] == '1')
            {
                ans++;
                eP[i + 1] = '2';
            }
        }
        cout << ans << "\n";
    }
}