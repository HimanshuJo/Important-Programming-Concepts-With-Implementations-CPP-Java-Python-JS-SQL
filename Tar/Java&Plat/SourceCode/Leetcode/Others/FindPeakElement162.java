
import java.util.*;

class Solution
{
    public int findPeakElement(int[] nums)
    {

        int max_element =  Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] > max_element)
                max_element = nums[i];
        }

        int index = 0;
        int j = 0;
        while (j < nums.length)
        {
            if (nums[j] == max_element)
            {
                index = j;
                return j;
            }
            else
                j += 1;
        }

        return index;
    }

    public static void main(String[] args)
    {
        Solution my_obj =  new Solution();
        int[] num_array = {1, 6, 7, 7, 8, 9};
        System.out.println(my_obj.findPeakElement(num_array));
    }
}
