
// Java program to ReverString using ByteArray.

import java.lang.*;
import java.io.*;
import java.util.*;

// Class of ReverseString

class ReverseString
{
    public static void main(String[] args)
    {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");
        String input = myObj.nextLine();

        // getBytes() method to convert string into bytes[]

        byte[] strAsByteArray = input.getBytes();

        byte[] result = new byte[strAsByteArray.length];

        result[0] = strAsByteArray[0];

        result[strAsByteArray.length - 1] = strAsByteArray[strAsByteArray.length - 1];

        // store the result in reverse order into the result byte[]

        for(int i = 1; i < strAsByteArray.length - 1; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];

        System.out.println(new String(result));
        return (new String(result));
    }
}
