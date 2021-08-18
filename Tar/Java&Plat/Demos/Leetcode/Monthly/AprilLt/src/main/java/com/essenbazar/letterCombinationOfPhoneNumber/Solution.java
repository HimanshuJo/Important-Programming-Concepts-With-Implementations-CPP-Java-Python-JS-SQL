/*
Project for solving some April_21 leetcode problems
 */
package com.essenbazar.letterCombinationOfPhoneNumber;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author himanshu
 */

/*

Given a string containing digits from 2-9 inclusive, return all possible letter combinations 
that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. 
Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]


 */

 /*

Algo:

Intution:

    Suppose we have a number 23 (digit string)

        As the first number present in this string is 2, we will press the digit 2

            when we press the digit two, it can represent any of the three character that is mapped to
                this particular digit

                2 -> a, b and c

            Now we move ahead and press the digit 3 and the characters mapped to this digit

                3 -> d, e and f

        Now we need to find all the combinations that can exist between these 6 characters

        The constraint is 'the length of the resultant string should be only of length
            equal to the digit's length (that is 2 in this case)

            We will find the combinations that we get, initially from the character a
                and all the three characters from the digit 3

                a -> ad, ae, af
                b -> bd, be, bf
                c -> cd, ce, cf

        As we notice more closely we are working in a DFS fashion

            wherein we take one character (e.g. a), 
                go all the way till the end of the combination in this case (e.g. d)

            at 'd' we found out that the length of the string is now equal to the digit string
                so we know that we have come across one combination

                we add this combination to our resultant list

            We then we work backwards
                go again to 'a', taken next char from b (that is 'e')

        -------

        So in essence we will use the DFS approach wherein the exit condition is based on the
            the length of the resultant string and the original length of the string given to us

 */
class Solution {

    List<String> result = null;
    String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        dfs(0, digits, new StringBuilder());

        return result;
    }

    private void dfs(int length, String digits, StringBuilder temp) {
        if (length == digits.length()) {
            result.add(temp.toString());
            return;
        }

        char ch = digits.charAt(length);
        String str = mapping[ch - '0'];
        for (char c : str.toCharArray()) {
            temp.append(c);
            dfs(length + 1, digits, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
    
    public static void main(String [] args) {
        Solution myObj = new Solution();
        String digits = "23";
        myObj.letterCombinations(digits);
    }
}

/*

Time Complexity:

    O(4^N * N)

        As in the worst case, the digits contain in this string are only 7 and 9

Space Complexity:

    O(n)

 */
