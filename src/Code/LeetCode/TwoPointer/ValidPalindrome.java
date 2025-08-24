package Code.LeetCode.TwoPointer;

import java.util.HashSet;
import java.util.Set;

public class ValidPalindrome {

//    https://leetcode.com/problems/valid-palindrome/description/



    class Solution {
        public boolean isPalindrome(String x) {
            String s = x.toLowerCase();
            Set<Character> set = new HashSet<>();
            for(char c = 'a' ; c<='z';c++){
                set.add(c);
            }
            for(char i = '0' ; i <='9';i++)set.add(i);
            int i = 0 ; int j = s.length()-1;

            while(i<=j){
                while(i<j && !set.contains(s.charAt(i)))i++;
                while(i<j && !set.contains(s.charAt(j)))j--;

                if(s.charAt(i)!=s.charAt(j))return false;
                i++;
                j--;


            }
            return true;


        }
    }
}
