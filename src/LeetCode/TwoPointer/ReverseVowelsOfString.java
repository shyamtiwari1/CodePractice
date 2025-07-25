package LeetCode.TwoPointer;

import java.util.Set;

public class ReverseVowelsOfString {
    //https://leetcode.com/problems/reverse-vowels-of-a-string/description/

    public static void main(String args[]){
        String s = "leetcode";
        System.out.println(reverseVowels(s));
        System.out.println(reverseVowelsoptimised(s));

    }


    public static String reverseVowels(String s) {
        // int n = s.length;

        int n = s.length();
        int i = 0 ; int j = n-1;
        Character[] c = new Character[s.length()];
        Set<Character> set = Set.of('a','e','i','o','u' , 'A' , 'E' , 'I' , 'O' ,'U');
        while(i<=j){
            if(set.contains(s.charAt(i))){
                while(!set.contains(s.charAt(j))){
                    c[j] = s.charAt(j);
                    j--;
                }
                Character temp = s.charAt(i);
                c[i] = s.charAt(j);
                c[j] = temp;
            }else if(set.contains(s.charAt(j))){
                while(!set.contains(s.charAt(i))){
                    c[i] = s.charAt(i);
                    i++;
                }
                Character temp = s.charAt(i);
                c[i] = s.charAt(j);
                c[j] = temp;

            }else{
                c[i] = s.charAt(i);
                c[j] = s.charAt(j);
            }
            i++;
            j--;
        }
        String ans = "";
        for(Character c1 : c){
            ans+=c1;
        }
        return ans;
    }



        public static String reverseVowelsoptimised(String s) {

            int i = 0 ; int n = s.length();
            int j = n-1;
            char[] arr = s.toCharArray();
            Set<Character> vowels = Set.of('a' , 'e' , 'i' , 'o' , 'u' , 'A' ,'E' ,'I' ,'O' ,'U');
            while(i<j){
                while(i<j && !vowels.contains(s.charAt(i))){
                    i++;
                }
                while(i<j && !vowels.contains(s.charAt(j))){
                    j--;
                }
                Character temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;j--;
            }
            return new String(arr);
        }
}
