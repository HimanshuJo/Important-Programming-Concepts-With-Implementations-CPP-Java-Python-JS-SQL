// 2240. Number of Ways to Buy Pens and Pencils
/*
You are given an integer total indicating the amount of money you have. 
You are also given two integers cost1 and cost2 indicating the price of a pen and 
pencil respectively. 

You can spend part or all of your money to buy multiple quantities (or none) of each kind of writing utensil.

Return the number of distinct ways you can buy some number of pens and pencils.

Example 1:

Input: total = 20, cost1 = 10, cost2 = 5
Output: 9
Explanation: The price of a pen is 10 and the price of a pencil is 5.
- If you buy 0 pens, you can buy 0, 1, 2, 3, or 4 pencils.
- If you buy 1 pen, you can buy 0, 1, or 2 pencils.
- If you buy 2 pens, you cannot buy any pencils.
The total number of ways to buy pens and pencils is 5 + 3 + 1 = 9.
Example 2:

Input: total = 5, cost1 = 10, cost2 = 10
Output: 1
Explanation: The price of both pens and pencils are 10, which cost more than total, 
so you cannot buy any writing utensils. Therefore, there is only 1 way: buy 0 pens and 0 pencils.
 

Constraints:

1 <= total, cost1, cost2 <= 10^6
*/

/**
 * @param {number} total
 * @param {number} cost1
 * @param {number} cost2
 * @return {number}
 */
var waysToBuyPensPencils = function(total, cost1, cost2) {
    if(cost1>total&&cost2>total) return 1;
    var ans=0;
    var maxx=Math.max(cost1, cost2);
    var minn=Math.min(cost1, cost2);
    var curval=total;
    while(true){
        var curans=0;
        var tempcurval=curval;
        while(true){
            if(tempcurval<minn) break;
            else if(tempcurval%minn===0){
                curans+=(tempcurval/minn);
                tempcurval-=tempcurval;
            } else{
                let quo=Math.floor(tempcurval/minn);
                curans+=quo;
                tempcurval-=(quo*minn);
            }
        }
        ans+=curans+1;
        curval-=maxx;
        if(curval>=0&&curval<maxx){
            var curans_=0;
            var tempcurval_=curval;
            while(true){
                if(tempcurval_<minn) break;
                else{
                    curans_++;
                    tempcurval_-=minn;
                }
            }
            ans+=curans_+1;
            break;
        } else if(curval<0) break;
    }
    return ans;
};