package src.collection;

import java.util.*;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue= new LinkedList<String>();
       // Map<String,Integer> map= new HashMap<>(8);
        queue.offer("你");
        queue.add("我");
        queue.offer("他");

        System.out.println(queue.element());
        System.out.println(queue.peek());
//        System.out.println(queue.remove());
//        System.out.println(queue.poll());
//        System.out.println(queue.remove());
        System.out.println(queue.size());

    }
}
