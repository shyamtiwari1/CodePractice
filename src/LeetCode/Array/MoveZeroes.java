package LeetCode.Array;

public class MoveZeroes {

//https://leetcode.com/problems/move-zeroes/

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int insertpos = 0 ;
        for(int num: nums){
            if(num!=0){
                nums[insertpos] = num;
                insertpos++;
            }
        }
        while(insertpos <n){
            nums[insertpos]=0;
            insertpos++;
        }
    }
}
