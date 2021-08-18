
/*

You are given a string s of even length consisting of digits from 0 to 9, and two integers a and b.

You can apply either of the following two operations any number of times and in any order on s:

Add a to all odd indices of s (0-indexed).

Digits post 9 are cycled back to 0.

For example, if s = "3456" and a = 5, s becomes "3951".

Rotate s to the right by b positions.

For example, if s = "3456" and b = 1, s becomes "6345".

Return the lexicographically smallest string you can obtain by applying the above operations any
number of times on s.

A string a is lexicographically smaller than a string b (of the same length) if in the first
position where a and b differ, string a has a letter that appears earlier in the alphabet than the
corresponding letter in b.

For example, "0158" is lexicographically smaller than "0190" because the first position they differ
is at the third letter, and '5' comes before '9'.

*/

import java.util.*;

class Solution
{

    Set<String> set;
    String smallest;

    public String findLexSmallestString(String s, int a, int b)
    {
        set = new HashSet<>();
        smallest = s;

        helper(s, a, b);

        return smallest;
    }

    void helper(String s, int a, int b)
    {
        if (set.contains(s))
        {
            return;
        }

        if (s.compareTo(smallest) < 0)
        {
            smallest = s;
        }

        set.add(s);

        helper(rotate(s, b), a, b);
        helper(add(s, a), a, b);
    }

    String rotate(String s, int pos)
    {
        int len = s.length() - pos;
        return s.substring(len) + s.substring(0, len);
    }

    String add(String s, int a)
    {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (i % 2 == 1)
            {
                sum = ((c - '0') + a) % 10;
                c = (char) (sum + 48);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
