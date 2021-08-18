class Solution
{
    public boolean checkPalindromeFormation(String a, String b)
    {

        int i = 0;
        int j = a.length() - 1;

        boolean a1_b2 = true;
        boolean b1_a2 = true;

        while (i < j)
        {
            boolean increment = false;
            if (a1_b2 && a.charAt(i) == b.charAt(j))
            {
                increment = true;
            }
            else
            {
                a1_b2 = false;
            }
            if (b1_a2 && b.charAt(i) == a.charAt(j))
            {
                increment = true;
            }
            else
            {
                b1_a2 = false;
            }
            if(increment)
            {
                i++;
                j--;
            }
            if (!a1_b2 && !b1_a2)
            {
                break;
            }
        }

        return a1_b2 || b1_a2;
    }
}
