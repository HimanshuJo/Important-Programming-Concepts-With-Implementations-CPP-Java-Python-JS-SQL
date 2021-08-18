/*
Project for solving some common algorithm problems
 */
package com.essenbazar.vowelSpellChecker_966;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author himanshu
 */

/*

Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.

For a given query word, the spell checker handles two categories of spelling mistakes:

    Capitalization: If the query matches a word in the wordlist (case-insensitive),
                    then the query word is returned with the same case as the case in the wordlist.

        Example: wordlist = ["yellow"], query = "YellOw": correct = "yellow"
        Example: wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
        Example: wordlist = ["yellow"], query = "yellow": correct = "yellow"

    Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the query word with any vowel individually,
                  it matches a word in the wordlist (case-insensitive), then the query word is returned with the
                  same case as the match in the wordlist.

        Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
        Example: wordlist = ["YellOw"], query = "yeellow": correct = "" (no match)
        Example: wordlist = ["YellOw"], query = "yllw": correct = "" (no match)

In addition, the spell checker operates under the following precedence rules:

    When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.
    When the query matches a word up to capitlization, you should return the first such match in the wordlist.
    When the query matches a word up to vowel errors, you should return the first such match in the wordlist.
    If the query has no matches in the wordlist, you should return the empty string.

Given some queries, return a list of words answer, where answer[i] is the correct word for query = queries[i].

Example 1:

Input: wordlist = ["KiTe","kite","hare","Hare"],

queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]

Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]


 */
public class Solution {

    public boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    public String deVowel(String word) {
        StringBuilder sbf = new StringBuilder();

        for (char c : word.toCharArray()) {
            sbf.append(isVowel(c) ? "*" : c);
        }

        return sbf.toString();
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> consonant = new HashMap<>();
        String[] res = new String[queries.length];

        for (String word : wordlist) {
            exact.add(word);
            caseInsensitive.putIfAbsent(word.toLowerCase(), word);
            consonant.putIfAbsent(deVowel(word.toLowerCase()), word);
        }

        int i = 0;

        for (String query : queries) {
            if (exact.contains(query)) {
                res[i] = query;
            } else if (caseInsensitive.containsKey(query.toLowerCase())) {
                res[i] = caseInsensitive.get(query.toLowerCase());
            } else if (consonant.containsKey(deVowel(query.toLowerCase()))) {
                res[i] = consonant.get(deVowel(query.toLowerCase()));
            } else {
                res[i] = "";
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution my_obj = new Solution();
        String[] wordlist = {"KiTe", "kite", "hare", "Hare"};
        String[] queries = {"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};
        my_obj.spellchecker(wordlist, queries);
    }
}
