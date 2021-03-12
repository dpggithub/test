package thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread04 {
        public static void main(String[] args) throws InterruptedException {
            TaskQueue q = new TaskQueue();
            List<Thread> ts = new ArrayList<Thread>();
            for (int i=0; i<5; i++) {
                Thread t = new Thread() {
                    public void run() {
                        // 执行task:
                        while (true) {
                            try {
                                String s = q.getTask();
                                System.out.println("execute task: " + s);
                            } catch (InterruptedException e) {
                                return;
                            }
                        }
                    }
                };
                t.start();
                ts.add(t);
            }
            Thread add = new Thread(() -> {
                for (int i=0; i<10; i++) {
                    // 放入task:
                    String s = "t-" + Math.random();
                    System.out.println("add task: " + s);
                    q.addTask(s);
                    try { Thread.sleep(100); } catch(InterruptedException e) {}
                }
            });
            add.start();
            add.join();
            Thread.sleep(100);
            for (Thread t : ts) {
                t.interrupt();
            }
        }

//    static class TaskQueue {
//        Queue<String> queue = new LinkedList<>();
//
//        public synchronized void addTask(String s) {
//            this.queue.add(s);
//            this.notifyAll();
//        }
//
//        public synchronized String getTask() throws InterruptedException {
//            while (queue.isEmpty()) {
//                this.wait();
//            }
//            return queue.remove();
//        }
//    }

    static class TaskQueue {
        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();
        private Queue<String> queue = new LinkedList<>();

        public void addTask(String s) {
            lock.lock();
            try {
                queue.add(s);
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public String getTask() throws InterruptedException {
            lock.lock();
            try {
                while (queue.isEmpty()) {
                    condition.await();
                }
                return queue.remove();
            } finally {
                lock.unlock();
            }
        }
    }
}



