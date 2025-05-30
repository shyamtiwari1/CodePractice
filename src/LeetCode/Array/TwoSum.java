package LeetCode.Array;

import java.util.Arrays;

public class TwoSum {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Arrays.sort(nums);
            int [] res = new int[2];
            for(int i = 0 ; i< nums.length ; i++){
                int x = binarySearch(nums , target - nums[i] , 0 , nums.length-1);
                if(x!=-1 && x!=i){
                    res[0] = x;
                    res[1] = i;
                }

            }
            return res;

        }
        public int binarySearch(int[] nums , int target , int left , int right){
            int mid = left +(right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid]>target){
                binarySearch(nums , target , left , mid-1);
            }else{
                binarySearch(nums , target , mid+1 , right);
            }
            return -1;



        }
    }
}

