package LeetCode.BianrySearch;

public class MissingNumber268 {
    public static void main (String args[]){
        int nums[] = {9,6,4,2,3,5,7,0,1};
        int x = missingNumber(nums);
        System.out.println(x);

    }


    public static int missingNumber(int[] nums) {
        int result = 0 ;
            for(int i = 0 ; i<nums.length; i ++){
                result+=  i - nums[i];

            }
            return result+nums.length;
    }

}
