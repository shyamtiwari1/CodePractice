package Code.LeetCode.BinarySearch;

public class MinimumInRotatedSortedArray {
//    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array


    public static void main(String args[]){
// so , in this question we try to use binary search , we check if the mid elemnt if greater or small than the right most ,
//  so if it is greater than the right most , it means the min lies between the mid and right most so we move left one to mid+1
//  now , if it is lesser , we move the roght one to exactly at mid so that we dont exclude mid
        int [] nums = new int[]{3,4,5,1,2};
        System.out.println(findMin(nums));

    }



    /*** In this problem lets understand
     * [4,5,6,7,0,1,2]
     * first nums[mid] = 7
     * 7>2 , this the right half must have decrreased somewhere , and there can be only one min thus
     * in right half and its not mid so l = mid+1
     * in the other case
     *
     * [11,13,15,17]
     * first mid = 13
     * 13<17 , this in second else case we'll go ,
     * Since 13 < 17, this means the array is still sorted in the left to mid portion,
     * so the minimum cannot be to the right.
     * j = 1 , new mid = 0+1/2 = 0
     * i<j fails , we return the nums[i]
     */



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
