package Code.LeetCode.Array;

public class BestTimeToBuySellStock3 {
//    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

/***
 * using two loops from both end to calculate the transactions , then combinging the result
 *
 *
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
}
