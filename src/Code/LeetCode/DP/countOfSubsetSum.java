package Code.LeetCode.DP;

public class countOfSubsetSum {

    public static void main (String args[]){

        int arr[] = new int[]{3, 34, 4, 12, 5, 2};
        int sum1 = 8;
        System.out.println(countSubsetSumTopDown(arr, sum1, arr.length));


    }



    public static int countSubsetSumTopDown(int[] arr, int sum  , int n ){
        int [][] x = new int[n+1][sum+1];

        for(int i = 0 ; i< n+1 ; i++){
            for(int j = 0 ; j< sum+1 ; j++){
                if(i==0){
                    x[i][j] = 0;
                }
                if(j==0){
                    x[i][j] = 1;
                }
                if(i==0 && j==0){
                    x[i][j] = 1;
                }

            }
        }

        for(int i = 1 ; i<n+1 ; i++ ){
            for(int j = 1 ; j< sum+1 ; j++){
                if(arr[i-1]<=j){
                    x[i][j] = x[i-1][j-arr[i-1]] + x[i-1][j];
                }else{
                    x[i][j] =  x[i-1][j];
                }
            }
        }
        return x[n][sum];
    }
}
