package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {
//    https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

        public static void main(String [] args){
            String s="abba";
            System.out.println(lengthOfLongestSubstring(s));

        }

        public static int lengthOfLongestSubstring(String s) {
            if(s.length()==0){
                return 0;
            }
/*
"abcabcbb"

*/


            int len = 1;
            int n = s.length();
            int i = 0 ; int j = 0 ;
            int maxCount = 1;
            int currentCount = 1;
            Map<Character , Integer> charMap = new HashMap<>();
            while(j<n){
                if(charMap.get(s.charAt(j))!= null && charMap.get(s.charAt(j)) >= i){
                    i= charMap.get(s.charAt(j))+1;
                }
                charMap.put(s.charAt(j) , j);
                maxCount = Math.max(maxCount , j-i+1);
                j++;
            }
            return maxCount;

        }



}


