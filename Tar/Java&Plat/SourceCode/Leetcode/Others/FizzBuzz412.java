
import java.util.*;

class Solution
{
    public List<String> fizzBuzz(int n)
    {
        List<String> output_array = new ArrayList<>();
        for (int i = 1; i <= n; i++ )
        {
            if (i % 3 == 0 && i % 5 == 0)
            {
                output_array.add("FizzBuzz");
            }
            else if (i % 5 == 0)
            {
                output_array.add("Buzz");
            }
            else if (i % 3 == 0)
            {
                output_array.add("Fizz");
            }
            else
            {
                output_array.add(String.valueOf(i));  // Integer.toString(i) will throw an error
            }
        }
        return output_array;
    }

    public static void main(String[] args)
    {
        Solution my_obj =  new Solution();
        int number = 15;
        System.out.println(my_obj.fizzBuzz(number));
    }
}
