package smartcoin_preparation.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {




        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;

            List<List<Integer>> ans = new ArrayList<>();

            Arrays.sort(nums);
            for (int j = 0; j < n - 1; j++) {

                if (j > 0 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int curr = nums[j];
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    int sum = curr + nums[left] + nums[right];
                    if (sum == 0 && left!=j && left!=right) {
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right - 1] == nums[right])
                            right--;
                        ans.add(List.of(nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }

            }

            return ans;
    }
}
