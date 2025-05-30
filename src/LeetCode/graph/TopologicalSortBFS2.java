package LeetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortBFS2 {


    public static void main (String args[]) {
        // Graph:
        // 0 → 1
        // 0 → 2
        // 1 → 3
        // 2 → 3
        int v = 4;
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(1).add(3);
        adjList.get(2).add(3);

        int[] result = bfsToposort(v, adjList);

        System.out.println("Topological Sort using BFS:");
        System.out.println(Arrays.toString(result));
    }


    public static int[] bfsToposort(int v , List<List<Integer>>adjList){
        int[] inDegree = new int[v];
        for(int i = 0 ; i < v ; i ++){
            for(int j : adjList.get(i)){
                inDegree[j]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i <v ; i ++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        int[] ans = new int[v];
        int i = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            ans[i]=curr;
            i++;
            for(int l : adjList.get(curr)){
                inDegree[l]--;
                if(inDegree[l]==0){
                    queue.add(l);
                }

            }
        }
        return ans;

    }
}
