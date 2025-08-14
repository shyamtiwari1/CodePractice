package Code.LeetCode.DP.TwoD;

import java.util.Arrays;

public class CoinChangeII {

//    https://leetcode.com/problems/coin-change-ii/description/

    class Solution {
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[][] dp = new int[n+1][amount+1];
            for(int[]row : dp){
                Arrays.fill(row, -1);
            }
            return recursion(amount , coins ,coins.length-1  , dp );



        }

        public int recursion(int amount , int[] coins , int n , int[][] dp){
            if(amount ==0){
                return 1;
            }
            if(n<0 || amount <0){
                return 0 ;
            }

            if(dp[n][amount]!=-1){
                return dp[n][amount];
            }
            return dp[n][amount] =  recursion(amount , coins ,n-1 , dp )+recursion(amount-coins[n] , coins , n , dp );
        }
    }
}
