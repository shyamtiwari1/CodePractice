package LeetCode.TwoPointer;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInString {
//    https://leetcode.com/problems/reverse-words-in-a-string/

    public static void main(String args[]){
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
        System.out.println("blue is sky the");

    }



    public static String reverseWords(String s) {
        List<String> arr= new ArrayList<>();
        int j= 0; int n = s.length();
        String currString = "";

        while(j<n){
            if(s.charAt(j)==' '){
                arr.add(currString);
                currString = "";
            }else{
                currString+=s.charAt(j);
            }
            j++;

        }
        arr.add(currString);
        String ans = "";
        for(int i = arr.size()-1;i>=0;i--){
            ans+=arr.get(i);
            if( i!=0){
                ans+=" ";
            }

        }
        return ans;

    }
}
