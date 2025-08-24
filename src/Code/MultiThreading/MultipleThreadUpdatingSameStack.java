package Code.MultiThreading;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultipleThreadUpdatingSameStack {


    public class ThreadSafeStack<T> {


        private final Deque<T> stack = new ArrayDeque<>();


       // Synchronized


        public synchronized void push(T val) {
            stack.push(val);
        }

        public synchronized T pop() {
            return stack.isEmpty()?null:stack.poll();
        }


        //reentrant lock

        private final Stack<T> stack2 = new Stack<>();


        private final Lock lock = new ReentrantLock();


//        public void push(T val){
//            lock.lock();
//            try{
//                stack2.push(val);
//            }finally {
//                lock.unlock();
//            }
//        }

    }
}
