#include<vector>
#include<map>
using namespace std;

class Solution {
public:

    int n;
    long long tree[2 * 100000];

    void build(vector<int> arr)
    {
        for (int i=0; i<n; i++)   
            tree[n+i] = arr[i];
        for (int i = n - 1; i > 0; --i)    
            tree[i] = tree[i<<1] + tree[i<<1 | 1];   
    }

    void updateTreeNode(int p, int value)
    {
        tree[p+n] = value;
        p = p+n;
        for (int i=p; i > 1; i >>= 1)
            tree[i>>1] = tree[i] + tree[i^1];
    }

    long long query(int l, int r)
    {
        long long res = 0;
        for (l += n, r += n; l < r; l >>= 1, r >>= 1)
        {
            if (l&1)
                res += tree[l++];

            if (r&1)
                res += tree[--r];
        }

        return res;
    }

    vector<int> getAverages(vector<int>& nums, int k) {
        n=nums.size();
        build(nums);
        if(k>nums.size()) return {-1};
        vector<int>res2(nums.size(), -1);
		map<int, pair<int, int>>mp;
		for(int i=0+k; i<nums.size()-k; ++i){
			if(i+k<=nums.size()-1&&i-k>=0){
                long long sm=0;
                long long avg=(i+k)-(i-k)+1;
				sm=query(i-k, (i+k)+1);
                res2[i]=sm/avg;
			}
		}
		return res2;
    }
};

int main(){}
