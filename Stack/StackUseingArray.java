package Stack;

public class StackUseingArray {

    private int data[];
    private int top;

    public StackUseingArray(){
        data = new int[10];
        top = -1;
    }

    public StackUseingArray(int capacity){
        data = new int[capacity];
        top = -1;
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public int size(){
        return top + 1;
    }

    public int top() throws StackEmptyException{
        if(size() == 0){
            //Stack Empty exection throw
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        return data[top];
    }

    public void push(int elem) throws StackFullExeception{
        if(size() == data.length){
            // StackFullExeception e = new StackFullExeception();
            // throw e;
            doubleCapacity();
        }
        top++;
        data[top] = elem;
    }

    public void doubleCapacity(){
        int temp[] = data;
        data = new int[2 * temp.length];
        for(int i=0; i <= top; i++){
            data[i] = temp[i];
        }
    }

    public int pop() throws StackEmptyException{
        if(size() == 0){
            //Stack empty exception throw
            StackEmptyException e = new StackEmptyException();
            throw e;
        }

        int temp = data[top];
        top--;
        return temp;
    }
}
