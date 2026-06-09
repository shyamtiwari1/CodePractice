package Code.LeetCode.DP.OneD;

import java.util.Arrays;
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

//TC : O(N**3) , O(n) states
//O(n) split positions per state
//O(n) substring creation cost
//    O(n) - SC

        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordset = new HashSet<>();
            int[] dp = new int[s.length()];
            Arrays.fill(dp,-1);
            for(String x : wordDict){
                wordset.add(x);
            }

            return recursion(s,0,wordset,dp)==1;

        }


        public int recursion(String s,int currindex,Set<String>wordset, int[]dp){

            if(currindex==s.length())return 1;

            if(dp[currindex]!=-1)return dp[currindex];
            for(int i = currindex+1;i<=s.length();i++){
                String word = s.substring(currindex,i);

                if(wordset.contains(word) &&  recursion(s, i,wordset,dp)==1){
                    return dp[currindex] = recursion(s, i,wordset,dp);
                }

            }

            return dp[currindex] =0;

        }
}
