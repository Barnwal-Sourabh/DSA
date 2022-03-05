package Stack;

public class Stack {
    
        Node head;
        int size;

    public Stack() {
        head = null;
        size = 0;
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
       return size;

    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void push(int element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public int pop() {
        if(getSize() == 0){
            return -1;
        }
        int temp = head.data;
        Node temp1 = head;
        head = head.next;
        temp1.next = null;
        size--;
        return temp;
    }

    public int top() {
        if(getSize() == 0 || head == null){
            return -1;
        }
        return head.data;
    }
}
