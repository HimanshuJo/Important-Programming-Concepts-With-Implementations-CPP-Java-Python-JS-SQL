
import java.lang.Math;

class Solution
{
    public boolean isPowerOfTwo(int n)
    {

        long i = 1;

        while (i < n)
        {
            i *= 2;
        }

        return i == n;
    }

    public static void main(String[] args)
    {
        Solution my_obj =  new Solution();
        int number = (int) Math.pow(2, 31);
        System.out.println(my_obj.isPowerOfTwo(number));
    }
}
