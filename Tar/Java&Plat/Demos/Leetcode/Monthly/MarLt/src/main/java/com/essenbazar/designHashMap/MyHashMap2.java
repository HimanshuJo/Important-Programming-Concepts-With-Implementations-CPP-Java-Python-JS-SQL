
package com.essenbazar.designHashMap;

/*

A basic structure of a HashMap is like an array, where we have different buckets
    
    Different bucket can have each multiple keys and values

    These key and value can be stored inside the bucket as a linkedlist
        as there can be situation wherein we are going to get collision, that is two different keys
            would want to go into the same bucket
            Therefore we need to keep a LinkedList

    The LinkedList can be viewed as a custom class, that is 'Entry'

    Generall the initial size of the HashMap is 60, but we should use a larger prime number
        so that the hashing becomes efficient

    -------

    get(int key)

        firstly we search which bucket my key could lie, and that would be by using the hashcode method
            e.g. hashcode could be key % size
        
            for that bucket we will get a linkedlist
                in that linkedlist we need to search for the given key

    -------

    put(int key, int val)
    
        firstly we need to search for a bucket wherein we can store the key and value
            if the bucket is null
                we can create a new linkedlist and add the current entry in it
            else
                we need to search all the entries for the given key
                    if the given key is already present, we need to update its value to the new value
                    else
                        we need to add a new entry with the current key and the value

    -------

    remove(int key)

        here first we need to search for the bucket in which the key could be present

        there can be 2 cases
            1. the key is present in the map

            2. the key is not present in the map

        if the bucket is null that means the key is not present
            here we can simply return from the method
        otherwise we need to search for all the entries in the given bucket
            if the key is present
                remove the entry from that bucket
            else
                no key found and we simply return
*/

import java.util.*;

class MyHashMap2 {

	LinkedList<Entry>[] map; // LinkedList Array

	public static int SIZE = 769;

	@SuppressWarnings("unchecked")
	public MyHashMap2() {
		map = new LinkedList[SIZE];
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		int bucket = key % SIZE;
		if (map[bucket] == null) {
			map[bucket] = new LinkedList<>();
			map[bucket].add(new Entry(key, value));
		} else {
			for (Entry entry : map[bucket]) {
				if (entry.key == key) {
					entry.val = value;
					return;
				}
			}

			map[bucket].add(new Entry(key, value));

		}
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		int bucket = key % SIZE;
		LinkedList<Entry> entries = map[bucket];
		if (entries == null)
			return -1;
		for (Entry entry : entries) {
			if ((int) entry.key == key)
				return entry.val;
		}
		return -1;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		int bucket = key % SIZE;
		Entry toRemove = null;
		if (map[bucket] == null)
			return; // no key present, so no need to remove

		else {
			for (Entry entry : map[bucket]) {
				if (entry.key == key) {
					toRemove = entry;
				}
			}
		}

		if (toRemove == null)
			return;
		map[bucket].remove(toRemove);
	}
}

class Entry {
	public int key;
	public int val;

	public Entry(int key, int val) {
		this.key = key;
		this.val = val;
	}

}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */