/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.testingalgoswithajax;

import java.util.*;

/**
 *
 * @author hjoshi
 */
public class YourAlgoChoice {

    private String[] graphs;
    private String[] trees;
    private String[] backtracking;
    private String[] greedy;

    public YourAlgoChoice() {
    }

    public String[] getGraphs() {
        return graphs;
    }

    public void setGraphs(String[] graphs) {
        this.graphs = graphs;
    }

    public String[] getTrees() {
        return trees;
    }

    public void setTrees(String[] trees) {
        this.trees = trees;
    }

    public String[] getBacktracking() {
        return backtracking;
    }

    public void setBacktracking(String[] backtracking) {
        this.backtracking = backtracking;
    }

    public String[] getGreedy() {
        return greedy;
    }

    public void setGreedy(String[] greedy) {
        this.greedy = greedy;
    }

    public String[] getTreesAlgorithms() {

        trees = new String[5];
        trees[0] = "DfS";
        trees[1] = "BFS";
        trees[2] = "Best First Seach";
        trees[3] = "Prims's Algo";
        trees[4] = "Dijkstra's algorithm";
        return trees;
    }

    public String getStringTreesAlgorithm() {
        return (Arrays.toString(trees));
    }

    public static Map<String, Object> map;

    static {
        map = new LinkedHashMap<>();
        map.put("8 queens", "8 Queens");
        map.put("Water in a jug", "Water in a jug");
        map.put("sudoku", "sudoku");
    }

    public Map<String, Object> getBacktrackingAlgorithms() {
        return map;
    }

    public String getStringBacktracking() {
        return (Arrays.toString(backtracking));
    }
}
