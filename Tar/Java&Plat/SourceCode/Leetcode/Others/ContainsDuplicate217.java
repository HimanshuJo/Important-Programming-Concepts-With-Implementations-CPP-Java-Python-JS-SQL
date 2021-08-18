
/*

Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should
return false if every element is distinct.

*/

import java.util.HashSet;

class Solution
{
    public boolean containsDuplicate(int[] nums)
    {

        // as soon as we see a number we remember it and when we see it twice we return true
        // we will use HashSet to remember what we've seen before
        // HashSet offers fastest lookup time

        HashSet<Integer> numbers =  new HashSet<Integer>();
        for (int i : nums)
        {
            if (numbers.contains(i))
                return true;
            else
                numbers.add(i);
        }

        return false;
    }

    public static void main(String [] args)
    {
        Solution my_obj =  new Solution();
        int [] my_array = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(my_obj.containsDuplicate(my_array));
    }
}
