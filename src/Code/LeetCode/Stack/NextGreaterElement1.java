package Code.LeetCode.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {


//    https://leetcode.com/problems/next-greater-element-i/description/

/***
 * here we first push an element in stack then we check if the next elemet in array which we want to push in
 * stack is greater than the last elemt in stack if yes we pop that elemt and put both of them into a map as key value
 * since all ememnts are unique map can be used , and then we push that elemt in stack as well to get the maximim for it as well
 *O(M+n) solution
 *
 *
 */



    class Solution {

//nums1 = [4,1,2], nums2 = [1,3,4,2]
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {

            Stack<Integer> stack = new Stack<>();
            Map<Integer , Integer> mpp = new HashMap<>();
            int n = nums1.length;
            int m = nums2.length;

            for(int i = 0 ; i < m ; i++){
                while(!stack.isEmpty() && nums2[i]>stack.peek()){
                    mpp.put(stack.pop() , nums2[i]);
                }
                stack.push(nums2[i]);
            }
            int[]res = new int[n];
            for(int i =0;i<n;i++){
                res[i] = mpp.getOrDefault(nums1[i] , -1);
            }
            return res;

        }
    }
}
