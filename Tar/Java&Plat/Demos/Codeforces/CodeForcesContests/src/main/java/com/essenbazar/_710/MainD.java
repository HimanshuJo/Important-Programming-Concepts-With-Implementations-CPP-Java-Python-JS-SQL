package com.essenbazar._710;

/*

Intution:

   Which are the cases, where we will be left with the elements

Algo:

   If n is odd:

       there is very high probability that one will be left in the end
           as there is always a pair of two elements

Case 1:

   Suppose x is the element in our array that is occurring most of the time

           suppose it has the frequency of m

           if m <= n / 2

               in this case the answer will be 0 (when n is even)

               if n is odd then answer will be 1
Case 2:
   
   Suppose x is the element in our array that is occurring most of the time

       suppose it has the frequency of m

       if m > n / 2

           res = m - (n - m)
   

*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MainD {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t;
			t = sc.nextInt();
			while (t-- > 0) {
				int n;
				n = sc.nextInt();
				int[] arr = new int[n];
				for (int i = 0; i < n; ++i) {
					arr[i] = sc.nextInt();
				}
				Map<Integer, Integer> map = new HashMap<>();
				for (int i = 0; i < arr.length; ++i) {
					map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
				}
				int res = Integer.MIN_VALUE;
				for (Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
					Entry<Integer, Integer> entry = iterator.next();
					int toSub = (int) (entry.getValue());
					if (toSub > res) {
						res = toSub;
					}
				}
				int finalRes = 0;
				if (res <= n / 2) {
					if (n % 2 == 0) {
						finalRes = 0;
					} else {
						finalRes = 1;
					}
					System.out.println(finalRes);
				} else if (res > n / 2) {
					finalRes = res - (n - res);
					System.out.println(finalRes);
				}
			}
		}
	}
}
