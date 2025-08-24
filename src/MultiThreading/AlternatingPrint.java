package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AlternatingPrint {

    public static void main(String[] args) {
        AlternatingPrint alt = new AlternatingPrint();

        Thread thread1 =  new Thread(()->{
            try{
                alt.printA();
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });
        Thread thread2 =  new Thread(()->{
            try{
                alt.printB();
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });
        Thread thread3 =  new Thread(()->{
            try{
                alt.printC();
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });



        Thread thread4 =  new Thread(()->{
            try {
                alt.printAReentrant();
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });

        Thread thread5 =  new Thread(()->{
            try {
                alt.printBReentrant();
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });

        Thread thread6 =  new Thread(()->{
            try {
                alt.printCReentrant();
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });

//        thread1.start();
//        thread2.start();
//        thread3.start();

        thread4.start();
        thread5.start();
        thread6.start();
    }



    private int counter = 1 ;

    private int counter1 = 1 ;
    private int MAXVALUE = 1000;

    public synchronized void printA() throws InterruptedException {

        while(counter<MAXVALUE){
            while(counter%3!=0){
                wait();

            }

            System.out.println(Thread.currentThread().getName()+":"+counter);
            counter++;
            notifyAll();
        }

    }


    public synchronized void printB() throws InterruptedException {

        while(counter<MAXVALUE){
            if(counter%3==1){
                System.out.println(Thread.currentThread().getName()+":"+counter);
                counter++;
                notifyAll();
            }else{
                wait();
            }
        }

    }

    public synchronized void printC() throws InterruptedException {

        while(counter<MAXVALUE){
            if(counter%3==2){
                System.out.println(Thread.currentThread().getName()+":"+counter);
                counter++;
                notifyAll();
            }else{
                wait();
            }
        }

    }

    Lock lock = new ReentrantLock();



    public  void printAReentrant() throws InterruptedException {

        lock.lock();
        try{
            while(counter<MAXVALUE && counter%3==0) {
                System.out.println(Thread.currentThread().getName()+":"+counter);
                counter++;
            }
        }catch (Exception e){
            Thread.currentThread().interrupt();
        }finally {
            lock.unlock();
        }

        }



    public  void printBReentrant() throws InterruptedException {
        lock.lock();
        try{
            while(counter<MAXVALUE && counter%3==1) {
                System.out.println(Thread.currentThread().getName()+":"+counter);
                counter++;
            }
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }


    public  void printCReentrant() throws InterruptedException {

        lock.lock();

        try{
            while(counter<MAXVALUE && counter%3==2){
                System.out.println(Thread.currentThread().getName()+":"+counter);
                counter++;
            }
        }catch (Exception e){
            Thread.currentThread().interrupt();
        }finally {
            lock.unlock();
        }


    }







}
