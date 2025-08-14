package Code.LeetCode.Stack;

public class NextGreaterElement3 {

//    https://leetcode.com/problems/next-greater-element-iii/description/


    /***
     * 1. find the first dip from right
     * 2. find the smallest greater elemt for this dip on the right side
     * 3. swap these twop
     * 4. sort the remaining right part of this arr from ith index
     * 5. convert to int handle the overflow error and return
     *
     *
     */


    class Solution {
        public int nextGreaterElement(int x) {
            char[] arr  = String.valueOf(x).toCharArray();
            int n = arr.length;
            int i = n-2;
            while(i>=0 && arr[i]>=arr[i+1]){
                i--;
            }
            if(i==-1){
                return -1;
            }
            int k  =  n-1;
            while(arr[i]>=arr[k]){
                k--;
            }
            // swap k & i
            char temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp ;
            // concatenate till ith index
            String res = "";
            for(int l = 0 ; l<=i;l++){
                res+=arr[l];
            }
            for(int l = n-1;l>i;l--){
                res+=arr[l];
            }
            long val = Long.parseLong(new String(res));
            return (val <= Integer.MAX_VALUE) ? (int) val : -1;


        }
    }
}
