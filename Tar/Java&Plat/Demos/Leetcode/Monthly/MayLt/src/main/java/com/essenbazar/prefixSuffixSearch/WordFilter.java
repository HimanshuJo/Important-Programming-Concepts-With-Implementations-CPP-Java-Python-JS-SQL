package com.essenbazar.prefixSuffixSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author himanshu
 */

/*

Design a special dictionary which has some words and allows you to search the words in 
it by a prefix and a suffix.

Implement the WordFilter class:

    WordFilter(string[] words) Initializes the object with the words in the dictionary.

    f(string prefix, string suffix) Returns the index of the word in the dictionary 
        which has the prefix prefix and the suffix suffix. 

    If there is more than one valid index, return the largest of them. 

    If there is no such word in the dictionary, return -1.

 */

 /*

We can maintain a HashMap that will contain the suffix and the prefix of a word, and then its index
    e.g. for the word 'apple'

            we have to save all the possible prefix and suffix combinations

                e.g. <a#e, 0>  mapping prefix and suffix with the index
                     <ap#e, 0>
                     ...
                     <ap#le, 0>
                     ...

                     <app#e, 0>
                     ...

                suppose we have another word in our input e.g. sea
                
                    <s#a, 1>
                    <se#a, 1>
                    ...

 */
class WordFilter {

    Map<String, Integer> map;

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public WordFilter(String[] words) {
        map = new HashMap();

        for (int i = 0; i < words.length; i++) {
            String curWord = words[i];

            List<String> prefix = new ArrayList();
            List<String> suffix = new ArrayList();

            for (int j = 0; j <= curWord.length(); j++) {
                prefix.add(curWord.substring(0, j));
                suffix.add(curWord.substring(j));
            }

            for (String p : prefix) {
                for (String s : suffix) {
                    String key = p + "#" + s;

                    if (!map.containsKey(key)) {
                        map.put(key, i);
                    } else {
                        map.put(key, Math.max(map.get(key), i));
                    }
                }
            }
        }

        System.out.println(map.toString());
    }

    public int f(String prefix, String suffix) {
        String key = prefix + "#" + suffix;
        return map.containsKey(key) ? map.get(key) : -1;
    }

    public static void main(String[] args) {

    }
}

class WordFilter2 {

    Map<String, Integer> map;

    public WordFilter2(String[] words) {
        
        map = new HashMap<>();
        
        for (int ii = 0; ii < words.length; ++ii) {
            int index = ii;
            String word = words[ii];

            StringBuilder aa = new StringBuilder("");
            for (int i = 0; i < word.length(); ++i) {
                aa.append(String.valueOf(word.charAt(i)));
                StringBuilder temp_ = new StringBuilder("");
                for (int j = word.length() - 1; j >= 0; --j) {
                    char temp = word.charAt(j);
                    temp_.insert(0, String.valueOf(temp));
                    map.put(aa.toString() + '#' + temp_, index);
                    map.put(aa.toString() + '#' + "", index);
                    map.put("" + '#' + temp_, index);
                }
                map.put("" + '#' + "", index);
            }
        }
        
        System.out.println(map.toString());
    }

    public int f(String prefix, String suffix) {
        return map.containsKey(prefix+'#'+suffix) ? map.get(prefix+'#'+suffix) : -1;
    }
}
