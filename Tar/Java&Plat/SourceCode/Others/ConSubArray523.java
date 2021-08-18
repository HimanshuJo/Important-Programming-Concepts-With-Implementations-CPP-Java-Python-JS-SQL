
/*

Given an integer array nums and an integer k, return true if nums has a 
continuous subarray of size at least two whose elements sum up to a multiple of k, 
or false otherwise.

An integer x is a multiple of k if there exists an integer n such that x = n * k. 
0 is always a multiple of k.

Example 1:

Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.


*/


class Solution {
    
    public boolean checkSubarraySum(int [] nums, int k) {
        // key will be rolling sum % k
        // val will be array index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = k == 0 ? sum : sum % k;
            // when map contains mod, it means that there exist a subarray from
            // 0 ~ j (j == map.get(mod))
            // where its sum % k == mod
            if (map.constainsKey(mod) && i - map.get(mod) > 1) return true;
            map.putIfAbsent(mod, i);
        }
        return false;
    }
}
