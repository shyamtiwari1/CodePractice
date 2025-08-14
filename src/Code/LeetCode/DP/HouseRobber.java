package Code.LeetCode.DP;

import java.util.Arrays;

public class HouseRobber {

//    https://leetcode.com/problems/house-robber/description/?envType=problem-list-v2&envId=oizxjoit

    public static void main(String args[]){
        int[] nums = new int[]{1,2,3,1};

        System.out.println(rob(nums));
    }




        public static int rob(int[] nums) {
            int[] dp = new int[nums.length+1];
            Arrays.fill(dp,-1);
            return recursion(nums, nums.length-1 , dp);

        }

        public static  int recursion(int []nums, int n  , int[] dp){

            if(n<0){
                return 0;
            }
            if(n==0){
                return nums[0];
            }
            if(n==1){
                return Math.max(nums[0] , nums[1]);
            }
            if(dp[n]!=-1){
                return dp[n];
            }
            return dp[n] = Math.max(nums[n]+recursion(nums, n-2, dp), recursion(nums, n-1, dp));
        }

}
