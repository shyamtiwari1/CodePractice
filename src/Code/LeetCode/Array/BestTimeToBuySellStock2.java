package Code.LeetCode.Array;

public class BestTimeToBuySellStock2 {
//    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/\



    class Solution {
        public int maxProfit(int[] prices) {

            int totalprofit = 0 ;
            for(int i = 1 ; i <prices.length;i++){
                if(prices[i]>prices[i-1]){
                    totalprofit+=prices[i]-prices[i-1];
                }
            }
            return totalprofit;

        }
    }

}
