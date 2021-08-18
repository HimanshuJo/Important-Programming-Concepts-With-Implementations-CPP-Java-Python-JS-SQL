import java.util.*;

/*class GFG {

static int fib(int n) {
double phi = (1 + Math.sqrt(5)) / 2;
return (int) Math.round(Math.pow(phi, n)
                        / Math.sqrt(5));
}

// Driver Code
public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    System.out.println("Please enter a number");
    Integer n = myObj.nextInt();
    System.out.println(fib(n));
    }
}*/

class fibonacci
{
    static int fib(int n)
    {
        int n1 = 0, n2 = 1, n3 = 0;
        if (n == 0)
            return n1;
        for (int i = 2; i <= n; i++)
        {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }

    public static void main (String args[])
    {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter a number");
        Integer n = myObj.nextInt();
        System.out.println(fib(n));
    }
}
