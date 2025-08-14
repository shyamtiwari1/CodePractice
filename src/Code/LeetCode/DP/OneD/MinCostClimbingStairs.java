package Code.LeetCode.DP.OneD;

import java.util.Arrays;

public class MinCostClimbingStairs {
//    https://leetcode.com/problems/min-cost-climbing-stairs/description/




    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int[] dp = new int[cost.length];
            Arrays.fill(dp , -1);
            return recursion(cost ,dp, cost.length);

        }

        public int recursion(int[] cost,int[] dp , int n){
            if(n==0 || n==1){
                return 0;
            }
            if(dp[n-1]!=-1)return dp[n-1];
            int oneStep = recursion(cost , dp,n-1)+cost[n-1];
            int twoStep = recursion(cost , dp,n-2)+cost[n-2];
            return dp[n-1] = Math.min(oneStep , twoStep);



        }
    }
}
