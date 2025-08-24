package Code.LeetCode.BinarySearch;
/*
* Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
* */

public class SearchInsertPosition {


//    https://leetcode.com/problems/search-insert-position/description/
    public static void main(String args[]){
        int[] nums = {1,3,5,6};
        int target = 7;
        int x = searchInsert(nums , target);
        System.out.println(x);
    }


        public static int searchInsert(int[] nums, int target) {

            int i = 0;
            int n = nums.length;
            int j = n - 1;
            int ans = -1;

            while (i <= j) {
                int mid = i + (j - i) / 2;
                if (nums[mid] == target) {
                    ans = mid;
                    return ans;
                } else if (nums[mid] > target) {
                    j = mid - 1;
                } else {
                    ans = mid;
                    i = mid + 1;
                }

            }
            return ans + 1;

        }
    }


