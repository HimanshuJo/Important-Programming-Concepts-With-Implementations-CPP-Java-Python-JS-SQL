package com.essenbazar.chefAndStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/*

Chef is writing some arbitrary strings as he is getting bored. 
After writing some strings , he thinks that his arrangement of letters is very dirty. 

Then he is struck by an idea that he can play a game with those arbitrary strings .

NOTE:
Strings are in form aabbbccdeefffff….. 
and so on. once the repetition of a letter is over , 
it can't be repeated again . ( abbcddddeefff (valid) , 
aabbbccbdd ( invalid, as b is repeated again even after its repetition is over))

He takes a string S and then decides to modify the string such that it 
should contain all the letters present in it in ascending order of their repetitions. 
To do that he starts swapping the groups of letters . 
( swaps whole ′aa′ with ′ccc′ , swaps whole ′ddd′ with ′ffff′ , etc) 
and cost of swap is difference in the frequencies of the letters getting swapped.

Frequency of a letter is the number of times the letter is repeated in the string.

NOTE

    During a swap you have to swap all the repetitions of the selected letter with the other. 

    suppose string is aabbbcccdd , if you want to swap a and c swapping occurs like ′aa′ with ′ccc′
        thus after swap , string is cccbbbaadd

Find the minimum cost to attain such a string .

Sample Input:

    4
    aabbcccdeffffggghhhhhii
    aaaa
    abbcccdd
    aaaabbbccd

Sample Output:

    5
    0
    1
    4

 */

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t;
			t = sc.nextInt();
			sc.nextLine();
			while (t-- > 0) {
				String s;
				s = sc.nextLine();

				TreeMap<Character, Integer> map = new TreeMap<>();
				for (int i = 0; i < s.length(); ++i) {
					map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
				}

				List<Integer> list = new ArrayList<>();
				for (Iterator<Entry<Character, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
					Entry<Character, Integer> entry = iterator.next();
					list.add((int) entry.getValue());
				}

				List<Integer> copy = new ArrayList<>();
				copy.addAll(list);

				Collections.sort(list);
				int res = 0;

				for (int i = 0; i < list.size(); ++i) {
					res += (Math.abs(list.get(i) - copy.get(i)));
				}

				System.out.println(res / 2);
			}
		}
	}
}
