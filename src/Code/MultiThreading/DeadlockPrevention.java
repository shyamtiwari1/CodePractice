package Code.MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockPrevention {

    private static final Lock lock = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();



    public static void main(String[] args)  {

        Runnable task1 = ()->{
            acquireLockInorder(lock , lock2);
            try{
                System.out.println("Task1: acquired both locks and executing critical section.");
                //criticalSection
            }finally {
                lock.unlock();
                lock2.unlock();
            }
        };

        Runnable task2 = ()->{
            acquireLockInorder(lock , lock2);
            try{
                System.out.println("Task2: acquired both locks and executing critical section.");
                //criticalSection
            }finally {
                lock.unlock();
                lock2.unlock();
            }


        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();



    }

    private static void acquireLockInorder(Lock lock, Lock lock2) {
        lock.lock();
        lock2.lock();
    };
}
