package thread;

import java.util.LinkedList;
import java.util.Queue;

public class Thread03 {
    public static void main(String[] args) {

    }

    class TaskQueue {
        Queue<String> queue = new LinkedList<>();

        public synchronized void addTask(String s) {
            this.queue.add(s);
        }

        public synchronized String getTask() {
            while (queue.isEmpty()) {
            }
            return queue.remove();
        }
    }
}
