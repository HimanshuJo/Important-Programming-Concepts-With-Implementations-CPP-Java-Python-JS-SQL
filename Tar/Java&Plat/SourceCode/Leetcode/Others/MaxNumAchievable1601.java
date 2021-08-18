class Solution
{
    int ach_requests = Integer.MIN_VALUE;

    public int maximumRequests(int n, int [][] requests)
    {
        int [] count = new int[n];
        dfs(requests, 0, 0, count, "");
        return ach_requests;
    }

    private void dfs(int [][] requests, int initial, int curr_max_req, int [] count, String s)
    {
        if(initial > requests.length)
            return;

        if(backAtStart(count))
        {
            ach_requests =  Math.max(ach_requests, curr_max_req);
        }

        for(int i = initial; i < requests.length; i++)
        {
            count[requests[i][0]]++;
            count[requests[i][1]]--;

            dfs(requests, i + 1, curr_max_req + 1, count, s + i);

            count[requests[i][0]]--;
            count[requests[i][1]]++;
        }
    }

    private boolean backAtStart(int[] count)
    {
        for(int num : count)
            if(num != 0)
                return false;

        return true;
    }
}
