import java.io.*;

class Solution
{
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost)
    {

        int current_customers = 0;
        int waiting_customers = 0;
        int rotations = 0;
        int out = 0;
        int max_profit = -1;

        for(int i = 0; i < customers.length; i++)
        {
            rotations += 1;
            if (i < customers.length)
                waiting_customers += customers[i];
            else
                i = 0;
            if (waiting_customers < 4)
            {
                current_customers += waiting_customers;
                waiting_customers = 0;
            }
            else
            {
                current_customers += 4;
                waiting_customers -= 4;
            }
            int profit = current_customers * boardingCost - rotations * runningCost;
            if (profit > max_profit)
            {
                max_profit = profit;
                out = rotations;
            }
        }

        while(waiting_customers != 0)
        {
            rotations += 1;
            if (waiting_customers < 4)
            {
                current_customers += waiting_customers;
                waiting_customers = 0;
            }
            else
            {
                current_customers += 4;
                waiting_customers -= 4;
            }
            int profit = current_customers * boardingCost - rotations * runningCost;
            if (profit > max_profit)
            {
                max_profit = profit;
                out = rotations;
            }
        }

        if (max_profit < 0)
            return -1;
        else
            return out;

    }
}
