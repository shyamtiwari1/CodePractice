package Code.LeetCode.TwoPointer;

public class RemoveDuplicateFromSortedArray {
//    https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    public static void main (String args[]){
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));

    }

//[0,0,1,1,1,2,2,3,3,4]
    /*
    * i=0 ; j = 0 ;
    * nums[i] = nums[0] = 0
    * nums[j] = nums[0] = 0  - j++ -> j =1
    * nums[i] = nums[0] = 1
    * nums[j] = nums[1] = 0 - > j++ - > j = 2;
    * nums[i] = nums[0] = 1
    * nums[j] = nums[2] = 1 - > nums[i+1]
    * nums[i+1] = nums[1] = nums[j] = 2
    *
    *
    *
    * */
    public static int removeDuplicates(int[] nums) {
        int i =0 ;
        int j = 0 ;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }else{
                nums[i+1] = nums[j];
                j++;
                i++;
            }
        }
        return i+1;


    }
}
