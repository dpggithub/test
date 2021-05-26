package thread;

import java.util.concurrent.*;

public class SemaphoreTest implements Runnable{

    final Semaphore semaphore=new Semaphore(5);

    @Override
    public void run(){
        try{
            semaphore.acquire();
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getId()+":done");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(20);
        final SemaphoreTest sema =new SemaphoreTest();
        for(int i=1;i<=20;i++){
            ex.submit(sema);
        }
    }


}
