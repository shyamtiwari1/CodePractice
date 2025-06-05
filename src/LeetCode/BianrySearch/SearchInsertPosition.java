package LeetCode.BianrySearch;
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
            int startIndex = 0 ;
            int lastIndex = nums.length-1;
            int nearestSmallest = nums[lastIndex];
            int nearestSmallestIndex = lastIndex;
            while(startIndex<= lastIndex){
                int mid = (startIndex+lastIndex)/2;
                if(nums[mid] == target){
                    return mid;
                }
                if(nums[mid] < target){
                    startIndex = mid+1;
                }
                if(nums[mid] >target){
                    lastIndex = mid-1;
                }
                nearestSmallest = Math.min(nearestSmallest , nums[mid]);
                nearestSmallestIndex = mid;

            }
            if(nums[nearestSmallestIndex]<target){
                return nearestSmallestIndex+1;
            }else{
                return nearestSmallestIndex;
            }


        }

}
