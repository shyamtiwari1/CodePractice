package LeetCode.DP;

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
    }
}
