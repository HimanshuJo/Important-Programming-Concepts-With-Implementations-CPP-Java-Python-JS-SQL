package com.essenbazar.hammingDist_461;

/*

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.

 */

import java.util.*;

class Solution {

    public int hammingDistance(int x, int y) {
        int result = 0;
        Map<Object, Object> map = new HashMap<>();
        Map<Object, Object> map_ = new HashMap<>();
        String temp1 = Integer.toBinaryString(x);
        String temp2 = Integer.toBinaryString(y);
        if (temp1.length() > temp2.length()) {
            while (temp2.length() < temp1.length()) {
                temp2 = "0" + temp2;
            }
        } else {
            while (temp1.length() < temp2.length()) {
                temp1 = "0" + temp1;
            }
        }
        for (int i = 0; i < temp1.length(); i++) {
            map.put(i, temp1.charAt(i));
            map_.put(i, temp2.charAt(i));
        }
        for (int i = 0; i < map.size(); i++) {
            if (!map.get(i).equals(map_.get(i))) {
                result++;
            }
        }
        return result;
    }
}
