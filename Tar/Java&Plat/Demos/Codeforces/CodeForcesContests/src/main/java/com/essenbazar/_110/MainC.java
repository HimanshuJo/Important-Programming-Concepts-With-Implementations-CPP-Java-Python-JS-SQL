package com.essenbazar._110;

/*
You are given a string s consisting of the characters 0, 1, and ?.

Let's call a string unstable if it consists of the characters 0 and 1 and any two adjacent characters 
	are different (i. e. it has the form 010101... or 101010...).

Let's call a string beautiful if it consists of the characters 0, 1, and ?, and 
	you can replace the characters ? to 0 or 1 (for each character, the choice is independent), 
	so that the string becomes unstable.

For example, the strings 0??10, 0, and ??? are beautiful, and the strings 00 and ?1??1 are not.

Calculate the number of beautiful contiguous substrings of the string s

Example
Input

3
0?10
???
?10??1100

Output

8
6
25

-------

First test case, all beautiful substrings:

0 (from position 1 to position 1)
0? (from position 1 to position 2)
? (from position 2 to position 2)
?1 (from position 2 to position 3)
?10 (from position 2 to position 4)
1 (from position 3 to position 3)
10 (from position 3 to position 4)
0 (from position 4 to position 4)

*/
/*
	Intuition:
	
		In essence we have to find given the string s, how many substrings can be formed that are
			continuous and beautiful
			
		Important point to note is that, a single character is a beautiful character in it's own
		
		-------
		
		Suppose we have a unstable string:
		
			String: 	1 0 1 0 1 0 1 0
			Indices:    0 1 2 3 4 5 6 7
			
				This string can also be considered as a beautiful string as it has no ?
					and every adjacent character is different
			
			so how many substrings are there in this string that are beautiful
			
			first substring can start at before the 0th index and end at after 0th index
				(that means a single character)
				
				hence our ans = 1
				
			 next when we have reached the end of 1st index both the characters are satisfying
			 	the condition of a beautiful string
			 	
			 	so here, one substring can be such which can be started before the 0th index and
			 		end after the 1st index
			 		
		 		one substring can be such which will start just after the 0th index and
		 			end after the 1st index
		 			
	 			so in total we have 2 such substrings
	 			
	 				hence our ans = 1 + 2
	 				
			 Following the same procedure, since the entire string has alternate characters
			 	the end ans will look like this
			 		1 + 2 + 3 + 4 + 5 + 6 + 7 + 8
			 		
 		-------
 		
 		Suppose we don't have an unstable string at the start:
 		
 			String:		1 0 1 0 0 1 0 1 1
 			Indices:    0 1 2 3 4 5 6 7 8
 			
			The entire string is not unstable, but the problem is only in the middle and at the end
				so, it's substring can be unstable
				
			Following the above describe procedure till index 3 our ans will be like
				1 + 2 + 3 + 4
				
				reaching index 4, the unstable condition is not satisfying
				
					so in this only this single character will be a substring in its own
					
					at this point our counter will be reset again back to 1
					
					hence ans will look like this:
						1 + 2 + 3 + 4 + 1 and so on
						
			final ans in this case will be: 1 + 2 + 3 + 4 + 1 + 2 + 3 + 4 + 1
			
		------
		
		Now talking about whether we have to replace the ? with 0 or 1
			we have to check our ans by replacing the ? with both 0 and 1 and take the max
			
	 	Suppose we have a test case: 
	 		
 		String:		1 0 1 0 ? ? ? 0 1 0
		Indices:	0 1 2 3 4 5 6 7 8 9
		
			So until 3, our ans will already be 1 + 2 + 3 + 4
			
			now at index 4, it is beneficial to replace it with 1 as the previous character was 0
				so automatically the next character will take 0 and the next 1 again
				
					hence until index 6 now the ans looks like:
						1 + 2 + 3 + 4 + 5 + 6 + 7
						
				 	since now at index 7 we have 0 and the last ? was replaced with 1, so
				 		our greedy approach was good in this case and we continue
				 		
			 		final ans: 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10
			 		
	 		when there occurs a case that the greedy approach doesn't work and we have to restart
	 			the counter, at that point we have to check for both the possibilities
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MainC {

	static PrintWriter out;

	static class CustomReader {

		BufferedReader br;
		StringTokenizer st;

		public CustomReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) {
		CustomReader cs = new CustomReader();
		int t = cs.nextInt();
		while (t-- > 0) {
			String s = cs.nextLine();
			int n = s.length();
			long res = 0, max0 = 0, max1 = 0;
			for (int i = 0; i < n; ++i) {
				if (s.charAt(i) == '0') {
					++max0;
					max1 = 0;
					res += max0;
				} else if (s.charAt(i) == '1') {
					++max1;
					max0 = 0;
					res += max1;
				} else {
					++max0;
					++max1;
					res += Math.max(max0, max1);
				}
				long temp = max0;
				max0 = max1;
				max1 = temp;
			}
			out.println(res);
		}
		out.flush();
	}
}
