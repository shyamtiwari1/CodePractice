package LeetCode.DP.OneD;

public class HouseRobber2 {
//    https://leetcode.com/problems/house-robber-ii/


    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;

            if (n == 1) return nums[0]; // only one house

            // Case 1: Rob from 0 to n-2
            int case1 = helper(nums, 0, n - 2);

            // Case 2: Rob from 1 to n-1
            int case2 = helper(nums, 1, n - 1);

            return Math.max(case1, case2);
        }

        private int helper(int[] nums, int start, int end) {
            if (start > end) return 0;

            // Either rob current house and move to start + 2
            // or skip current house and move to start + 1
            return Math.max(
                    nums[start] + helper(nums, start + 2, end),
                    helper(nums, start + 1, end)
            );
        }
    }

}
