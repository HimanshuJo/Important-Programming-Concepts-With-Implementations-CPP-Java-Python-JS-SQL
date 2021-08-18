package com.essenbazar._49;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * You are given coordinates, a string that represents the coordinates of a
 * square of the chessboard. Below is a chessboard for your reference.
 * 
 * Return true if the square is white, and false if the square is black.
 * 
 * The coordinate will always represent a valid chessboard square. The
 * coordinate will always have the letter first, and the number second.
 * 
 */

class Solution {

	public boolean squareIsWhite(String coordinates) {
		boolean[][] chessBoard = new boolean[8][8];
		Map<Character, Integer> map = new HashMap<>();
		map.put('a', 0);
		map.put('b', 1);
		map.put('c', 2);
		map.put('d', 3);
		map.put('e', 4);
		map.put('f', 5);
		map.put('g', 6);
		map.put('h', 7);
		int counter = 0;
		for (int i = 0; i < 8; ++i) {
			if (counter % 2 == 0) {
				for (int x = 0; x < 8; ++x) {
					chessBoard[i][x] = x % 2 != 0;
				}
			} else {
				for (int x = 0; x < 8; ++x) {
					chessBoard[i][x] = x % 2 == 0;
				}
			}
			counter++;
		}
		int firstInt = map.get(coordinates.charAt(0));
		int secondInt = Character.getNumericValue(coordinates.charAt(1));
		return chessBoard[firstInt][secondInt - 1];
	}
}
