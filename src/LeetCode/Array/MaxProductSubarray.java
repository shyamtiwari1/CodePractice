package LeetCode.Array;

public class MaxProductSubarray {
//    https://leetcode.com/problems/maximum-product-subarray/description/?envType=problem-list-v2&envId=oizxjoit


    class Solution {
        public int maxProduct(int[] nums) {
            int n = nums.length;
            int currMax = nums[0];
            int currMin = nums[0];
            int maxSoFar = nums[0];

            for(int i= 1 ; i<n;i++) {
                int temp = currMax;

                currMax = Math.max(nums[i] , Math.max(currMax*nums[i] , currMin*nums[i]));
                currMin = Math.min(nums[i] , Math.min(temp*nums[i] , currMin*nums[i]));

                maxSoFar = Math.max(maxSoFar , currMax);
            }
            return maxSoFar;

        }
    }
    // TC - : O(N) , SC - : O(1)
}
