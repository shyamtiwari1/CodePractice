package LeetCode.DP.OneD;

import java.util.Arrays;

public class HouseRobber {
//    https://leetcode.com/problems/house-robber/description/


    class Solution {
        public int rob(int[] nums) {

            int[] dp = new int[nums.length];
            Arrays.fill(dp , -1);
            return helper(nums ,  dp , nums.length);

        }
        public int helper(int[] nums ,int[] dp, int n){
            if(n==0){
                return 0;
            }
            if(n==1){
                return nums[n-1];
            }

            if(dp[n-1]!=-1){
                return dp[n-1];
            }
            return dp[n-1] =  Math.max(nums[n-1]+helper(nums,dp ,  n-2) , helper(nums ,dp ,  n-1));
        }
    }
}
