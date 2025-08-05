package LeetCode.DP.OneD;

public class JumpGame {
//    https://leetcode.com/problems/jump-game/?envType=problem-list-v2&envId=oizxjoit
    // recursion and memoization
        public boolean canJump(int[] nums) {
            Boolean[] dp = new Boolean[nums.length];
            return memoization(nums , 0 , nums.length , dp);

        }


    public boolean recursion(int[] nums , int index){
        if(index >=nums.length-1){
            return true;
        }

        int maxJump = nums[index];
        for(int jump = 1 ; jump <=maxJump ;jump++){
            if(recursion(nums , jump+index)){
                return true;
            }
        }
        return false;
    }

        public boolean memoization(int[] nums , int currIndex , int n  , Boolean[] dp){
            if(currIndex>=n-1){
                return true;
            }
            if(dp[currIndex]!=null){
                return dp[currIndex];
            }
            int maxJump = nums[currIndex];

            for(int i = 1 ; i <=maxJump;i++){
                if(memoization(nums, i+currIndex , n  , dp)){
                    dp[currIndex] = true;
                    return true;
                }
            }
            dp[currIndex] = false;
            return false;
        }



        public boolean canJumpGreedy(int[] nums) {
            int n = nums.length;
// so we calculate first what farthest we can get till , now
// for every index , we're checking if we can be here from any previous position
            int farthest = nums[0];
            for(int i = 0 ; i < n ; i ++){
                if(i>farthest){
                    return false;
                }
                farthest = Math.max(farthest , i+nums[i]);
            }
            return true;

        }



//

}
