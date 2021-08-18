package com.essenbazar.destinationCity_1436;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a
direct path going from cityAi to cityBi. Return the destination city,
that is, the city without any path outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop,
therefore, there will be exactly one destination city.

Example 1:

Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo" 
Explanation: Starting at "London" city you will reach "Sao Paulo" city which
is the destination city.

Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".

 */

class Solution {

    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        StringBuilder sbf = new StringBuilder();
        for (int i = 0; i < paths.size(); i++) {
            List<String> temp_list = new ArrayList<>();
            temp_list = paths.get(i);
            map.put(temp_list.get(0), temp_list.get(1));
        }
        for (@SuppressWarnings("rawtypes") Map.Entry entry : map.entrySet()) {
            String temp_key = (String) entry.getValue();
            if (map.containsKey(temp_key)) {
                continue;
            } else {
                sbf.append(temp_key);
            }
        }
        return sbf.toString();
    }
}
