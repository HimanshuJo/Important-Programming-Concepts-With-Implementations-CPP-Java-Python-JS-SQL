package com.essenbazar.copyCopy_1325B;
/*

Ehab has an array a of length n. He has just enough free time to make a new array consisting of n
copies of the old array, written back-to-back.

What will be the length of the new array's longest increasing subsequence?

A sequence a is a subsequence of an array b if a can be obtained from b by deletion of several 
(possibly, zero or all) elements. 

The longest increasing subsequence of an array is the longest subsequence such 
that its elements are ordered in strictly increasing order.

Input

The first line contains an integer t — the number of test cases you need to solve. 
    The description of the test cases follows.

The first line of each test case contains an integer n (1≤n≤105) — the number of elements in the array a

The second line contains n space-separated integers a1, a2, …, an (1≤ai≤109) — the elements of the array a

The sum of n across the test cases doesn't exceed 10^5

Output

For each testcase, output the length of the longest increasing subsequence of a if you concatenate 
    it to itself n times.

 */
import java.util.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int t;
			t = sc.nextInt();

			while (t-- > 0) {
			    int len;
			    len = sc.nextInt();
			    Set<Integer> set = new HashSet<>();
			    for (int i = 0; i < len; ++i) {
			        int num = sc.nextInt();
			        set.add(num);
			    }

			    System.out.println(set.size());
			}
		}
    }
}
