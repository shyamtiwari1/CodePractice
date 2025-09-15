package Code.MultiThreading.ReaderWriterProblem;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {

    private int data  = 0 ;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();



    public void readData(String readerName) throws InterruptedException {
        lock.readLock().lock();

        try{
            System.out.println("Reading " + readerName);
            Thread.sleep(500);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }finally {
            lock.readLock().unlock();
        }
    }

    public void writeData(String writerName , int value) throws InterruptedException {
        lock.writeLock().lock();
        try{
            System.out.println(writerName + " is Writing "+value);
            Thread.sleep(500);
        }catch(Exception e){
            Thread.currentThread().interrupt();
        }finally {
            lock.writeLock().unlock();
        }
    }
}
