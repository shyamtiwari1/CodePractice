package LeetCode.DP.OneD;

public class JumpGame2 {

//    https://leetcode.com/problems/jump-game-ii/description/

// here we're calculationg farthest we can go from that index ,
//    we're maintaining the currEnd that max where can we end currrently

//    when you reach currEnd we need to jump , we update farthest and increase jump

    class Solution {
        public int jump(int[] nums) {
            int jumps = 0 ; int currEnd = 0 ;
            int n = nums.length;
            int farthest = nums[0];

            for(int i = 0 ; i < n-1 ; i ++){
                farthest = Math.max(farthest , i+nums[i]);

                if(i==currEnd){
                    jumps++;
                    currEnd= farthest;
                }

            }
            return jumps;

        }



        public int recursion(int[] nums , int index){

            if (index>=nums.length-1) return 0;
            int maxJump = nums[index];
            int minJump = Integer.MAX_VALUE;

            for(int i = 1 ; i <=maxJump;i++){
                int nextindex = i+index;
                if(nextindex<nums.length){
                    int subjump = recursion(nums, nextindex);
                    if(subjump!=Integer.MAX_VALUE){
                        minJump = Math.max(minJump, subjump+1);

                    }
                }

            }
            return minJump;
        }


        public int memoize(int[] nums, int [] dp , int index){

            if (index>=nums.length-1) return 0;
            int maxJump = nums[index];
            int minJump = Integer.MAX_VALUE;
            if(dp[index]!=-1)return dp[index];

            for(int i = 1 ; i <=maxJump;i++){
                int nextindex = i+index;
                if(nextindex<nums.length){
                    int subjump = memoize(nums,dp ,  nextindex);
                    if(subjump!=Integer.MAX_VALUE){
                        minJump = Math.min(minJump, subjump+1);

                    }
                }

            }
            return dp[index] = minJump;
        }
    }
}
