package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeIntervals {
//    https://leetcode.com/problems/merge-intervals/description/?envType=problem-list-v2&envId=oizxjoit



        public int[][] merge(int[][] intervals) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(intervals , (a, b)->Integer.compare(a[0],b[0]));
            int n = intervals.length;
            int i = 1;
            int prevEnd = intervals[0][1];
            int start =  intervals[0][0];

            while(i<n){
                if(prevEnd>=intervals[i][0]){
                    prevEnd = Math.max(prevEnd , intervals[i][1]);
                }else{
                    ans.add(Arrays.asList(start, prevEnd));
                    start= intervals[i][0];
                    prevEnd = intervals[i][1];
                }
                i++;
            }
            ans.add(Arrays.asList(start, prevEnd));


            int[][] res = new int[ans.size()][2];
            for(int j = 0 ; j < ans.size();j++){
                res[j][0] = ans.get(j).get(0);
                res[j][1] = ans.get(j).get(1);
            }
            return res;
    }

}
