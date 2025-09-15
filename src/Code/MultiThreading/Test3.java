package Code.MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test3 {


    public static void main(String[] args) throws InterruptedException {


         Synchronisedcounter synchronisedCounter = new Synchronisedcounter();

         LockCounter lockCounter = new LockCounter();

         SemaphoreCounter semaphorecounter = new SemaphoreCounter();


        ExecutorService executor  = Executors.newFixedThreadPool(10);

        for(int i = 0 ; i <10;i++){
            Runnable task = ()->{
                System.out.println("Running task by thread :{}" + Thread.currentThread().getName());
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            };
            executor.submit(task);
        }
        executor.shutdown();

         Thread thread = new Thread(()->{
             for(int i = 1;i<=1000;i++){
                 synchronisedCounter.incrememnt();
             }

         });


        Thread thread2 = new Thread(()->{
            for(int i = 1;i<=1000;i++){
                synchronisedCounter.incrememnt();
            }

        });


        Thread thread3 = new Thread(()->{
            for(int i = 1;i<=1000;i++){
                lockCounter.increment();
            }
        });
        Thread thread4 = new Thread(()->{
            for(int i = 1;i<=1000;i++){
                lockCounter.increment();
            }
        });

        Thread thread5 = new Thread(()->{
            for(int i = 1;i<=1000;i++){
                semaphorecounter.increment();
            }
        });
        Thread thread6 = new Thread(()->{
            for(int i = 1;i<=1000;i++){
                semaphorecounter.increment();
            }
        });

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

        thread3.join();
        thread4.join();
        System.out.println(lockCounter.getCount());



        thread.join();
        thread2.join();

        System.out.println(synchronisedCounter.getCount());



        thread5.join();
        thread6.join();

        System.out.println(semaphorecounter.getCount());






    }
}
