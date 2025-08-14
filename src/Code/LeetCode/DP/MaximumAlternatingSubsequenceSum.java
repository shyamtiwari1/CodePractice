package Code.LeetCode.DP;

public class MaximumAlternatingSubsequenceSum {

//    https://leetcode.com/problems/maximum-alternating-subsequence-sum/description/


        public long maxAlternatingSum(int[] nums) {
            int n = nums.length;
            long[][] dp = new long[n][2];
            for (int i = 0; i < n; i++) {
                dp[i][0] = -1;
                dp[i][1] = -1;
            }

            return recursion(nums , nums.length-1 , 1 , dp);

        }

        public long recursion(int[] nums , int n , int evenTurn , long[][] dp) {
            if (n < 0) {
                return 0;
            }
            long take = 0;
            if (dp[n][evenTurn] != -1) {
                return dp[n][evenTurn];
            }
            if (evenTurn == 1) {
                take = nums[n] + recursion(nums, n - 1, 0, dp);
            } else {
                take = recursion(nums, n - 1, 1, dp) - nums[n];
            }
            long skip = recursion(nums, n - 1, evenTurn, dp);

            long result = Math.max(skip, take);
            dp[n][evenTurn] = result;
            return result;
        }
}

