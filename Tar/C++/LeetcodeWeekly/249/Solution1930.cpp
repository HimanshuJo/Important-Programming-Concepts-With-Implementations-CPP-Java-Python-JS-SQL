// Unique Length-3 Palindromic Subsequences

/*
Given a string s, return the number of unique palindromes of length three that are a subsequence of s.

Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.

A palindrome is a string that reads the same forwards and backwards.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

    For example, "ace" is a subsequence of "abcde".

Example 1:

Input: s = "aabca"
Output: 3
Explanation: The 3 palindromic subsequences of length 3 are:
- "aba" (subsequence of "aabca")
- "aaa" (subsequence of "aabca")
- "aca" (subsequence of "aabca")
*/

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int countPalindromicSubsequence(string s)
    {
        vector<pair<int, int>> v(26, {-1, -1});
        int n = s.length();
        for (int i = 0; i < n; ++i)
        {
            if (v[s[i] - 'a'].first == -1)
            {
                // storing when alphabet appear for the first time
                v[s[i] - 'a'].first = i;
            }
            else
            {
                // Last storing at second when it re-appears again
                v[s[i] - 'a'].second = i;
            }
        }
        int ans = 0;
        for (auto &num : v) {
            cout << num.first << " " << num.second << "\n";
        }
        cout << "-------" << "\n";
        for (int i = 0; i < 26; ++i)
        {
            // Only when the alphabet occur for the second time
            if (v[i].second != -1)
            {
                // we need to keep the unique elements in the set
                unordered_set<char> st;
                for (int x = v[i].first + 1; x < v[i].second; ++x)
                {
                    st.insert(s[x]);
                }
                cout << ans << "\n";
                ans += ((int)st.size());
            }
        }
        cout << ans << "\n";
        return ans;
    }
};

int main() {
    Solution obj;
    string s = "bbcbaba";
    obj.countPalindromicSubsequence(s);
}