package Queues;

public class QueueUse {
    
    public static void main(String[] args) {
        // QueueUsingArray queue = new QueueUsingArray(3);
        QueueUsingLL<Integer> queue1 = new QueueUsingLL<>();

        for(int i = 1; i <= 5; i++){
            // try {
            //     queue.enqueue(i);
            // } catch (QueueFullException e) {

            // }
            queue1.enqueue(i);
        }

        while(!queue1.isEmpty()){
            try {
                System.out.println(queue1.dequeue());
            } catch (QueueEmptyException e) {
               
                e.printStackTrace();
            }
        }
    }
}
