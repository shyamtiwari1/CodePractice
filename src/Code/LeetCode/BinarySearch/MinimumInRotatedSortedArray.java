package Code.LeetCode.BinarySearch;

public class MinimumInRotatedSortedArray {
//    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array


    public static void main(String args[]){
/// so , in this question we try to use binary search , we check if the mid elemnt if greater or small than the right most ,
//  so if it is greater than the right most , it means the min lies between the mid and right most so we move left one to mid+1
//  now , if it is lesser , we move the roght one to exactly at mid so that we dont exclude mid
        int [] nums = new int[]{3,4,5,1,2};
        System.out.println(findMin(nums));

    }



        public static int findMin(int[] nums) {
            int left = 0 ;
            int right = nums.length-1;

            while(left<right){
                int mid = left+(right-left)/2;
                if(nums[mid]>nums[right]){
                    left = mid+1;
                }else{
                    right=mid;
                }
            }
            return nums[left];


        }




}
