/*
Project for solving some feb_21 leetcode problems
 */
package com.essenbazar.lettercasePermut;

/**
 *
 * @author himan
 */

/*

Given a string S, we can transform every letter individually to be lowercase or uppercase
to create another string.

Return a list of all possible strings we could create. You can return the output in any order.

Example 1:

Input: S = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]

*/

/*

Adding the original string to the linkedlist or queue

Let's suppose we start from the end
    if the end is not a character, so do nothing

        move left, if it's a character, then we can have two permutations for that
            
            pop the string and take the two combinations for that particular string and add it to the queue
        
        move left in the original queue

            if we encounter another character, there we need to perform a permutation for each
                and every value that is present in the queue
                
                and perform the character casing permutation of the current character in the queue

                    How the character casing looks

                        take both the permuations and adding for each of these permuations both
                            the lowercase of the current character and the uppercase of the current character
            
            add everthing in the queue

*/

/*

Time:

    Number of permutations that we can have O(2^N)

Space:

    O(N * (2^N))  to store 2^N permutations

*/

import java.util.*;

class Solution {
    public List<String> letterCasePermutation(String S) {
        // using BFS
        LinkedList<String> result = new LinkedList<>();
        result.add(S);
        int n = S.length();
        
        for (int i = n - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (Character.isLetter(c)) {
                // iterate all the strings present in the linked list and add the permutations
                    // for the current character
                int size = result.size();
                while (size-- > 0) {
                    // first thing to do in BFS is always to pop an element
                    String s = result.poll();
                    String left = s.substring(0 , i);
                    String right = s.substring(i + 1, n);
                    
                    result.add(left + Character.toLowerCase(c) + right);
                    result.add(left + Character.toUpperCase(c) + right);
                }
            }
        }
        
        return result;
    }
}
