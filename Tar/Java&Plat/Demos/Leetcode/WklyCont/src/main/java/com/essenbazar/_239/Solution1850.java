package com.essenbazar._239;

/*
 *
 * You are given a string num, representing a large integer, and an integer k.
 *
 * We call some integer wonderful if it is a permutation of the digits in num
 * and is greater in value than num. There can be many wonderful integers.
 *
 * However, we only care about the smallest-valued ones.
 *
 * For example, when num = "5489355142": The 1st smallest wonderful integer is
 * "5489355214". The 2nd smallest wonderful integer is "5489355241". The 3rd
 * smallest wonderful integer is "5489355412". The 4th smallest wonderful
 * integer is "5489355421".
 *
 * Return the minimum number of adjacent digit swaps that needs to be applied to
 * num to reach the kth smallest wonderful integer.
 *
 * The tests are generated in such a way that kth smallest wonderful integer
 * exists.
 *
 * Example 1:
 *
 * Input: num = "5489355142", k = 4 Output: 2 Explanation: The 4th smallest
 * wonderful number is "5489355421". To get this number: - Swap index 7 with
 * index 8: "5489355142" -> "5489355412" - Swap index 8 with index 9:
 * "5489355412" -> "5489355421"
 *
 *
 */

class Solution1850 {

	public int getMinSwaps(String num, int k) {
		int N = num.length();
		int[] orig = new int[num.length()];
		int[] nums = new int[num.length()];
		for (int i = 0; i < num.length(); ++i) {
			nums[i] = num.charAt(i) - '0';
			orig[i] = num.charAt(i) - '0';
		}
		while (k-- > 0) {
			nextPermutation(nums);
		}
		int res = 0;
		for (int i = 0; i < N; ++i) {
			if (nums[i] != orig[i]) {
				int j = i;
				while (nums[j] != orig[i]) {
					++j;
				}
				for (int x = j; x > i; --x) {
					swap(nums, x, x - 1);
					res++;
				}
			}
		}
		return res;
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}

	public void nextPermutation(int[] nums) {
		if (nums.length < 2) {
			return;
		}
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
					temp = temp != -1 && nums[temp] < nums[i] ? temp : i;
				} else {
					break;
				}
			}
			int curr = nums[temp];
			nums[temp] = nums[firstDecreasing];
			nums[firstDecreasing] = curr;
		}
		reverse(nums, firstDecreasing + 1, nums.length - 1);
	}

	public void reverse(int[] nums, int left, int right) {
		while (left < right) {
			int curr = nums[left];
			nums[left] = nums[right];
			nums[right] = curr;
			left++;
			right--;
		}
	}
}
