package Queues;

public class QueueUsingArray {
    private int data[];
    private int front, rear, size;

    public QueueUsingArray() {
        data = new int[10];
        front = -1;
        rear = -1;
        size = 0;    
    }

    public QueueUsingArray(int capacity){
        data = new int[capacity];
        front = -1;
        rear = -1;
        size = 0; 
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return size == 0;
    }

    int front() throws QueueEmptyException{
        if(size == 0){
            throw new QueueEmptyException();
        }
        return data[front];
    }

    void enqueue(int element) throws QueueFullException{
        if(size == data.length){
            doubleCapacity();
        }
        if(size == 0){
            front = 0;
        }
        size++;
        // rear++;
        // if(rear == data.length){
        //     rear = 0;
        // }
        rear = (rear + 1) % data.length;
        data[rear] = element;
    }

    private void doubleCapacity() {
        int temp[] = data;
        data = new int[temp.length * 2];
        int index = 0;

        for(int i = front; i < temp.length; i++){
            data[index] = temp[i];
            index++;
        }
        for(int i = 0; i <= temp.length -1; i++){
            data[index] = temp[i];
            index++;
        }
        front = 0;
        rear = temp.length -1;
    }

    int dequeue() throws QueueEmptyException{
        if(size == 0){
            throw new QueueEmptyException();
        }
        size--;
        int temp = data[front];
        // front++;
        // if(front == data.length){
        //     front = 0;
        // }
        front = (front +1) % data.length;
        return temp;


    }

}

