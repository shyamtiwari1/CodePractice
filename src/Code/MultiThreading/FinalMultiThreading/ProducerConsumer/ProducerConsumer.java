package Code.MultiThreading.FinalMultiThreading.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    private Queue<Integer> queue;
    private int capacity;

    public ProducerConsumer(int capacity){
        this.capacity = capacity;
        queue = new LinkedList<>();
    }



    public synchronized void producer(int item){
        while(queue.size() == capacity){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        queue.add(item);
        System.out.println("produced: " + item);
        notifyAll();
    }

    public synchronized void consumer(){
        while(queue.size() == 0){
            try{
                wait();
            }catch (InterruptedException e){}
        }
        int item = queue.poll();
        System.out.println("consumed: " + item);
        notifyAll();
    }

    public synchronized int getSize(){
        return queue.size();
    }
}
