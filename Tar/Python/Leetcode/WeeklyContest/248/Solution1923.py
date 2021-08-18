# Longest Common Subpath
'''

There is a country of n cities numbered from 0 to n - 1. In this country, there is a road connecting every pair of cities.

There are m friends numbered from 0 to m - 1 who are traveling through the country. 
Each one of them will take a path consisting of some cities. 
Each path is represented by an integer array that contains the visited cities in order. 
The path may contain a city more than once, but the same city will not be listed consecutively.

Given an integer n and a 2D integer array paths where paths[i] is an integer array representing 
the path of the ith friend, return the length of the longest common subpath that is shared by every 
friend's path, or 0 if there is no common subpath at all.

A subpath of a path is a contiguous sequence of cities within that path.

Example 1:

Input: n = 5, paths = [[0,1,2,3,4],
                       [2,3,4],
                       [4,0,1,2,3]]
Output: 2
Explanation: The longest common subpath is [2,3].

'''
'''

Firstly for performing Binary Search we have to set up our left and the right boundary
	left boundary is: 0 for all the paths and right is min length among all the paths

Rolling Hash:

	For each of the array we'll be storing all the rolling hash with length middle in a set (for each list independent sets)

	Let say we've two sets, setA and setB, then we just need to find the intersection between these two sets

	The resultant intersection will be used for the intersection with the next set let's say setC

	Finally we check if there is anything in our intersection set

	-------

	For Rolling Hash, base should always be 
		as big as the max number in the constraint

		second we always want to choose a prime number


'''

'''

Time:

	For the helper:
		since the total number of paths 10^5, inner for loop runs O(n)

		outer for loop, for each run, we have an intersect (in Python that is min(hashSet1, hashSet2))

			inner loops runs parallel, so the time is still in the range of O(n)

	BS: log n

'''


class Solution:
    def longestCommonSubpath(self, n: int, paths: List[List[int]]) -> int:
        # the mid will be length of the common sub-array
        def helper(mid):
            # if there is at-least one common sub-array
            # with the above described length exist across
            # all the lists
            base = 10**5+1
            mod = 2**64+9
            a = pow(base, mid, mod)
            # hashSet will be storing the common sub-array
            # which has the size equals to mid
            hashSet = set()
            for i, path in enumerate(paths):
                hashSet2 = set()
                currHash = 0
                for j in range(len(path)):
                    currHash = currHash*base + path[j]
                    if j >= mid:
                        currHash -= path[j - mid] * a
                    currHash %= mod
                    if j >= mid - 1:
                        hashSet2.add(currHash)
                if i == 0:
                    hashSet = hashSet2
                else:
                    hashSet = hashSet.intersection(hashSet2)
                if i > 0 and not hashSet:
                    break
            return len(hashSet) > 0

        left = 0
        right = min(len(path) for path in paths)
        while left < right:
            mid = left + (right - left + 1) // 2
            if helper(mid):
                left = mid
            else:
                right = mid - 1
        return left
