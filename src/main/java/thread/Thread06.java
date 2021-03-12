package thread;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Thread06 {
    public static void main(String[] args) throws InterruptedException {
        Thread06.Counter counter=new Thread06.Counter();

        Thread t =new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    counter.write(i);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        };
        t.start();

            Thread ts =new Thread(()->{
                System.out.println(Arrays.toString(counter.get()));
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                });
            ts.start();
            ts.join();
    }

     static class Counter{
        private final ReadWriteLock lock =new ReentrantReadWriteLock();

        private final Lock rlock =lock.readLock();

        private final Lock wlock =lock.writeLock();

        private final int[] count =new int[10];

         public void write(int index){
             wlock.lock();
             try{
                 count[index]+=1;
             }finally {
                 wlock.unlock();
             }
         }

         public int[] get(){
             rlock.lock();
             try{
                 return Arrays.copyOf(count,count.length);
             }finally {
                 rlock.unlock();
             }
         }
    }
}
