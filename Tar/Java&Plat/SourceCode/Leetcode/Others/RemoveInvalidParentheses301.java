
/*

Remove the minimum number of invalid parentheses in order to make the input string valid.
Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

*/

// hints: return all possible results: that means we can only use brute force or backtracking!
//          as we need to generate all the possible results


/*

we can use stack or a counter to iterate the sting

current char c: ( -> stack ++
                ) -> stack --

                if stack < 0 exit --> we have to remove ')'

if stack < 0 (we need a pointer that should point to the location where we've seen the invalid parenthesis)
    pointer starts from 0 to that place, and remove a close parenthesis and call the helper function again
    we need to recursively check the rest part
    we also need handle the duplicates results

else if stack > 0

    need to remove '('
    reverse string to reuse the code

else add string to result list
    (ordered or reversed ordered)
    if left is ')' and right is '(' we've to reverse them

*/

import java.util.*;

class Solution
{
    public List<String> removeInvalidParentheses(String s)
    {
        List<String> result = new ArrayList<>();
        int left_pointer = 0;
        int right_pointer = 0;
        char[] paren_type =  new char[] {'(', ')'};
        helper(s, left_pointer, right_pointer, result, paren_type);
        return result;
    }

    private void helper(String s, int left, int right, List<String> result, char[] parenthesis)
    {
        int stack = 0;

        // first we need to move the right pointer to check whether 'closed parenthesis' > 'no. of open parenthesis'

        int n = s.length();
        for (; right < n; right ++)
        {
            char c = s.charAt(right);
            if (c == parenthesis[0])    // open parenthesis
                stack ++;
            else if (c == parenthesis[1])
                stack --;
            if (stack < 0)
                break;
        }

        if (stack < 0)    // we need to remove one closed parenthesis
        {

            // here we need to move the left pointer and keep the right pointer stay at his place

            for(; left <= right; left++)
            {
                char c = s.charAt(left);

                // we need to remove the close parenthesis, so if this char is not a closed parenthesis just continue

                if (c != parenthesis[1])
                    continue;

                // we also need to avoid duplicates; we can remove either the first seen closed parenthesis or the next
                // but not the last

                if (left > 1 && s.charAt(left) == s.charAt(left - 1))  // continue if current == next
                    continue;

                helper(s.substring(0, left) + s.substring(left + 1), left, right, result, parenthesis);

            }
        }
        else if (stack > 0)

            // we just need to reverse the order

            helper(new StringBuilder(s).reverse().toString(), 0, 0, result, new char[] {')', '('});

        else
            result.add(parenthesis[0] == '(' ? s : new StringBuilder(s).reverse().toString());
    }

    public static void main(String[] args)
    {
        Solution my_obj = new Solution();
        String input_string = "()())()";
        System.out.println(my_obj.removeInvalidParentheses(input_string));
    }
}
