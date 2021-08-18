package com.essenbazar._720;

import java.util.Scanner;

/*
 * 
 * Nastia and a Good Array:
 * 
 * Nastia has received an array of n positive integers as a gift.
 * 
 * She calls such an array a good that for all i (2≤i≤n) takes place
 * gcd(ai−1,ai)=1, where gcd(u,v) denotes the greatest common divisor (GCD) of
 * integers u and v.
 * 
 * You can perform the operation: select two different indices i,j (1≤i,j≤n,
 * i≠j) and two integers x,y (1≤x,y≤2⋅109) so that min(ai,aj)=min(x,y). Then
 * change ai to x and aj to y.
 * 
 * Input
 * 
 * 2 5 9 6 3 11 15 3 7 5 13
 * 
 * Output
 * 
 * 2 1 5 11 9 2 5 7 6 0
 * 
 */

/*
 * 
 * Prime Intution is to make a sequence that is strictly increasing
 * 
 * For that we need to make the very first value in our series to be the minimum
 * value
 * 
 * -------
 * 
 * For that it makes sense to check which index has the minimum value
 * 
 * We can swap the minimum value with the value present in the first index, if
 * it is already minimum continue
 * 
 * suppose the array is: [9, 6, 3, 11]
 * 
 * so ai will be 3 which is at 3 index aj will be 9 which is at 1 index
 * 
 * x will be 3 (ai) y will be 9 (aj)
 * 
 * -------
 * 
 * As an operation we will write: 3 1 9 3
 * 
 * index are 1 based 3 -> where the smalles element was (i) -> element is ai 1
 * -> with whom the smallest value has been swaped (j) -> element is aj
 * 
 * -------
 * 
 * so here we are basicaly swapping numbers
 * 
 * -------
 * 
 * 9 -> what number I am putting at j, this is basically new ai or x 3 -> what
 * number I am putting at i, this is basically new aj or y
 * 
 * the array is now: 3 6 9 11
 * 
 * [index ai, index aj, new ele at index ai, new ele at index aj]
 * 
 * -------
 * 
 * we have used one operation and make the first index the smallest ele
 * 
 * now we have to make our array strictly increasing
 * 
 * new we make the num at second index one greater than the 1st num
 * 
 * loop through the 2nd index and perform the same operations
 * 
 * -------
 * 
 * We will fix ai again as the smallest element x as the value of this ai
 * 
 * we will take y as index next to ai and aj will become ai + 1
 * 
 * 1 -> where the smallest element is
 * 
 * 2 -> where the j is
 * 
 * -------
 * 
 * 3 -> what value we want at ai is basically the smallest element that is 3 4
 * -> what value we need at the next index
 * 
 */

public class MainB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; ++i) {
			solve(sc);
		}
	}

	public static void solve(Scanner sc) {
		int n;
		n = sc.nextInt();
		int[] arr = new int[n + 1];
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 1; i <= n; ++i) {
			int num = sc.nextInt();
			arr[i] = num;
			if (arr[i] < min) {
				index = i;
				min = arr[i];
			}
		}
		if (index == 1) {
			System.out.println(n - 1);
			for (int i = 2; i <= n; ++i) {
				System.out.println(1 + " " + i + " " + arr[1] + " " + (arr[1] + i - 1));
			}
		} else {
			System.out.println(n);
			System.out.println(1 + " " + index + " " + arr[index] + " " + arr[1]);
			arr[index] = arr[index] ^ arr[1] ^ (arr[1] = arr[index]);
			for (int i = 2; i <= n; ++i) {
				System.out.println(1 + " " + i + " " + arr[1] + " " + (arr[1] + i - 1));
				arr[i] = arr[1] + i - 1;
			}
		}
	}
}
