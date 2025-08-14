package Code.LeetCode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule1 {

//    https://leetcode.com/problems/course-schedule/description/



    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            //try toposort , kahn algo bfs
            // if number of nodes is not equal to the the length of topo sort
            // then its a cycle

            List<List<Integer>> adj = new ArrayList<>();
            for(int i = 0 ; i < numCourses ; i ++){
                adj.add(new ArrayList<>());
            }
            int [] indegree = new int[numCourses+1];
            for(int i = 0 ; i <prerequisites.length ; i++){
                adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
                indegree[prerequisites[i][0]]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0 ; i <numCourses;i++ ){
                if(indegree[i]==0){
                    queue.add(i);
                }
            }

            List<Integer> ans = new ArrayList<>();
            while(!queue.isEmpty()){
                int z = queue.poll();
                ans.add(z);
                for(int l : adj.get(z)){
                    indegree[l]--;
                    if(indegree[l]==0){
                        queue.add(l);
                    }
                }
            }
            if(numCourses != ans.size()){
                return false;
            }
            return true;

        }
    }
}
