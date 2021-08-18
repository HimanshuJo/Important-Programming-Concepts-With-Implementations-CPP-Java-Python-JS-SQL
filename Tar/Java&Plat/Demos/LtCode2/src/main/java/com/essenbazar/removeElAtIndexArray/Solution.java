
package com.essenbazar.removeElAtIndexArray;

import java.util.Arrays;

class Solution {

    public int [] maxOperations(int[] nums, int k) {
        nums = removeTheElement(nums, 2);
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public int[] removeTheElement(int[] arr, int index) 
    { 
        if (arr == null || index < 0 || index >= arr.length) { 
            return arr; 
        }
        int[] anotherArray = new int[arr.length - 1]; 
        System.arraycopy(arr, 0, anotherArray, 0, index); 
        System.arraycopy(arr, index + 1, anotherArray, index, arr.length - index - 1); 
        return anotherArray; 
    }
    
    public static void main(String[] args) {
        Solution my_obj = new Solution();
        int [] nums = {1,2,3,4,5,6};
        my_obj.maxOperations(nums, 0);
    }
}
