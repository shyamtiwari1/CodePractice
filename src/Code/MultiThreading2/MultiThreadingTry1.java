package Code.MultiThreading2;

public class MultiThreadingTry1 extends Thread implements Runnable {


    /***
     * 1. if we extend thread , we cannot any other class java doesnt allow multiple inheritance
     *
     *
     *
     */

    private int threadNumber ;


    public  MultiThreadingTry1(int threadNumber){
        this.threadNumber = threadNumber;

    }


    @Override
    public void run(){
        for(int i = 0 ; i<10 ;i++){
            System.out.println(i+ " from thread number :{}" + threadNumber);
//            try{
//                Thread.sleep(1000);
//            }catch(Exception e){
//
//            }

        }


    }
}
