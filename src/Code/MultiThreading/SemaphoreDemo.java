package Code.MultiThreading;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {




    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        semaphore.acquire();
        semaphore.acquire(2);
        semaphore.release();

        System.out.println(semaphore.availablePermits());
    }
}
