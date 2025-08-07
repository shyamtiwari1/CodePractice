package LeetCode.DP.TwoD;

public class PartitionEqualSubsetsum {
//    https://leetcode.com/problems/partition-equal-subset-sum/description/




    public boolean canPartition(int[] nums) {

        int sum = 0 ;
        int n = nums.length;
        for(int i : nums){
            sum+=i;
        }
        if(sum%2!=0){
            return false;
        }else{
            int reqsum = sum/2;
            Boolean[][] dp = new Boolean [n+1][reqsum+1];
            return memoization(nums, reqsum , n-1 , dp);
        }

    }



    public boolean recursion(int[]nums, int reqsum ,int n){
        if(reqsum==0){
            return true;
        }
        if(n==0){
            return false;
        }

        return recursion(nums, reqsum-nums[n-1] , n-1)||recursion(nums, reqsum , n-1);

    }

    public boolean memoization(int[]nums, int reqsum , int n , Boolean[][] dp ){
        if(reqsum==0){
            return true;
        }
        if(n<0 ||reqsum<0 ){
            return false;
        }
        if(dp[n][reqsum]!=null){
            return dp[n][reqsum];
        }


        return dp[n][reqsum]= memoization(nums, reqsum-nums[n] , n-1 , dp)|| memoization(nums, reqsum , n-1, dp);

    }
}
