package LeetCode.BianrySearch;

public class FirstAndLastOccurance {




//    https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/1659943461/



        public int[] searchRange(int[] nums, int target) {

            int x = findFirst(nums , target);
            int y = findLast(nums , target);

            return new int[]{x,y};



        }

        public int findFirst(int[] nums , int target){
            int i = 0 ; int j = nums.length-1;
            int ans = -1 ;
            while(i<=j){
                int mid= i+(j-i)/2;
                if(nums[mid]==target){
                    ans = mid;
                    j=mid-1;
                }else if(nums[mid]>target){
                    j=mid-1;
                }else{
                    i= mid+1;
                }
            }
            return ans;
        }


        public int findLast(int[] nums , int target){
            int i = 0 ; int j = nums.length-1;
            int ans = -1 ;
            while(i<=j){
                int mid = i+(j-i)/2;
                if(nums[mid]==target){
                    ans = mid;
                    i=mid+1;
                }else if(nums[mid]>target){
                    j=mid-1;
                }else{
                    i= mid+1;
                }
            }
            return ans;
        }
}
