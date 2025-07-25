package LeetCode.Array;

import java.util.Arrays;

public class kthLargestElementInArray {


//https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/


        public String kthLargestNumber(String[] nums, int k) {


            Arrays.sort(nums , (a, b)->{
                if(a.length()==b.length()){
                    return b.compareTo(a);
                }
                return b.length()-a.length();
            });
            return nums[k-1];

        }
}
