package com.essenbazar._50;
// Minimum Number of Operations to Make String Sorted

import java.math.BigInteger;

/*
 * You are given a string s (0-indexed)​​​​​​. You are asked to perform the following operation on s​​​​​​ 
 * until you get a sorted string:

    Find the largest index i such that 1 <= i < s.length and s[i] < s[i - 1].
    
    Find the largest index j such that i <= j < s.length and s[k] < s[i - 1] for all the possible 
    	values of k in the range [i, j] inclusive.
    	
    Swap the two characters at indices i - 1​​​​ and j​​​​​.
    
    Reverse the suffix starting at index i​​​​​​.

 */

/*
 * Intuition:
 * 
 * 		string here is nothing else but a number expressed in base-26
 * 
 * 		-------
 * 
 * 		Let's start with a basic problem. I give you the number 15324. 
 * 			I want you to give me the highest number following those two conditions :
	
			    It should be lower than the original
			    It should contain exactly the same digits
			    
		    The answer is 15243. How did I find it? 
		    
		    	I start from the end, and I'm looking for the first digit 
		    		which will not follow the decreasing order (from right remember). 
		    		
		    		So 4-> 2 -> 3. OK, we found 3. 
		    		
	    		I then switch with the highest value lower than 3, which is 2. 
	    		
	    		15234, and then, I revert everything on the right of the 2 we just put, so 15243.
	    		
		It is exactly the algorithm that leetcode is using in the problem. 
			So what they do is just getting the highest lower number formed with those digits
			
		-------
		
		Counting (with distinct digits)
		
			Now, let's consider we have 4 digits: 1, 2, 3 and 4. 
			
			I would like to know the number of combination I can make with those digits. 
			
			It's 4! (4×3×2×1) = 24. Now, let's list them all here in ascending order
		
			    1. 1234
			    2. 1243
			    3. 1324
			    4. 1342
			    5. 1423
			    6. 1432
			    7. 2134
			    8. 2143
			    9. 2314
			    10. 2341
			    11. 2413
			    12. 2431
			    13. 3124
			    14. 3142
			    15. 3214
			    16. 3241
			    17. 3412
			    18. 3421
			    19. 4123
			    20. 4132
			    21. 4213
			    22. 4231
			    23. 4312
			    24. 4321
			    
		    So now, let's assume I give you the number 3412, and I ask you how much permutations 
		    	do I need to make it sorted. Solution is quite easy, you just have to look at the 
		    	list above, it's 17
		    	
	    	Actually it is 16, because the first one in the list with rank 1 has a score of 0 
	    		in the problem we are trying to solve. But how could we find 16 without that list
	    		
    		-------
    		
    		Task: find 16 without that list
    		
		-------
		
		Counting (with digits that can appear many times)
		
			what is the position of the number 2312 in the list
						
			    1. 1223
			    2. 1232
			    3. 1322
			    4. 2123
			    5. 2132
			    6. 2213
			    7. 2231
			    8. 2312
			    9. 2321
			    10. 3122
			    11. 3212
			    12. 3221
			
			First important question is how many possibilities do we have:
			
				Actually, it seems to be 4!/(product of number of occurrences of all digits)
					4! / 2 = 12, which seems to work
					
			-------
			
			let's try with 11223 :

			    1. 11223
			    2. 11232
			    3. 11322
			    4. 12123
			    5. 12132
			    6. 12213
			    7. 12231
			    8. 12312
			    9. 12321
			    10. 13122
			    11. 13212
			    12. 13221
			    13. 21123
			    14. 21132
			    15. 21213
			    16. 21231
			    17. 21312
			    18. 21321
			    19. 22113
			    20. 22131
			    21. 22311
			    22. 23112 *
			    23. 23121
			    24. 23211
			    25. 31122
			    26. 31212
			    27. 31221
			    28. 32112
			    29. 32121
			    30. 32211
			    
	    	Now, and it is the leetcode problem, how to know the rank of 23121 
	    		(we know from the list it is 22).
	    		
    		-------
    		
    		As we can see for the number 23121, 
    			the numbers with 1 and 2 appears 2 times more in the first position than the number 3
    			
				Our formula to calculate the individual ranks for the digits in 23121 will be : 
					n / (sum of occurrences) * (sum of occurrences before)
    			
			Let's do first an array of pairs (value, occurrences) = [[1,2], [2,2], [3,1]]
			
				So we start with n, which is the number of possibilities, which is 30
				
					For 2 -> (30 / 5) * 2 = 6 * 2 = 12
				
			Now, we have [[1,2], [2,1], [3,1]], and number of possibilities is 4! / (2! x 1! x 1!) = 12
			
				Next digit is a 3, so 
					For 3 -> (12 / 4) * (3) = 9
					
			Now we have [[1,2], [2,1], [3,0]], and number of possibilities is 3! / (2! x 1! x 0!) = 3
				
				Next digit is a 1, so 
					For 1 -> (3 / 3) * (0) = 0
					
			Now we have [[1,1], [2,1], [3,0]] and number of possibilities is 2! / (1! x 1! x 0!) = 2
			
				Next digit is a 2, so
					For 2 -> (2/2) * 1 = 1
					
			Now we have [[1,1], [2,0], [3,0]] and number of possibilities is 1! / (1! x 0! x 0!) = 1
			
				Next digit is a 1, so
					For 1 -> (1/1) * 0 = 0

			Let's sum all numbers we got : 12 + 9 + 0 + 1 + 0 : 22. 
				Which is the result we expected.
				
		-------
		
		Time : O(n * m)
			where n is the number of characters and m is the number of characters allowed
 */

// As the no. of characters may be up to 3000, and we deal with factorial on those numbers

import java.util.HashMap;
import java.util.Map;

public class Solution1830 {

	public int f = 1;
	Map<Integer, BigInteger> factorMemo = new HashMap<Integer, BigInteger>();

	// Function to create an array of occurrences we dealt with
	// We will use an array of 26 integers,
	// each index being the first part of the pair we used
	// and its value being the no. of occurrences
	public int makeStringSorted(String s) {
		int[] occurrences = new int[26];
		populateOccurrences(occurrences, s);
		int totalLength = s.length();
		BigInteger result = BigInteger.ZERO;
		// get the total number of possibilities
		// e.g. 5! / (2!x2!x1!) = 120 / 4 = 30
		BigInteger possibilities = numberOfPossibilities(occurrences, s.length());
		while (totalLength > 1) {
			if (totalLength < s.length()) {
				int previousOccurrences = occurrences[s.charAt(s.length() - totalLength - 1) - 'a'] + 1;
				possibilities = possibilities.multiply(BigInteger.valueOf(previousOccurrences))
						.divide(BigInteger.valueOf(totalLength + 1));
			}
			BigInteger numberOfOccurrencesBefore = numberOfOccurrencesBefore(occurrences,
					s.charAt(s.length() - totalLength));
			BigInteger currentResult = possibilities.multiply(numberOfOccurrencesBefore)
					.divide(BigInteger.valueOf(totalLength));
			occurrences[s.charAt(s.length() - totalLength) - 'a'] -= 1;
			result = result.add(currentResult);
			totalLength--;
		}
		return result.mod(BigInteger.valueOf(1000000007)).intValue();
	}

	public void populateOccurrences(int[] occurrences, String s) {
		for (char ch : s.toCharArray()) {
			occurrences[ch - 'a'] += 1;
		}
	}

	public BigInteger numberOfPossibilities(int[] occurrences, int totalSum) {
		BigInteger result = factorial(totalSum);
		for (int i = 0; i < occurrences.length; ++i) {
			result = result.divide(factorial(occurrences[i]));
		}
		return result;
	}

	// We need the sum of occurrences before the first char
	public BigInteger numberOfOccurrencesBefore(int[] occurrences, char character) {
		int result = 0;
		for (int i = 0; i < character - 'a'; ++i) {
			result += occurrences[i];
		}
		return BigInteger.valueOf(result);
	}

	// We need to count the number of possibilities for an array of occurrences
	// For that we need a factorial method
	public BigInteger factorial(int n) {
		if (factorMemo.get(n) != null) {
			return factorMemo.get(n);
		}
		BigInteger result = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			result = result.multiply(BigInteger.valueOf(i));
			factorMemo.put(i, result);
		}
		factorMemo.put(n, result);
		return result;
	}
}
