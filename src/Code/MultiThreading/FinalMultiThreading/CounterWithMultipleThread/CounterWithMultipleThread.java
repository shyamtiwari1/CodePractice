package Code.MultiThreading.FinalMultiThreading.CounterWithMultipleThread;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterWithMultipleThread {

    private int counter;

    AtomicInteger atomicInteger = new AtomicInteger(0);


    public  void increment(){
        atomicInteger.incrementAndGet();

    }

    public  void decrement(){
        atomicInteger.decrementAndGet();

    }
    public synchronized int getCounter(){
        return atomicInteger.get();
    }
}
