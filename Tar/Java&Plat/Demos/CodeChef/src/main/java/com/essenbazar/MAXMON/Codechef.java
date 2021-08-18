package com.essenbazar.MAXMON;

/*

Once Chef was going through the stuff he has in his basement and to his surprise 
he found N metal balls, each with different weight. 

Our Chef who is always searching for a way to earn money has decided to sell these 
balls to gain free money. 

To his luck, he has found a dealer who is ready to buy these balls but the 
dealer has agreed to buy only M number of balls. 

The dealer has also told Chef that lesser the difference between minimum and maximum 
weigth of metal balls, more money he gets.

Help Chef find M metal balls that he has to give to the dealer to gain Maximum money.

Input:

The first line of the input contains a single integer T denoting the number of test cases.

The first line of each test case contains a single integer N which denotes number of metal balls.

Second line of each test case contains N space-seperated numbers that denote weight of each ball.

Third line of each test case contains a single integer N which denotes number of metal balls that 
the dealer want to buy.

 */
/* package codechef; // don't place package name! */
import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {

	public static void main(String[] args) throws java.lang.Exception {
		try (Scanner sc = new Scanner(System.in)) {
			int t;
			t = sc.nextInt();

			while (t-- > 0) {

				int n = sc.nextInt();
				List<Integer> list = new ArrayList<>();

				for (int i = 0; i < n; ++i) {
					int num = sc.nextInt();
					list.add(num);
				}

				int m = sc.nextInt();
				int begin = 0;
				int end = m - 1;

				Collections.sort(list);

				int min = Integer.MAX_VALUE;

				for (int ii = end; ii < n; ++ii) {
					if (list.get(ii) - list.get(begin) < min) {
						min = list.get(ii) - list.get(begin);
					}
					begin++;
				}

				System.out.println(min);
			}
		}
	}
}
