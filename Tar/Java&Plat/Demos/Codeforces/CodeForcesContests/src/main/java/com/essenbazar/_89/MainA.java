package com.essenbazar._89;

/*

Petya started to attend programming lessons.

On the first lesson his task was to write a simple program.

The program was supposed to do the following: in the given string, consisting if uppercase and
    lowercase Latin letters, it:

    deletes all the vowels,
    inserts a character "." before each consonant,
    replaces all uppercase consonants with corresponding lowercase ones.

Vowels are letters "A", "O", "Y", "E", "U", "I", and the rest are consonants.

The program's input is exactly one string, it should return the output as a single string,
    resulting after the program's processing the initial string.

Help Petya cope with this easy task.

Input

The first line represents input string of Petya's program.

This string only consists of uppercase and lowercase Latin letters and its length is from 1 to 100, inclusive.

Output

Print the resulting string. It is guaranteed that this string is not empty.

Examples

Input

tour

Output

.t.r

Input

Codeforces

Output

.c.d.f.r.c.s

Input

aBAcAba

Output

.b.c.b

 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainA {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String s;
			s = sc.nextLine();
			Map<Character, Character> map = new HashMap<>();
			map.put('a', 'a');
			map.put('e', 'e');
			map.put('i', 'i');
			map.put('o', 'o');
			map.put('u', 'u');
			map.put('y', 'y');
			String ss = s.toLowerCase();
			StringBuilder sbf = new StringBuilder();
			for (int i = 0; i < ss.length(); ++i) {
				if (!map.containsKey(ss.charAt(i))) {
					sbf.append('.');
					sbf.append(ss.charAt(i));
				}
			}
			System.out.println(sbf.toString());
		}
	}
}
