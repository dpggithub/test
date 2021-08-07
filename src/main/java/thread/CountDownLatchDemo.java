package thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo implements Runnable{

    /**
     *  倒计数器门闩
     */
    static final CountDownLatch countDownLatch=new CountDownLatch(10);

    static final CountDownLatchDemo countDownLatchDemo=new CountDownLatchDemo();

    @Override
    public void run(){
        try {
            //模拟检查任务
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println("check completed");
            countDownLatch.countDown();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        for(int i=1;i<=10;i++) {
            executorService.submit(countDownLatchDemo);
        }
        countDownLatch.await();
        System.out.println("Fire");
        executorService.shutdown();
    }

}
