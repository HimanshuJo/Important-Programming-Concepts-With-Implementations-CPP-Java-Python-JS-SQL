
package com.essenbazar.maxFreqStack;

/*

Implement FreqStack, a class which simulates the operation of a stack-like data structure.

FreqStack has two functions:

push(int x), which pushes an integer x onto the stack.
pop(), which removes and returns the most frequent element in the stack.
If there is a tie for most frequent element, the element closest to the top of the stack is
removed and returned.

Input: 
["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
Output: [null,null,null,null,null,null,null,5,7,5,4]
Explanation:
After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:

pop() -> returns 5, as 5 is the most frequent.
The stack becomes [5,7,5,7,4].

pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
The stack becomes [5,7,5,4].

pop() -> returns 5.
The stack becomes [5,7,4].

pop() -> returns 4.
The stack becomes [5,7].

 */

import java.util.*;

class FreqStack {

	Map<Integer, Integer> freqMap;
	Map<Integer, Stack<Integer>> freqStack;
	int maxFreq;

	public FreqStack() {
		freqMap = new HashMap<>();
		freqStack = new HashMap<>();
		maxFreq = 0;
	}

	// Incrementing value in freqMap
	// Updating the max Frequency
	// Adding value in the freqStack
	public void push(int x) {
		int freq = freqMap.getOrDefault(x, 0) + 1;
		freqMap.put(x, freq);
		if (freq > maxFreq)
			maxFreq = freq;

		// first check whether a stack present for a particular frequency
		// if not create a new stack, and put the current value into the frequency stack
		freqStack.computeIfAbsent(freq, f -> new Stack<>()).push(x);
	}

	// Return and remove the top of the max frequency
	// Update maxFreq by decrementing if applicable
	// Update freqMap
	public int pop() {
		Stack<Integer> s = freqStack.get(maxFreq);
		int top = s.pop();
		if (s.isEmpty())
			maxFreq--;
		freqMap.put(top, freqMap.get(top) - 1);
		return top;
	}
}

/**
 * Your FreqStack object will be instantiated and called as such: FreqStack obj
 * = new FreqStack(); obj.push(x); int param_2 = obj.pop();
 */
