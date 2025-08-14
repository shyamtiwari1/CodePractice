package Code.LeetCode.TwoPointer;

public class maximumConsecutiveOnes {

    //https://leetcode.com/problems/max-consecutive-ones-iii/
    public static void main(String args[]){
        int [] arr = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(arr , k));

    }


    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int max_length = 0 ;
        int l = 0 ; int r = 0 ;
        while(r<n){
            if(nums[r] == 1){
                r++;
            }else{
                if( k>0){
                    k--;
                    r++;
                }else{
                    while(nums[l]!=0){
                        l++;
                    }
                    k++;
                    l++;
                }

            }
            max_length = Math.max(max_length , r-l);
        }
        return max_length;

    }
}
