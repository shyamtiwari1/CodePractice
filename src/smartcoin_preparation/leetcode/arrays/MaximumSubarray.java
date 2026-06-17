package smartcoin_preparation.leetcode.arrays;

public class MaximumSubarray {


    //kadane algorithm
        public int maxSubArray(int[] nums) {
            int maxsum = Integer.MIN_VALUE;
            int n = nums.length;
            int currsum = 0;

            for (int j = 0; j < n; j++) {

                currsum = Math.max(currsum + nums[j], nums[j]);

                maxsum = Math.max(maxsum, currsum);
            }
            return maxsum;

        }
}
