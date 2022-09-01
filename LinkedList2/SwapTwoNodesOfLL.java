

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SwapTwoNodesOfLL {
    
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
    
    public static void print(LinkedListNode<Integer> head){
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
            String[] i_j = br.readLine().trim().split("\\s");

            int i = Integer.parseInt(i_j[0]);
            int j = Integer.parseInt(i_j[1]);

            LinkedListNode<Integer> newHead = SwapTwoNodesOfLL.swapNodes(head, i, j);
            print(newHead);
            
            t -= 1;
        }

    }

    public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int I, int J) {
		LinkedListNode<Integer> prev1 = null,prev2 = null,curr1 = head,curr2 = head; 
        
        for(int i =1; i<=I; i++){
            prev1 = curr1;
            curr1 = curr1.next;
        }
        for(int i =1; i<= J; i++){
            prev2 =curr2;
            curr2 = curr2.next;
        }
        if(prev1 == null){
            head = curr2;
        }else{
            prev1.next = curr2;
        }

        LinkedListNode<Integer> temp = curr2.next;
        if(prev2 != curr1){
            curr2.next = curr1.next;
        }else {
            curr2.next = curr1;
        }
        if(prev2 == null){
            head = curr1;
        }else{
            prev2.next =curr1;
        }
        curr1.next = temp;
        return head;
	}

}