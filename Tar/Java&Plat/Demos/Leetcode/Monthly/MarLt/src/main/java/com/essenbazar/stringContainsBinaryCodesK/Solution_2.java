/*
Project for solving some Mar_21 leetcode problems
 */
package com.essenbazar.stringContainsBinaryCodesK;

/**
 *
 * @author himanshu
 */

/*

Return True if every binary code of length k is a substring of s. Otherwise, return False.

We just need to check every substring with length k until we get all the possible binary codes.

Since there are two possible char for each place: 0 or 1, there will be 2^k possible binary code.

We can continue until we count up to 2^k.
    
    We will return false if did not get 2^k counts after iteration.
    To prevent repeated counting, a set can be used to store the result we previously counted.

 */
import java.util.*;

public class Solution_2 {

    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;

        Set<String> set = new HashSet<>();

        for (int i = k; i <= s.length(); i++) {
            String a = s.substring(i - k, i);
            //System.out.println("substring " + a);
            if (!set.contains(a)) {
                set.add(a);
                need--;
                if (need == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution my_obj = new Solution();
        String s = "00110110";
        my_obj.hasAllCodes(s, 4);
    }

}
