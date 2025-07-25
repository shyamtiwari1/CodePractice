package LeetCode.DP;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

//    https://leetcode.com/problems/longest-increasing-subsequence/description/?envType=problem-list-v2&envId=binary-search


// memoization

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return recursion(nums, n-1, -1 , dp);

    }

    public int recursion(int[] nums , int currIndex  , int prevIndex,int[][] dp){
        if(currIndex<0){
            return 0;
        }

        if(dp[currIndex][prevIndex+1]!=-1){
            return dp[currIndex][prevIndex+1];
        }
        int include = 0;
        if(prevIndex == -1 || nums[prevIndex]>nums[currIndex]){
            include =  1+recursion(nums , currIndex-1 , currIndex , dp);
        }
        int exclude =   recursion(nums , currIndex-1 , prevIndex , dp);

        return dp[currIndex][prevIndex+1] =  Math.max(include , exclude);

    }
}
