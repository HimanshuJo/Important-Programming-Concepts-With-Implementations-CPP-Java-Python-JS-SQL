package com.essenbazar.designOrderedStream1656;

/**
 *
 * @author hjoshi
 */
/*
 * There is a stream of n (idKey, value) pairs arriving in an arbitrary order, 
 * where idKey is an integer between 1 and n and value is a string. 
 * No two pairs have the same id.

	Design a stream that returns the values in increasing order of their IDs by 
	returning a chunk (list) of values after each insertion. 
	
	The concatenation of all the chunks should result in a list of the sorted values.

	Implement the OrderedStream class:

    OrderedStream(int n) Constructs the stream to take n values.
    String[] insert(int idKey, String value) Inserts the pair (idKey, value) into 
    the stream, then returns the largest possible chunk of currently inserted values 
    that appear next in the order.

 */
import java.util.*;

class OrderedStream {

	String[] array;
	int pointer = 0;

	public OrderedStream(int n) {
		this.array = new String[n];
	}

	public List<String> insert(int idKey, String value) {
		array[idKey - 1] = value;
		List<String> res_ = new ArrayList<>();
		while (pointer < array.length && array[pointer] != null) {
			res_.add(array[pointer]);
			pointer++;
		}
		return res_;
	}

	public static void main(String[] args) {
		OrderedStream obj = new OrderedStream(5);
		int idKey = 3;
		String value = "ccccc";
		int idKey2 = 1;
		String value2 = "aaaa";
		int idKey3 = 2;
		String value3 = "bbbbb";
		int idKey4 = 5;
		String value4 = "eeeee";
		int idKey5 = 4;
		String value5 = "ddddd";
		List<String> param_1 = obj.insert(idKey, value);
		List<String> param_2 = obj.insert(idKey2, value2);
		List<String> param_3 = obj.insert(idKey3, value3);
		List<String> param_4 = obj.insert(idKey4, value4);
		List<String> param_5 = obj.insert(idKey5, value5);
		System.out.println(param_1);
		System.out.println(param_2);
		System.out.println(param_3);
		System.out.println(param_4);
		System.out.println(param_5);
	}
}
