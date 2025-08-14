package Code.LeetCode.Array;

public class BestTimeToBuySellStock {
//    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
    class Solution {
        public int maxProfit(int[] prices) {
            int minpricesofar = Integer.MAX_VALUE;
            int maxprofitsofar = Integer.MIN_VALUE;
            int n = prices.length;
            for(int i = 0 ; i <n ;i++){
                minpricesofar = Math.min(minpricesofar , prices[i]);
                maxprofitsofar = Math.max(maxprofitsofar , prices[i]-minpricesofar);
            }
            return maxprofitsofar;


        }
    }
}
