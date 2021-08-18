/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essenbazar.uglyNumberII_264;

/**
 *
 * @author himanshu
 */

/*

O(1) space algo

*/

public class Solution_2 {
    
    private int greatestDivide(int a, int b) {
        while (a % b == 0) {
            a /= b;
        }
        
        return a;
    }
    
    private boolean uglyCount(int n) {
        n = greatestDivide(n, 2);
        n = greatestDivide(n, 3);
        n = greatestDivide(n, 5);
        
        return n == 1;
    }
    
    
    public int nthUglyNumber(int n) {
        
        int index = 1;
        int count = 1;
        
        while (n > count) {
            index++;
            if (uglyCount(index))
                count++;
        }
        
        return index;
    }
}
