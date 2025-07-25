package LeetCode.TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostKDistinctCharacters {
//https://www.naukri.com/code360/problem-details/distinct-characters_2221410
    public static void main(String args[]){

    }


    public static int kDistinctChars(int k, String str) {
        int i = 0 ; int j = 0 ; int n = str.length();
        Map<Character , Integer> mpp = new HashMap<>();
        int ans =  0 ;
        while(j<n){
            mpp.put(str.charAt(j) , mpp.getOrDefault(str.charAt(j) , 0 )+1);
                while(mpp.size()>k){
                    mpp.put(str.charAt(i) , mpp.get(str.charAt(i))-1);
                    if(mpp.get(str.charAt(i))==0){
                        mpp.remove(str.charAt(i));
                    }
                    i++;
                }
            ans = Math.max(ans, j-i+1);
            j++;

        }
        return ans;
    }
}
