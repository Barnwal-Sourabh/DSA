package PriorityQueue;

public class PriorityQueueUse {

    private static void insertHeapIntoVirtualHeap(int[] arr, int i) {
        int childIndex = i;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (arr[childIndex] < arr[parentIndex]) {
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex] = temp;
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    private static int removeMinFromVirtualHeap(int[] arr, int heapSize) {
        int temp = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;
        int index = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        while (leftChildIndex < heapSize) {
            int minIndex = index;
            if (arr[leftChildIndex] < arr[minIndex]) {
                minIndex = leftChildIndex;
            }

            if (rightChildIndex < heapSize && arr[rightChildIndex] < arr[minIndex]) {
                minIndex = rightChildIndex;
            }

            if (minIndex != index) {
                int temp1 = arr[index];
                arr[index] = arr[minIndex];
                arr[minIndex] = temp1;
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;

            }else{
                break;
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        // MinPriorityQueue pq = new MinPriorityQueue();
        // int arr[] = { 5, 1, 9, 0, 3 };

        // for (int i = 0; i < arr.length; i++) {
        // pq.insert(arr[i]);
        // }

        // while(!pq.isEmpty()){
        // System.out.print(pq.removeMin() + " ");
        // }

        // optimixe space complexity
        int arr[] = { 5, 1, 9, 0, 3 };

        for (int i = 0; i < arr.length; i++) {
            insertHeapIntoVirtualHeap(arr, i);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - 1 - i] = removeMinFromVirtualHeap(arr, arr.length - i);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}
