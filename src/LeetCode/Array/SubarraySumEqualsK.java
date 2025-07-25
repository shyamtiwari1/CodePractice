package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
//    https://leetcode.com/problems/subarray-sum-equals-k/description/



    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int totalCount  = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (mpp.containsKey(prefixSum - k)) {
                totalCount += mpp.get(prefixSum - k);
            }

            mpp.put(prefixSum, mpp.getOrDefault(prefixSum, 0) + 1);
        }

        return totalCount;
    }
}
