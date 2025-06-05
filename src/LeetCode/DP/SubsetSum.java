package LeetCode.DP;

import java.util.Arrays;

public class SubsetSum {


//    https://leetcode.com/problems/partition-equal-subset-sum/description/

    public static void main(String args[]){
        int arr[] = new int[]{3, 34, 4, 12, 5, 2};
        int sum1 = 30;
        System.out.println(subsetSumTopDown(arr, sum1, arr.length));


    }


    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0 ;
            int n = nums.length;
            for(int i = 0 ; i < nums.length;i++){
                sum+=nums[i];
            }
            if(sum%2!=0){
                return false;
            }else{

                Boolean[][] dp  = new Boolean[n+1][20001];
                for(int i = 0 ; i <= n;i++){
                    Arrays.fill(dp[i] , null);
                }
                return recursive(nums , nums.length-1 , sum/2 , 0 , dp);
            }

        }
        public boolean recursive(int[] nums , int n , int target , int currSum ,Boolean[][] dp){
            if(n<0){
                if(currSum ==target){
                    return true;
                }else{
                    return false;
                }
            }
            if(dp[n][currSum]!=null){
                return dp[n][currSum];
            }
            return dp[n][currSum]= recursive( nums ,  n -1,  target,  currSum+nums[n], dp  ) ||  recursive( nums ,  n-1 ,  target ,  currSum ,dp);

        }
    }


    public static boolean subsetSumRecursive(int[] arr, int sum  , int n ){
            if(sum == 0){
                return true;
            }
            if(n==0){
                return false;
            }

            if(arr[n-1]<=sum){
                return subsetSumRecursive(arr , sum-arr[n-1] , n-1 ) || subsetSumRecursive(arr , sum , n-1);
            }else{
                return subsetSumRecursive(arr , sum , n-1);
            }
    }
    public static boolean subsetSumTopDown(int[] arr, int sum  , int n ){
        boolean [][] x = new boolean[n+1][sum+1];

        for(int i = 0 ; i< n+1 ; i++){
            for(int j = 0 ; j< sum+1 ; j++){
                if(i==0){
                    x[i][j] = false;
                }
                if(j==0){
                    x[i][j] = true;
                }
                if(i==0 && j==0){
                    x[i][j] = true;
                }

                }
            }

        for(int i = 1 ; i<n ; i++ ){
            for(int j = 1 ; j< sum ; j++){
                if(arr[i-1]<=j){
                    x[i][j] = x[i-1][j-arr[i-1]] || x[i-1][j];
                }else{
                    x[i][j] =  x[i-1][j];
                }
            }
        }
        return x[n][sum];
        }

    }

