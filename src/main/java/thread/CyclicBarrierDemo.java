package thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static class Solider implements Runnable{

        private final String solider;

        /**
         * 循环栅栏
         */
        private final CyclicBarrier cyclic;

        public Solider(String soliderName, CyclicBarrier cyclic) {
            this.solider = soliderName;
            this.cyclic = cyclic;
        }

        @Override
        public void run() {
            try {
                // 等待所有士兵到齐
                cyclic.await();
                doWork();
                // 等待所有士兵完成工作
                cyclic.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        void doWork(){
            try{
                Thread.sleep(new Random().nextInt(10)*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(solider +":任务完成！");
        }
    }

    public static class BarrierRun implements Runnable {
        private final int N;
        private boolean flag;

        public BarrierRun(int n, boolean flag) {
            N = n;
            this.flag = flag;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("司令:[士兵" + N + "个,完成任务！]");
            } else {
                System.out.println("司令:[士兵" + N + "个,集合完毕！]");
                flag = true;
            }
        }
    }

        public static void main(String[] args) throws InterruptedException{
            final int N=10;
            Thread[] allSolider=new Thread[N];
            final boolean flag=false;
            CyclicBarrier cyclicBarrier=new CyclicBarrier(N,new BarrierRun(N,flag));
            // 集合队伍
            System.out.println("集合队伍！");
            for(int i=0;i<N;i++){
                System.out.println("士兵" + i + "报到！");
                allSolider[i]=new Thread(new Solider("士兵"+i,cyclicBarrier));
                allSolider[i].start();
            }
        }
}

