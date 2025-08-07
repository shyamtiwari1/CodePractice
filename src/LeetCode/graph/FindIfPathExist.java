package LeetCode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindIfPathExist {


//    https://leetcode.com/problems/find-if-path-exists-in-graph/description/
/***
 * here we're not travelling all the nodes , only check for source or destination
 */

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
                adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                adj.get(i).add(j);
                adj.get(j).add(i);
            }
        }
        boolean[] visited = new boolean[n];
        return bfs(adj , source , visited , source , destination);

    }

    public boolean bfs(List<List<Integer>>adj  , int basenode , boolean[] visited , int source , int destination){
        visited[basenode] = true;
        Queue<Integer> q = new LinkedList<>();

        q.add(basenode);

        boolean destinationexist = false;
//        boolean sourceexist = false;
        while (!q.isEmpty()){

            int x =  q.poll();
            if(x==destination){
                destinationexist = true;
            }
            for(int i : adj.get(x)){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return destinationexist;

    }
}



