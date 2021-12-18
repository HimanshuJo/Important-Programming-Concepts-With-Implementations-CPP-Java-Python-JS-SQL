import java.io.*;
import java.util.*;

class Solution {
    public long subArrayRanges(int[] nums) {

        long result = 0;

        int[] nextSmallestLeft = findNextSmallestLeftIndex(nums);
        int[] nextSmallestRight = findNextSmallestRightIndex(nums);

        int[] nextLargestLeft = findNextLargestLeftIndex(nums);
        int[] nextLargestRight = findNextLargestRightIndex(nums);

        for (int index = 0; index < nums.length; index++) {

            // how much left and right the current ELement can be the minimum
            long minleftCount = (index - nextSmallestLeft[index]) - 1;
            long minrightCount = (nextSmallestRight[index] - index) - 1;

            // how much left and right the current ELement can be the maximum
            long maxleftCount = (index - nextLargestLeft[index]) - 1;
            long maxrightCount = (nextLargestRight[index] - index) - 1;

            // count of subarrays for which current elemnt is minimum
            long totalMinCount = minleftCount + minrightCount + (minleftCount * minrightCount);
            // count of subarrays for which current elemnt is maximum
            long totalMaxCount = maxleftCount + maxrightCount + (maxleftCount * maxrightCount);

            result += (totalMaxCount - totalMinCount) * nums[index];
            System.out.println(result);
            System.out.println("-------");
        }

        return result;

    }

    private int[] findNextSmallestLeftIndex(int[] nums) {

        int[] result = new int[nums.length];

        Stack<Integer> decreasingStack = new Stack<>();

        for (int index = 0; index < nums.length; index++) {

            while (!decreasingStack.isEmpty() && nums[decreasingStack.peek()] > nums[index]) {

                decreasingStack.pop();

            }

            if (decreasingStack.isEmpty()) {
                result[index] = -1;

            } else {

                result[index] = decreasingStack.peek();
            }

            decreasingStack.push(index);

        }
        return result;
    }

    private int[] findNextSmallestRightIndex(int[] nums) {
        int[] result = new int[nums.length];

        Stack<Integer> decreasingStack = new Stack<>();

        for (int index = nums.length - 1; index >= 0; index--) {

            while (!decreasingStack.isEmpty() && nums[decreasingStack.peek()] >= nums[index]) {

                decreasingStack.pop();

            }

            if (decreasingStack.isEmpty()) {
                result[index] = nums.length;

            } else {

                result[index] = decreasingStack.peek();
            }

            decreasingStack.push(index);

        }

        return result;

    }

    private int[] findNextLargestLeftIndex(int[] nums) {

        int[] result = new int[nums.length];

        Stack<Integer> increasingStack = new Stack<>();

        for (int index = 0; index < nums.length; index++) {

            while (!increasingStack.isEmpty() && nums[increasingStack.peek()] < nums[index]) {

                increasingStack.pop();

            }

            if (increasingStack.isEmpty()) {
                result[index] = -1;

            } else {

                result[index] = increasingStack.peek();
            }

            increasingStack.push(index);

        }

        return result;

    }

    private int[] findNextLargestRightIndex(int[] nums) {

        int[] result = new int[nums.length];

        Stack<Integer> increasingStack = new Stack<>();

        for (int index = nums.length - 1; index >= 0; index--) {

            while (!increasingStack.isEmpty() && nums[increasingStack.peek()] <= nums[index]) {

                increasingStack.pop();

            }

            if (increasingStack.isEmpty()) {
                result[index] = nums.length;

            } else {

                result[index] = increasingStack.peek();
            }

            increasingStack.push(index);

        }

        return result;

    }

    public static void main(String[] args){
        Solution obj=new Solution();
        int[] nums=new int[3];
        nums[0]=1;
        nums[1]=2;
        nums[2]=3;
        obj.subArrayRanges(nums);
    }

}

