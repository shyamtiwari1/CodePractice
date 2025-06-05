package LeetCode.BianrySearch;

public class OccurenceOfFirstAndLAst {

//    https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=problem-list-v2&envId=binary-search




    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] ans = new int[2];
            int x = findFirst(nums , target);
            int y = findLast(nums , target);
            ans[0] = x;
            ans[1] = y;
            return ans;

        }


        public int findFirst(int[] nums, int target){
            int n = nums.length;
            int left = 0 ; int right = n-1;
            int result = -1;
            while(left <=right){
                int mid = left+(right-left)/2;
                if(nums[mid]==target){
                    result = mid;
                    right = mid-1;
                }else if(nums[mid]>target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            return result;
        }



        public int findLast(int[] nums, int target){
            int n = nums.length;
            int left = 0 ; int right = n-1;
            int result = -1;
            while(left <=right){
                int mid = left+(right-left)/2;
                if(nums[mid]==target){
                    result = mid;
                    left = mid+1;
                }else if(nums[mid]>target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            return result;
        }
    }
}
