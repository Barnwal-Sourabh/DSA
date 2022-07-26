package PriorityQueue;

public class PriorityQueueUse {

    public static void main(String[] args) {
        MinPriorityQueue pq = new MinPriorityQueue();
        int arr[] = { 5, 1, 9, 0, 3 };

        for (int i = 0; i < arr.length; i++) {
            pq.insert(arr[i]);
        }

        while(!pq.isEmpty()){
            System.out.print(pq.removeMin() + " ");
        }
    }
}
