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


    public String kthLargestNumberoptimal(String[] nums, int k) {

        // Arrays.sort(nums , (a,b) -> b.compareTo(a));


        PriorityQueue<String> pq = new PriorityQueue<>((a,b)-> {
            if(a.length()!= b.length())return Integer.compare(a.length() , b.length());
            return a.compareTo(b);
        });


        for(String i : nums){
            pq.add(i);
            while(pq.size()>k)pq.poll();
        }

        return pq.peek();

    }
}
