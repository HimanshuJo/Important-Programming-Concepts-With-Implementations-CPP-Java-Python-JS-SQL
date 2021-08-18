/*
Project for solving some feb_21 leetcode problems
 */
package com.essenbazar.containerWithMostWater;

/**
 *
 * @author himan
 */
import java.util.*;

class Solution {

    public int maxArea(int[] height) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int first_max = height[0];
        int second_max = height[1];
        int temp_second_max = 0;
        int start = 0;
        if (height[0] < height[1]) {
            for (int i = 0; i < height.length; i++) {
                if (height[start] < height[start + 1]) {
                    start++;
                } else {
                    break;
                }
            }

            first_max = height[start];
            second_max = height[start + 1];
        }
        List<Integer> ini_l = new ArrayList<>();
        ini_l.add(start);
        ini_l.add(first_max);
        map.put(1, ini_l);
        //System.out.println(first_max);
        //System.out.println(second_max);
        for (int i = start + 1; i < height.length; i++) {
            if (height[i] > first_max) {
                first_max = height[i];
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(first_max);
                map.replace(1, list);
            } else if (height[i] < first_max && height[i] > second_max) {
                second_max = height[i];
                List<Integer> list_ = new ArrayList<>();
                list_.add(i);
                list_.add(second_max);
                map.put(2, list_);
            } else if (height[i] > second_max && height[i] == first_max) {
                if (i == height.length - 1) {
                    second_max = height[i];
                    List<Integer> list__ = new ArrayList<>();
                    list__.add(i);
                    list__.add(second_max);
                    map.replace(2, list__);
                } else {
                    temp_second_max = height[i];
                    List<Integer> list___ = new ArrayList<>();
                    list___.add(i);
                    list___.add(temp_second_max);
                    map.put(3, list___);
                }
            }

            if (i == height.length - 1) {
                List<Integer> temp_list = map.get(2);
                int check_index = temp_list.get(0);
                List<Integer> temp_list2 = map.get(3);
                int check_index2 = temp_list2.get(0);
                if (check_index < check_index2) {
                    map.replace(2, temp_list2);
                }
            }
        }

        System.out.println(map.toString());
        List<Integer> l1 = map.get(2);
        int h = l1.get(1);

        List<Integer> l2 = map.get(1);
        int w = (l1.get(0)) - (l2.get(0));

        int result = (int) h * w;
        return result;
    }

    public static void main(String[] args) {
        Solution my_obj = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(my_obj.maxArea(height));
    }
}
