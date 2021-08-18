package com.essenbazar.nUniqueIntSumUpToZeros_1304;

import java.util.ArrayList;
import java.util.List;

/*

Given an integer n, return any array containing n unique integers such that they add up to 0.

Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].

 */

class Solution {

    public int[] sumZero(int n) {
        int[] res = new int[1];
        if (n == 1) {
            res[0] = 0;
            return res;
        }
        List<Integer> list = new ArrayList<>();
        if (n % 2 != 0) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    list.add(-i);
                } else {
                    list.add(n - i);
                }
            }
        } else {
            int temp = n / 2;
            list.add(0, temp);
            list.add(1, -temp);
            for (int i = 2; i < n; i++) {
                list.add(temp - 1);
                list.add(-(temp - 1));
                temp = temp - 1;
                if (temp == 0 || temp - 1 == 0) {
                    break;
                }
            }
        }
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        return arr;
    }
}
