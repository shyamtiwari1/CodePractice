package LeetCode.String;

import java.util.ArrayList;
import java.util.List;

public class CommonChars {




//    https://leetcode.com/problems/find-common-characters/


    class Solution {
        public List<String> commonChars(String[] words) {

            int[] minfreq = new int[26];
            for(int i = 0 ; i<26;i++ ){
                minfreq[i] = Integer.MAX_VALUE;
            }
            for(String word : words){
                int[] freq = new int[26];

                for(Character c : word.toCharArray()){
                    freq[c-'a'] = freq[c-'a']+1;
                }
                for(int i = 0 ; i < 26 ;i++){
                    minfreq[i] = Math.min(minfreq[i] , freq[i]);
                }
            }
            List<String> ans = new ArrayList<>();

            for(int i = 0 ; i < 26 ; i++){
                int currfreq = minfreq[i];
                while(currfreq!=0){
                    ans.add(String.valueOf((char)(i+'a')));
                    currfreq--;
                }
            }
            return ans;



        }
    }
}
