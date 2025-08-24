package Code.MultiThreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ProducerConsumerDemo {



        private static final int CAPACITY = 5;

        private static final Queue<Integer> buffer = new LinkedList<>();
    private static final int TOTAL_ITEMS = 10;


    private static final Semaphore empty = new Semaphore(CAPACITY);
        private static final Semaphore full = new Semaphore(0);
        private static final Semaphore mutex = new Semaphore(1);


        public static class Producer implements Runnable{

            private final int id;

            Producer(int id){
                this.id = id;
            }

            @Override
            public void run() {
                int item = 0 ;
                try{
                    while(true){
                        item++;
                        empty.acquire();
                        mutex.acquire();

                        buffer.add(item);

                        System.out.println("Producer:{}" + id + "produced:{}" + item);


                        mutex.release();
                        full.release();
                    }
                }catch (InterruptedException e){
                   Thread.currentThread().interrupt();
                }
            }
        }

        public static class Consumer implements Runnable{
            private final int id;

            Consumer(int id){
                this.id = id;
            }


            @Override
            public void run() {
                try{

                    while (true){
                        full.acquire();
                        mutex.acquire();
                        int item = buffer.poll();
                        System.out.println("Consumer " + id + " consumed: " + item);


                        mutex.release();
                        empty.release();
                    }

                }catch (Exception e){
                    Thread.currentThread().interrupt();
                }
            }
        }



}
