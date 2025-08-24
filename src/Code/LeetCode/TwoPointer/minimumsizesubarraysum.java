package Code.LeetCode.TwoPointer;

public class minimumsizesubarraysum {

//https://leetcode.com/problems/minimum-size-subarray-sum/


    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int currsum = 0;
            int i = 0 ; int j = 0; int n = nums.length;
            int minlen = Integer.MAX_VALUE;
            while(j<n){
                currsum+=nums[j];
                j++;

                while(currsum>=target){
                    minlen = Math.min(minlen , j-i);
                    currsum-=nums[i];
                    i++;
                }
            }
            return minlen==Integer.MAX_VALUE?0:minlen;

        }
    }
}
