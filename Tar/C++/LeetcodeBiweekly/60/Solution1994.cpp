// The Number of Good Subsets
/*
You are given an integer array nums. We call a subset of nums good if its product can be represented as a product of one or more distinct prime numbers.

For example, if nums = [1, 2, 3, 4]:
[2, 3], [1, 2, 3], and [1, 3] are good subsets with products 6 = 2*3, 6 = 2*3, and 3 = 3 respectively.
[1, 4] and [4] are not good subsets with products 4 = 2*2 and 4 = 2*2 respectively.
Return the number of different good subsets in nums modulo 109 + 7.

A subset of nums is any array that can be obtained by deleting some (possibly none or all) elements from nums. 
Two subsets are different if and only if the chosen indices to delete are different.

Example 1:

Input: nums = [1,2,3,4]
Output: 6
Explanation: The good subsets are:
- [1,2]: product is 2, which is the product of distinct prime 2.
- [1,2,3]: product is 6, which is the product of distinct primes 2 and 3.
- [1,3]: product is 3, which is the product of distinct prime 3.
- [2]: product is 2, which is the product of distinct prime 2.
- [2,3]: product is 6, which is the product of distinct primes 2 and 3.
- [3]: product is 3, which is the product of distinct prime 3.
*/
/*
Observations:
Given nums[i] <= 30 , the number of distinct possible prime numbers are only 10, i.e. {2, 3, 5, 7, 11, 13, 17, 19, 23, 29}
Given 1 <= nums.length <= 1e5 it suggests that a lot of repeated occurences of numbers is expected.
We can directly eliminate all the numbers which have any prime factor occuring multiple times in its factorisation. Eg: 4, 9, 12, etc.

Now when we multiply two numbers, the key point to keep in mind is they should have mutually exclusive set of prime factors. 
Let's imagine this set as a 10 bit number where the ith bit is set if the ith prime factor is a factor of the given number.

Array Primes : {2, 3, 5, 7, 11, 13, 17, 19, 23, 29}

E.g. The number 2 can be represented as 1000000000, 6 can be represented as 1100000000, and so on,

Now to multiply two number A and B, whose factor-bitsets are represented by X and Y, we can just check if X & Y == 0

Due to a large number of repetitions in Array Nums, we can store the frequency of the factor bitsets in a separate 1024 sized vector (referred as cache in the code)

Approach:
We downsize the Array nums into Array V, by converting the numbers into 10-bit-representations, and store the frequency for repeated occurences.

Let goodSubsets(pos, mask) represent the number of good subsets, if currently on position pos, and have already used the prime factors 
represented by the setBits in mask.

If V[pos] & mask == 0 :
Either multiply the current element and go to statecache[V[pos]] * goodSubsets(pos+1, mask|V[pos]), or just simply ignore and move ahead to the state 
goodSubsets(pos+1, mask)

else:
move to goodSubsets(pos+1, mask)

Last Observation:
We need to handle 1's separately as they can be present in any frequency and will not affect the prime factor criteria. 
So we can store the frequency of ones, and at the end, take any number of ones from the amount avaiable and create goodSubsets, 
the total number of ways to do this is : 2^numOnes * goodSubsets(0, 0)
*/
#include <bits/stdc++.h>
using namespace std;
class Solution
{
public:
#define lld long long int

    int mul(lld a, lld b)
    {
        lld product = (a * b) % MOD;
        return product;
    }

    int add(lld a, lld b)
    {
        lld addition = (a + b) % MOD;
        return addition;
    }

    const int MOD = 1e9 + 7;
    int binary_exponentiation(lld x, int p)
    {
        long long res = 1;
        while (p)
        {
            if (p & 1)
                res = mul(res, x);
            x = mul(x, x);
            p /= 2;
        }
        return res;
    }

    int goodSubsets(int pos, int mask, vector<int> &V, vector<vector<int>> &dp, vector<int> &cache)
    {
        if (pos == V.size())
            return (mask > 0);

        if (dp[pos][mask] != -1)
            return dp[pos][mask] % MOD;

        if (V[pos] & mask)
            return dp[pos][mask] = goodSubsets(pos + 1, mask, V, dp, cache) % MOD;
        return dp[pos][mask] = add(mul(cache[V[pos]], goodSubsets(pos + 1, mask | V[pos], V, dp, cache)), goodSubsets(pos + 1, mask, V, dp, cache));
    }

    int numberOfGoodSubsets(vector<int> &nums)
    {

        int primes[10] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        vector<int> V;
        vector<int> cache(1025, 0);

        int ones = 0;

        for (auto x : nums)
        {

            int num = 0, k = 0;
            int flag = 1;

            for (auto j : primes)
            {

                int cnt = 0;
                while (x % j == 0)
                {
                    x /= j;
                    cnt++;
                    if (cnt > 1)
                        break;
                }

                if (cnt > 1)
                {
                    flag = 0;
                    break;
                }

                if (cnt == 1)
                    num = num | (1 << k);

                ++k;
            }

            if (flag == 0)
                continue;

            if (num == 0)
            {
                ones++;
                continue;
            }

            cache[num]++;
            if (cache[num] > 1)
                continue;

            V.push_back(num);
        }

        vector<vector<int>> dp(V.size(), vector<int>(1024, -1));

        int ans = goodSubsets(0, 0, V, dp, cache);
        ans = mul(binary_exponentiation(2, ones), ans);

        return ans;
    }
};
int main()
{
    Solution obj;
    vector<int> nums = {1, 2, 3, 4};
    obj.numberOfGoodSubsets(nums);
}