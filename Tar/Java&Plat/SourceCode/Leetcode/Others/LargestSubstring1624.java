
/*

Given a string s, return the length of the longest substring between two equal characters,
excluding the two characters.

If there is no such substring return -1.

A substring is a contiguous sequence of characters within a string.

*/


class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int str_len = s.length();
        int result = -1;

        for (int i = 0; i < str_len - 1; i++)
            for (int j = i + 1; j < str_len; j++)
                if (s.charAt(i) == s.charAt(j))
                    result = Math.max(result, Math.abs(j - i - 1));

        return result;
    }

    public static void main(String[] args) {
        Solution my_obj =  new Solution();
        System.out.println(my_obj.maxLengthBetweenEqualCharacters("acbcba"));
    }
}
