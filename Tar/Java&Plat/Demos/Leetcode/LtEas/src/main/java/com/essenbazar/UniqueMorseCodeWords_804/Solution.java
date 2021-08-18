/*
Project for solving some common algorithm problems
 */
package com.essenbazar.UniqueMorseCodeWords_804;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author himan
 */

/*

International Morse Code defines a standard encoding where each letter is mapped to a
series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c"
maps to "-.-.", and so on.

For convenience, the full table for the 26 letters of the English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.",
"---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]

Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter.
For example, "cab" can be written as "-.-..--...",
(which is the concatenation "-.-." + ".-" + "-...").
We'll call such a concatenation, the transformation of a word.

Return the number of different transformations among all words we have.

Example:
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation: 
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

There are 2 different transformations, "--...-." and "--...--.".

 */
class Solution {

    public int uniqueMorseRepresentations(String[] words) {

        Map<Character, String> map = new HashMap<>();
        map.put('a', ".-");
        map.put('b', "-...");
        map.put('c', "-.-.");
        map.put('d', "-..");
        map.put('e', ".");
        map.put('f', "..-.");
        map.put('g', "--.");
        map.put('h', "....");
        map.put('p', ".--.");
        map.put('o', "---");
        map.put('n', "-.");
        map.put('m', "--");
        map.put('l', ".-..");
        map.put('k', "-.-");
        map.put('j', ".---");
        map.put('i', "..");
        map.put('q', "--.-");
        map.put('r', ".-.");
        map.put('s', "...");
        map.put('t', "-");
        map.put('u', "..-");
        map.put('v', "...-");
        map.put('w', ".--");
        map.put('x', "-..-");
        map.put('y', "-.--");
        map.put('z', "--..");

        List<List<String>> ss_list = new ArrayList<>();
        Set<List<String>> str_set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            String temp = "";
            List<String> list = new ArrayList<>();
            for (int j = 0; j < str.length(); j++) {
                char check = str.charAt(j);
                String morse = map.get(check);
                temp += morse;
            }
            list.add(temp);
            ss_list.add(list);
        }

        for (int i = 0; i < ss_list.size(); i++) {
            str_set.add(ss_list.get(i));
        }

        return str_set.size();
    }
}
