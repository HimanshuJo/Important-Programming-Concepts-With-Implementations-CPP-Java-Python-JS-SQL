
/*

Implement next permutation, which rearranges numbers into the lexicographically next 
greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order 
(i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]

*/

class Solution {
    
    public void reverse(int[] nums, int left) {
        int right = nums.length - 1;
        
        while (left < right) {
            int curr = nums[left];
            nums[left] = nums[right];
            nums[right] = curr;
            left++;
            right--;
        }
    }
    
    public void nextPermutation(int[] nums) {
        
        if (nums.length < 2) return;
        
        int firstDecreasing = -1;
        
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                firstDecreasing = i;
                break;
            }
        }
        
        if (firstDecreasing != -1) {
            int temp = -1;
            
            for (int i = firstDecreasing + 1; i < nums.length; ++i) {
                if (nums[i] > nums[firstDecreasing]) {
                    // if the curr num is greater, we only need the lowest number which is
                        // greater than the current
                    temp = temp != -1 && nums[temp] < nums[i] ? temp : i;
                } else {
                    break;
                }
            }
            
            int curr = nums[temp];
            nums[temp] = nums[firstDecreasing];
            nums[firstDecreasing] = curr;
        }
        
        reverse(nums, firstDecreasing + 1);
        
    }
}