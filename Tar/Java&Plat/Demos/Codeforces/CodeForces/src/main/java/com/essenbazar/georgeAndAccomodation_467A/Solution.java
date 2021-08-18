package com.essenbazar.georgeAndAccomodation_467A;
/*

George has recently entered the BSUCP (Berland State University for Cool Programmers). 
George has a friend Alex who has also entered the university. Now they are moving into a dormitory.

George and Alex want to live in the same room. The dormitory has n rooms in total. 
At the moment the i-th room has pi people living in it and the room can accommodate qi people in total (pi ≤ qi). 
Your task is to count how many rooms has free place for both George and Alex.

Input

The first line contains a single integer n (1 ≤ n ≤ 100) — the number of rooms.

The i-th of the next n lines contains two integers pi and qi (0 ≤ pi ≤ qi ≤ 100) — the number of people 
who already live in the i-th room and the room's capacity.

Output

Print a single integer — the number of rooms where George and Alex can move in.

Examples
Input

3
1 1
2 2
3 3

Output

0

Input

3
1 10
0 10
10 10

Output

2

 */
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int t;
			t = sc.nextInt();
			int res = 0;
			while (t-- > 0) {
			    int[] arr = new int[2];
			    arr[0] = sc.nextInt();
			    arr[1] = sc.nextInt();

			    if (arr[0] != arr[1] && arr[0] < arr[1]) {
			        arr[0] += 2;
			        if (arr[0] <= arr[1]) {
			            res++;
			        }
			    }
			}

			System.out.println(res);
		}
    }
}
