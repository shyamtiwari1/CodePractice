package Code.MultiThreading.FinalMultiThreading.DeadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();


    public static Lock lock3 = new ReentrantLock();
    public static Lock lock4 = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(() -> {
            synchronized(lock1){
                System.out.println("thread 1 acquired lock 1 ");
                synchronized (lock2){
                    System.out.println("thread 1 acquired lock 2 ");
                }
            }
        });


        Thread t2 = new Thread(() -> {
            synchronized(lock2){
                System.out.println("thread 2 acquired lock 2 ");
                synchronized (lock1){
                    System.out.println("thread 2 acquired lock 1 ");
                }
            }
        });

        Thread t3 = new Thread(() -> {
            lock3.lock();
            System.out.println("thread 3 acquired lock 3 ");
            System.out.println("Thread 3: Waiting for lock4...");
            lock4.lock();
            System.out.println("thread 3 acquired lock 4 ");

        });


        Thread t4 = new Thread(() -> {
            lock4.lock();
            System.out.println("thread 4 acquired lock 4 ");
            System.out.println("Thread 4: Waiting for lock3...");
            lock3.lock();
            System.out.println("thread 4 acquired lock 3 ");
        });



        t1.start();
        t2.start();

        t3.start();
        t4.start();

    }
}
