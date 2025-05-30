package LeetCode.DP;

public class SubsetSum {

    public static void main(String args[]){
        int arr[] = new int[]{3, 34, 4, 12, 5, 2};
        int sum1 = 30;
        System.out.println(subsetSumTopDown(arr, sum1, arr.length));


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

