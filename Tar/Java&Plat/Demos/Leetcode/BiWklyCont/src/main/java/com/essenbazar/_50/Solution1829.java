package com.essenbazar._50;

// Maximum XOR for Each Query
/*
 *	You are given a sorted array nums of n non-negative integers and an integer maximumBit. 
 *	You want to perform the following query n times:

    Find a non-negative integer k < 2^maximumBit such that 
    nums[0] XOR nums[1] XOR ... XOR nums[nums.length-1] XOR k is maximized. 
    
    k is the answer to the ith query.
    
    Remove the last element from the current array nums.

	Return an array answer, where answer[i] is the answer to the ith query.
	
	Input: nums = [0,1,1,3], maximumBit = 2
	Output: [0,3,2,3]
	Explanation: The queries are answered as follows:
	1st query: nums = [0,1,1,3], k = 0 since 0 XOR 1 XOR 1 XOR 3 XOR 0 = 3.
	2nd query: nums = [0,1,1], k = 3 since 0 XOR 1 XOR 1 XOR 3 = 3.
	3rd query: nums = [0,1], k = 2 since 0 XOR 1 XOR 2 = 3.
	4th query: nums = [0], k = 3 since 0 XOR 3 = 3.
	
	Input: nums = [2,3,4,7], maximumBit = 3
	Output: [5,2,6,5]
	Explanation: The queries are answered as follows:
	1st query: nums = [2,3,4,7], k = 5 since 2 XOR 3 XOR 4 XOR 7 XOR 5 = 7.
	2nd query: nums = [2,3,4], k = 2 since 2 XOR 3 XOR 4 XOR 2 = 7.
	3rd query: nums = [2,3], k = 6 since 2 XOR 3 XOR 6 = 7.
	4th query: nums = [2], k = 5 since 2 XOR 5 = 7.
	
	Example 3:
	
	Input: nums = [0,1,2,2,5,7], maximumBit = 3
	Output: [4,3,6,4,6,7]

 */

/*
 * Basic XOR operations:
 * 
 * 		x ^ x = 0 (A number xor with itself is always 0)
 * 
 * 		x ^ 0 = x (A number xor with 0 always results in the same number)
 * 
 * 		111111 ^ 101010 = 010101 
 * 			(A number which has all 1 in it's binary representation, when xor with a number which has
 * 				alternate 0 and 1 in it's binary representation (starting with 1) results in
 * 				flipping of all the bits in the other number)
 * 
 *  	Let xorVal = a ^ b ^ c
 *  		If we want to remove any number let's say her we want ot remove c
 *  
 *  	then the operation should look like this:
 *  		
 *  		xorVal ^ c = a ^ b ^ c ^ c (we will xor with c both the sides)
 *  
 *  	=>  xorVal ^ c = a ^ b ^ 0
 *  	=>  xorVal ^ c = a ^ b
 *  
 *  	-------
 *  
 *  	Let xor be the xor of all the elements
 *  		we want to maximize xor ^ k (we want to find a k such that xor is maximized)
 *  
 *  	Suppose our maximumBit = 3, and the number we have is 5 -> 101
 *  
 *  	Now to get a maximum after xoring 5 with another number, it needs to have opposite bits
 *  		at the corresponding place to get all set bits
 *  
 *  		e.g. 5 in binary -> 101 and opposite 010
 *  
 *  		and we can find it by doing: 101 ^ 111 = 010
 *  			=> 5 ^ 7 = 2 (which is our k)
 *  
 *  			As 5 ^ 2 = 7 which is the required max number
 *  	
 *  	-------
 *  
 *  	by applying the same operation we can find k by doing:
 *  		
 *  		xor ^ ((1 << maximumBit) - 1)
 *  
 *  			((1 << maximumBit) - 1) is same as Math.pow(2, maximumBit) - 1 
 *  				(but little bit faster in operation)
 *  	
 *  		For example: maximumBit = 3 => math.pow(2, 3) - 1 = 7 -> 111
 *  
 *  	-------
 *  
 *  	In other words we are finding k such that:
 *  
 *  		xor ^ k = max (let max be a number with maximum number of allowed set bits)
 *  
 *  	=> xor ^ xor ^ k = max ^ xor
 *  	=> k = max ^ xor
 *  
 *  	-------
 *  
 *		TC: O(N) Nis the length of the array
		SC: O(N)
 * 		
 */

public class Solution1829 {
	public int[] getMaximumXor(int[] nums, int maximumBit) {
		int xor = 0, n = nums.length - 1;
		int max = ((1 << maximumBit) - 1);
		int[] res = new int[n];
		for (int num : nums) {
			xor ^= num;
		}
		for (int i = 0; i < n; ++i) {
			res[i] = xor ^ max; // or k = xor ^ max
			xor ^= nums[n - i - 1]; // remove last element from the xor as it's contribution is done
		}
		return res;
	}

	public static void main(String[] args) {
		Solution1829 obj = new Solution1829();
		int[] nums = { 0, 1, 2, 2, 5, 7 };
		int maximumBit = 3;
		System.out.println(obj.getMaximumXor(nums, maximumBit));
	}
}

class Solution_PrefixXor {
	public int[] getmaximumXor(int[] nums, int maximumBit) {
		int xor = 0;
		int max = ((1 << maximumBit) - 1);
		int[] prefixXor = new int[nums.length];
		int[] finalArr = new int[nums.length];
		for (int i = 0; i < nums.length; ++i) {
			prefixXor[i] = xor ^ nums[i];
			xor = prefixXor[i];
		}
		int j = 0;
		for (int i = prefixXor.length - 1; i >= 0; --i) {
			finalArr[j++] = prefixXor[i] ^ max;
		}
		return finalArr;
	}
}

/*
 * 
 * Important point: If we have a number and we xor that number with the binary
 * opposite of that number than we will get a number which has in its binary
 * representation all bits set to 1
 * 
 * e.g. 6 in binary -> 100 opposite of 6 in binary is 3 -> 011
 * 
 * Now if we do 100 ^ 011 we will get 111 = 7
 * 
 * Now given a particular number either 6 or 3, if we want to find it's other
 * pair number that will give us the max number with all bits set to 1, we can
 * simply xor the given number with the available maxBit number
 * 
 */