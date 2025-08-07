package LeetCode.graph;

import java.util.*;

public class CourseSchedule2 {
//    https://leetcode.com/problems/course-schedule-ii/description/



    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {

            List<List<Integer>> adj = new ArrayList<>();
            int n = prerequisites.length;
            for(int i = 0 ; i < numCourses ; i++){
                adj.add(new ArrayList<>());
            }
            int [] indegree = new int[numCourses];
            Arrays.fill(indegree, 0);
            for(int i = 0 ; i <prerequisites.length ; i ++){
                int u = prerequisites[i][1];
                int v = prerequisites[i][0];
                adj.get(u).add(v);
                indegree[v]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0 ; i <numCourses ;i++){
                if(indegree[i]==0){
                    queue.add(i);
                }
            }
            List<Integer> ans = new ArrayList<>();
            // int i = 0 ;
            while(!queue.isEmpty()){
                int x = queue.poll();
                ans.add(x);
                // i++;
                for(int l : adj.get(x)){
                    indegree[l]--;
                    if(indegree[l]==0){
                        queue.add(l);
                    }
                }
            }

            if(ans.size()!=numCourses){

                return new int[]{};
            }
            int[] ans2 = new int[ans.size()];
            for(int i =0;i<ans.size();i++){
                ans2[i] = ans.get(i);
            }
            return ans2;

        }
    }
}
