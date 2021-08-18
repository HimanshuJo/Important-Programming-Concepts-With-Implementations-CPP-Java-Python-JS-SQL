package com.essenbazar._226;

/*

You are given a (0-indexed) array of positive integers candiesCount where candiesCount[i]
represents the number of candies of the ith type you have.

You are also given a 2D array queries where queries[i] = [favoriteTypei, favoriteDayi, dailyCapi].

You play a game with the following rules:

    You start eating candies on day 0.
    You cannot eat any candy of type i unless you have eaten all candies of type i - 1.
    You must eat at least one candy per day until you have eaten all the candies.

Construct a boolean array answer such that

    answer.length == queries.length and answer[i] is true if you can eat a candy of type
        favoriteTypei on day favoriteDayi
        without eating more than dailyCapi candies on any day, and

    false otherwise.

Note that you can eat different types of candy on the same day, provided that you follow rule 2.

Example 1:

Input: candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
Output: [true,false,true]
Explanation:
1- If you eat 2 candies (type 0) on day 0 and 2 candies (type 0) on day 1, you will eat a
candy of type 0 on day 2.

2- You can eat at most 4 candies each day.
   If you eat 4 candies every day, you will eat 4 candies (type 0) on day 0 and 4 candies
    (type 0 and type 1) on day 1.

   On day 2, you can only eat 4 candies (type 1 and type 2), so you cannot eat a candy of type 4 on day 2.

3- If you eat 1 candy each day, you will eat a candy of type 2 on day 13.

Example 2:

Input: candiesCount = [5,2,6,4,1], queries = [[3,1,2],[4,10,3],[3,10,100],[4,100,30],[1,3,1]]
Output: [false,true,true,false,false]

*/
/*
    Intuition:

        Since we can eat at-least 'one' candy a day and at-most 'dailyCapi' a day

            with this we create a range for each of the candy like [1 .. dailyCapi] as start and end points
                we can calculate, basically the last day we can eat the current candy type
                (current candy type is here -> favoriteTypei)

                and also the earliest day we can eat the current candy type

            And as long as our current day is within this range, we can simply return true, else false

        -------

        how to calculate the lastDay:

            For this we want to eat one candy per-day

            suppose our candiesCount array is: [7, 4, 5, 3, 8]
                                                0  1  2  3  4

                and we are trying to eat candy type 2, so what is the last day we can eat candy type 2
                    (7 + 4 + 5) - 1 = 15

                    for previous candies we will eat one candy/ one day and complete eating candy of type 2 on the 16th day

        -------

        How to calculate the earliest day:

            For this, for each of the candy type we'll be eating the 'dailyCapi' amount

            For example, to be able to eat candy of type 2 as early as possible, we first have to finish eating
                candies of type 0, and 1 (that means 7 + 4)

                assuming our daily cap is 4,

                therefore the earliest day will be:
                    11 // 4 = 2

                * Note days here are 0, based therefore 2 day is actually day 3
                    (0, 1, 2)

    -------

    class Solution:
        def canEat(self, cnadiesCount: List[int], queries: List[List[int]]) -> List[bool]:
            ans = []
            preSum = {-1 : 0}
            for i, c in enumerate(candiesCount):
                preSum[i] = c + preSum[i - 1]

            for t, d, cap in queries:
                # last day we can eat the type 't' of the candies
                lastDay = preSum[t] - 1
                # for the first day we need to eat all the candies before
                firstDay = preSum[t - 1] // cap
                ans.append(firstDay <= d <= lastDay)
            return ans
*/

/*
    class Solution {
    public:
        vector<bool> canEat(vector<int>& candiesCount, vector<vector<int>>& queries) {
            int n = candiesCount.size();
            vector<long long> prefix(n + 1, 0);
            for (int i = 1; i < n + 1; ++i) {
                prefix[i] = prefix[i - 1] + candiesCount[i - 1];
            }
            vector<bool> ans;
            for (auto &query : queries) {
                long long type = query[0], day = query[1], capacity = query[2];
                long long maxDay = prefix[type + 1] - 1;
                long long minDay = prefix[type] / capacity;
                if (day <= maxDay && day >= minDay) {
                    ans.push_back(true);
                } else {
                    ans.push_back(false);
                }
            }
            return ans;
        }
    };
*/


public class Solution1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] prefix = new long[candiesCount.length + 1];
        boolean[] res = new boolean[queries.length];
        prefix[0] = 0;
        for (int i = 1; i < prefix.length; ++i) {
            prefix[i] = prefix[i - 1] + candiesCount[i - 1];
        }
        for (int i = 0; i < res.length; ++i) {
            int type = queries[i][0];
            int day = queries[i][1];
            int cap = queries[i][2];
            long maxDay = prefix[type + 1] - 1;
            long minDay = prefix[type] / cap;
            res[i] = (minDay <= day && day <= maxDay);
        }
        return res;
    }
}