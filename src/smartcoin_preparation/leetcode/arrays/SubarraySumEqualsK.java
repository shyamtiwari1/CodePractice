package smartcoin_preparation.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {


    public int subarraySum(int[] nums, int k) {

        int numberofsubarrays  = 0 ;
        int prefixsum = 0 ;
        int n = nums.length;
        Map<Integer , Integer> mpp = new HashMap<>();

        mpp.put(0,1);
        for(int i =0 ; i <n;i++){
            prefixsum +=nums[i];

            if(mpp.containsKey(prefixsum-k))numberofsubarrays+=mpp.get(prefixsum-k);

            mpp.put(prefixsum, mpp.getOrDefault(prefixsum,0)+1);

        }
        return numberofsubarrays;

    }



}
