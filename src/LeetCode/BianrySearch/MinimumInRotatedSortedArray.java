package LeetCode.BianrySearch;

public class MinimumInRotatedSortedArray {
//    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/?envType=problem-list-v2&envId=oizxjoit


    public static void main(String args[]){

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
