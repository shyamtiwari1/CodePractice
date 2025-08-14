package Code.LeetCode.graph;

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

        // we store parent as well in queue along with the integer itself
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


    public static boolean detectCycleUsingBFSAgain(List<List<Integer>>adjList, int baseNode , boolean[] visisted){
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(baseNode , -1));
        while(!queue.isEmpty()){
            List<Integer> curr = queue.poll();
            for(int i : adjList.get(curr.get(0))){
                if(visisted[i] && i!=curr.get(1)){
                    return true;
                }
                if(!visisted[i]){
                    queue.add(List.of(i, curr.get(0)));
                    visisted[i] = true;
                }
            }
        }
        return false;

    }
}
