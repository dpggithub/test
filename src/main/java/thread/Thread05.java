package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread05 {
    public static void main(String[] args) throws InterruptedException {
        Thread05.Counter counter =new Thread05.Counter();
        counter.add(5);
    }

    static class Counter {
        private boolean flag;
        private final Lock lock = new ReentrantLock();
        private int count;

        public void add(int n) throws InterruptedException {
            // lock.lock();
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    count += n;
                    System.out.println(flag);
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
