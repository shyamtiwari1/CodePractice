package Code.LeetCode.BinarySearch;

public class SplitArrayLargestSum {


//    https://leetcode.com/problems/split-array-largest-sum/



    class Solution {
        public int splitArray(int[] nums, int k) {
            int maxsum = 0 ; int minsum = Integer.MIN_VALUE;

            for(int i : nums){
                maxsum+=i;
                minsum = Math.max(i, minsum);
            }

            while(minsum<maxsum){
                int mid = minsum+(maxsum-minsum)/2;

                int subarrays = getsubarrays(mid , nums );
                if(subarrays>k){
                    minsum = mid+1;

                }else{
                    maxsum = mid;

                }


            }
            return minsum;
        }
        public int getsubarrays(int mid , int[]nums ){
            int countofsubarray = 1 ;
            int currsum = 0 ;
            for(int i = 0 ; i<nums.length;i++){
                if(currsum+nums[i]>mid){
                    currsum = nums[i] ;
                    countofsubarray++;
                }else{
                    currsum+=nums[i];
                }

            }
            return countofsubarray;
        }



    }
}
