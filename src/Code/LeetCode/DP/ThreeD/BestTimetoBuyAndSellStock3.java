package Code.LeetCode.DP.ThreeD;

import java.util.Arrays;

public class BestTimetoBuyAndSellStock3 {


    //    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

    /***
     * using two loops from both end to calculate the transactions , then combinging the result
     * so the first loop leftmax  tells what is the best possible profit possible till the index i
     * and the right loop tell what is the max possible profit from i to last
     *then we combine both and return the max of both
     */





    class Solution {
        public int maxProfit(int[] prices) {

            int minpricesofar = Integer.MAX_VALUE;
            // int maxprofitsofar = Integer.MIN_VALUE;
            int n = prices.length;
            int[] leftProfit = new int[n];
            int[] rightProfit = new int[n];
            minpricesofar = prices[0];
            for(int i = 1 ; i <n ;i++){
                minpricesofar = Math.min(minpricesofar , prices[i]);
                leftProfit[i] = Math.max(leftProfit[i-1] , prices[i]-minpricesofar);
            }

            // int maxprofitsofar2 = Integer.MIN_VALUE;
            int maxValueTillNow = Integer.MIN_VALUE;
            maxValueTillNow = prices[n-1];
            int ans = Integer.MIN_VALUE;
            for(int i = n-2;i>=0;i--){
                maxValueTillNow = Math.max(maxValueTillNow , prices[i]);
                rightProfit[i] = Math.max(rightProfit[i+1] , maxValueTillNow - prices[i]);
            }

            for(int i = 0 ; i <n;i++){
                ans = Math.max(ans, rightProfit[i]+leftProfit[i]);
            }
            return ans;



        }
    }



    public static void main(String rags[]){

    }

/***
 * here this problem is solved using DP
 * we wrote the recursion
 * with three states changine
 * 1. Index ,
 * 2. weather we can buy or not
 * 3. cap(number of transactions allowed)
 *
 * now if we can buy (i.e we've not already buyed) , then either we can buy or skip
 * if we cannot buy (already buyed) then we can sell or skip that is recursion
 *
 * TC(N*2*3) , SC(O(N))
 */


    class Solution1 {
        public int maxProfit(int[] prices) {

            int[][][] dp = new int[prices.length][2][3];

            for (int i = 0; i < prices.length; i++) {
                for (int j = 0; j < 2; j++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }

            return helper(prices, 0, 1, 2, dp);

        }

        public int helper(int[] prices, int n, int buy, int cap, int[][][] dp) {
            if (cap == 0)
                return 0;
            if (n >= prices.length)
                return 0;

            if (dp[n][buy][cap] != -1)
                return dp[n][buy][cap];
            if (buy == 1) {
                return dp[n][buy][cap] = Math.max(helper(prices, n + 1, 0, cap, dp) - prices[n],
                        helper(prices, n + 1, 1, cap, dp));
            } else {
                return dp[n][buy][cap] = Math.max(helper(prices, n + 1, 1, cap - 1, dp) + prices[n],
                        helper(prices, n + 1, 0, cap, dp));
            }
        }
    }
}
