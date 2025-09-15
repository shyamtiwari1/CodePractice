package Code.MultiThreading;

import java.util.concurrent.locks.ReentrantLock;

public class LockCounter {

    private int count = 0 ;
    private ReentrantLock lock = new ReentrantLock();

    public void increment(){
        lock.lock();
        try{
            count++;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public int getCount(){
        lock.lock();
        try{
            return count;
        }finally {
            lock.unlock();
        }


    }
}
