package Code.LeetCode.DP;

import java.util.Arrays;

public class LIS2 {
//    https://leetcode.com/problems/russian-doll-envelopes/description/



    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes , (a, b)->{
                if(a[0]==b[0]){
                    return b[1]-a[1];
                }
                return a[0]-b[0];
            });
            int[][] dp = new int[envelopes.length+1][envelopes.length+1];
            for(int i = 0 ; i <envelopes.length;i++){
                Arrays.fill(dp[i],-1)
                ;        }
            return recursion(envelopes, envelopes.length-1,-1 , dp);

        }

        public int recursion(int[][] envelopes , int currindex , int previndex  , int[][]dp){

            if(currindex<0)return 0 ;
            if(dp[currindex][previndex+1]!=-1)return dp[currindex][previndex+1];
            int nottake = recursion(envelopes , currindex-1, previndex, dp );

            int take = 0 ;
            if(previndex==-1 || (envelopes[currindex][0]<envelopes[previndex][0] && envelopes[currindex][1]<envelopes[previndex][1] )){
                take = 1+recursion(envelopes , currindex-1 , currindex, dp );
            }

            return dp[currindex][previndex+1] = Math.max(take, nottake);

        }
    }
}
