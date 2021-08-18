package com.essenbazar._710;

import java.util.Scanner;

/*
 * Polycarp found a rectangular table consisting of n rows and m
 * 
 * columns. He noticed that each cell of the table has its number, obtained by
 * the following algorithm "by columns":
 * 
 * cells are numbered starting from one; cells are numbered from left to right
 * by columns, and inside each column from top to bottom; number of each cell is
 * an integer one greater than in the previous cell.
 * 
 * For example, if n=3 and m=5, the table will be numbered as follows:
 * 
 * 1 4 7 10 13 2 5 8 11 14 3 6 9 12 15
 * 
 * However, Polycarp considers such numbering inconvenient. He likes the
 * numbering "by rows":
 * 
 * cells are numbered starting from one; cells are numbered from top to bottom
 * by rows, and inside each row from left to right; number of each cell is an
 * integer one greater than the number of the previous cell.
 * 
 * For example, if n=3 and m=5, then Polycarp likes the following table
 * numbering:
 * 
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
 * 
 * Polycarp doesn't have much time, so he asks you to find out what would be the
 * cell number in the numbering "by rows", if in the numbering "by columns" the
 * cell has the number x?
 * 
 * Input
 * 
 * The first line contains a single integer t (1≤t≤104). Then t test cases
 * follow.
 * 
 * Each test case consists of a single line containing three integers n, m, x
 * (1≤n,m≤106, 1≤x≤n⋅m), where n and m are the number of rows and columns in the
 * table, and x is the cell number.
 * 
 * Note that the numbers in some test cases do not fit into the 3 -bit integer
 * type, so you must use at least the 64-bit integer type of your programming
 * language.
 * 
 * Output
 * 
 * For each test case, output the cell number in the numbering "by rows".
 * 
 * Example
 * 
 * Input
 * 
 * 5 1 1 1 2 2 3 3 5 11 100 100 7312 1000000 1000000 1000000000000
 * 
 * Output
 * 
 * 1 2 9 1174 1000000000000
 * 
 */

/*
 * 
 * Suppose we want to find out the what will be the position of 7 in the row
 * wise table
 * 
 * Firstly in the column wise table, in every column we have three numbers
 * 
 * so if we want to find out the number of column in which the 7 is present, we
 * can simply divide it by 3 (or more formally no of rows)
 * 
 * however, if we do it for the elements in the first columns (e.g. 1, 2, 3)
 * 
 * 3 / 3 = 1 which is Okay
 * 
 * but 2 / 3 is 2 which is incorrect
 * 
 * so what we can do it to subtract 1 from the number for which we are trying to
 * find out its column number (or take the ceil value of the division)
 * 
 * e.g. (7 - 1) / 3 = 2 (now the columns are indexed from 0, 1, 2...
 * 
 * so now if we want to find out the row, we can do the same thing
 * 
 * (7 - 1) % 3 (if we are not subtracting 1, then if we do for 3 e.g. 3 % 3 == 0
 * here we can apply a check that if mode value is 0, then make it equal to num
 * rows)
 * 
 * so basically 7 is in 0th row and 2 column [0 indexing]
 * 
 * Now to find what lies at (0th + 1) row and (2 + 1) column in the row wise
 * matrix
 * 
 * (at which row the number is in) * No. of columns + (At which column the
 * number is in)
 * 
 * -------
 * 
 * e.g. for 11, in the column wise table it is in 2nd row and 3rd column so in
 * the row wise matrix now, we already know, that the fist row has already been
 * filled and in the first row there can be at most 3 number,
 * 
 * so we basically add the last value number in the earlier row + what's the col
 * number of 11
 * 
 * 
 */

public class MainA {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t;
			t = sc.nextInt();
			while (t-- > 0) {
				long n, m, x;
				n = sc.nextLong(); // no. rows
				m = sc.nextLong(); // no. cols
				x = sc.nextLong();
				long atWhichRow = (x - 1) % n;
				long atWhichCol = (x - 1) / n;
				long newPos = atWhichRow * m + (atWhichCol + 1);
				System.out.println(newPos);
			}
		}
	}
}
