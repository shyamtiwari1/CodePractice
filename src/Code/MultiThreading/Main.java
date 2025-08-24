package Code.MultiThreading;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        ProducerConsumerProblem.SharedBuffer sharedBuffer = new ProducerConsumerProblem.SharedBuffer(10);


        Thread producer = new Thread(()->{
            for(int i = 1;i<=20;i++){
                try{
                    sharedBuffer.producer(i);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    );


        Thread consumer = new Thread(()->{
            for(int i = 1; i<=20;i++){
                try{
                    sharedBuffer.consume();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
    });


        producer.start();
        consumer.start();


        Thread producer1 = new Thread(new ProducerConsumerDemo.Producer(1));
        Thread producer2 = new Thread(new ProducerConsumerDemo.Producer(2));
        Thread consumer1 = new Thread(new ProducerConsumerDemo.Consumer(1));
        Thread consumer2 = new Thread(new ProducerConsumerDemo.Consumer(2));

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();





}
}