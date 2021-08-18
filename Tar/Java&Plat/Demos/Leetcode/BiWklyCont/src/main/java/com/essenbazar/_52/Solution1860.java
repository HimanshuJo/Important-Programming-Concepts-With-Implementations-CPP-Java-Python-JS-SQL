package com.essenbazar._52;

/*
You are given two integers memory1 and memory2 representing the 
available memory in bits on two memory sticks. 
There is currently a faulty program running that consumes an increasing 
amount of memory every second.

At the ith second (starting from 1), i bits of memory are allocated to the 
stick with more available memory (or from the first memory stick if 
both have the same available memory). If neither stick has at least 
i bits of available memory, the program crashes.

Return an array containing [crashTime, memory1crash, memory2crash], 
where crashTime is the time (in seconds) when the program crashed and 
memory1crash and memory2crash are the available bits of memory in the 
first and second sticks respectively.

Input: memory1 = 2, memory2 = 2
Output: [3,1,0]
Explanation: The memory is allocated as follows:
- At the 1st second, 1 bit of memory is allocated to stick 1. 
    The first stick now has 1 bit of available memory.
- At the 2nd second, 2 bits of memory are allocated to stick 2. 
    The second stick now has 0 bits of available memory.
- At the 3rd second, the program crashes. The sticks have 1 and 0 bits available respectively.
 */

class Solution {

	public int[] memLeak(int memory1, int memory2) {
		int[] res = new int[3];
		int i = 1;
		int crashT = 0;
		int mem1 = memory1;
		int mem2 = memory2;
		while (true) {
			crashT = i;
			if (mem1 > mem2) {
				if (crashT > mem1) {
					break;
				}
				mem1 = mem1 - i;
			} else if (mem2 > mem1) {
				if (crashT > mem2) {
					break;
				}
				mem2 = mem2 - i;
			} else {
				if (crashT > mem1 && crashT > mem2) {
					break;
				}
				mem1 = mem1 - i;
			}
			i++;
		}
		res[0] = crashT;
		res[1] = mem1;
		res[2] = mem2;
		return res;
	}
}