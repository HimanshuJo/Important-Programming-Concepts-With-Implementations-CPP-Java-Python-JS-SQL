/*
Project for solving some Mar_21 leetcode problems
 */
package com.essenbazar.binaryTreesWithFactors;

/**
 *
 * @author himanshu
 */
import java.util.*;

class Solution_Fail {

    public int numFactoredBinaryTrees(int[] arr) {
        int res = 0;
        res += arr.length;

        for (int j = 0; j < arr.length; j++) {
            Set<Integer> set = new HashSet<>();
            set.add(arr[j]);
            for (int i = 0; i < arr.length; i++) {
                if (arr[j] % arr[i] == 0) {
                    set.add(arr[i]);
                }
                if (set.size() == 3) {
                    break;
                }
            }
            
            System.out.println(set);
            
            if (!set.isEmpty() && set.size() == 2) {
                List<Integer> list = new ArrayList<>(set);
                Collections.sort(list);
                list.add(list.get(0));
                Collections.sort(list);
                if (list.get(0) * list.get(1) == list.get(2)) {
                    res += 1;
                }
            } else if (!set.isEmpty() && set.size() == 3) {
                List<Integer> list = new ArrayList<>(set);
                Collections.sort(list);
                if (list.get(0) * list.get(1) == list.get(2)) {
                    res += 2;
                }
            }
            System.out.println(res);
            System.out.println("-----");
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_Fail my_obj = new Solution_Fail();
        int[] arr = {2,4,5,10,4,5};
        my_obj.numFactoredBinaryTrees(arr);
    }
}
