package LeetCode;

public class twoSum {



//[(7)(6)(4)(3)(1)7,6,4,3,1]



    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int prefix = 1;
            int n = nums.length;
            int[] res  = new int[n];
            for(int i = 0 ; i < n ; i++){
                res[i]=prefix;
                prefix*=nums[i];
            }
            int suffix = 1;
            for (int i = n - 1; i >= 0; i--) {
                res[i] *= suffix;
                suffix *= nums[i];
            }
            return res;

        }
    }

}
