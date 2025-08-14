package Code.LeetCode.TwoPointer;

public class TwoSumTwo {


//    https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=problem-list-v2&envId=binary-search


    class Solution {
        public int[] twoSum(int[] numbers, int target) {

            int i = 0 ; int n = numbers.length; int j = n-1;
            int[] ans = new int[2];
            while(i<=j){
                if(numbers[i]+numbers[j]==target){
                    ans[0] = i+1;
                    ans[1] = j+1;
                    return ans;
                }else if(numbers[i]+numbers[j]>target){
                    j--;
                }else{
                    i++;
                }
            }
            return ans;
        }





//Binary search TC - O(nlog(n))
            public int[] twoSumBinarySearch(int[] numbers, int target) {
                int n = numbers.length;
                int[] ans = new int[2];
                for(int i = 0 ; i < n-1;i++){
                    int right = n-1;
                    int left = i+1;
                    while(left<=right){
                        int mid = left+(right-left)/2;
                        int requiredNum = target-numbers[i];
                        if(numbers[mid]==requiredNum ){
                            ans[0] = i+1;
                            ans[1] = mid+1;
                            return ans;
                        }else if(numbers[mid]>requiredNum){
                            right = mid-1;
                        }else{
                            left = mid+1;
                        }
                    }
                }
                return ans;

            }

    }
}
