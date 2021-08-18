package com.essenbazar.bearAndBigBrother_791A;

/*

Bear Limak wants to become the largest of bears, or at least to become larger than his brother Bob.

Right now, Limak and Bob weigh a and b respectively. 

It's guaranteed that Limak's weight is smaller than or equal to his brother's weight.

Limak eats a lot and his weight is tripled after every year, 
while Bob's weight is doubled after every year.

After how many full years will Limak become strictly larger (strictly heavier) than Bob?

Input

The only line of the input contains two integers a and b (1 ≤ a ≤ b ≤ 10) — 
the weight of Limak and the weight of Bob respectively.

Output

Print one integer, denoting the integer number of years after which Limak will 
become strictly larger than Bob.

Examples

Input

4 7

Output

2

 */
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int[] arr = new int[2];
			arr[0] = sc.nextInt();
			arr[1] = sc.nextInt();
			int res = 0;
			while (arr[0] <= arr[1]) {
			    arr[0] *= 3;
			    arr[1] *= 2;
			    res++;
			}

			System.out.println(res);
		}
    }
}
