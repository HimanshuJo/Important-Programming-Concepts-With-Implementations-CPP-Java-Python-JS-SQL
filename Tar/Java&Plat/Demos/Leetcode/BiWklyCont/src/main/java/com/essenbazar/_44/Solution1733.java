package com.essenbazar._44;

import java.util.Arrays;

// Minimum Number of People to Teach

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * On a social network consisting of m users and some friendships between users, 
 * two users can communicate with each other if they know a common language.

You are given an integer n, an array languages, and an array friendships where:

    There are n languages numbered 1 through n,
    languages[i] is the set of languages the ith user knows, and
    friendships[i] = [ui, vi] denotes a friendship between the users ui and vi.

	You can choose one language and teach it to some users so that all friends can communicate with each other. 
	Return the minimum number of users you need to teach.
	
	Note that friendships are not transitive, meaning if x is a friend of y and y is a friend of z, 
	this doesn't guarantee that x is a friend of z.
	
Example 1:

Input: n = 2, languages = [[1],[2],[1,2]], friendships = [[1,2],[1,3],[2,3]]
Output: 1
Explanation: You can either teach user 1 the second language or user 2 the first language.

 */
/*
 * Intuition:
 * 	Find out all the friendships that are already possible without any teachings
 * 
 * 	The rest we will try to teach using 1 language
 * 		Find out from all the languages what is the minimum we need to teach
 */

public class Solution1733 {
	public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
		Map<Integer, Set<Integer>> languageMap = new HashMap<>();
		for (int i = 0; i < languages.length; ++i) {
			languageMap.put(i + 1, new HashSet<>());
			// which user can speak which and how many languages
			for (int l : languages[i]) {
				languageMap.get(i + 1).add(l);
			}
		}
		System.out.println(languageMap.toString());
		System.out.println("-------");
		boolean[] alreadyCan = new boolean[friendships.length];
		for (int i = 0; i < friendships.length; ++i) {
			// check if there is a common language between two friends instead making
			// the search language wise
			// for a particular row in friendship, catch the first friend and his/her
			// languages
			// traverse in map and check if there is a user/friend which is basically the
			// 1'st friend in this case
			// has any of the languages of his neighbor friend (in this case 0)
			for (int j : languageMap.get(friendships[i][0])) {
				if (languageMap.get(friendships[i][1]).contains(j)) {
					// is so then the pair is already good
					alreadyCan[i] = true;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(alreadyCan));
		System.out.println("-------");
		int minTeach = Integer.MAX_VALUE;
		// Traverse for all the available languages
		// Now we only have to deal with the friendship array
		for (int i = 1; i <= n; ++i) {
			Set<Integer> teachSet = new HashSet<>();
			for (int j = 0; j < friendships.length; ++j) {
				// if the entire pair is already mark good, no need to process it
				if (alreadyCan[j]) {
					continue;
				}
				// if the first friend in the pair doesn't have language i
				if (!languageMap.get(friendships[j][0]).contains(i)) {
					teachSet.add(friendships[j][0]);
				}
				// if the second friend in the pair doesn't have language i
				if (!languageMap.get(friendships[j][1]).contains(i)) {
					teachSet.add(friendships[j][1]);
				}
			}
			minTeach = Math.min(teachSet.size(), minTeach);
		}
		return minTeach;
	}

	public static void main(String[] args) {
		Solution1733 obj = new Solution1733();
		int[][] languages = { { 1 }, { 2 }, { 1, 2 } };
		int[][] friendships = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
		obj.minimumTeachings(2, languages, friendships);
	}
}
