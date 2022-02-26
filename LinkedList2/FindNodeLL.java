package LinkedList2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;





public class FindNodeLL {
    
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
            int n = Integer.parseInt(br.readLine().trim());

            System.out.println(FindNodeLL.findNodeRec(head, n));
            
            t -= 1;
        }

    }
    public static int findNodeRec(LinkedListNode<Integer> head, int n) {
		return findNodeRec(head, n, 0);
	}
    public static int findNodeRec(LinkedListNode<Integer> head, int n, int pos) {
        if(head == null){
            return -1;
        }
        
        if(head.data == n){
            return pos;
        }
        int smallAns = findNodeRec(head.next, n, pos+1);
        return smallAns;

       
    }
}