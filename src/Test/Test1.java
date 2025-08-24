package Test;

import java.util.Arrays;

public class Test1 {

    public static void main(String[] args) {

        int[] arr = new int[]{3,2,2,3}; int val = 3;

        System.out.println(removeElement(arr,val));

    }




    public static int removeElement(int[] nums, int val) {
        int i = 0; // slow pointer

        for (int j = 0; j < nums.length; j++) { // fast pointer
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i; // new length
    }

}
