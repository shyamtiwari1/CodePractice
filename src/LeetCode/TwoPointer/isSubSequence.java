package LeetCode.TwoPointer;

public class isSubSequence {

//    https://leetcode.com/problems/is-subsequence/


    public static void main(String args[]){
        String s= "b";
        String t = "c";
        boolean b = isSubsequence(s , t);
        System.out.println(b);
    }
        public static boolean isSubsequence(String s, String t) {
            int n = s.length();
            int m = t.length();

            int i = 0 ; int j = 0 ;
            while(i<n && j<m){

                while(i<n && j<m && s.charAt(i)!=t.charAt(j)){
                    j++;
                }

                if(j==m && i!=n-1){
                    return false;
                }
                if(i==n-1){
                    return true;
                }
                i++;
                j++;

            }
            return true;

        }
    }

