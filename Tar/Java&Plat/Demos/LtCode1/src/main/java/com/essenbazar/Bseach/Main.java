package com.essenbazar.Bseach;

import java.util.Arrays;

public class Main {

    public int getIndex(int[] nums, int target) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        int middle = low + (high - low) / 2;
        long start = System.nanoTime();
        while (low <= high) {
            if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
            if (nums[middle] == target) {
                long end = System.nanoTime() - start;
                System.out.println("Found it at index" + " " + middle + " in " + end);
                return 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Main my_obj = new Main();
        int[] num_array = {1, 3, 2};
        int target = 3;
        System.out.println(my_obj.getIndex(num_array, target));
    }
}
