
/*

Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.

The compressed string s should not be returned separately, but instead be stored in the
input character array chars.

Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.


Follow up:
Could you solve it using only O(1) extra space?

*/

/*
O(1) space --> we can't store anything in the memory

               we can only use a few different variables

               no real data-structures

*/

/*
Idea:

    Iterate through the whole string, and then we just need to know that for every single
        character that we're on (let's say i), how many characters following that ith character
        are the same

    Example: [a, a, b, b, c, c, c]

    so suppose i, is at a (0th index)

        we'll have another pointer j, at index 0

            j will walk forward through our string; counting how many times we have seen that same
                character

*/

class Solution {

    public int compress(char[] chars) {
        int index = 0;
        int i = 0;

        while (i < chars.length()) {
            int j = i;
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }

            chars[index++] == chars[i];  // record the character we just saw, and also keep
                                            // moving the index forward

            if (j - i > 1) {
                String count =  j - i + "";
                for (char c: count.toCharArray()) {  // walk through every char in that count
                    chars[index++] == c;
                }
            }

            i = j;
        }

        return index;
    }
}
