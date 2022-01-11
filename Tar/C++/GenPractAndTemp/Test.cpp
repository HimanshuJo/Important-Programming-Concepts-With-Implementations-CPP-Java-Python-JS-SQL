#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

class Trie
{
    bool last;
    Trie *child[26];

public:
    Trie()
    {
        for (int i = 0; i < 26; i++)
        {
            child[i] = NULL;
        }
        last = false;
    }

    void insert(string &s)
    {
        auto tmp = this;
        for (auto c : s)
        {
            if (!tmp->child[c - 'a'])
            {
                tmp->child[c - 'a'] = new Trie();
            }
            tmp = tmp->child[c - 'a'];
        }
        tmp->last = true;
    }

    bool check(string &s)
    {
        auto tmp = this;
        for (auto c : s)
        {
            if (!tmp->child[c - 'a'])
            {
                return false;
            }
            tmp = tmp->child[c - 'a'];
        }
        return tmp->last;
    }
};

class Solution
{
public:
    int wordCount(vector<string> &startWords, vector<string> &targetWords)
    {
        Trie t;

        for (auto s : startWords)
        {
            sort(s.begin(), s.end());
            t.insert(s);
        }

        int count = 0;
        for (auto s : targetWords)
        {
            sort(s.begin(), s.end());
            // remove one character and check if the remaining string is in Trie
            for (int i = 0; i < s.size(); i++)
            {
                string s1 = s.substr(0, i) + s.substr(i + 1);
                if (t.check(s1))
                {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
};