import java.util.*;

class Solution
{
    public int maximalNetworkRank(int n, int[][] roads)
    {
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        for(int i = 0; i < n; i++)
            edges.put(i, new HashSet<>());

        for(int[] road : roads)
        {
            edges.get(road[0]).add(road[1]);
            edges.get(road[1]).add(road[0]);
        }

        int max_rank = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                int rank = edges.get(i).size() + edges.get(j).size();
                if(edges.get(i).contains(j) || edges.get(j).contains(i))
                    rank --;
                max_rank = Math.max(max_rank, rank);
            }
        }
        System.out.println(max_rank);
        return max_rank;
    }

    public static void main(String[] args)
    {
        Solution my_obj =  new Solution();
        int num_roads = 5;
        int[][] roads_array = {{0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}};
        my_obj.maximalNetworkRank(num_roads, roads_array);
    }
}
