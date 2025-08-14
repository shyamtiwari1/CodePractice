package Code.LeetCode.Stack;

import java.util.Arrays;

public class NextGreaterElement2 {
//    https://leetcode.com/problems/next-greater-element-ii/description/


    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int i = 0 ;
            int[] doublenums = new int[nums.length * 2];
            for (int l = 0; l < nums.length; l++) {
                doublenums[l] = nums[l];
                doublenums[l + nums.length] = nums[l];
            }
            int n = nums.length;
            int [] res = new int[n];
            Arrays.fill(res, -1);
            int last = -1;
            while(i<n){
                int j = i ;
                while(j<2*n && doublenums[j]<=nums[i]){
                    j++;
                }
                if(j!=2*n){
                    res[i] = doublenums[j];
                }
                i++;

            }
            return res ;
        }
    }
}
