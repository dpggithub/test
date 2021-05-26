package thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Thread09 {
    private static List<Integer> al = Collections.synchronizedList(new ArrayList<>());

    public static class AddThread implements Runnable{

        @Override
        public void run(){
            //synchronized (Thread09.class){
                for(int i=1;i<=100;i++){
                    al.add(i);
                //}
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 =new Thread(new AddThread());
        Thread t2 =new Thread(new AddThread());
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(al.size());
    }
}
