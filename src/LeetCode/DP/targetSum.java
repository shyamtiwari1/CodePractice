package LeetCode.DP;

public class targetSum {

    public static void main(String args[]) {
        int[] nums = new int[]{0}; int target = 0;

        int totalSum = 0;
        for(int i = 0 ; i< nums.length; i++){
            totalSum+=nums[i];
        }
        if((target+totalSum)%2!=0){
            System.out.println(0);
            return;
        }
        int subsetSum = (target+totalSum)/2;

        System.out.println(countSunSetSumDP(nums , subsetSum , nums.length));

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
