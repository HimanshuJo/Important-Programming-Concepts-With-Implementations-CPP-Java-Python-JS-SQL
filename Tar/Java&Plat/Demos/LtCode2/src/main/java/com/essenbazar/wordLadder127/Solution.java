
package com.essenbazar.wordLadder127;

/*

Given two words beginWord and endWord, and a dictionary wordList, return the length
of the shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Return 0 if there is no such transformation sequence.

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

 */

/*
Algo:

   Suppose we have String array as {"hot", "dot", "dog", "lot", "log", "cog"}
   
       we want to reach the word "cog" from "hit"

   Let's suppose we want to try and find out all the word combinations we can get from "hit"
       not considering the wordList

       changing the first letter

           hit  --> ait
                --> bit
                ...
                --> zit
            
       similarly we can change the second letter
       
           hit  --> hat
                --> hbt
                ...
                --> zit
       
       similarly we can change the third letter
       
       In this way we have three types of combinations
           
           Ist level:

               hit --> *it
                   --> h*t
                   --> hi*

       -------
       
       For each word we've 26^3 combinations
               
               3 is the length and
               for every character we have 26 characters that we can get
       
       -------

       Furthermore, for these combinations, we have 26^3 combinations
       
           IInd level:

               e.g. h*t  --> %*t
                         --> h%t
                         --> h*%
       
       -------

       Finding all these combinations for a particular word, it will be pretty huge
           in order to reduce that amount of data we've a wordList which we need to check at every word
           and see if the word exists in this wordList or not
           
           If that exists, only then we need to move forward with that combination

       It might happen that we find a word in the Ist level itself, therefore, we should perform
           bfs
           
           as going much deeper into the depth and realizing later that the word isn't there
               will not be optimal
       
       -------

       We are finding these set of combinations of levels using the first set or first word
           e.g. using "hit" we will be finding all the combinations that exist,
                we'll be checking what all words exists in this wordList and then we move forward

           In order to find another level of the combinations, we'll be making the previous set
               as a beginSet and these new combinations become the reachable word that we can reach
               from these set of combinations

           at each level we're increasing one distance
               that becomes the distance between two nodes
*/
import java.util.*;

class Solution {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		if (!wordList.contains(endWord)) {
			return 0;
		}

		Set<String> beginSet = new HashSet<>();

		// we will do the searching from the end also
		Set<String> endSet = new HashSet<>();

		// we need to perform operations on the wordList also, so we convert it to Set
		// also,
		// as we need to delete some values also
		Set<String> wordSet = new HashSet<>(wordList);
		beginSet.add(beginWord);
		endSet.add(endWord);
		return bfs(beginSet, endSet, wordSet, 1);
	}

	int bfs(Set<String> beginSet, Set<String> endSet, Set<String> wordSet, int distance) {

		if (beginSet.size() > endSet.size()) {
			// we swap beginSet and endSet here as we first try to find the combination
			// from the smaller set, rather than finding in the bigger set
			// because a bigger set will create more number of combinations as compared to
			// endSet
			// and there will be more chances to reach the word from the smaller set than
			// the
			// bigger set
			return bfs(endSet, beginSet, wordSet, distance);
		}

		// we need to have a set that we can use to store the combinations that we can
		// get from the
		// beginSet
		Set<String> reachableWords = new HashSet<>();

		// all the words present in the beignSet should be removed from the wordSet
		// as we can not reuse the word
		wordSet.removeAll(beginSet);

		// for each of the word that resides in the beginSet we need to apply the logic
		// for every position starting from 0 till the length of the word
		// we need to change the character from a to z at each of these positions
		for (String word : beginSet) {
			for (int pos = 0; pos < word.length(); pos++) {
				char[] charArray = word.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					charArray[pos] = c;

					String newWord = new String(charArray);
					if (wordSet.contains(newWord)) {
						if (endSet.contains(newWord)) {
							return distance + 1;
						}
						reachableWords.add(newWord);
						// wordSet.remove(newWord);
					}
				}
			}
		}
		distance++;

		// if there comes the condition where there exists no word in the reachableSet
		// that means we've exhausted all the combinations from the source node
		// that we do not have any word left that can be used in orde to reach the
		// endNode
		if (reachableWords.isEmpty()) {
			return 0;
		} else {
			// the new set will become reachableSet
			return bfs(reachableWords, endSet, wordSet, distance);
		}
	}
}
