package LeetCode.TwoPointer;

import java.util.Arrays;

public class FrequencyOfMostFrequentElement {


//    https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/



    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0 ; int j = 0;
        int n = nums.length;
        int ans = 0 ; int currans = 0 ;
        long currSum = 0;
        while(i<n && j<n){
            currSum += nums[j];


            long currentCost = (long)nums[j]*(j-i+1) - currSum;
            while( currentCost > k){
                currSum-=(long)nums[i];
                i++;
                currentCost = (long)nums[j]*(j-i+1) - currSum;
            }

            ans = Math.max(ans, j-i+1);
            j++;

        }
        return ans;

    }




}
