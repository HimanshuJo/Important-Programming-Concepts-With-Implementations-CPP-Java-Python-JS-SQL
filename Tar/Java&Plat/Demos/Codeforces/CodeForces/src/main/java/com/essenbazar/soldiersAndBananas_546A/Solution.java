package com.essenbazar.soldiersAndBananas_546A;
/*

A soldier wants to buy w bananas in the shop. 
He has to pay k dollars for the first banana, 2k dollars for the second one and so on 
(in other words, he has to pay i·k dollars for the i-th banana).

He has n dollars. How many dollars does he have to borrow from his friend soldier to buy w bananas?

Input

The first line contains three positive integers k, n, w (1  ≤  k, w  ≤  1000, 0 ≤ n ≤ 109), 
the cost of the first banana, initial number of dollars the soldier has and number of bananas he wants.

Output

Output one integer — the amount of dollars that the soldier must borrow from his friend. 
If he doesn't have to borrow money, output 0.

Examples

Input

3 17 4

Output

13

*/
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int[] arr = new int[3];

			for (int i = 0; i < arr.length; ++i) {
			    arr[i] = sc.nextInt();
			}

			int res = 0;
			res += arr[0];

			if (arr.length > 2) {
			    for (int i = 2; i <= arr[2]; ++i) {
			        res += (arr[0] * i);
			    }

			    if (arr[1] > res) {
			        System.out.println(0);
			    } else {
			        System.out.println(Math.abs(arr[1] - res));
			    }
			} else {
			    if (arr[1] > res) {
			        System.out.println(0);
			    } else {
			        System.out.println(Math.abs(arr[1] - res));
			    }
			}
		}
    }
}
