package Code.LeetCode.Array;

import java.util.Arrays;

public class LargestNumber {


//    https://leetcode.com/problems/largest-number/

    public static void main(String args[]){

        int []num =new int[]{10,2};

        System.out.println(largestNumber(num));

    }





        public static String largestNumber(int[] nums) {

            String[] arr = new String[nums.length];
            int n = nums.length;

            for(int i  =0 ; i<n;i++){
                arr[i] = String.valueOf(nums[i]);
            }

            Arrays.sort(arr , (a, b) ->(a+b).compareTo(b+a));

            if(arr[0]=="0")return "0";
            StringBuilder ans = new StringBuilder();
            for(String s : arr){
                ans.append(s);
            }
            return ans.toString();
        }
    }
