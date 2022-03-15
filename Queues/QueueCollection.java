package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCollection {
    
    public static void main(String[] args) {
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(23);
        queue.add(69);
        
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.size());
    }
}
