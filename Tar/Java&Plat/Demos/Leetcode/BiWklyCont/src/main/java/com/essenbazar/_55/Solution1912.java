package com.essenbazar._55;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class MovieRentingSystem {
	Comparator<int[]> cmp = (a, b) -> a[2] != b[2] ? a[2] - b[2] : a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];

	// <movie, Set<entry>>
	Map<Integer, Set<int[]>> availableMovies = new HashMap<>();

	// <shop, <movie, price>>
	Map<Integer, Map<Integer, Integer>> shopInventory = new HashMap<>();

	// <entry>
	Set<int[]> rented = new TreeSet<>(cmp);

	public MovieRentingSystem(int n, int[][] entries) {
		for (int[] entry : entries) {
			int shop = entry[0], movie = entry[1], price = entry[2];
			if (!availableMovies.containsKey(movie))
				availableMovies.put(movie, new TreeSet<>(cmp));
			availableMovies.get(movie).add(entry);
			if (!shopInventory.containsKey(shop))
				shopInventory.put(shop, new HashMap<>());
			shopInventory.get(shop).put(movie, price);
		}
	}

	public List<Integer> search(int movie) {
		return availableMovies.getOrDefault(movie, Collections.emptySet()).stream().limit(5).map(entry -> entry[0])
				.collect(Collectors.toList());
	}

	public void rent(int shop, int movie) {
		int[] entry = { shop, movie, shopInventory.get(shop).get(movie) };
		availableMovies.get(movie).remove(entry);
		rented.add(entry);
	}

	public void drop(int shop, int movie) {
		int[] entry = { shop, movie, shopInventory.get(shop).get(movie) };
		availableMovies.get(movie).add(entry);
		rented.remove(entry);
	}

	public List<List<Integer>> report() {
		return rented.stream().limit(5).map(entry -> List.of(entry[0], entry[1])).collect(Collectors.toList());
	}

}