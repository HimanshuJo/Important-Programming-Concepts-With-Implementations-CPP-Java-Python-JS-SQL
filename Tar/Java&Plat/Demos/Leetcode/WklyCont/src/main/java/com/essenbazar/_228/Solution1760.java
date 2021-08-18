package com.essenbazar._228;

/*
 * You are given an integer array nums where the ith bag contains nums[i] balls.
 * You are also given an integer maxOperations.

You can perform the following operation at most maxOperations times:

    Take any bag of balls and divide it into two new bags with a positive number of balls.
        For example, a bag of 5 balls can become two new bags of 1 and 4 balls,
        or two new bags of 2 and 3 balls.

Your penalty is the maximum number of balls in a bag. You want to minimize your
penalty after the operations.

Return the minimum possible penalty after performing the operations.

Input: nums = [9], maxOperations = 2
Output: 3
Explanation:
- Divide the bag with 9 balls into two bags of sizes 6 and 3. [9] -> [6,3].
- Divide the bag with 6 balls into two bags of sizes 3 and 3. [6,3] -> [3,3,3].
The bag with the most number of balls has 3 balls, so your penalty is 3 and you should return 3.
 */
/*
 * Approach:
 * 	Use the Binary Search to locate the minimum size that we can divide to, given the max Operations
 * 		1. At least there is 1 and at most there are 10^9 balls in a bag, considering the range;
 * 			therefore we choose 1 and 10^9 + 1 as low and high bound inclusively and exclusively resp.
 * 		2. The min value of the max size must be between low and high bounds:
 * 			low and high, we can check if the mid value size between low and high, is no less than or less
 * 			than the required solution; this process is completed by private method canDivide()
 * 		3. Adjust the low or high bounds accordingly to the value of canDivide(), then repeat 2 till
 * 			low == high, which is the solution
 */
public class Solution1760 {
	public int minimumSize(int[] nums, int maxOperations) {
		int low = 1, high = (int) 1e9 + 1;
		while (low < high) {
			int size = low + high >> 1;
			if (canDivide(nums, size, maxOperations)) {
				System.out.println("T: size here: " + size);
				System.out.println("T: low here: " + low);
				System.out.println("T: high here: " + high);
				System.out.println("-------");
				high = size;
			} else {
				System.out.println("F: size here: " + size);
				System.out.println("F: low here: " + low);
				System.out.println("F: high here: " + high);
				System.out.println("-------");
				low = size + 1;
			}
		}
		return low;
	}

	public boolean canDivide(int[] nums, int size, int maxOperations) {
		int count = 0;
		for (int balls : nums) {
			System.out.println("balls: " + balls);
			System.out.println("size: " + size);
			count += (balls - 1) / size;
			System.out.println("count: " + count);
			if (count > maxOperations) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution1760 obj = new Solution1760();
		int[] nums = { 2, 4, 8, 2 };
		int maxOperations = 4;
		System.out.println(obj.minimumSize(nums, maxOperations));
	}
}
