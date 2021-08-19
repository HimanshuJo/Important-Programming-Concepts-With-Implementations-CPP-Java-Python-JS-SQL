/*
 * On a social network consisting of m users and some friendships between users, 
 * two users can communicate with each other if they know a common language.

You are given an integer n, an array languages, and an array friendships where:

    There are n languages numbered 1 through n,
    languages[i] is the set of languages the ith user knows, and
    friendships[i] = [ui, vi] denotes a friendship between the users ui and vi.

	You can choose one language and teach it to some users so that all friends can communicate with each other. 
	Return the minimum number of users you need to teach.
	
	Note that friendships are not transitive, meaning if x is a friend of y and y is a friend of z, 
	this doesn't guarantee that x is a friend of z.
	
Example 1:

Input: n = 2, languages = [[1],[2],[1,2]], friendships = [[1,2],[1,3],[2,3]]
Output: 1
Explanation: You can either teach user 1 the second language or user 2 the first language.

 */
/*
 * Intuition:
 * 	Find out all the friendships that are already possible without any teachings
 *  (no need to teach here anything)
 * 
 * 	The rest we will try to teach using 1 language
 * 		Find out from all the languages what is the minimum we need to teach
 */

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int minimumTeaching(int n, vector<vector<int>> languages, vector<vector<int>> friendships)
    {
        map<int, set<int>> languageMp;
        for (int i = 0; i < languages.size(); ++i)
        {
            languageMp.insert(pair<int, set<int>>(i + 1, set<int>()));
            for (int l : languages[i])
            {
                languageMp[i + 1].insert(l);
            }
        }
        for (auto &entry : languageMp)
        {
            cout << entry.first << " : ";
            for (auto &setEntry : entry.second)
            {
                cout << setEntry << " ";
            }
            cout << endl;
        }
        bool alreadyCan[friendships.size()];
        for (int i = 0; i < friendships.size(); ++i)
        {
            alreadyCan[i] = false;
        }
        for (int i = 0; i < friendships.size(); ++i)
        {
            set<int> curr = languageMp[friendships[i][0]];
            for (auto it = curr.begin(); it != curr.end(); ++it)
            {
                // If second friend has knowledge about any of the languages which the first friend can speak
                set<int> next = languageMp[friendships[i][1]];
                if (next.count(*it) != 0)
                {
                    alreadyCan[i] = true;
                    break;
                }
            }
        }
        cout << "--------" << endl;
        for (bool entry : alreadyCan)
        {
            cout << entry << " ";
        }
        cout<<endl;
        cout << "--------" << endl;
        int minTeach = INT_MAX;
        // Travel friendship array and check in already can which friendship needs teachings
        for (int i = 0; i <= n; ++i)
        {
            unordered_set<int> teachSet;
            for (int j = 0; j < friendships.size(); ++j)
            {
                if (alreadyCan[j] == 1)
                {
                    continue;
                }
                set<int> temp1 = languageMp[friendships[j][0]];
                set<int> temp2 = languageMp[friendships[j][1]];
                if (temp1.count(i) == 0)
                {
                    teachSet.insert(friendships[j][0]);
                }
                if (temp2.count(i) == 0)
                {
                    teachSet.insert(friendships[j][1]);
                }
            }
            int stSize = teachSet.size();
            minTeach = min(minTeach, stSize);
        }
        cout << minTeach;
        return minTeach;
    }
};

int main()
{
    Solution obj;
    vector<vector<int>> languages = {{1}, {2}, {1, 2}};
    vector<vector<int>> friendships = {{1, 2}, {1, 3}, {2, 3}};
    obj.minimumTeaching(2, languages, friendships);
}