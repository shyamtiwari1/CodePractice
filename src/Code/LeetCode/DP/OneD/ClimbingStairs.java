package Code.LeetCode.DP.OneD;

import java.util.Arrays;

public class ClimbingStairs {

//    https://leetcode.com/problems/climbing-stairs/description/

    public static void main(String args[]){
     System.out.println(climbStairs(3));
    }



    public static int climbStairs(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp , -1);
        return helper(dp , n );



    }

    public static int helper (int[] dp , int n ){
        if(n==1 || n==0){
            return 1;
        }
        if(dp[n-1]!=-1){
            return dp[n-1];
        }
        return dp[n-1] = helper(dp,n-1) + helper(dp,n-2);
    }
}
