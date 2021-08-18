
package com.essenbazar.ifNumIspalindrome;

/*
 * 1) We can compare the first digit and the last digit, then we repeat the process.
 *
 * 2) For the first digit, we need the order of the number.
 * 	  Say, 12321. Dividing this by 10000 would get us the leading 1.
 * 	  The trailing 1 can be retrieved by taking the mod with 10.
 * 3)  Now, to reduce this to 232.
 * 4 ) And now, the 10000 would need to be reduced by a factor of 100.
 */

public class Solution {
	public boolean isPalindrome(int n) {
		// Find the appropriate divisor
		// to extract the leading digit
		int divisor = 1;
		while (n / divisor >= 10)
			divisor *= 10;

		while (n != 0) {
			int leading = n / divisor;
			int trailing = n % 10;

			// If first and last digit
			// not same return false
			if (leading != trailing)
				return false;

			// Removing the leading and trailing
			// digit from number
			n = (n % divisor) / 10;

			// Reducing divisor by a factor
			// of 2 as 2 digits are dropped
			divisor = divisor / 100;
		}
		return true;
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.isPalindrome(123454321));
	}
}
