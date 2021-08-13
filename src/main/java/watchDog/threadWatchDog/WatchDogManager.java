package watchDog.threadWatchDog;

import java.lang.ref.WeakReference;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

public class WatchDogManager {
    private static final ConcurrentHashMap<Long, WeakReference<Thread>> map= new ConcurrentHashMap<>();

    static void watch(Thread thread){
        map.put(thread.getId(),new WeakReference<>(thread));
    }

    static void start(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    Enumeration<Long> keys = map.keys();
                    while (keys.hasMoreElements()){
                        Long aLong = keys.nextElement();
                        WeakReference<Thread> threadWeakReference = map.get(aLong);
                        System.out.println(threadWeakReference.get());
                        if(threadWeakReference.get() != null){
                            System.out.println("thread:"+aLong+"监听");
                        }else{
                            map.remove(aLong);
                            System.out.println("thread:"+aLong+"不监听");
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }).start();
    }

    static class TestRunnable implements Runnable{
        private final String name;
        private final String desc;

        public TestRunnable(String name, String desc) {
            this.name = name;
            this.desc = desc;
        }

        @Override
        public void run() {
            System.out.println(desc);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程"+name+"结束");
        }
    }

    public static void main(String[] args) {

        test();

        int i = 10000;
        while (i-->0){
            System.gc();
        }
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void test(){
        Thread thread1 = new Thread(new TestRunnable("1", "no 111111"));
        Thread thread2 = new Thread(new TestRunnable("2", "no 22222"));
        Thread thread3 = new Thread(new TestRunnable("3", "no 33333"));
        Thread thread4 = new Thread(new TestRunnable("4", "no 44444"));
        Thread thread5 = new Thread(new TestRunnable("5", "no 55555"));

        start();
        watch(thread1);
        watch(thread2);
        watch(thread3);
        watch(thread4);
        watch(thread5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

}
