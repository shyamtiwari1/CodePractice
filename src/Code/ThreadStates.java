package Code;

public class ThreadStates {
    public static void main(String args[]) throws InterruptedException {
        Thread  t = new Thread(()-> {
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
        Thread.sleep(1000);
        System.out.println(t.getState());
        t.join();
        System.out.println(t.getState());

    }
}
