
package com.essenbazar.boatsToSavePeople881;

/*
 * Boats to Save People
 * 
 * You are given an array people where people[i] is the weight of the ith person, 
 * and an infinite number of boats where each boat can carry a maximum weight of limit. 
 * Each boat carries at most two people at the same time, provided the sum of the weight 
 * of those people is at most limit.

	Return the minimum number of boats to carry every given person.

	Example 1:
	
	Input: people = [1,2], limit = 3
	Output: 1
	Explanation: 1 boat (1, 2)
	
	Example 2:
	
	Input: people = [3,2,2,1], limit = 3
	Output: 3
	Explanation: 3 boats (1, 2), (2) and (3)
	
	Example 3:
	
	Input: people = [3,5,3,4], limit = 5
	Output: 4
	Explanation: 4 boats (3), (3), (4), (5)

*/

/*

Algo:

    since at most two weights can be together we can try to solve it 'greedily'
        which says try to eliminate lowest and highest together in single boat
        
    Step 1:
        Sort the array. point i=0 and j = to last element index.

    Step 2:
        Create count variable
            count will store the count of the boats which we want to minimize.

    Step 3:
        loop till i<=j and check if at any point element at i index crosses
            max_capacity limit itself.

            if yes it means remaining elements in array are already exceeding max_capacity limit.
            
            so just return current count + remaining elements.
                
                (why -> because all the remaining element will travel in separate boat
                    as they are too fat to to fit together with others)
    Step 4:
        else if arr[i] + arr[j] together is with in max_capacity it means they
            together can come in 1 boat. 
        Hence increment count. and increment i and decrement j to compare next pair.
    
    Step 5:
        else it might be possible that element present at j-1 index can fit together with i
            index element. so don't increment i. just decrement j.
    
    Step 6:
        once loop finishes count is the desired output.
*/

import java.util.*;

public class Solution {
	public int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
		int i = 0;
		int j = people.length - 1;
		int ans = 0;
		while (i <= j) {
			if (people[i] >= limit) {
				return ans + j - i + 1;
			}
			if (people[i] + people[j] <= limit) {
				i++;
			}
			j--;
			ans++;
		}
		return ans;
	}
}
