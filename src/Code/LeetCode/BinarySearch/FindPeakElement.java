package Code.LeetCode.BinarySearch;

public class FindPeakElement {

//https://leetcode.com/problems/find-peak-element/description/
    class Solution {
        public int findPeakElement(int[] nums) {
            return findPeakElementRecursive(nums, 0 , nums.length-1);
        }


        public int findPeakElementRecursive(int[] nums , int l , int r){

            if(l==r){
                return l;
            }
            int mid = l+ (r-l)/2;
            if(nums[mid]>nums[mid+1]){
                return findPeakElementRecursive(nums , l , mid);
            }else{
                return findPeakElementRecursive(nums , mid+1 , r);
            }
        }


    }
}
