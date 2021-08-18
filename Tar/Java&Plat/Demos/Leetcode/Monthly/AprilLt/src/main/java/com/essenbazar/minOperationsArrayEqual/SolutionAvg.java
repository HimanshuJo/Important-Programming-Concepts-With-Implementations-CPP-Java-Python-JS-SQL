/*
Project for solving some April_21 leetcode problems
 */
package com.essenbazar.minOperationsArrayEqual;

/**
 *
 * @author himanshu
 */
public class SolutionAvg {

    public int minOperations(int n) {
        int res = 0;

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (2 * i) + 1;
        }

        //System.out.println(Arrays.toString(arr));
        if (n % 2 != 0) {
            int mid = arr[arr.length / 2];
            for (int i = 0; i < arr.length; ++i) {
                res += Math.abs(mid - arr[i]);
            }
        } else if (n % 2 == 0) {
            int mid = (arr[(arr.length / 2) - 1] + arr[arr.length / 2]) / 2;
            //System.out.println(mid);
            for (int i = 0; i < arr.length; ++i) {
                res += Math.abs(mid - arr[i]);
            }
        }

        return res / 2;
    }
}
