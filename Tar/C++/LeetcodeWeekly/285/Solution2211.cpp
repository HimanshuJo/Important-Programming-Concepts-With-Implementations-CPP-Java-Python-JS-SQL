// 2211. Count Collisions on a Road
/*
There are n cars on an infinitely long road. The cars are numbered from 0 to n - 1 
from left to right and each car is present at a unique point.

You are given a 0-indexed string directions of length n. directions[i] can be either 
'L', 'R', or 'S' denoting whether the ith car is moving towards the left, towards the right, 
or staying at its current point respectively. Each moving car has the same speed.

The number of collisions can be calculated as follows:

    When two cars moving in opposite directions collide with each other, the number 
    of collisions increases by 2.
    When a moving car collides with a stationary car, the number of collisions increases by 1.

After a collision, the cars involved can no longer move and will stay at the point 
where they collided. Other than that, cars cannot change their state or direction of motion.

Return the total number of collisions that will happen on the road.

Example 1:

Input: directions = "RLRSLL"
Output: 5
Explanation:
The collisions that will happen on the road are:
- Cars 0 and 1 will collide with each other. Since they are moving in opposite directions, 
the number of collisions becomes 0 + 2 = 2.
- Cars 2 and 3 will collide with each other. Since car 3 is stationary, the number of 
collisions becomes 2 + 1 = 3.
- Cars 3 and 4 will collide with each other. Since car 3 is stationary, the number of 
collisions becomes 3 + 1 = 4.
- Cars 4 and 5 will collide with each other. After car 4 collides with car 3, it will stay 
at the point of collision and get hit by car 5. The number of collisions becomes 4 + 1 = 5.
Thus, the total number of collisions that will happen on the road is 5. 

Example 2:

Input: directions = "LLRR"
Output: 0
Explanation:
No cars will collide with each other. Thus, the total number of collisions that will happen on the road is 0.

 

Constraints:

    1 <= directions.length <= 10^5
    directions[i] is either 'L', 'R', or 'S'.

*/

class Solution {
public:
    int countCollisions(string directions) {
        int ans=0;
        int sz=directions.length();
        char prev=directions[0];
        for(int i=1; i<sz; ++i){
            bool flag1=false, flag2=false, flag3=false;
            if(directions[i]=='L'&&prev=='R'){
                int idx=i-2;
                while(idx>=0&&directions[idx]=='R'){
                    ans+=1;
                    idx--;
                }
                flag1=true;
                ans+=2;
                directions[i]='S';
                prev=directions[i];
            } else if(directions[i]=='S'){
                int idx=i-1;
                while(idx>=0&&directions[idx]=='R'){
                    idx--;
                    ans+=1;
                }
                flag2=true;
                prev=directions[i];
            } else if(directions[i]=='L'&&prev=='S'){
                flag3=true;
                ans+=1;
                directions[i]='S';
                prev=directions[i];
            }
            if(!flag1&&!flag2&&!flag3) prev=directions[i];
        }
        return ans;
    }
};