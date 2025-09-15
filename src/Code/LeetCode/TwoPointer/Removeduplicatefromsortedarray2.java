package Code.LeetCode.TwoPointer;

public class Removeduplicatefromsortedarray2 {


//    https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

// just check for two points in stead of one


    class Solution {
        public int removeDuplicates(int[] nums) {

            int n = nums.length;
            if(n<2)return 2;
            int i = 2;
            for(int j = 2; j<n;j++){
                if(nums[i-2]!=nums[j]){
                    nums[i] = nums[j];
                    i++;
                }
            }
            return i ;

        }
    }
}
