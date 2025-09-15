package Code.MultiThreading.DiningPhilospherProblem;

import java.util.concurrent.locks.ReentrantLock;

public class Philospher implements Runnable {

    private int id ;
    private ReentrantLock leftfork ;
    private ReentrantLock rightfork ;

    public Philospher(int id , ReentrantLock leftfork, ReentrantLock rightfork) {
        this.id = id;
        this.leftfork = leftfork;
        this.rightfork = rightfork;
    }

    public void think() throws InterruptedException {
        System.out.println("Philospher " + id + " is thinking...");
//        Thread.sleep(10000);
    }

    public void eat() throws InterruptedException {
        System.out.println("Philospher " + id + " is eating...");
//        Thread.sleep(10000);
    }
    @Override
    public void run() {

        try{
            while(true){
                think();
                ReentrantLock firstfork = leftfork;
                ReentrantLock secondfork = rightfork;

                if(id%2==0){
                    firstfork = rightfork;
                    secondfork = leftfork;
                }

                firstfork.lock();
                try {
                    secondfork.lock();
                    try{
                        eat();
                    }finally {
                        secondfork.unlock();
                    }
                }finally {
                    firstfork.unlock();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
