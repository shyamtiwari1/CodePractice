package LeetCode.DP;

public class CountOfSubsetWithAGivenDifference {
    public static void main (String args[]){
        int arr[] = new int[]{3, 34, 4, 12, 5, 2};
        int sum = 8;
        System.out.println(countSubsetSumRecursive(arr , sum , arr.length));
        System.out.println(countSunSetSumDP(arr , sum , arr.length));

    }

//    https://leetcode.com/problems/target-sum/description/

    public static int countSubsetSumRecursive(int arr[] , int sum , int n ){
        if(sum==0){
            return 1;
        }
        if( n==0){
            return 0;
        }
        if(arr[n-1]>sum){
            return countSubsetSumRecursive(arr , sum , n-1);
        }else{
            return countSubsetSumRecursive(arr , sum , n-1) + countSubsetSumRecursive(arr, sum-arr[n-1] , n-1);
        }

    }

    public static int countSunSetSumDP(int arr[] , int sum , int n){
        int t[][] = new int[n+1][sum+1];
        for(int i = 0 ; i<n+1;i++){
            t[i][0] = 1;
        }
        for(int i = 0 ; i<sum+1;i++){
            t[0][i] = 0;
        }
        t[0][0] = 1;
        for(int i = 1 ; i< n+1; i++){
            for(int j = 1; j<sum+1;j++){
                if(arr[i-1]>j){
                    t[i][j]  = t[i-1][j];
                }else{
                    t[i][j]  = t[i-1][j]+t[i-1][j-arr[i-1]];
                }
            }
        }
        return t[n][sum];
    }
}
