package com.essenbazar.flippingImage_832;

import java.util.ArrayList;
import java.util.List;

/*

Given an n x n binary matrix image, flip the image horizontally, then invert it, 
and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.

For example, flipping [1,1,0] horizontally results in [0,1,1].
To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.

For example, inverting [0,1,1] results in [1,0,0].
 

Example 1:

Input: image = [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]

Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

 */

class Solution {

    public int[][] flipAndInvertImage(int[][] A) {
        List<List<Integer>> dd_list = new ArrayList<>();
        List<List<Integer>> dd_list_ = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int[] arr = A[i];
            int[] temp_arr = new int[arr.length];
            int j = 0;
            for (int x = arr.length - 1; x >= 0; x--) {
                temp_arr[j] = arr[x];
                j++;
            }
            List<Integer> list = new ArrayList<>();
            for (Integer num : temp_arr) {
                list.add(num);
            }
            dd_list.add(list);
        }
        for (int z = 0; z < dd_list.size(); z++) {
            int[] arr = dd_list.get(z).stream().mapToInt(i -> i).toArray();
            int[] temp_arr = new int[arr.length];
            for (int x = 0; x < arr.length; x++) {
                if (arr[x] == 0) {
                    temp_arr[x] = 1;
                } else if (arr[x] == 1) {
                    temp_arr[x] = 0;
                }
            }
            List<Integer> list = new ArrayList<>();
            for (Integer num : temp_arr) {
                list.add(num);
            }
            dd_list_.add(list);

        }
        int[][] res = dd_list_.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        return res;
    }
}
