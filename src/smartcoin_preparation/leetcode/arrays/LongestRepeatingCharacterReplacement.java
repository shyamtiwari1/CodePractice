package smartcoin_preparation.leetcode.arrays;

import java.util.Arrays;

public class LongestRepeatingCharacterReplacement {




        public int characterReplacement(String s, int k) {


            int[] freq = new int[26];
            Arrays.fill(freq,0);

            int maxfreq = 0 ; int maxlen = 0 ;
            int i = 0 ; int j = 0 ; int n = s.length();

            while(i<n && j<n){
                freq[s.charAt(j)-'A']++;

                int currentwindowlength = j-i+1;
                maxfreq = Math.max(freq[s.charAt(j)-'A'],maxfreq);
                if(currentwindowlength-maxfreq>k){
                    freq[s.charAt(i)-'A']--;
                    i++;
                }
                maxlen = Math.max(maxlen, j-i+1);
                j++;
            }
            return maxlen;

        }
}
