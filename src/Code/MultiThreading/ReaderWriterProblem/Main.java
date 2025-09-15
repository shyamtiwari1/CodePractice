package Code.MultiThreading.ReaderWriterProblem;

public class Main {


    public static void main(String[] args) {

        SharedResource sr = new SharedResource();

        for(int i = 0 ; i<3;i++){
            int id = i;
            new Thread(()->{
                while(true){
                    try {
                        sr.readData("reader-"+id);

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }


        for(int i = 0 ; i <=2;i++){
            int id = i;
            new Thread(()->{
                int val = 1;
                try{
                    sr.writeData("writer-"+id ,val++);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }
}
