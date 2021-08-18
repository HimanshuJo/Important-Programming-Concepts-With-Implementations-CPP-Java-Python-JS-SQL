package com.essenbazar.nRepeatedElementin2NArr_961;

/*

In a array A of size 2N, there are N+1 unique elements,
and exactly one of these elements is repeated N times.

Return the element repeated N times.

Example 1:

Input: [1,2,3,3]
Output: 3
Example 2:

Input: [2,1,2,5,3,2]
Output: 2

 */

import java.util.*;

class Solution {

    public int repeatedNTimes(int[] A) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            set.add(num);
        }
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        for (@SuppressWarnings("rawtypes") Map.Entry entry : map.entrySet()) {
            if ((set.size() - 1) * 2 != A.length) {
                return 1;
            }
            if ((int) entry.getValue() == set.size() - 1) {
                res = (int) entry.getKey();
            }
        }
        return res;
    }
}
