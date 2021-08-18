class Solution
{
    public int maxDepth(String s)
    {

        int current_max = 0;
        int max = 0;
        int n = s.length();
        for (int i = 0; i < n; i++)
        {
            if (s.charAt(i) == '(')
            {
                current_max++;
                if (current_max > max)
                {
                    max = current_max;
                }
            }
            else if (s.charAt(i) == ')')
            {
                if (current_max > 0)
                {
                    current_max--;
                }
                else
                {
                    return -1;
                }
            }
        }
        if (current_max != 0)
        {
            return -1;
        }
        System.out.println(max);
        return max;
    }
    public static void main(String[] args)
    {
        String s = "(1+(2*3)+((8)/4))+1";
        Solution my_obj =  new Solution();
        my_obj.maxDepth(s);
    }
}
