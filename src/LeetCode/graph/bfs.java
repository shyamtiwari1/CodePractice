package LeetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bfs {
    public static void main(String[] args) {

        // create the adjacency list
        // { {2, 3, 1}, {0}, {0, 4}, {0}, {2} }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(2)));

        int src = 0;
        ArrayList<Integer> ans = (ArrayList<Integer>) bfsTraversal(adj, src);
        ArrayList<Integer> ans1 = (ArrayList<Integer>) bfs(adj, src);
        ArrayList<Integer> ans2 = (ArrayList<Integer>) bfsTraversalagain(adj, src);
        for (int i : ans) {
            System.out.print(i + " ");
        }

        for (int i : ans1) {
            System.out.print(i + " ");
        }
        for (int i : ans2) {
            System.out.print(i + " ");
        }
    }


    public static List<Integer> bfsTraversal(ArrayList<ArrayList<Integer>> adjecencyList, int baseNode){
        List<Integer> ans = new ArrayList<>();
        int n = adjecencyList.size();
        boolean [] visited = new boolean[n];
        visited [baseNode] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(baseNode);
        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);
            for(int x : adjecencyList.get(curr)){
                if(!visited[x]){
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
        return ans ;
    }


    public static List<Integer> bfs(ArrayList<ArrayList<Integer>> adjececncyList , int baseNode){
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean [] vis = new boolean[adjececncyList.size()+1];
        vis[baseNode] = true;
        queue.add(baseNode);
        while(!queue.isEmpty()){
            int x = queue.poll();
            ans.add(x);
            for(int i : adjececncyList.get(x)){
                if(!vis[i]){
                    queue.add(i);
                    vis[i]=true;
                }
            }
        }
        return ans;

    }


    public static List<Integer> bfsTraversalagain(ArrayList<ArrayList<Integer>> adjececncyList , int baseNode){
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> fifo = new LinkedList<>();
        fifo.add(baseNode);
        int [] vis = new int[adjececncyList.size()];
        vis[baseNode] = 0;
        Arrays.fill(vis , -1);
        while(!fifo.isEmpty()){
            int top = fifo.poll();
            ans.add(top);
            List<Integer> adjecentElement = adjececncyList.get(top);
            for(int i : adjecentElement){
                if(vis[i]==-1){
                    fifo.add(i);
                    vis[i] = 0;
                }
            }
        }
        return ans;
    }



}
