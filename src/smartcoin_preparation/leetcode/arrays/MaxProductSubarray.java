package smartcoin_preparation.leetcode.arrays;

public class MaxProductSubarray {



    public int maxProduct(int[] nums) {


        int n = nums.length;


        int currmin = nums[0];
        int currmax = nums[0];

        int maxsofar = nums[0];


        for(int i = 1 ; i <n;i++){
            int temp = currmax ;


            currmax = Math.max(nums[i] , Math.max(currmax*nums[i], currmin*nums[i]));
            currmin = Math.min(nums[i] , Math.min(temp*nums[i] , currmin*nums[i]));

            maxsofar  = Math.max(currmax, maxsofar);
        }

        return maxsofar;

    }



}
