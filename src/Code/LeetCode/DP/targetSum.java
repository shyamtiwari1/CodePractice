package Code.LeetCode.DP;

public class targetSum {


//    https://leetcode.com/problems/target-sum/submissions/1653627679/




    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int[][] dp = new int[nums.length][2001];
            for(int i = 0 ; i < nums.length ; i++){
                for(int j = 0 ; j <2001;j++){
                    dp[i][j] =-1;
                }

            }
            return recursion(nums, nums.length-1 , target , 0  , dp);

        }


        public int recursion(int[] nums, int n ,int target , int currSum ,int[][] dp) {

            if( n<0){
                if( currSum ==target){
                    return 1;
                }else{
                    return 0;
                }
            }
            int offset = 1000;
            int index = currSum+offset;
            if(dp[n][index]!=-1){
                return dp[n][index];
            }
            return dp[n][index]=   recursion( nums, n-1 , target ,  currSum-nums[n], dp ) + recursion( nums, n-1 , target ,  currSum+nums[n] , dp);


        }
    }
}

//    public static void main(String args[]) {
//        int[] nums = new int[]{0}; int target = 0;
//
//        int totalSum = 0;
//        for(int i = 0 ; i< nums.length; i++){
//            totalSum+=nums[i];
//        }
//        if((target+totalSum)%2!=0){
//            System.out.println(0);
//            return;
//        }
//        int subsetSum = (target+totalSum)/2;
//
//        System.out.println(countSunSetSumDP(nums , subsetSum , nums.length));
//
//    }
//
//
//    public static int countSunSetSumDP(int arr[] , int sum , int n){
//        int t[][] = new int[n+1][sum+1];
//        for(int i = 0 ; i<n+1;i++){
//            t[i][0] = 1;
//        }
//        for(int i = 0 ; i<sum+1;i++){
//            t[0][i] = 0;
//        }
//        t[0][0] = 1;
//        for(int i = 1 ; i< n+1; i++){
//            for(int j = 1; j<sum+1;j++){
//                if(arr[i-1]>j){
//                    t[i][j]  = t[i-1][j];
//                }else{
//                    t[i][j]  = t[i-1][j]+t[i-1][j-arr[i-1]];
//                }
//            }
//        }
//        return t[n][sum];
//    }
//}
