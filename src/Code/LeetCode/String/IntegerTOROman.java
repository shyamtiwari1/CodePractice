package Code.LeetCode.String;

public class IntegerTOROman {

//    https://leetcode.com/problems/integer-to-roman/



    class Solution {
        public String intToRoman(int num) {

            int[]nums = new int[]{1000 , 900, 500, 400, 100, 90 , 50 , 40 , 10 ,9,5,4 ,1};
            String[]values = new String[]{"M" , "CM" , "D" , "CD" , "C" , "XC" , "L" , "XL" , "X" , "IX","V" ,"IV" , "I"};
            StringBuilder ans = new StringBuilder();
            for (int i = 0 ; i<nums.length;i++){
                while(num>=nums[i]){
                    num-=nums[i];
                    ans.append(values[i]);
                }
            }
            return ans.toString();
        }}
}
