package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class findDuplicatesinArray {

//    https://leetcode.com/problems/find-all-duplicates-in-an-array/

    /***
     * here since we have to solve the problem in o(N) time and constant space we will flip every element which comes in our way to its negative
     * the ones which are already pointing to negative must be duplicate
     * this is a nice problem
     */




    public List<Integer> findDuplicates(int[] nums) {
            List<Integer> ans = new ArrayList<>();

            for(int i = 0 ; i < nums.length;i++){
                if(nums[Math.abs(nums[i])-1]<0){
                    ans.add(Math.abs(nums[i]));
                }else{
                    nums[Math.abs(nums[i])-1] = (-1)*(nums[Math.abs(nums[i])-1]);
                }
            }
            return ans;
        }
    }

