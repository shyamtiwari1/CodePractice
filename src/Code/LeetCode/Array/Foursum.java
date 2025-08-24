package Code.LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Foursum {

//    https://leetcode.com/problems/4sum/description/


    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {

            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            for (int j = 0; j < n - 3; j++) {
                if (j > 0 && nums[j] == nums[j - 1])
                    continue;
                for (int i = j + 1; i < n - 2; i++) {
                    if (i > j + 1 && nums[i] == nums[i - 1])
                        continue;

                    int left = i + 1;
                    int right = n - 1;
                    while (left < right) {
                        long sum = (long) nums[i] + nums[j] + nums[right] + nums[left];
                        if (sum == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[left + 1])
                                left++;
                            while (left < right && nums[right] == nums[right - 1])
                                right--;
                            left++;
                            right--;
                        } else if (sum > target) {
                            right--;
                        } else {
                            left++;
                        }

                    }

                }
            }

            return res;

        }
    }
}
