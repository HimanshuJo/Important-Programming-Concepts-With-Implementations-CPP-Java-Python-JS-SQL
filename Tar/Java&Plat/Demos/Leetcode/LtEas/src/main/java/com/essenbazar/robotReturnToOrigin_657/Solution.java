package com.essenbazar.robotReturnToOrigin_657;

/*

There is a robot starting at position (0, 0), the origin, on a 2D plane.
Given a sequence of its moves, judge if this robot ends up at (0, 0)
after it completes its moves.

The move sequence is represented by a string, and the character moves[i] represents its ith move.
Valid moves are R (right), L (left), U (up), and D (down).
If the robot returns to the origin after it finishes all of its moves, return true.
Otherwise, return false.

Note: The way that the robot is "facing" is irrelevant.
"R" will always make the robot move to the right once, "L" will always make it move left, etc.
Also, assume that the magnitude of the robot's movement is the same for each move.

Example 1:

Input: moves = "UD"
Output: true
Explanation: The robot moves up once, and then down once.
All moves have the same magnitude, so it ended up at the origin where it started.
Therefore, we return true.

 */

import java.util.*;

class Solution {

    public boolean judgeCircle(String moves) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('L', -2);
        map.put('R', 2);
        map.put('U', -3);
        map.put('D', 3);
        for (int i = 0; i < moves.length(); i++) {
            res += map.get(moves.charAt(i));
        }
        return res == 0;
    }
}
