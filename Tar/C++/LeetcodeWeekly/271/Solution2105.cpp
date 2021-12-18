#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    bool isValid(vector<int> &plants, int capacityA, int capacityB, int capA, int capB, int bgn, int end)
    {
        if ((plants[bgn] <= capacityA && capacityA == capacityB) || (plants[bgn] <= capacityA && capacityA > capacityB) || (plants[end] <= capacityB && capacityB > capacityA))
        {
            return true;
        }
        else if ((plants[bgn] <= capA && capacityA > capacityB) || (plants[end] <= capB && capacityB > capacityA) || (plants[bgn] <= capA && capacityA == capacityB))
        {
            return false;
        }
        return true;
    }

    int minimumRefill(vector<int> &plants, int capacityA, int capacityB)
    {
        int ans = 0;
        int n = plants.size();
        int bgn = 0, end = n - 1;
        int capA = capacityA, capB = capacityB;
        while (bgn <= end)
        {
            if (bgn != end)
            {
                if (plants[bgn] <= capacityA)
                {
                    capacityA -= plants[bgn];
                    bgn++;
                }
                else
                {
                    ans++;
                    if (bgn != n / 2)
                        capacityA = capA;
                    capacityA -= plants[bgn];
                    bgn++;
                }
                if (plants[end] <= capacityB)
                {
                    capacityB -= plants[end];
                    end--;
                }
                else
                {
                    ans++;
                    if (end != n / 2)
                        capacityB = capB;
                    capacityB -= plants[end];
                    end--;
                }
            }
            else
            {
                if (isValid(plants, capacityA, capacityB, capA, capB, bgn, end))
                {
                    break;
                }
                else
                    ans++;
                break;
            }
        }
        return ans;
    }
};
