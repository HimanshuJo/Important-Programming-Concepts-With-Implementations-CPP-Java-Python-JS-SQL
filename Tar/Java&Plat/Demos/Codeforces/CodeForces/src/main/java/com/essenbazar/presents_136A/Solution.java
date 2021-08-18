/*
Project for solving some CodeForces problems
 */
package com.essenbazar.presents_136A;

/**
 *
 * @author himanshu
 */

/*

Little Petya very much likes gifts. Recently he has received a new laptop as a New Year 
gift from his mother. 

He immediately decided to give it to somebody else as what can be more pleasant than 
giving somebody gifts. And on this occasion he organized a New Year party at his place and 
invited n his friends there.

If there's one thing Petya likes more that receiving gifts, that's watching others giving 
gifts to somebody else. Thus, he safely hid the laptop until the next New Year and made up 
his mind to watch his friends exchanging gifts while he does not participate in the process. 

He numbered all his friends with integers from 1 to n. Petya remembered that a friend number 
i gave a gift to a friend number pi. He also remembered that each of his friends received exactly one gift.

Now Petya wants to know for each friend i the number of a friend who has given him a gift.

Input

The first line contains one integer n (1 ≤ n ≤ 100) — the quantity of friends Petya 
invited to the party. 

The second line contains n space-separated integers: the i-th number is pi — 
the number of a friend who gave a gift to friend number i. 

It is guaranteed that each friend received exactly one gift. 
It is possible that some friends do not share Petya's ideas of giving gifts to somebody else. 
Those friends gave the gifts to themselves.

Output

Print n space-separated integers: the i-th number should equal the number of the friend 
who gave a gift to friend number i.

Examples

Input

4
2 3 4 1

Output

4 1 2 3

 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int t;
			t = sc.nextInt();

			TreeMap<Integer, Integer> map = new TreeMap<>();

			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < t; ++i) {
			    int temp = sc.nextInt();
			    list.add(temp);
			}

			List<Integer> res = new ArrayList<>();

			int friendNumber = 1;

			for (int i = 0; i < list.size(); ++i) {
			    map.put(list.get(i), friendNumber);
			    friendNumber++;
			}
			
			// 2nd friend gave gift to 1  --> array looks like [_,1,_,_]
			// 3rd friend gave gift to 2  --> array looks like [_,1,2,_]
			// 4th friend gave gift to 3  --> array looks like [_,1,2,3]
			// 1st friend gave gift to 4  --> array looks like [4,1,2,3]
			System.out.println(map.toString());

			for (@SuppressWarnings("rawtypes") Map.Entry entry : map.entrySet()) {
			    res.add((int) entry.getValue());
			}

			for (int num : res) {
			    System.out.println(num);
			}
		}
    }
}
