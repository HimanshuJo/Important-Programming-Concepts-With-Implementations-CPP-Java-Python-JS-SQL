package com.essenbazar.allTemps;

import java.util.ArrayList;
import java.util.List;

class Pair<Key, Value> {
	private Key key;
	private Value value;

	public Pair(Key key, Value value) {
		this.key = key;
		this.value = value;
	}

	public Key getKey() {
		return this.key;
	}

	public Value getValue() {
		return this.value;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public void setValue(Value value) {
		this.value = value;
	}

}

public class Main {
	public static List<Pair<Integer, String>> pairList = new ArrayList<Pair<Integer, String>>();

	public static void main(String[] args) {
		Pair<Integer, String> obj = new Pair<Integer, String>(123, "abcd");
		pairList.add(obj);
		for (Pair<?, ?> par : pairList) {
			System.out.println(par.getKey());
			System.out.println(par.getValue());
		}
		System.out.println("-------");
		obj.setKey(123456789);
		obj.setValue("hjj");
		for (Pair<?, ?> par : pairList) {
			System.out.println(par.getKey());
			System.out.println(par.getValue());
		}
	}
}
