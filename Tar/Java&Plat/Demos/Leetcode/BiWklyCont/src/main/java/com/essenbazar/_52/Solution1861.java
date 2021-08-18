package com.essenbazar._52;

import java.util.*;

/*
You are given an m x n matrix of characters box representing a side-view of a box. 
    Each cell of the box is one of the following:

    A stone '#'
    A stationary obstacle '*'
    Empty '.'

The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. 
Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. 
Gravity does not affect the obstacles' positions, and the inertia from the box's rotation 
does not affect the stones' horizontal positions.

It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.

Return an n x m matrix representing the box after the rotation described above.

Input: box = [["#",".","#"]]
Output: [["."],
         ["#"],
         ["#"]]

 */
/*
After rotating the array 90 degree, the right hand side of the original box will be the bottom
   in the changed box

   For each row:
       1. empty will point to the last cell that is empty
           Initially empty is the index => columns - 1
       2. start from the last column in the row, for each column c:
           if the current cell contains a stone, we will move it from the current cell to the empty
               cell (which is represented by the empty variable)
           if the current cell contains an obstacle, we will change the value of empty to c - 1
               because at this point it doesn't matter if there is an empty cell after this obstacle
               the stone will not surpass this obstacle.
               so the new empty cell can now only be at a cell after this cell

   	-------

   	So the algo will be, doing the required operations in the original box and then finally rotating it

*/
   	
public class Solution1861 {

	public char[][] rotateTheBox(char[][] box) {
		int r = box.length, c = box[0].length;
		char[][] box2 = new char[c][r]; // rows will be columns now and the columns will be rows
		for (int i = 0; i < r; ++i) {
			int empty = c - 1;  // last column
			for (int j = c - 1; j >= 0; --j) {
				if (box[i][j] == '*') {
					// if current cell contains an obstacle, we will change value of empty to c-1.
					// because after this obstacle there is no point in having an empty value
					// no stone will reach there
					empty = j - 1;
				}
				if (box[i][j] == '#') {
					box[i][j] = '.';
					box[i][empty] = '#';
					--empty;  // decrementing empty means pushing it to the left side
				}
			}
		}
		for (int i = 0; i < r; ++i) {
			for (int j = c - 1; j >= 0; --j) {
				box2[j][r - i - 1] = box[i][j];
			}
		}
		return box2;
	}

	public static void main(String[] args) {
		Solution1861 obj = new Solution1861();
		char[][] box = { { '#', '#', '*', '.', '*', '.' }, { '#', '#', '#', '*', '.', '.' },
				{ '#', '#', '#', '.', '#', '.' } };
		System.out.println(Arrays.toString(obj.rotateTheBox(box)));
	}
}
