package Code.MultiThreading.FinalMultiThreading.CounterWithMultipleThread;

public class Main {


    public static void main(String args[]) throws InterruptedException {

        CounterWithMultipleThread counter = new CounterWithMultipleThread();


        Thread t1 = new Thread(() ->{

            for(int i = 0 ; i <10;i++){
                counter.increment();
            }

        });


        Thread t2 = new Thread(() ->{
            for(int i = 0 ; i <5;i++){counter.decrement();}
        });

        t1.start();
//        System.out.println(counter.getCounter());
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.getCounter());

    }




}
