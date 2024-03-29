// Eliminate Maximum Number of Monsters

/*
You are playing a video game where you are defending your city from a group of n monsters.
You are given a 0-indexed integer array dist of size n, where dist[i] is the initial distance in meters of the ith monster from the city.

The monsters walk toward the city at a constant speed. The speed of each monster is given to you in an integer array speed of size n, 
where speed[i] is the speed of the ith monster in meters per minute.

The monsters start moving at minute 0. You have a weapon that you can choose to use at the start of every minute, 
including minute 0. You cannot use the weapon in the middle of a minute. The weapon can eliminate any monster that is still alive. 
You lose when any monster reaches your city. If a monster reaches the city exactly at the start of a minute, 
it counts as a loss, and the game ends before you can use your weapon in that minute.

Return the maximum number of monsters that you can eliminate before you lose, or n if you can eliminate all the monsters before they reach the city.

Example 1:

Input: dist = [1,3,4], speed = [1,1,1]
Output: 3
Explanation:
At the start of minute 0, the distances of the monsters are [1,3,4], you eliminate the first monster.
At the start of minute 1, the distances of the monsters are [X,2,3], you don't do anything.
At the start of minute 2, the distances of the monsters are [X,1,2], you eliminate the second monster.
At the start of minute 3, the distances of the monsters are [X,X,1], you eliminate the third monster.
All 3 monsters can be eliminated.
*/

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int eliminateMaximum(vector<int> &dist, vector<int> &speed)
    {
        int len = dist.size();
        double time[len];
        for (int i = 0; i < len; ++i)
        {
            time[i] = (double) dist[i] / speed[i];
        }
        sort(time, time + len);
        int count = 0;
        double currTime = 0.0;
        for (int i = 0; i < len; ++i)
        {
            if (time[i] > currTime)
            {
                ++count;
            }
            else
            {
                return count;
            }
            currTime += 1.0;
        }
        return count;
    }
};