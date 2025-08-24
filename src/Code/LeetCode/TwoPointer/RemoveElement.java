package Code.LeetCode.TwoPointer;

public class RemoveElement {
//    https://leetcode.com/problems/remove-element/description/
    public static void main(String args[]){
        int[] nums = {0,1,2,2,3,0,4,2};
        int xm  = removeElement(nums , 2);
        System.out.println(xm);
        System.out.println(removeElementOptimal(nums , 2));

    }
/*
* {3,2,2,3} - > {2 , 2, ...,  ... }
* */




    public static int removeElementOptimal(int[] nums, int val) {
        int i = 0; // slow pointer

        for (int j = 0; j < nums.length; j++) { // fast pointer
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i; // new length
    }
    public static int removeElement(int[] nums, int val) {
        int i =0 ;
        int j =0 ;
        while(i<nums.length){
            if(nums[i] == val){
                while(j< nums.length && nums[j]==val){
                    j++;
                }
                if(j!= nums.length){
                    int x = nums[i];
                    nums[i] = nums[j];
                    nums[j] = x;
                }

            }
            i++;
            j=i;
        }
        int k = 0 ;
        while(k< nums.length && nums[k]!=val){
            k++;
        }
        return k;

    }
}
