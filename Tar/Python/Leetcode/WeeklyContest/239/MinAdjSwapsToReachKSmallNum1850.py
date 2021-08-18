'''
You are given a string num, representing a large integer, and an integer k.

We call some integer wonderful if it is a permutation of the digits in num and is greater in value than num. 
There can be many wonderful integers. However, we only care about the smallest-valued ones.

    For example, when num = "5489355142":
        The 1st smallest wonderful integer is "5489355214".
        The 2nd smallest wonderful integer is "5489355241".
        The 3rd smallest wonderful integer is "5489355412".
        The 4th smallest wonderful integer is "5489355421".

Return the minimum number of adjacent digit swaps that needs to be applied to num to 
reach the kth smallest wonderful integer.

The tests are generated in such a way that kth smallest wonderful integer exists.

Input: num = "5489355142", k = 4
Output: 2
Explanation: The 4th smallest wonderful number is "5489355421". To get this number:
- Swap index 7 with index 8: "5489355142" -> "5489355412"
- Swap index 8 with index 9: "5489355412" -> "5489355421"

'''

'''

So taking into account the previous example: from 5489355142 we have to reach 5489355421
	more specifically from 142 to 421

	The question follows the pattern of simulation, and no fancy solution

		so we start from left to right in 142 and whenever the original one is not equal to the target number
			we have to perform some swap

		To do that we can just use the greedy approach

			so, from 142 we are trying to reach 421

				we are trying to set 1 to 4

					so we scan from left to right and search for the first 4
						once we have found the number, we can simply perform a bubble sort

	-------

	Initially we need to perform k times next permutation of the number
		and then we just simply do the swapping simulation

	-------

	To find the next permutation

		suppose we have a number 54586

			we initially start from the end amd we find the first index of the number who is
				smaller than the number next to it

				e.g. in the above case that first number is 5 which is smaller than 8

				That's the place where we want to place a bigger number

			next step is to find the first number scanning from the end that is greater than the number
				which we have just found

				in this case we will find number 6

				then we swap those two numbers

			after swapping we just have to reverse the numbers after the swapped index as we know
				all the numbers after the swapped index will be in decreasing order
	
'''

class Solution:
	def getMinSwaps(self, num: str, k: int) -> int:
		
		def nextPermutation():

			def reverse(l, r):
				while l < r:
					nums[l], nums[r] = nums[r], nums[l]
					l += 1
					r -= 1

			index1 = -1
			# starting from the end find the first nums[i] who is smaller than nums[i + 1]
			for i in range(n - 2, -1, -1):
				if nums[i] < nums[i + 1]:
					index1 = i
					break
			if index1 != -1:  # if we couldn't find any index then all the number are in desc order and there is no next permutation
				index2 = -1
				# starting from the end find the first number who is greater than the index1
				for i in range(n - 1, 0, -1):
					if nums[i] > nums[index1]:
						index2 = i
						break

				# swap those two number
				nums[index1], nums[index2] = nums[index2], nums[index1]

				# we have to reverse from index + 1 to the end
				reverse(index1 + 1, n - 1)

		nums = list(num)
		oldNums = nums.copy()
		n = len(nums)

		while k:
			nextPermutation()
			print(nums)
			k -= 1

		ans = 0
		for i in range(n):
			if nums[i] != oldNums[i]:
				j = i + 1
				# find the first letter in old nums that matches the current number
				while oldNums[j] != nums[i]:
					j += 1

				# bubble that number to the current position
				while j != i:
					oldNums[j], oldNums[j - 1] = oldNums[j - 1], oldNums[j]
					j -= 1
					ans += 1
		#print(ans)
		return ans

testInstance = Solution();
num = "5489355142"
k = 4
testInstance.getMinSwaps(num, k);

'''

O(n^2)

'''