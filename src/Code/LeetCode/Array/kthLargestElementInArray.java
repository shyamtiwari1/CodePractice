package Code.LeetCode.Array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class kthLargestElementInArray {


//https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/


        public String kthLargestNumber(String[] nums, int k) {


            Arrays.sort(nums , (a, b)->{
                if(a.length()==b.length()){
                    return b.compareTo(a);
                }
                return b.length()-a.length();
            });
            return nums[k-1];

        }


    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(int num : nums){
            minheap.offer(num);
            if(minheap.size()>k){
                minheap.poll();
            }
        }
        return minheap.peek();


    }
}
