package com.essenbazar.replaceElemwithGreatRS_1299;

/*

Given an array arr, replace every element in that array with the greatest element
among the elements to its right, and replace the last element with -1.

After doing so, return the array.

Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
Explanation: 
- index 0 --> the greatest element to the right of index 0 is index 1 (18).
- index 1 --> the greatest element to the right of index 1 is index 4 (6).
- index 2 --> the greatest element to the right of index 2 is index 4 (6).
- index 3 --> the greatest element to the right of index 3 is index 4 (6).
- index 4 --> the greatest element to the right of index 4 is index 5 (1).
- index 5 --> there are no elements to the right of index 5, so we put -1.

 */

import java.util.*;

class Solution {

    private int returnGreatest(int[] arr, int i) {
        int tempGreatest = Integer.MIN_VALUE;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] > tempGreatest) {
                tempGreatest = arr[j];
            }
        }
        return tempGreatest;
    }

    public int[] replaceElements(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int[] res = new int[1];
        if (arr.length == 1) {
            res[0] = -1;
            return res;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int getG = returnGreatest(arr, i);
            list.add(getG);
        }
        list.add(-1);
        int[] arr_ = list.stream().mapToInt(i -> i).toArray();
        return arr_;
    }
}
