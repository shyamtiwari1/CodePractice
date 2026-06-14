package smartcoin_preparation.leetcode.dynamic_programming;

import java.util.Arrays;

public class JumpGameTwo {

        public static void main(String[] args) {
            int[] nums = new int[]{2,3,1,1,4};
            System.out.println(jump(nums));
        }

        public static int jump(int[] nums) {

            int[] dp = new int[nums.length];
            Arrays.fill(dp, -1);

            return recursion(nums, 0, dp);

        }


        public static int recursion(int[] nums , int i, int[]dp){

            if(i>=nums.length-1)return 0;

            if(nums[i]==0) return Integer.MAX_VALUE;

            int count = Integer.MAX_VALUE;
            if(dp[i]!=-1)return dp[i];
            for(int j = 1;j<=nums[i];j++){
                int next =  recursion(nums, i+j,dp);
                if(next !=Integer.MAX_VALUE){
                    count =Math.min(count , 1+next);
                }
            }
            return dp[i]=count;
        }
    }

