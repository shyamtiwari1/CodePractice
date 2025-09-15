package Code.LeetCode.DP.OneD;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak {


//    https://leetcode.com/problems/word-break/description/
    class Solution {


        public boolean wordBreak(String s, List<String> wordDict) {
            Boolean[] dp = new Boolean[s.length()];
            return memoized(s , new HashSet<>(wordDict) , 0 , dp);
        }



        public boolean recursion(String s, List<String> wordDict , int start) {

            if(start==s.length()){
                return true;
            }
            for(int end = start+1 ;end <=s.length();end++){
                if(wordDict.contains(s.substring(start,end)) && recursion(s.substring(start,end), wordDict, end)){
                    return true;
                }
            }
            return false;

        }

        public boolean memoized(String s , Set<String> dict , int start, Boolean[] dp){
            if(start==s.length()){
                return true;
            }
            if(dp[start]!=null){
                return dp[start];
            }

            for(int i = start+1 ; i <=s.length();i++){
                String word = s.substring(start , i);


                if(dict.contains(word) && memoized(s , dict ,i , dp )){
                    return dp[start] =  true;
                }

            }
            return dp[start] = false;
        }

        // here time complexity is O(n**2) may degrade to o(n**3) in case of substring overhead
    }
}
