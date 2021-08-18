'''

Let's say a positive integer is a super-palindrome if it is a palindrome, 
and it is also the square of a palindrome.

Given two positive integers left and right represented as strings, 
return the number of super-palindromes integers in the inclusive range [left, right].

Input: left = "4", right = "1000"
Output: 4
Explanation: 4, 9, 121, and 484 are superpalindromes.
Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.

'''

'''

There is no fancy solution for this

Only thing to do is to brute force

	However, we can't simply brute force 10^18 numbers, the constraints are too big
		again we have to check the square of these big numbers is a palindrome or not

	But the key thing to note is that, we don't have to search through the entire range

	We can cut our range from 10^18 to 10^9

	We can only search through the base numbers
		e.g. 
			2^2 -> 4
			3^2 -> 9
			11^2 -> 121
			22^2 -> 484

	But again the down side is 10^9 is also a big range it also fall into TLE
		how can we further reduce our range

		So the last number in the range also has to be palindrome,

			suppose we have a number 123454321
				a 9 digit number, 

				in this case, we only need to enumerate only half the size of the number

		So we can only search until 10^5 and then concatenate to check if the string forms a palindrome

		Once we have a palindrome string, we just need to do the square of that string
			and check, whether the square is also a palindrome

			also if the square of the value is the range left and right

'''

class Solution:
	def superpalindromesInRange(self, left: str, right: str) -> int:
		ans = 0
		l = int(left)
		r = int(right)

		# odd case
		for i in range(10**5):
			s1 = str(i)

		 	# s1[::-1] will reverse the entire string, but we only need to reverse from last 2
		 	# e.g. 12345  we want 4321, we will reverse from the last second digit
			s2 = s1[-2::-1]

			# concatenated palindrome string
			s = s1 + s2

			num = int(s)**2

			if num > r:
				break

			if num >= l and str(num) == str(num)[::-1]:
				ans += 1


		# even case  --> 1234554321
		for i in range(10**5):
			s1 = str(i)

		 	# for the even case we will reverse everything
			s2 = s1[::-1]

			# concatenated palindrome string
			s = s1 + s2

			num = int(s)**2

			if num > r:
				break

			if num >= l and str(num) == str(num)[::-1]:
				ans += 1

		return ans

'''

Time Complexity:
	O(10^5) * some string manipulations

'''