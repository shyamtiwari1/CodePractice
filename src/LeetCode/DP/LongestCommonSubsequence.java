package LeetCode.DP;

public class LongestCommonSubsequence {

//    https://leetcode.com/problems/longest-common-subsequence/description/?envType=problem-list-v2&envId=oizxjoit


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
}
