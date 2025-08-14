package Code.LeetCode.DP;

public class EqualSumPartition {
    public static void main(String args[]){
        int arr[] = new int[]{1,2,5};
        int sum1 = 4;
        System.out.println(equalSumPartitionTopDown(arr, sum1, arr.length));
    }

//    https://leetcode.com/problems/partition-equal-subset-sum/description/


    public static boolean equalSumPartitionRecursive(int arr [] , int sum , int n ){
        if(sum ==0 ){
            return true;
        }
        if(n==0){
            return false;
        }
        if(arr[n-1]<=sum){
            return equalSumPartitionRecursive(arr , sum , n-1) || equalSumPartitionRecursive(arr , sum-arr[n-1] , n-1);
        }else{
            return  equalSumPartitionRecursive(arr , sum , n-1);
        }

    }

    public static boolean equalSumPartitionTopDown(int arr[] , int sum , int n ){
        boolean [][] x = new boolean [sum+1][n+1];
        for (int j = 0; j <= n; j++) {
            x[0][j] = true;
        }
        for (int i = 1; i <= sum; i++) {
            x[i][0] = false;
        }
        for(int i = 1 ; i<sum+1 ; i++){
            for(int j = 1 ; j <n+1 ; j++){
                if(arr[j-1]<=i){
                    x[i][j] =  x[i][j-1] || x[i-arr[j-1]][j-1];
                }else{
                    x[i][j] = x[i][j-1];
                }
            }
        }
        return x[sum][n];
    }
}
