package Code.MultiThreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerProblem {


    public static class SharedBuffer{

        private final Queue<Integer> buffer = new LinkedList<>();

        private int capacity ;

        public SharedBuffer(int capacity){
            this.capacity = capacity;
        }


        public synchronized void producer(int item) throws InterruptedException {
            if(buffer.size() == capacity){
                wait();
            }
            buffer.add(item);
            System.out.println("produced: " + item);
            notifyAll();
        }

        public synchronized int consume() throws InterruptedException {
            if(buffer.isEmpty()){
                wait();
            }
            int item =  buffer.poll();
            System.out.println("Consumed: " + item);
            notifyAll();
            return item;
        }
    }
}
