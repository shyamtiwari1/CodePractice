package Code.LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    public static void main(String args[]){
    int arr[] = new int[]{-1,0,1,2,-1,-4};

        System.out.println(threeSumBruteForce(arr));
        System.out.println(threeSum(arr));

    }
    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j< n ; j++){
                for(int k = 0 ; k< n ; k++){
                    if(i!=j && i!= k && j!= k && nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> intList = new ArrayList<>(List.of(nums[i], nums[j], nums[k]));
                        Collections.sort(intList);
                        res.add(intList);

                    }
                }

            }
        }
        return res.stream().toList();


    }

//nums[i]+nums[j] +nums[k] = 0

    // skip duplicates use kind of binary seartch
    public  static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i< n-2 ; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i+1 ; int right = n-1;
            while(left <right){
                int sum = nums[i]+nums[right]+nums[left];
                if(sum ==0 ){
                    res.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                    while(left<right && nums[left]==nums[left+1]) left++;
                    while(left<right && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }else if(sum>0){
                    right--;
                }else{
                    left++;
                }

            }

        }

return res;
    }
}
