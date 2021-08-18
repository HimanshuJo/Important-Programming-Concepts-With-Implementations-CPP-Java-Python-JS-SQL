/*

Directory to test few algorithm tasks

 */
package com.essenbazar.revCharArray;

/**
 *
 * @author hjoshi
 */
public class Main {

    public void charArrayrev(String s1) {

        char[] chars = s1.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
        System.out.println(chars);
    }

    public static void main(String[] args) {
        Main my_obj = new Main();
        String my_string = "himanshh";
        my_obj.charArrayrev(my_string);
    }
}
