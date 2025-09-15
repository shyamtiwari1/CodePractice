package Code.MultiThreading.FinalMultiThreading.ProducerConsumer;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        ProducerConsumer producerConsumer = new ProducerConsumer(10);


        Thread producer1 = new Thread(() -> {
            for(int i = 0; i < 20; i++){
                producerConsumer.producer(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });
         Thread producer2 = new Thread(() -> {
             for(int i = 0; i < 20; i++){
                 producerConsumer.producer(i);
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
             }

         });


        Thread consumer1 = new Thread(() -> {
            for(int i = 0; i < 15; i++){
                producerConsumer.consumer();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        Thread consumer2 = new Thread(() -> {
            for(int i = 0; i < 15; i++){
                producerConsumer.consumer();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

       producer1.start();
       producer2.start();
       consumer1.start();
       consumer2.start();
        System.out.println(producerConsumer.getSize());
    }
}
