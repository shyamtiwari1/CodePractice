package Code.MultiThreading;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosphersLeetcode {

    class DiningPhilosophers {

        ReentrantLock[] forks = new ReentrantLock[5];
        public DiningPhilosophers() {
            Arrays.fill(forks ,new ReentrantLock() );
        }
        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {

            int left = philosopher;
            int right = (philosopher+1)%5;

            ReentrantLock firstfork = philosopher%2==0?forks[left]:forks[right];
            ReentrantLock secondfork = philosopher%2==0?forks[right]:forks[left];


            firstfork.lock();
            try{
                secondfork.lock();
                try{
                    pickLeftFork.run();
                    pickRightFork.run();
                    eat.run();
                    putLeftFork.run();
                    putRightFork.run();


                }finally{
                    secondfork.unlock();
                }
            }finally{
                firstfork.unlock();
            }

        }
    }
}
