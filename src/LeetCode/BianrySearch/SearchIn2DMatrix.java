package LeetCode.BianrySearch;

public class SearchIn2DMatrix {

//    https://leetcode.com/problems/search-a-2d-matrix/description/



    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int n = matrix[0].length;
            int m = matrix.length;
            boolean ans = false;

            for(int i = 0 ; i < m ; i ++){
                if(ans){
                    return true;
                }
                ans = binarySearch(matrix[i] , target) || ans;
            }
            return ans;

        }


        public boolean binarySearch(int[] nums, int target){
            int n = nums.length;
            int left = 0 ; int right = n-1;
            while(left <=right){
                int mid = left+(right-left)/2;
                if(nums[mid]==target){
                    return true;
                }else if(nums[mid]>target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            return false;
        }
    }
}
