package LeetCode.TwoPointer;

import java.util.HashSet;
import java.util.Set;

public class LongestCOmmonSubStringWithoutRepeatingCharacter {
//    https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=problem-list-v2&envId=oizxjoit




        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            int j = 0 ;
            int i = 0 ;
            Set<Character> set = new HashSet<>();
            int maxLen = 0;
            while(j<n){
                if(set.contains(s.charAt(j))){
                    while(set.contains(s.charAt(j))){
                        set.remove(s.charAt(i));
                        i++;
                    }
                }else{
                    set.add(s.charAt(j));
                    maxLen = Math.max(set.size(), maxLen);
                    j++;
                }

            }
            return maxLen;

        }
}
