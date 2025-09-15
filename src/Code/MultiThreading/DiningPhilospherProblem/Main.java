package Code.MultiThreading.DiningPhilospherProblem;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        int n = 5 ;
        ReentrantLock [] forks = new ReentrantLock[n];
        Arrays.fill(forks , new ReentrantLock());

        for (int i = 0; i < n; i++) {
            ReentrantLock left = forks[i];
            ReentrantLock right = forks[(i + 1) % n];
            new Thread(new Philospher(i, left, right)).start();
        }
    }
}
