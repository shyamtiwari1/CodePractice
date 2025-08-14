package Code.LeetCode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictonaryDFS {

    public static  void main(String args[]){
        String[] words = new String []{"caa", "aaa", "aab"};
        int k = 3;
        System.out.println(findOrder(words , k));
    }


    public static String findOrder(String[] words , int k ) {
        List<List<Integer>> adjecencyList = new ArrayList<>();
        for(int i = 0 ; i < k ;i++){
            adjecencyList.add(new ArrayList<>());
        }

        for(int i=0;i<words.length-1;i++){
            int len = Math.min(words[i].length() , words[i+1].length());
            for(int ptr = 0 ; ptr<len;ptr++){
                if(words[i].charAt(ptr)!=words[i+1].charAt(ptr)){
                    adjecencyList.get(words[i].charAt(ptr) - 'a').add(words[i+1].charAt(ptr)-'a');
                    break;
                }
            }

        }
        int [] ans = topoSort(k , adjecencyList);
        String s = "";
        for(int it: ans){
            s += (char)(it+'a');
        }
        return s;

    }



    public static int[] topoSort(int V , List<List<Integer>>adjecencyList){

        int[] inDegree = new int[V];
        for(int i = 0 ; i < V ; i ++){
            for(int j : adjecencyList.get(i)){
                inDegree[j] = inDegree[j]+1;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i= 0 ; i < inDegree.length ; i ++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        int[] ans = new int[V];
        int i = 0;
        while (!queue.isEmpty()){
            int curr = queue.poll();
            ans[i]=curr;
            i++;
            for(int j: adjecencyList.get(curr)){
                inDegree[j]--;
                if(inDegree[j]==0){
                    queue.add(j);
                }
            }
        }
        return ans;
    }
}
