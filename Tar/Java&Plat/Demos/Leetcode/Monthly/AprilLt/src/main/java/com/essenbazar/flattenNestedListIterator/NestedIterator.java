/*
Project for solving some April_21 leetcode problems
 */
package com.essenbazar.flattenNestedListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author himanshu
 */

/*

You are given a nested list of integers nestedList. 
Each element is either an integer or a list whose elements may also be integers or other lists. 
Implement an iterator to flatten it.

Implement the NestedIterator class:

    NestedIterator(List<NestedInteger> nestedList) I
        Initializes the iterator with the nested list nestedList.

    int next() Returns the next integer in the nested list.

    boolean hasNext() Returns true if there are still some integers in the nested 
        list and false otherwise.

Example 1:

Input: nestedList = [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, the order of 
elements returned by next should be: [1,1,2,1,1].

Example 2:

Input: nestedList = [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
the order of elements returned by next should be: [1,4,6].

Constraints:

    1 <= nestedList.length <= 500
    The values of the integers in the nested list is in the range [-106, 106].

 */


interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
    
    List<Integer> flattenList = null;
    
    int curr = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        flattenList = new ArrayList<>();
        for (NestedInteger integer : nestedList) {
            helper(integer);
        }
    }

    @Override
    public Integer next() {
        return flattenList.get(curr++);
    }

    @Override
    public boolean hasNext() {
        return curr < flattenList.size();
    }
    
    private void helper(NestedInteger value) {
        if (value.isInteger()) {
            flattenList.add(value.getInteger());
        } else {
            for (NestedInteger integer : value.getList()) {
                helper(integer);
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such: NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()] = i.next();
 */
