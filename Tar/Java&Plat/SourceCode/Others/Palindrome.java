
public class Main
{

    public void revStrCheck(int n)
    {
        if (n < 0)
        {
            System.out.println("Number is less than zero");
        }
        int temp = n;
        int rev = 0;
        while (temp != 0)
        {
            rev = temp % 10 + (rev * 10);
            temp =  temp / 10;
        }
        if (rev == n)
            System.out.println("Number is a Palindrome");
        else
            System.out.println("Number is 'not' a Palindrome");
        System.out.println(rev);
    }

    public static void main(String[] args)
    {
        Main my_obj =  new Main();
        my_obj.revStrCheck(12113215);
    }

}
