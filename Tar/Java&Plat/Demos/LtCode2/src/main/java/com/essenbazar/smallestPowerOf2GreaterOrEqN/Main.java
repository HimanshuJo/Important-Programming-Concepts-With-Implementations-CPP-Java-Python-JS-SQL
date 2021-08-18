package com.essenbazar.smallestPowerOf2GreaterOrEqN;

/*
 * Write a function that, for a given no n, finds a number p which is greater than 
	or equal to n and is a smallest power of 2. 

Examples : 

    Input : n = 5
    Output: 8     

    Input  : n = 17
    Output : 32     

    Input  : n = 32
    Output : 32     
 */
/*
 * Method 1:
 * 	Using the log of the number
 * 		1. We can calculate the position of set bit in p(next power of 2):
 * 			pos = ceil(log n)
 * 		2. Now we can calculate p:
 * 			p = pow(2, pos)
 * 
 * 		Example:
 * 			Suppose n = 17
 * 			therefore pos = ceil(log 17)
 * 					  pos = 5
 * 			Hence p = 2^5
 * 
 * 	Method 2:
 * 	 By getting the position of only set bit in result
 * 
 * 	// if n is the power of 2 return n
 *	// if n is even then n & (n - 1) will always be 0
 * 	1. If (n & !(n & (n - 1)) then return n
 * 	2. Else keep right shifting n until it becomes zero
 * 		and count no of shifts
 * 		a. Initialize count = 0
 * 		b. While n != 0
 * 			n = n >> 1
 * 			count = count + 1
 * 	// Now count has the position of set bit in result
 * 	3. Return (1 << count) 	
 * 	
 */
public class Main {

	public static int nextPowerOf2(int n) {
		int count = 0;
		if (n > 0 && (n & (n - 1)) == 0) {
			System.out.println("we are here!");
			System.out.println(n & (n - 1));
			return n;
		}
		while (n != 0) {
			n >>= 1;
			count += 1;
		}
		return 1 << count;
	}

	public static void main(String[] args) {
		int n = 4;
		System.out.println(nextPowerOf2(n));
	}
}
