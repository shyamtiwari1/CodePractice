package Code.LeetCode.graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSourceToTarget {


//    https://leetcode.com/problems/all-paths-from-source-to-target/description/



    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

            int start = 0;
            int dest = graph.length - 1;
            List<Integer> path = new ArrayList<>();

            path.add(0);
            helper(graph, start, dest, path);
            return ans;
        }

        public void helper(int[][] graph, int start, int dest, List<Integer> path) {
            if (start == dest) {
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < graph[start].length; i++) {
                path.add(graph[start][i]);
                helper(graph, graph[start][i], dest, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
