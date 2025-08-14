package Code.LeetCode.DP;

public class minimumSubsetSumDifference {
    public static void main (String args[]){
        int [] arr = new int[]{1 , 6, 11 , 5};
        int maxSum = 0 ;
        int minSum = 0;
        for(int i = 0 ; i< arr.length ; i++){
            maxSum+=arr[i];
        }
        for(int i = 1 ; i< maxSum ; i++){
            if(subsetSumTopDown(arr , i , arr.length)){
                System.out.println(i);
                break;
            }
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
