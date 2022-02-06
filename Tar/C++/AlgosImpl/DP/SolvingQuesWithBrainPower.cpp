// 2140. Solving Questions With Brainpower
/*
You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].

The array describes the questions of an exam, where you have to process the questions in order 
(i.e., starting from question 0) and make a decision whether to solve or skip each question. 

Solving question i will earn you pointsi points but you will be unable to solve each of the next 
brainpoweri questions. 
If you skip question i, you get to make the decision on the next question.

For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be 
unable to solve questions 2 and 3.
Return the maximum points you can earn for the exam.

Example 1:

Input: questions = [[3,2],[4,3],[4,4],[2,5]]    
Output: 5
Explanation: The maximum points can be earned by solving questions 0 and 3.
- Solve question 0: Earn 3 points, will be unable to solve the next 2 questions
- Unable to solve questions 1 and 2
- Solve question 3: Earn 2 points
Total points earned: 3 + 2 = 5. There is no other way to earn 5 or more points.
Example 2:

Input: questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]
Output: 7
Explanation: The maximum points can be earned by solving questions 1 and 4.
- Skip question 0
- Solve question 1: Earn 2 points, will be unable to solve the next 2 questions
- Unable to solve questions 2 and 3
- Solve question 4: Earn 5 points
Total points earned: 2 + 5 = 7. There is no other way to earn 7 or more points.
 

Constraints:

1 <= questions.length <= 10^5
questions[i].length == 2
1 <= pointsi, brainpoweri <= 10^5
*/

/*
Bottom Up:

using ll=long long;

class Solution {
public:
    long long mostPoints(vector<vector<int>>& questions) {
        int sz=questions.size();
        vector<vector<ll>>dp(sz+1, vector<ll>(2, 0));
        for(int i=0; i<sz; ++i){
            for(int j=0; j<2; ++j){
                dp[i][j]=0;
            }
        }
        dp[sz-1][0]=questions[sz-1][0];
        for(int i=sz-2; i>=0; --i){
            dp[i][0]=dp[i+1][0];
            ll val=0;
            if(i+questions[i][1]+1<sz){
                val=dp[i+questions[i][1]+1][0];
            }
            dp[i][0]=max(questions[i][0]+val, dp[i][0]);
        }
        return dp[0][0];
    }
};
*/

using ll=long long;

class Solution {
public:
    
    ll dfs(vector<vector<int>>&questions, int idx, int n, ll &ans, vector<ll>&memo){
        if(idx>=n) return 0;
        if(memo[idx]!=-1) return memo[idx];
        ll ans1=questions[idx][0]+dfs(questions, idx+questions[idx][1]+1, n, ans, memo);
        ll ans2=dfs(questions, idx+1, n, ans, memo);
        ll currans=max(ans1, ans2);
        ans=max(ans, currans);
        return memo[idx]=currans;
    }
    
    long long mostPoints(vector<vector<int>>& questions) {
        int n=questions.size();
        vector<ll>memo(n+1, -1);
        ll ans=INT_MIN;
        dfs(questions, 0, n, ans, memo);
        return ans;
    }
};