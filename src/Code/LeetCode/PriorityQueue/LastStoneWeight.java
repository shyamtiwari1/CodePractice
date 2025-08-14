package Code.LeetCode.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class LastStoneWeight {

    public static void main(String args[]){
        int [] arr = new int[]{2,7,4,1,8,1};

        System.out.println(lastStoneWeight(arr));

    }


    public static int lastStoneWeight(int[] stones) {
        Stack<Integer> stack = new Stack<>();
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int stoneWeight: stones){
            pqueue.add(stoneWeight);
        }

        while(pqueue.size()>1){
            int x = pqueue.poll();
            int y = pqueue.poll();
            if(x!=y){
                pqueue.add(x-y);
            }
        }
        return pqueue.isEmpty()?0: pqueue.poll();

    }
}
