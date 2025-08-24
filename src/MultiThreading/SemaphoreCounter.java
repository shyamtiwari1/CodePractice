package MultiThreading;

import java.util.concurrent.Semaphore;

public class SemaphoreCounter {


    private int count= 0 ;
    private final Semaphore semaphore = new Semaphore(1);



    public void increment()  {
        try{
            semaphore.acquire();
            count++;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }finally {
            semaphore.release();
        }

    }

    public int getCount() {
        try{
            semaphore.acquire();
            return count;

        }catch (InterruptedException e ){
            Thread.currentThread().interrupt();
        }finally {
            semaphore.release();
        }
        return 0;
    }
}
