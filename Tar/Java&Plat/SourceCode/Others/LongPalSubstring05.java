
/*

Given a string s, return the longest palindrome substring s


Example 1:
    Input s: "babad"
    Output: "bab"

    Input s: "cbbd"
    Output: "bb"
*/

class Solution
{
    public String longestPalindrome(String s)
    {
        String res = "";
        int n = s.length();
        for (int i = 0; i < n; ++i)
        {
            String l = maxPalindrome(s, i, i, n);
            String r = maxPalindrome(s, i, i + 1, n);
            String temp = (l.length() > r.length()) ? l : r;
            res = (res.length() > temp.length()) ? res : temp;
        }
        return res;
    }

    public String maxPalindrome(String s, int l, int r, int n)
    {
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r))
        {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}