package Code.LeetCode.DP;

public class SubsetSum1 {

    public static void main (String args[]){
        int[] arr= new int[]{3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(subsetSumRecursive(arr , sum, arr.length));
        System.out.println(susSetSumTopDown(arr , sum, arr.length));


    }

    public static boolean subsetSumRecursive(int [] arr  , int k  , int n ){
        if(k==0){
            return true;
        }
        if(n==0 ){
            return false;
        }
        if(arr[n-1]>k){
            return subsetSumRecursive(arr , k , n-1);
        }else{
            return subsetSumRecursive(arr , k , n-1) || subsetSumRecursive(arr , k-arr[n-1] , n-1);
        }

    }


    public static boolean susSetSumTopDown(int [] arr  , int k  , int n){
        boolean [][] t = new boolean[n+1][k+1];
        for(int i = 0 ; i< n+1 ;i++){
            t[i][0] = true;
        }
        for(int j =0; j<k+1;j++){
            t[0][j] = false;
        }
        t[0][0] = true;
        for(int i =1 ; i< n+1 ;i++){
            for(int j = 1 ; j<k+1 ; j++){
                if(arr[i-1]>j){
                    t[i][j] = t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
                }
            }
        }
        return t[n][k];
    }
}
