package thread;

import java.time.LocalTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private final Lock lock1=new ReentrantLock();
    private final Lock lock2=new ReentrantLock();

    private int count;

    public static void main(String[] args) {
        ReentrantLockTest reentrantLockTest=new ReentrantLockTest();
        reentrantLockTest.add(-5);

        Thread timerThread=new TimerThread();
        timerThread.setDaemon(true); //守护线程
        timerThread.start();
    }

    public void add(int n) {
        lock1.lock();
        try {
            if(n<0) {
                dec(-n);
            }else {
                count +=n;
            }
            System.out.println(n);
        } finally {
            lock1.unlock();
        }
    }

    public void dec(int n){
        lock2.lock();
        try{
            count +=n;
        }finally {
            lock2.unlock();
        }
    }
}

class TimerThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
