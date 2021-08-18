package com.essenbazar.wrongSubstraction_977A;

/*

Little girl Tanya is learning how to decrease a number by one, but she does it wrong with a number 
consisting of two or more digits. Tanya subtracts one from a number by the following algorithm:

    if the last digit of the number is non-zero, she decreases the number by one;
    if the last digit of the number is zero, she divides the number by 10 (i.e. removes the last digit). 

You are given an integer number n

Tanya will subtract one from it k times. Your task is to print the result after all k subtractions.

It is guaranteed that the result will be positive integer number.

Input

The first line of the input contains two integer numbers n and k (2≤n≤109, 1≤k≤50) — the number
from which Tanya will subtract and the number of subtractions correspondingly.

Output

Print one integer number — the result of the decreasing n by one k times.

It is guaranteed that the result will be positive integer number.

Examples

Input

512 4

Output

50

Input

1000000000 9

Output

1

Note

The first example corresponds to the following sequence: 512→511→510→51→50

 */
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner my_obj = new Scanner(System.in)) {
			int[] arr = new int[2];
			arr[0] = my_obj.nextInt();
			arr[1] = my_obj.nextInt();
			int res = 0;

			while (arr[1] > 0) {
			    String str = String.valueOf(arr[0]);
			    char temp = str.charAt(str.length() - 1);
			    int toCheck = Character.getNumericValue(temp);
			    if (toCheck != 0) {
			        int newInt = Integer.parseInt(str);
			        newInt--;
			        arr[0] = newInt;
			        res = newInt;
			    } else if (toCheck == 0) {
			        int newInt = Integer.parseInt(str);
			        newInt /= 10;
			        arr[0] = newInt;
			        res = newInt;
			    }
			    arr[1]--;
			}

			System.out.println(res);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
