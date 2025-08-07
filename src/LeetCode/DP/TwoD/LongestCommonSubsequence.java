package LeetCode.DP.TwoD;

import java.util.Arrays;

public class LongestCommonSubsequence {

//    https://leetcode.com/problems/longest-common-subsequence/description/


    public static void main(String args[]){
        String s1 = "aabaaba";
        String s2 = "abaabaa";
        int n = s1.length();
        int m = s2.length();
        int[][] t = new int[m+1][n+1];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j++){
                t[i][j] =-1;
            }
        }


        System.out.println(lcs(s1,s1.length()-1,s2,s2.length()-1 , t));

    }


    public static int lcs(String s1, int n , String s2 , int m  , int[][]t){
        if(n<0 || m<0){
            return 0;
        }
        if(t[m][n] !=-1){
            return t[n][m];
        }

        if(s1.charAt(n)==s2.charAt(m)){
            return t[n][m]= 1+ lcs(s1,n-1,s2,m-1 ,t );
        }else{
            return t[n][m]= Math.max(lcs(s1, n-1,s2,m , t) , lcs(s1,n,s2,m-1 , t));
        }

    }




    public int longestCommonSubsequence(String text1, String text2) {
        int n =  text1.length();
        int m = text2.length();
        int [][] dp = new int[n+1][m+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return recursion(text1 , n , text2 , m , dp);

    }


    public int recursion(String text1,  int n , String text2 , int m ,int [][] dp){
        if(n==0 || m==0){
            return 0 ;
        }
        if(dp[n-1][m-1]!=-1)return dp[n-1][m-1];

        if(text1.charAt(n-1)==text2.charAt(m-1)){
            return dp[n-1][m-1] = 1+recursion(text1 , n-1 , text2 , m-1 , dp );
        }

        return dp[n-1][m-1]= Math.max(recursion(text1, n-1 , text2, m,dp ) , recursion(text1, n , text2, m-1,dp ));
    }
}
