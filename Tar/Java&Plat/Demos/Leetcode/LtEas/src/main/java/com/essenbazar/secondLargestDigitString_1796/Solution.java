/*
Project for solving some common algorithm problems
 */
package com.essenbazar.secondLargestDigitString_1796;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author himanshu
 */

/*

Given an alphanumeric string s, return the second largest numerical digit that appears in s,
or -1 if it does not exist.

An alphanumeric string is a string consisting of lowercase English letters and digits.

Example 1:

Input: s = "dfa12321afd"
Output: 2
Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.


 */
class Solution {

    private String extractInt(String str) {
        str = str.replaceAll("[^\\d]", " ");
        str = str.trim();
        str = str.replaceAll(" +", " ");

        if (str.equals("")) {
            return "-1";
        }

        return str;
    }

    public int secondHighest(String s) {
        boolean containsDig = false;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                containsDig = true;
                break;
            }
        }

        if (containsDig) {
            String sbf = extractInt(s);
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < sbf.length(); ++i) {
                set.add(Character.getNumericValue(sbf.charAt(i)));
            }
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            if (list.size() == 2) {
                return list.get(0);
            } else if (list.size() == 1) {
                return -1;
            }
            return list.get(list.size() - 2);
        } else {
            return -1;
        }
    }
}
