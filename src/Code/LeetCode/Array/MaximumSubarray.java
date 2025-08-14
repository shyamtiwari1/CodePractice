package Code.LeetCode.Array;

public class MaximumSubarray {


//    kadane algo

//    https://leetcode.com/problems/maximum-subarray/description/


    class Solution {
        public int maxSubArray(int[] nums) {
            int currSum = nums[0];
            int maxSoFar = nums[0];
            for(int i = 1 ; i < nums.length;i++){
                currSum = Math.max(currSum+nums[i] , nums[i]);
                maxSoFar = Math.max(maxSoFar, currSum);
            }
            return maxSoFar;



        }
    }
}
