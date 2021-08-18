
package com.essenbazar.ifNumIsPalindrome;

/**
 *
 * @author hjoshi
 */
public class Solution {

    public boolean isPalindrome(int n) {

        if (n < 0) {
            return false;
        }
        int rev = 0;
        int temp = n;

        while (temp != 0) {
            rev = (rev * 10) + temp % 10;
            temp =  temp / 10;
        }

        return rev == n;
    }
    public static void main(String[] args) {
        Solution my_obj =  new Solution();
        System.out.println(my_obj.isPalindrome(121));
    }

}
