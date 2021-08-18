package com.essenbazar.baseBallGame_682;

import java.util.ArrayList;
import java.util.List;

/*

You are keeping score for a baseball game with strange rules. 
The game consists of several rounds, where the scores of past rounds may affect future rounds' scores.

At the beginning of the game, you start with an empty record. You are given a list of strings ops, 
where ops[i] is the ith operation you must apply to the record and is one of the following:

    An integer x - Record a new score of x.
    "+" - Record a new score that is the sum of the previous two scores. 
            It is guaranteed there will always be two previous scores.
    "D" - Record a new score that is double the previous score. 
            It is guaranteed there will always be a previous score.
    "C" - Invalidate the previous score, removing it from the record. 
            It is guaranteed there will always be a previous score.

Return the sum of all the scores on the record.

Example 1:

Input: ops = ["5","2","C","D","+"]
Output: 30

Explanation:
"5" - Add 5 to the record, record is now [5].
"2" - Add 2 to the record, record is now [5, 2].
"C" - Invalidate and remove the previous score, record is now [5].
"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
The total sum is 5 + 10 + 15 = 30.

 */

class Solution {

    public int calPoints(String[] ops) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < ops.length; ++i) {
            switch (ops[i]) {
                case "C":
                    int lsSize = res.size();
                    res.remove(lsSize - 1);
                    break;
                case "D":
                    int toChangeIndex = res.size() - 1;
                    int temp = res.get(toChangeIndex) * 2;
                    res.add(temp);
                    break;
                case "+":
                    int finalIndex = res.size() - 1;
                    int preFinalIndex = res.size() - 2;
                    int temp_ = res.get(finalIndex) + res.get(preFinalIndex);
                    res.add(temp_);
                    break;
                default:
                    int x = Integer.parseInt(ops[i]);
                    res.add(x);
                    break;
            }
        }
        int res_ = 0;
        for (int num : res) {
            res_ += num;
        }
        return res_;
    }
}
