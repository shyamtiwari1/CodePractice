package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPairsWithAbsoluteDifferenceK {

//    https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/


    class Solution {
        public int countKDifference(int[] nums, int k) {

            Map<Integer , Integer> mpp = new HashMap<>();

            int count = 0 ;
            for(int num : nums){
                count += mpp.getOrDefault(num-k, 0);
                count += mpp.getOrDefault(num+k, 0);

                mpp.put(num , mpp.getOrDefault(num,0)+1);
            }

            return count;

        }
    }
}
