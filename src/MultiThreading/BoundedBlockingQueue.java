package MultiThreading;

import java.util.LinkedList;
import java.util.Queue;

public class BoundedBlockingQueue {


    public static void main(String[] args) {

        BoundedBlockingQueue boundedBlockingQueue = new BoundedBlockingQueue(10);

        Thread thread1 = new Thread(()->{
            for(int i = 0 ; i <20;i++){
                try {
                    boundedBlockingQueue.producer(i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread thread2 = new Thread(()->{
            for(int i = 0 ; i <20;i++){
                try {
                    boundedBlockingQueue.consume();

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        thread1.start();
        thread2.start();


    }


    private final int capacity ;
    private  final Queue<Integer> buffer = new LinkedList<>();

    BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void producer(int item) throws InterruptedException {
        while(buffer.size()==capacity){
            wait();
        }
        buffer.add(item);
        System.out.println("produced: " + item);
        notifyAll();

    }

    public synchronized Integer consume() throws InterruptedException {
        while(buffer.isEmpty()){
            wait();
        }
        Integer item = buffer.remove();
        System.out.println("consumed: " + item);
        notifyAll();
        return item;
    }
}
