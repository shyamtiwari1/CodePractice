package LeetCode.Array;

import java.util.HashSet;
import java.util.Set;

public class longestconsecutivesequence {

//    https://leetcode.com/problems/longest-consecutive-sequence/


/***
 * since we have to O(N)  time we will use set here ,
 * we will add all the elemts in set and then look for each element and check if its preceeding
 * element is not there
 * that is , it is the start of sequence , the keep on moving untill the sequence remains
 *
 *
 *
 */


    class Solution {
        public int longestConsecutive(int[] nums) {

            Set<Integer> set = new HashSet<>();
            if(nums.length ==0){
                return 0;
            }

            for(int i : nums){
                set.add(i);
            }
            int maxlen = 1;
            for(int num : set){

                if(!set.contains(num-1)){
                    int currlen = 0;
                    int currnum = num;
                    while(set.contains(currnum)){
                        currlen++;
                        currnum++;
                    }

                    maxlen = Math.max(maxlen , currlen);
                }
            }

            return maxlen;

        }
    }
}
