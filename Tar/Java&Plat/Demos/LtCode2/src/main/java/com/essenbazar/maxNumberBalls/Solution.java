
package com.essenbazar.maxNumberBalls;

/*

Maximum Number of Balls in a Box

You are working in a ball factory where you have n balls numbered from
lowLimit up to highLimit inclusive (i.e., n == highLimit - lowLimit + 1), and
an infinite number of boxes numbered from 1 to infinity.

Your job at this factory is to put each ball in the box with a number equal to the
sum of digits of the ball's number.

For example, the ball number 321 will be put in the box number 3 + 2 + 1 = 6 and
the ball number 10 will be put in the box number 1 + 0 = 1.

Given two integers lowLimit and highLimit, return the number of balls in the box with the most balls.

 */
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public int countBalls(int lowLimit, int highLimit) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for (int i = lowLimit; i <= highLimit; i++) {
			int d = digitSum(i);
			map.put(d, map.getOrDefault(d, 0) + 1);
			res = Math.max(res, map.get(d));
		}

		return res;
	}

	private int digitSum(int i) {
		int sum = 0;
		while (i != 0) {
			sum += (i % 10);
			System.out.println("Sum is " + sum);
			i /= 10;
		}

		return sum;
	}

	private int arrayCheck(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Arr[i] is :" + arr[i]);
			try {
				System.out.println("Arr[i + 1] is :" + arr[i + 1]);
			} catch (Exception ArrayIndexOutOfBoundsException) {
				System.out.println("Array out of bound");
			}
		}
		System.out.println("---------------------");
		for (int i = 1; i < arr.length - 1; i++) {
			System.out.println("Arr[i] is :" + arr[i]);
			try {
				System.out.println("Arr[i - 1] is :" + arr[i - 1]);
			} catch (Exception ArrayIndexOutOfBoundsException) {
				System.out.println("Array out of bound");
			}
		}

		int lowLimit = 5;
		int highLimit = 10;

		System.out.println("---------------------");

		for (int i = lowLimit; i <= highLimit; i++) {
			System.out.println(i);
		}

		return 1;
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(my_obj.arrayCheck(arr));
	}
}
