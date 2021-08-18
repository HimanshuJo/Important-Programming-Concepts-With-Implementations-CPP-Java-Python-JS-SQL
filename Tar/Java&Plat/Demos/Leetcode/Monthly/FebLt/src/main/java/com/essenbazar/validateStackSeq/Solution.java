/*
Project for solving some feb_21 leetcode problems
 */
package com.essenbazar.validateStackSeq;

import java.util.Stack;

/**
 *
 * @author himan
 */

/*

Given two sequences pushed and popped with distinct values, return true if and only if
this could have been the result of a sequence of push and pop operations on an initially empty stack.


Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
Example 2:

Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.

*/

/*

We take a stack, and two pointers, one for pushed seq, and one for the popp ed seq
    pushed = [1,2,3,4,5] popped = [4,5,3,2,1]
We will interate over the pushed array and insert the fist element into the stack
    the first element in our popped array is not equal to the first element that is recently get pushed

    we push the next element into the stack, now stack contains  1, 2
        since 2 is also not the element that needs to be popped to form the popped array

        therefore we will push 3, and then we push 4

        once we have pushed 4, the popped element value and the top of the stack matches,
            so we can say that we can pop this top element

        we will again check, whether my top of the stack matches the current index element
            in the popped array, as it does not, we can't pop the element but we need to
            push the element

            keep doing the same procedure
    
*/

public class Solution {
    
    public boolean validateStackSequence(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int j = 0;
        
        for (int p : pushed) {
            st.push(p);
            
            while(!st.isEmpty() && j < popped.length && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
        }
        
        return j == popped.length;
    }
    
}
