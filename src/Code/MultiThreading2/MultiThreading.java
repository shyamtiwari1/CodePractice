package Code.MultiThreading2;

public class MultiThreading {


    public static void main(String args[]){
//        MultiThreadingTry1 multiThreadingTry1 = new MultiThreadingTry1();
//        MultiThreadingTry1 multiThreadingTry2 = new MultiThreadingTry1();

        for(int i = 0; i < 5; i++){
            MultiThreadingTry1 multiThreadingTry1 = new MultiThreadingTry1(i);
            multiThreadingTry1.start();
//            multiThreadingTry2.start();
        }

//        multiThreadingTry1.start();
//        multiThreadingTry1.start();
//        multiThreadingTry2.start();
    }
}
