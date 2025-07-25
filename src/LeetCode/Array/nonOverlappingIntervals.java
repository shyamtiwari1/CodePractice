package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nonOverlappingIntervals {



//    https://leetcode.com/problems/non-overlapping-intervals/description/?envType=problem-list-v2&envId=oizxjoit



        public int eraseOverlapIntervals(int[][] intervals) {
            int count = 0 ;
            Arrays.sort(intervals , (a, b)-> Integer.compare(a[1], b[1]));

            int i = 1 ;
            int n = intervals.length;
            List<List<Integer>> newIntervals = new ArrayList<>();
            int prevEnd = intervals[0][1];
            while(i<n){
                if(intervals[i][0]<prevEnd){
                    count++;
                    i++;
                }else{
                    prevEnd = intervals[i][1];
                    i++;
                }

            }
            return count;

        }
}
