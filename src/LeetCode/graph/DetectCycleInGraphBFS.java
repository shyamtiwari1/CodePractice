package LeetCode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInGraphBFS {

    public static void main(String args[]){
        List<List<Integer>> adjececnyList = new ArrayList<>();
        boolean [] visited = new boolean[adjececnyList.size()];

        //detect cycle in connected components

        for(int i = 0 ; i <adjececnyList.size();i++){
            if(!visited[i]){
                detectCycleUsingBFS(adjececnyList , i , visited);
            }
        }



//        detectCycleUsingBFS()
    }

    public static boolean detectCycleUsingBFS(List<List<Integer>> adjececnyList , int baseNode ,boolean [] visited ){

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(baseNode,-1));
        visited[baseNode] = true;
        while (!queue.isEmpty()){
            int curr = queue.poll().get(0);
            int currParent = queue.poll().get(1);
            for(int i : adjececnyList.get(curr)){
                if(visited[i] && i!=currParent){
                    return true;
                }
                if(!visited[i]){
                    queue.add(List.of(i , curr));
                    visited[i] = true;
                }
            }
        }
        return false;

    }
}
