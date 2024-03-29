

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class DeleteNode {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if(head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }

        return head;
    }
    
    public static void print(LinkedListNode<Integer> head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            
            LinkedListNode<Integer> head = takeInput();
            int pos = Integer.parseInt(br.readLine().trim());

            LinkedListNode<Integer> newHead = DeleteNode.deleteNodeRec(head, pos);
            print(newHead);
            
            t -= 1;
        }

        

    }
    public static int length(LinkedListNode<Integer> head){
		int size = 0;
        
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
	}
    public static LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int pos) {
        if(pos == 0){
            return head.next;
        }

        if(head == null || head.next == null){
            return head;
        }

        head.next = deleteNodeRec(head.next, pos-1);
        return head;
        
    }
    
}
