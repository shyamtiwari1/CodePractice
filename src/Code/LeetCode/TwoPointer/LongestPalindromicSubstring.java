package Code.LeetCode.TwoPointer;

public class LongestPalindromicSubstring {
//    https://leetcode.com/problems/longest-palindromic-substring/description/?source=submission-ac





// here's the two pointer approach , where we try to expand from center , for every index ,
// to get the maximum length of palindrome , the we take the index of string with maximum length and return substring
//    this will take o(n2)

    // this can have a dp solution as well , where we check and store the i , j substring is dp or not

    class Solution {
        public String longestPalindrome(String s) {
            int start = 0 , end=0;
            for(int i = 0 ; i <s.length();i++){
                int oddlen = expandfromcenter(s, i , i);
                int evenlen = expandfromcenter(s, i , i+1);


                int len = Math.max(oddlen, evenlen);

                if(len>end-start){
                    start = i-(len-1)/2;
                    end = i+len/2;
                }

            }
            return s.substring(start , end+1);
        }

        public int expandfromcenter(String s, int i , int j ){
            while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
                i--;j++;
            }
            return j-i-1;
        }
    }
}
