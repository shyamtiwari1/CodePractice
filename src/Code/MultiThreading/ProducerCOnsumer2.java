package Code.MultiThreading;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ProducerCOnsumer2 {


    public class sharedBuffer{
        private final static Queue<Integer> buffer =  new LinkedList<>();

        private final int capacity;


        public sharedBuffer(int capacity){
            this.capacity = capacity;
        }


        public synchronized  void producer(int item) throws InterruptedException {
            if(buffer.size() == capacity){
                wait();
            }
            buffer.add(item);
            notifyAll();

        }

        public synchronized  int consumer() throws InterruptedException {
            if(buffer.isEmpty()){
                wait();
            }
            int item = buffer.poll();
            notifyAll();
            return item;
        }
    }
}
