/*
Project for solving some April_21 leetcode problems
 */
package com.essenbazar.powerfulIntegers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author himanshu
 */
/*

Given three integers x, y, and bound, return a list of all the powerful integers that 
have a value less than or equal to bound.

An integer is powerful if it can be represented as xi + yj for some integers i >= 0 and j >= 0.

You may return the answer in any order. In your answer, each value should occur at most once.

Example 1:

Input: x = 2, y = 3, bound = 10
Output: [2,3,4,5,7,9,10]
Explanation:
2 = 20 + 30
3 = 21 + 30
4 = 20 + 31
5 = 21 + 31
7 = 22 + 31
9 = 23 + 30
10 = 20 + 32

 */

/*

Suppose we have x = 2 and y = 3 and bound = 10

    Firstly we can take the power of 2 until the bound condition is satisfied

        e.g. 2^0 = 1
             2^1 = 2
             2^2 = 4
             2^3 = 8
             2^5 = 16  --> out of bound

    Similary we can do that for 3

        e.g. 3^0 = 1
             3^1 = 3
             3^2 = 9
             3^3 = 27  --> out of bound

    Lastly we need to find the combination of both
        we need to find the addition of:
            2^0 with
                3^0
                3^1
                3^2

            and include only those which are inside the bound
            
            2^1 with
                3^0
                3^1
                3^2

            here 2^1 + 3^2 = 11 which goes out of bound so we will not include it
            
            ...

    -------

    Edge case, what if one of the number is 1

        in that case for example: 1^0 = 1 or 1^2 = 1 and so on..

        and that would be lower than our bound and give us TLE

    We need to keep in mind this special case of either of these numbers being one
        and that is we will only consider a single one and do not consider the other number

*/

class Solution {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        
        // we require two lists to store the power of x and y

        List<Integer> px = new ArrayList<>();
        List<Integer> py = new ArrayList<>();
        
        int powx = x, powy = y;  // to store the temporary power of x and y
        
        // we do this because we don't want to iterate when my x == 1 or y == 1
        
        px.add(1);  // anything raise to 0 is 1 so it is being included to both the lists
        py.add(1);
        
        // now we will only have the condition of either x != 1 or y != 1
        if (x != 1) {
            // here we will calculate the powers of x until it is less than the bound
            while (powx < bound) {
                px.add(powx);
                powx *= x;
            }
        }
        
        if (y != 1) {
            while (powy < bound) {
                py.add(powy);
                powy *= y;
            }
        }
        
        Set<Integer> res = new HashSet<>();
        for (int i : px) {
            for (int j : py) {
                if (i + j <= bound) {
                    res.add(i + j);
                }
            }
        }
        
        return res.stream().collect(Collectors.toList());

    }

    public static void main(String[] args) {
        Solution myObj = new Solution();
        int x = 2;
        int y = 3;
        int bound = 10;
        myObj.powerfulIntegers(x, y, bound);
    }
}
